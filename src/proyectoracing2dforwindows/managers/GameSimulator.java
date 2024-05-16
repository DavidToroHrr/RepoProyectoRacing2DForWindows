/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Timer;
import proyectoracing2dforwindows.interfaces.Coordenate;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.models.Car;
import proyectoracing2dforwindows.models.ReducedSize;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2dforwindows.models.SpecialObject;
import proyectoracing2dforwindows.threads.CarThread;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Coordenate{
    Paintable paint;
    //private boolean colision=false;
    
   
    
    private MapManager mapManager;
    private Runway currentRunway;
    private Car car1;
    private Timer timer;
    private Car car2;
    private CarThread carEngine;
    private Thread t1;
    private ArrayList <SpecialObject> specialsObjects;
    
    private BufferedImage image;
    
    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/images/encoger.png");

    
    URL imageUrl1 = getClass().getResource("/data/cars/yellowcar.png");
    
    public GameSimulator(Paintable p1) throws IOException{
        this.mapManager = new MapManager();
        this.currentRunway = null;
        this.paint=p1;
        specialsObjects=new ArrayList<>();
        
        
    }
    public void drawElements(Graphics g) throws InterruptedException{
        for (SpecialObject specialsObject : specialsObjects) {
            specialsObject.draw(g);
            paint.repaint();
        }
        if (car1 != null) {
            
            car1.draw(g); // Dibuja el carro normal si no hay colisión
            
            verifyMovement(car1);
            //paint.repaint(); // Es posible que no necesites llamar repaint() aquí, depende de cómo se maneje en tu implementación
        }
        
        
    }
    
    public void verifyMovement(Car car){
        for (SpecialObject specialsObject : specialsObjects) {
            
           if (specialsObject.verifyCollision(car.getX(), car.getY(), car.getWidth(), car.getHeight())) {
               System.out.println("COLISIONNNNNNNNNNNNNNNN");
               
               specialsObjects.remove(specialsObject);
               break;
            } 
        }
        
    
    }
    public void keyPressed(KeyEvent e) throws InterruptedException {
    if (car1 != null) {
        car1.keyPressed(e);
        
        // Llama al método de keyPressed de la clase Car
    }
    //d1.shrinkPlayer(car1);
    
    //colision=true;
    paint.repaint();
}
    public void keyReleased(KeyEvent e) throws InterruptedException {
    if (car1 != null) {
        car1.keyReleased(e);
        // Llama al método de keyPressed de la clase Car
    }
    
}
    
    public ArrayList<String> showMaps(){
        mapManager.loadRunways(0, 0);
        return mapManager.getRunwaysNames();
    }
    
    public void loadMap(String nameMap) throws IOException{
            setCurrentRunway(mapManager.getRunway(nameMap));
            if (getCurrentRunway() != null) {
                // Si se cargó la pista, inicializa el carro
                image = javax.imageio.ImageIO.read(imageUrl1); 
                car1 = new Car(0, 0, 34, 60, "Carro1", image, imageUrl1,paint);
                
                imageShrink = javax.imageio.ImageIO.read(imageUrl1);
                for (int i = 0; i < 2; i++) {
                    ReducedSize e=new ReducedSize(0, 100, 20, 20, "shrink", imageShrink, shrinkUrl1,paint);
                    //SpecialObject e=new SpecialObject(0, 100, 20, 20, "shrink", imageShrink, shrinkUrl1);
                    specialsObjects.add(e);
                }
                
                t1=new Thread(carEngine);
                t1.start();
                timer = new Timer(30, e -> car1.actualizar());
                timer.start();
            }
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
    
    public void stopCarThread() {
        //if (t1 != null) {
            //t1.stopThread(); // Detenemos el hilo si está en ejecución
        //}
        
    }
}
