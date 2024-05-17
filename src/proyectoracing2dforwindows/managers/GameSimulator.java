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
import proyectoracing2dforwindows.interfaces.Coordenate;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.models.Car;
import proyectoracing2dforwindows.models.Cell;
import proyectoracing2dforwindows.models.CellBorder;
import proyectoracing2dforwindows.models.CellGrass;
import proyectoracing2dforwindows.models.CellTrail;
import proyectoracing2dforwindows.models.CellWall;
import proyectoracing2dforwindows.models.IncreasedSize;
import proyectoracing2dforwindows.models.ReducedSize;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2dforwindows.models.SpecialObject;
import proyectoracing2forwindows.exceptions.FileManagerException;
import proyectoracing2forwindows.exceptions.InvalidMapFormatException;
import proyectoracing2forwindows.exceptions.MapFileNotFoundException;

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
    
    private Car car1;
    private Timer timer1;
    private BufferedImage image;
    URL imageUrl1 = getClass().getResource("/data/cars/yellowcar.png");
    
    private Timer timer2;
    private Car car2;
    private BufferedImage image2;
    URL imageUrl2 = getClass().getResource("/data/cars/greencar.png");
  
    private ArrayList <SpecialObject> specialsObjects;
    
    
    
    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/powers/reducesize.png");
    
    
    

    public GameSimulator()throws IOException {

    
    
    

        
        this.mapManager = new MapManager();
        this.currentRunway = null;
        
        
        
    }
    public void drawElements(Graphics g) throws InterruptedException{
        
        for (SpecialObject specialsObject : specialsObjects) {
            specialsObject.draw(g);
            
        }
        
        if (car1 != null) {
            
            car1.draw(g); // Dibuja el carro normal si no hay colisión
            car2.draw(g); // Dibuja el carro normal si no hay colisión
            
            //paint.repaint(); // Es posible que no necesites llamar repaint() aquí, depende de cómo se maneje en tu implementación
        }
        //paint.repaint();
        
        
    }
    
    public void verifyObjectCollision(Car car){
        Iterator<SpecialObject> iterator = specialsObjects.iterator();
        while (iterator.hasNext()) {
            SpecialObject specialObject = iterator.next();
            if (specialObject.verifyCollision(car.getX(), car.getY(), car.getWidth(), car.getHeight())) {
                if(car.receiveEffect(specialObject)){
                    iterator.remove(); // Elimina el objeto actual de la lista de manera segura
                    createSpecialObject();
                    //paint.repaint();
                    
                }
                break;
            }
        }
        
    }

    public void keyPressed(KeyEvent e) throws InterruptedException {
    if (car1 != null) {
        car1.keyPressed(e);
        
    }
    
    paint.repaint();
}
    public void keyReleased(KeyEvent e) throws InterruptedException {
    if (car1 != null) {
        car1.keyReleased(e);//if evt vk_up---->else el otro carro con sus teclas
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
    
    

    public void setPaint(Paintable paint) {
        this.paint = paint;
        this.specialsObjects=new ArrayList<>();
        if (getCurrentRunway() != null) {
            try {
                // Si se cargó la pista, inicializa el carro
                image = javax.imageio.ImageIO.read(imageUrl1); 
                image2 = javax.imageio.ImageIO.read(imageUrl2); 
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
                car1 = new Car(900/2-250, 900/2, 34, 60, "Carro1", image, imageUrl1,paint,this);
                car2 = new Car(900/2-300, 900/2, 34, 60, "Carro2", image2, imageUrl2,paint,this);
                
            try {
                imageShrink = javax.imageio.ImageIO.read(shrinkUrl1);
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                timer1 = new Timer(10, e -> car1.actualizar());
                //timer = new Timer(30, e -> car1.actualizar());
                timer1.start();
                timer2 = new Timer(10, e -> car2.actualizar());
                //timer = new Timer(30, e -> car1.actualizar());
                timer2.start();
                createSpecialObject();
                
            }
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
                    e=new ReducedSize(px, py, 20, 20, "shrink", imageShrink, shrinkUrl1,paint);

                }else{
                    e=new IncreasedSize(px, py, 20, 20, "grow", image, imageUrl1,paint);
                }
                specialsObjects.add(e);
                contObj+=1;
                }

            }
    
    }
    
    
}
