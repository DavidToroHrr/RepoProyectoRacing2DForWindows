/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;
import proyectoracing2dforwindows.interfaces.*;
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
import proyectoracing2dforwindows.exceptions.*;
import proyectoracing2dforwindows.models.*;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Coordenate, Movable, Drawable{
    Paintable paint;
    //private boolean colision=false;
    private static GameSimulator instance;

    private MapManager mapManager;
    private ScoreManager scoreManager;
    private Runway currentRunway;
    private SoundManager soundManager;
    private ImageManager imageManager;
    
    private int nCheckpoints;
    
    private Timer gameUpdateTimer;
    
    private String carplayer1;
    private Player1 player1;
    
    private String carplayer2;
    private Player2 player2;
  
    private ArrayList <SpecialObject> specialsObjects;
    
    
    
    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/powers/reducesize.png");
    
    
    private BufferedImage imageIncrease;
    URL shrinkUrl2 = getClass().getResource("/data/powers/hongo.png");

    private BufferedImage imageStop;
    URL stopUrl = getClass().getResource("/data/powers/stop.png");
    
    
    
    

    public GameSimulator()throws IOException {
        this.mapManager = new MapManager();
        this.currentRunway = null;
        this.soundManager=new SoundManager();
        this.imageManager=new ImageManager();
        this.scoreManager = new ScoreManager();
        this.carplayer1 = "redcar";
        this.carplayer2 = "greencar";
        
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
        paint.repaint();
        
        
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
                    //System.out.println(car.getWidth()+"despues de la fn");
                    createSpecialObject();
                    //paint.repaint();
                    
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
        int cp_current;
        if(id.equals(carplayer1)){
            cp_current = player1.getCpCurrent();
            if(cp_current == -1 & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
            }else if(cp_current + 1 == cp_collided){
                player1.setCpCurrent(cp_collided);
            }else if(cp_current == nCheckpoints & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
            }
            System.out.println("player1 checpoint actual:"+player1.getCpCurrent());
        }else if(id.equals(carplayer2)){
            cp_current = player2.getCpCurrent();
            if(cp_current == -1 & cp_collided == 0){
                player2.setCpCurrent(cp_collided);
            }else if(cp_current + 1 == cp_collided){
                player2.setCpCurrent(cp_collided);
            }else if(cp_current == nCheckpoints & cp_collided == 0){
                player2.setCpCurrent(cp_collided);
            }
            System.out.println("player2 checpoint actual:"+player2.getCpCurrent());
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
        //TO DO:
        //AQUI ADENTRO IRIA E POLIMORFISMO PARA VER CUAL MUEVE,DEPENDIENDO
        //DE LO QUE SE LE MANDE HARÁ LA ACCIÓN DEL MOC¿VIMIENTO
        // Llama al método de keyPressed de la clase Car
        
    }
    if (player2 != null) {
        player2.keyReleased(e);//if evt vk_up---->else el otro carro con sus teclas
        //TO DO:
        //AQUI ADENTRO IRIA E POLIMORFISMO PARA VER CUAL MUEVE,DEPENDIENDO
        //DE LO QUE SE LE MANDE HARÁ LA ACCIÓN DEL MOC¿VIMIENTO
        // Llama al método de keyPressed de la clase Car
        
    }
    
}
    
    
    
    public ArrayList<String> showMaps() throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException{
        mapManager.loadRunways(0, 0);
        return mapManager.getRunwaysNames();
    }
    
    public void loadMap(String nameMap) throws IOException{
            setCurrentRunway(mapManager.getRunway(nameMap));
            
    }
    
    public void addSpecialObject(){
    
    
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

    public void verifySpecialObjectCollision(SpecialObject specialObject, int newY) {
    if (currentRunway != null) {
        System.out.println("Verifying collision for SpecialObject at newY: " + newY);

        //Use the current x position of the special object
        int newX = specialObject.getX();
        Cell cell = currentRunway.verifyCellCollision(newX, newY, specialObject.getWidth(), specialObject.getHeight());

        if (cell != null) {
            System.out.println("Collision detected with cell ID: " + cell.getId());

            if (cell.getId().equals(CellWall.CELL_ID)) {
                int cellTop = cell.getY();
                int cellBottom = cell.getY() + cell.getHeight();
                int objectTop = newY;
                int objectBottom = newY + specialObject.getHeight();

                System.out.println("objectTop: " + objectTop + ", objectBottom: " + objectBottom);
                System.out.println("cellTop: " + cellTop + ", cellBottom: " + cellBottom);

                // Determine the side of the collision
                if (specialObject.getDirectionY() == 1) { //Moving down
                    if (objectBottom >= cellTop) {
                        specialObject.setDirectionY(-1); //Change direction to up
                        System.out.println("Direction changed to up");
                    }
                } else if (specialObject.getDirectionY() == -1) { // Moving up
                    if (objectTop <= cellBottom) {
                        specialObject.setDirectionY(1); // Change direction to down
                        System.out.println("Direction changed to down");
                    }
                }
            }
        } else {
            System.out.println("No collision detected at newY: " + newY);
        }
    } else {
        System.out.println("CurrentRunway is null");
    }
}




    
    public static GameSimulator getInstance() {
        if (instance == null) {
            try {
                instance = new GameSimulator();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
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
        while (contObj<=10) {                    
            int px=(int)(Math.random()*900);
            int py=(int)(Math.random() * 900) + 30;
            if (currentRunway.verifyPoint(px, py)) {
                int decision=(int)(Math.random()*3);
                SpecialObject e=null;
                if (decision==0) {
                    e=new ReducedSize(px, py, 30, 30, "shrink", imageShrink, shrinkUrl1,paint);

                }else if(decision==1){
                    e=new IncreasedSize(px, py, 30, 30, "grow", imageIncrease, shrinkUrl2,paint);
                
                }else if(decision==2){
                    e=new StoppedMovement(px, py, 30, 30, "stop", imageStop, stopUrl, paint) ;               }
                
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
        
        if (getCurrentRunway() != null) {
            //Player1
            ArrayList<BufferedImage> imagesCarPlayer1 = imageManager.getImagesCar(carplayer1);
            String namePlayer1 = scoreManager.getNameSelectedPlayer(1);
            player1 = new Player1(namePlayer1, imagesCarPlayer1, paint, this);
            
            //PLayer2
            ArrayList<BufferedImage> imagesCarPlayer2 = imageManager.getImagesCar(carplayer2);
            String namePlayer2 = scoreManager.getNameSelectedPlayer(2);
            player2 = new Player2(namePlayer2, imagesCarPlayer2, paint, this);
            
            createSpecialObject();
            gameUpdateTimer = new Timer(10, e -> updateGame()); 
            gameUpdateTimer.start();
            nCheckpoints = currentRunway.getnCheckpoints()-1;

        }
    }
    
    public String getScorePlayerName(int player){
            return scoreManager.getNameSelectedPlayer(player);
    }
    
    
}
