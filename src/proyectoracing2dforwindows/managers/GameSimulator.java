/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;
import proyectoracing2dforwindows.car.Car;
import proyectoracing2dforwindows.players.*;
import proyectoracing2dforwindows.specialsounds.Sound;
import proyectoracing2dforwindows.specialobjects.*;
import java.awt.Color;
import java.awt.Font;
import proyectoracing2dforwindows.interfaces.*;
import proyectoracing2dforwindows.exceptions.*;
import proyectoracing2dforwindows.models.*;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Movable, Drawable, Configurable, SpecialMovable{
    Paintable paint;
    //private boolean colision=false;
    
    private MapManager mapManager;
    private ScoreManager scoreManager;
    private Runway currentRunway;
    private SoundManager soundManager;
    private ImageManager imageManager;
    
    private int nCheckpoints;//Guarda el numero de checkpoints en pista
    
    private Timer gameUpdateTimer;
    
    private String carplayer1;//Color del carro del player 1
    private Player1 player1;
    
    private String carplayer2;//Color del carro del player 1
    private Player2 player2;
  
    private ArrayList <SpecialObject> specialsObjects;

    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/powers/reducesize.png");

    private BufferedImage imageIncrease;
    URL shrinkUrl2 = getClass().getResource("/data/powers/hongo.png");

    private BufferedImage imageStop;
    URL stopUrl = getClass().getResource("/data/powers/stop.png");
    
    
    
    private int numPowers; //Define el numero de poderes que apareceran en el juego
    
    private int maxLaps; //Define el numero de vueltas maximas
    
    private ArrayList <Sound> sounds;
    
    private ClickListener clickListener;//Sirve para avisar a la mainwindow que ya termino la partida
    
    private String winner; //Guarda el nombre del jugador que gane en cada ronda

    public GameSimulator(ClickListener clickListener)throws IOException {
        
        
        this.clickListener=clickListener;
        
        this.mapManager = new MapManager();
        this.currentRunway = null;
        this.soundManager=new SoundManager();
        this.imageManager=new ImageManager();
        this.scoreManager = new ScoreManager();
        this.carplayer1 = "redcar";
        this.carplayer2 = "greencar";
        
        maxLaps = 3;
        numPowers = 5;
        
        this.sounds=new ArrayList<>();
        sounds=soundManager.getSounds();
        
        
        try {
            scoreManager.loadScores();
        } catch (FileManagerException ex) {
            Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapFileNotFoundException ex) {
            Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void drawElements(Graphics g) throws InterruptedException{
        
        
        if(currentRunway != null){
            currentRunway.draw(g);
        }
        
        for (SpecialObject specialsObject : specialsObjects) {
            specialsObject.draw(g);
            
        }
        
        if (player1 != null) {
            
            player1.draw(g); // Dibuja el carro normal si no hay colisión
             // Dibuja el carro normal si no hay colisión
            
            //paint.repaint(); // Es posible que no necesites llamar repaint() aquí, depende de cómo se maneje en tu implementación
        }
        if (player2 !=null) {
            player2.draw(g);
            
        }
        g.setColor(Color.WHITE);
        
        g.fillRect(900/2-50, 900/2-50, 100, 100);
        g.setColor(Color.BLACK); // Establece el color del texto
        g.setFont(new Font(("Tw Cen MT"), Font.BOLD, 15)); // Establece la fuente del texto
        String lapsplayer1;
        if(player1.getLap()<maxLaps){
            lapsplayer1 = String.valueOf(player1.getLap());
        }else{
            lapsplayer1 = String.valueOf(maxLaps);
        }
        g.drawString(player1.getName()+": "+lapsplayer1, 900/2-50,900/2-30 ); // Dibuja el texto en las coordenadas (50, 50)
        g.drawString("Score: "+player1.getScore(), 900/2-50,900/2-12 ); // Dibuja el texto en las coordenadas (50, 50)
        
        String lapsplayer2;
        if(player2.getLap()<maxLaps){
            lapsplayer2 = String.valueOf(player2.getLap());
        }else{
            lapsplayer2 = String.valueOf(maxLaps);
        }
        g.drawString(player2.getName()+": "+lapsplayer2, 900/2-50,900/2+20 ); // Dibuja el texto en las coordenadas (50, 50)
        g.drawString("Score: "+player2.getScore(), 900/2-50,900/2+38 ); // Dibuja el texto en las coordenadas (50, 50)

        paint.repaint();
        
        
        
    }
    
    public void applyScore(String player, String opt){
        switch(opt){
                case "check":
                    if(player1.getName().equals(player)){
                        player1.setScore(10);
                    }else{
                        player2.setScore(10);
                    }
                    break;
                case "lap":
                    if(player1.getName().equals(player)){
                        player1.setScore(40);
                    }else{
                        player2.setScore(40);
                    }
                    break;
                case "shrink":
                    if(player1.getName().equals(player)){
                        player1.setScore(-5);
                    }else{
                        player2.setScore(-5);
                    }
                    break;
                case "grow":
                    if(player1.getName().equals(player)){
                        player1.setScore(5);
                    }else{
                        player2.setScore(5);
                    }
                    break;
                case "stop":
                    if(player1.getName().equals(player)){
                        player1.setScore(-10);
                    }else{
                        player2.setScore(-10);
                    }
                    break;
                case "win":
                    if(player1.getName().equals(player)){
                        player1.setScore(150);
                    }else{
                        player2.setScore(150);
                    }
                    break;
        }
    }
    
    @Override
    // aqui se esta verificando la colision con los objetos especiales
    public void verifyObjectCollision(Car car){
        Iterator<SpecialObject> iterator = specialsObjects.iterator();
        while (iterator.hasNext()) {
            SpecialObject specialObject = iterator.next();
            if (specialObject.verifyCollision(car.getX(), car.getY(), car.getWidth(), car.getHeight())) {
                if(car.receiveEffect(specialObject,soundManager.getSounds())){
                    iterator.remove(); // Elimina el objeto actual de la lista de manera segura
                    
                    applyScore(car.getId(), specialObject.getId());
                    
                    createSpecialObject();
                    
                }
                break;
            }
        }
        
    }
    
    @Override
    public void verifyCheckpoints(int x, int y, int width, int height, String id) {
        int cp_collided = currentRunway.verifyCheckpointCollision(x, y, width, height);
        if(cp_collided == -1){
            
            return;
        }
        //System.out.println("antes de entrat");
        int cp_current;
        if(id.equals(player1.getName())){
            

            //System.out.println("player1 checpoint actual:"+player1.getCpCurrent());
            cp_current = player1.getCpCurrent();
            if(cp_current == -1 & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
            }else if(cp_current + 1 == cp_collided){
                player1.setCpCurrent(cp_collided);
                applyScore(player1.getName(), "check");
            }else if(cp_current == nCheckpoints & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
                applyScore(player1.getName(), "lap");
                

            }
            
        }else if(id.equals(player2.getName())){
            cp_current = player2.getCpCurrent();
            if(cp_current == -1 & cp_collided == 0){
                player2.setCpCurrent(cp_collided);
            }else if(cp_current + 1 == cp_collided){
                player2.setCpCurrent(cp_collided);
                applyScore(player2.getName(), "check");
            }else if(cp_current == nCheckpoints & cp_collided == 0){
                player2.setCpCurrent(cp_collided);
                applyScore(player2.getName(), "ap");
            }
            //System.out.println("player2 checpoint actual:"+player2.getCpCurrent());
        }
        
        verifyLapsPerPlayer();
    }
    
    public void verifyLapsPerPlayer(){
        if (player1.getLap() > maxLaps && player2.getLap() > maxLaps) {
            System.out.println("SALIR");
            try {
                finalizePlayers();
                clickListener.returnMapSelector();
            } catch (FileManagerException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MapFileNotFoundException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidMapFormatException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CheckpointException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (player1.getLap() > maxLaps & winner.equals("none")) {          
               player1.getCar().setVelocityX(0);
               player1.getCar().setVelocityY(0);
               winner = player1.getName();
               applyScore(player1.getName(), "win");
            
        }else if (player2.getLap() > maxLaps & winner.equals("none")) {
            player2.getCar().setVelocityX(0);
            player2.getCar().setVelocityY(0);
               winner = player2.getName();
               applyScore(player2.getName(), "win");
        }
        
        
    
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {

    if (player1 != null) {
        player1.keyPressed(e);
    }if (player2 != null) {
        player2.keyPressed(e);

    }
    
    paint.repaint();
}
    public void keyReleased(KeyEvent e) throws InterruptedException {
    if (player1 != null) {
        player1.keyReleased(e);//if evt vk_up---->else el otro carro con sus teclas
        
        
    }
    if (player2 != null) {
        player2.keyReleased(e);//if evt vk_up---->else el otro carro con sus teclas
        
    }
    
}
    
    
    
    public ArrayList<String> showMaps() throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException{
        mapManager.loadRunways(0, 0);
        return mapManager.getRunwaysNames();
    }
    
    public void loadMap(String nameMap) throws IOException{
            setCurrentRunway(mapManager.getRunway(nameMap));
            
    }
    
    
    /**
     * @return the currentRunway
     */
    public Runway getCurrentRunway() {
        return currentRunway;
    }

    /**
     * @param currentRunway the currentRunway to set
     */
    public void setCurrentRunway(Runway currentRunway) {
        this.currentRunway = currentRunway;
    }
    
    
    @Override
    public void setPaint(Paintable paint) {
        this.paint = paint;
        initializePlayers();
    }
    
    // this function is used to verify the collision between the specialobjects and the runwayyyyyy

    @Override
    public void verifySpecialObjectCollision(SpecialObject specialObject, int newY) {
    if (currentRunway != null) {
        //System.out.println("Verifying collision for SpecialObject at newY: " + newY);

        //Use the current x position of the special object
        int newX = specialObject.getX();
        Cell cell = currentRunway.verifyCellCollision(newX, newY, specialObject.getWidth(), specialObject.getHeight());

        if (cell != null) {
            //System.out.println("Collision detected with cell ID: " + cell.getId());

            if (cell.getId().equals(CellWall.CELL_ID)) {
                int cellTop = cell.getY();
                int cellBottom = cell.getY() + cell.getHeight();
                int objectTop = newY;
                int objectBottom = newY + specialObject.getHeight();

                //System.out.println("objectTop: " + objectTop + ", objectBottom: " + objectBottom);
                //System.out.println("cellTop: " + cellTop + ", cellBottom: " + cellBottom);

                // Determine the side of the collision
                if (specialObject.getDirectionY() == 1) { //Moving down
                    if (objectBottom >= cellTop) {
                        specialObject.setDirectionY(-1); //Change direction to up
                        //System.out.println("Direction changed to up");
                    }
                } else if (specialObject.getDirectionY() == -1) { // Moving up
                    if (objectTop <= cellBottom) {
                        specialObject.setDirectionY(1); // Change direction to down
                        //System.out.println("Direction changed to down");
                    }
                }
            }
        } else {
            //System.out.println("No collision detected at newY: " + newY);
        }
    } else {
        //System.out.println("CurrentRunway is null");
    }
}

    public void updateGame() {
        for (SpecialObject specialObject : specialsObjects) {
            int newY = specialObject.getY() + specialObject.getVelocityY() * specialObject.getDirectionY();
            verifySpecialObjectCollision(specialObject, newY);
            specialObject.updatePosition(); // Asume que este método actualiza la posición basada en la dirección y velocidad
        }
        
    // Redibujar o actualizar el estado del juego aquí si es necesario
        paint.repaint(); // Llama a repaint para actualizar la visualización si es necesario
    }

    
    // aqui se esta verificando la colision con el borde de la pista
    @Override
    public void verifyRunwayCollision(int newX, int newY, Car car) {
        Cell cell = currentRunway.verifyCellCollision(newX, newY, car.getWidth(), car.getHeight());
        if(cell != null){
            if(cell.getId().equals(CellTrail.CELL_ID)){
                car.setMaxSpeed(Car.MAX_SPEED_TRAIL);
            }
            if(cell.getId().equals(CellBorder.CELL_ID)){
                car.setMaxSpeed(Car.MAX_SPEED_BORDER);
            }
            if(cell.getId().equals(CellGrass.CELL_ID)){
                car.setMaxSpeed(Car.MAX_SPEED_GRASS);
            }
            if(cell.getId().equals(CellWall.CELL_ID)){
                int collisionX = Math.max(newX, cell.getX());
                int collisionY = Math.max(newY, cell.getY());

                // Determina qué lado está colisionando
                if (collisionX == newX && collisionY == newY + car.getHeight()) {
                    //Superior
                    car.setVelocityY(0);
                } if (collisionX == newX && collisionY == newY) {
                    //Inferior
                    car.setVelocityY(0);
                } if (collisionX == newX + car.getWidth() && collisionY == newY) {
                    //Derecho
                    car.setVelocityX(0);
                } if (collisionX == newX + car.getWidth() && collisionY == newY + car.getHeight()) {
                    //Esquina
                } if (collisionX == newX){
                    //Izquierdo
                    car.setVelocityX(0);
                }
                else {
                    // Si no está en un lado, podría ser un lado lateral
                    if (collisionX == newX || collisionX == newX + car.getWidth()) {
                        //Lateral
                        car.setVelocityX(0);
                    } else {
                        // Podría ser un lado superior o inferior
                        //Superior o inferior
                        car.setVelocityY(0);
                    }
                }
            }
        }
        
    }
    
    
    public void createSpecialObject(){
        
        try {
                // Si se cargó la pista, inicializa el carro
                imageIncrease = javax.imageio.ImageIO.read(shrinkUrl2);
                imageShrink = javax.imageio.ImageIO.read(shrinkUrl1);
                imageStop = javax.imageio.ImageIO.read(stopUrl);

            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        int contObj=specialsObjects.size();
        while (contObj<getNumPowers()) {                    
            int px=(int)(Math.random()*900);
            int py=(int)(Math.random() * 900) + 30;
            if (currentRunway.verifyPoint(px, py)) {
                int decision=(int)(Math.random()*3);
                SpecialObject e=null;
                if (decision==0) {
                    e=new ReducedSize(px, py, 30, 30, "shrink", imageShrink, shrinkUrl1,paint,this);

                }else if(decision==1){
                    e=new IncreasedSize(px, py, 30, 30, "grow", imageIncrease, shrinkUrl2,paint,this);
                
                }else if(decision==2){
                    e=new StoppedMovement(px, py, 30, 30, "stop", imageStop, stopUrl, paint,this) ;               }
                
                specialsObjects.add(e);
                contObj+=1;
                }

            }
    
    }
    
    public ArrayList<String> getScoreNames(){
        
        return scoreManager.getNames();
    }
    
    public ArrayList<Integer> getScorePoints(){
        return scoreManager.getScores();
    }

    private void initializePlayers(){

                
        this.specialsObjects = new ArrayList<>();
        winner = "none";
        if (getCurrentRunway() != null) {
            
            int carCoorX = currentRunway.getCheckPoints().get(0).getX()+36;
            int carCoorY = currentRunway.getCheckPoints().get(0).getY()+36;
            
            //Player1
            ArrayList<BufferedImage> imagesCarPlayer1 = imageManager.getImagesCar(carplayer1);
            String namePlayer1 = scoreManager.getNameSelectedPlayer(1);
            int scorePlayer1 = scoreManager.getScorePlayer(namePlayer1);
            player1 = new Player1(namePlayer1, imagesCarPlayer1, paint, this, scorePlayer1, carCoorX, carCoorY);
           
            //PLayer2
            ArrayList<BufferedImage> imagesCarPlayer2 = imageManager.getImagesCar(carplayer2);
            String namePlayer2 = scoreManager.getNameSelectedPlayer(2);
            int scorePlayer2 = scoreManager.getScorePlayer(namePlayer2);
            player2 = new Player2(namePlayer2, imagesCarPlayer2, paint, this, scorePlayer2, carCoorX+40, carCoorY);
            
            createSpecialObject();
            gameUpdateTimer = new Timer(10, e -> updateGame()); 
            gameUpdateTimer.start();
            nCheckpoints = currentRunway.getnCheckpoints()-1;
            

        }
    }
    
    private void finalizePlayers(){
        
        scoreManager.updateScore(player1.getName(), player1.getScore());
        scoreManager.updateScore(player2.getName(), player2.getScore());
        
        gameUpdateTimer = null;
        player1.stopCar();
        player1 = null;
        player2.stopCar();
        player2 = null;
    }
    
    @Override
    public String getScorePlayerName(int player){
            return scoreManager.getNameSelectedPlayer(player);
    }

    @Override
    public void selectScorePlayerName(int player, String name) {
        scoreManager.setSelectedPlayers(player, name);
    }

    @Override
    public void addScorePlayer(int player, String name) throws DuplicateScoreException{
        scoreManager.addScore(name, 0);
    }

    @Override
    public void selectCarPlayer(int player, String carname) {
        if(player == 1){
            carplayer1=carname;
        }else{
            carplayer2=carname;

        }
    }

    /**
     * @return the sounds
     */
    public ArrayList <Sound> getSounds() {
        return sounds;
    }

    @Override
    public int getNumPowers() {
        return numPowers;
    }

    @Override
    public void setNumPowers(int numPowers) {
        this.numPowers = numPowers;
    }

    @Override
    public int getMaxLaps() {
        return maxLaps;
    }

    @Override
    public void setMaxLaps(int maxLaps) {
        this.maxLaps = maxLaps;
    }
    @Override
    public int getGameWidth(){
        return currentRunway.getWidth();
    }
    @Override
    public int getGameHeight(){
        return currentRunway.getHeight();
    }

    
    
    
}
