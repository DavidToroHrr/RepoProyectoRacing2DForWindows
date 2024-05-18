/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;
import proyectoracing2dforwindows.interfaces.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;
import proyectoracing2dforwindows.interfaces.Coordenate;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.models.*;

import proyectoracing2dforwindows.models.Sprite;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Coordenate, Movable, Drawable{
    Paintable paint;
    //private boolean colision=false;

    private MapManager mapManager;
    private Runway currentRunway;
    private SoundManager soundManager;
    
    private int nCheckpoints;
    
    private Player1 player1;
    private Timer timerCar1;
    private BufferedImage imageCar1;
    URL imageCarUrl1 = getClass().getResource("/data/cars/yellowcar.png");
    
    private Player2 player2;
    private Timer timerCar2;
    private BufferedImage imageCar2;
    URL imageCarUrl2 = getClass().getResource("/data/cars/greencar.png");
  
    private ArrayList <SpecialObject> specialsObjects;
    
    
    
    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/powers/reducesize.png");
    
    
    private BufferedImage imageIncrease;
    URL shrinkUrl2 = getClass().getResource("/data/powers/hongo.png");
    
    
    
    

    public GameSimulator()throws IOException {
        this.mapManager = new MapManager();
        this.currentRunway = null;
        this.soundManager=new SoundManager();
        
        
    }
    public void drawElements(Graphics g) throws InterruptedException{
        
        for (SpecialObject specialsObject : specialsObjects) {
            specialsObject.draw(g);
            
        }
        
        if (player1 != null) {
            
            player1.draw(g); // Dibuja el carro normal si no hay colisión
            player2.draw(g); // Dibuja el carro normal si no hay colisión
            
            //paint.repaint(); // Es posible que no necesites llamar repaint() aquí, depende de cómo se maneje en tu implementación
        }
        //paint.repaint();
        
        
    }
    
    @Override
    public void verifyObjectCollision(Car car){
        Iterator<SpecialObject> iterator = specialsObjects.iterator();
        while (iterator.hasNext()) {
            SpecialObject specialObject = iterator.next();
            if (specialObject.verifyCollision(car.getX(), car.getY(), car.getWidth(), car.getHeight())) {
                if(car.receiveEffect(specialObject,soundManager.getSounds())){
                    iterator.remove(); // Elimina el objeto actual de la lista de manera segura
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
        if(id.equals("player1")){
            cp_current = player1.getCpCurrent();
            if(cp_current == -1 & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
            }else if(cp_current + 1 == cp_collided){
                player1.setCpCurrent(cp_collided);
            }else if(cp_current == nCheckpoints & cp_collided == 0){
                player1.setCpCurrent(cp_collided);
            }
            System.out.println("player1 checpoint actual:"+player1.getCpCurrent());
        }else if(id.equals("player2")){
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
        int contObj=specialsObjects.size();
        while (contObj<=10) {                    
            int px=(int)(Math.random()*900);
            int py=(int)(Math.random() * 900) + 30;
            if (currentRunway.verifyPoint(px, py)) {
                int decision=(int)(Math.random()*2);
                SpecialObject e;
                if (decision==0) {
                    e=new ReducedSize(px, py, 30, 30, "shrink", imageShrink, shrinkUrl1,paint);

                }else{
                    e=new IncreasedSize(px, py, 30, 30, "grow", imageIncrease, shrinkUrl2,paint);
                }
                specialsObjects.add(e);
                contObj+=1;
                }

            }
    
    }

    private void initializePlayers(){
        
        this.specialsObjects = new ArrayList<>();
        if (getCurrentRunway() != null) {
            try {
                // Si se cargó la pista, inicializa el carro
                imageCar1 = javax.imageio.ImageIO.read(imageCarUrl1);
                imageCar2 = javax.imageio.ImageIO.read(imageCarUrl2);
                imageIncrease = javax.imageio.ImageIO.read(shrinkUrl2);
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
            player1 = new Player1("player1", imageCar1, paint, this);
            player2 = new Player2("player2", imageCar2, paint, this);

            try {
                imageShrink = javax.imageio.ImageIO.read(shrinkUrl1);
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }

            timerCar1 = new Timer(10, e -> player1.actualizar());
            //timer = new Timer(30, e -> car1.actualizar());
            timerCar1.start();
            timerCar2 = new Timer(10, e -> player2.actualizar());
            //timer = new Timer(30, e -> car1.actualizar());
            timerCar2.start();
            createSpecialObject();
            nCheckpoints = currentRunway.getnCheckpoints()-1;

        }
    }
    
    
}
