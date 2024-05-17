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
import proyectoracing2dforwindows.models.IncreasedSize;
import proyectoracing2dforwindows.models.ReducedSize;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2dforwindows.models.SpecialObject;
import proyectoracing2dforwindows.models.Sprite;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Coordenate, Movable, Drawable{
    Paintable paint;
    //private boolean colision=false;
    
   int cont=0;
    
    private MapManager mapManager;
    private Runway currentRunway;
    private Car car1;
    private Timer timer;
    private Car car2;
    private Thread t1;
    private ArrayList <SpecialObject> specialsObjects;
    
    private BufferedImage image;
    
    private BufferedImage imageShrink;
    URL shrinkUrl1 = getClass().getResource("/data/powers/reducesize.png");

    
    URL imageUrl1 = getClass().getResource("/data/cars/yellowcar.png");
    
    public GameSimulator() throws IOException{
        
        this.mapManager = new MapManager();
        this.currentRunway = null;
        
        
    }
    public void drawElements(Graphics g) throws InterruptedException{
        
        for (SpecialObject specialsObject : specialsObjects) {
            specialsObject.draw(g);
            
        }
        
        if (car1 != null) {
            
            car1.draw(g); // Dibuja el carro normal si no hay colisión
            
            //paint.repaint(); // Es posible que no necesites llamar repaint() aquí, depende de cómo se maneje en tu implementación
        }
        //paint.repaint();
        
        
    }
    
    public void verifyObjectCollision(Car car){
        Iterator<SpecialObject> iterator = specialsObjects.iterator();
        while (iterator.hasNext()) {
            SpecialObject specialObject = iterator.next();
            if (specialObject.verifyCollision(car.getX(), car.getY(), car.getWidth(), car.getHeight())) {
                if(car1.receiveEffect(specialObject)){
                    iterator.remove(); // Elimina el objeto actual de la lista de manera segura
                    paint.repaint();
                }
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
    
    public void deleteSpecialObject(SpecialObject eo){
        specialsObjects.remove(eo);
    
    }
    
    public ArrayList<String> showMaps(){
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
    
    public void stopCarThread() {
        //if (t1 != null) {
            //t1.stopThread(); // Detenemos el hilo si está en ejecución
        //}
        
    }

    public void setPaint(Paintable paint) {
        this.paint = paint;
        this.specialsObjects=new ArrayList<>();
        if (getCurrentRunway() != null) {
            try {
                // Si se cargó la pista, inicializa el carro
                image = javax.imageio.ImageIO.read(imageUrl1); 
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
                car1 = new Car(0, 0, 34, 60, "Carro1", image, imageUrl1,paint,this);
                
            try {
                imageShrink = javax.imageio.ImageIO.read(shrinkUrl1);
            } catch (IOException ex) {
                Logger.getLogger(GameSimulator.class.getName()).log(Level.SEVERE, null, ex);
            }
                int contObj=0;
                while (contObj<=20) {                    
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
                
                
                
                timer = new Timer(10, e -> car1.actualizar());
                //timer = new Timer(30, e -> car1.actualizar());
                timer.start();
            }
    }

    @Override
    public void verifyRunwayCollision(int newX, int newY, Sprite measures) {
        String cellId = currentRunway.verifyCellCollision(newX, newY, measures.getWidth(), measures.getHeight());
        
        
    }
    
    
}
