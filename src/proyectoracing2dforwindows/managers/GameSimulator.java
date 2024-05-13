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
import proyectoracing2dforwindows.interfaces.Coordenate;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.models.Car;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2dforwindows.threads.CarThread;

/**
 *
 * @author usuario
 */
public class GameSimulator implements Coordenate{
    Paintable paint;
    private MapManager mapManager;
    private Runway currentRunway;
    private Car car1;
    private Car car2;
    private CarThread carEngine;
    private Thread t1;
    
    private BufferedImage image;
    URL imageUrl1 = getClass().getResource("/data/images/carro.png");
    
    public GameSimulator(Paintable p1) throws IOException{
        this.mapManager = new MapManager();
        this.currentRunway = null;
        this.paint=p1;
        
    }
    public void drawElements(Graphics g){
        if (car1!=null) {
            car1.draw(g);
            
            
        }
        paint.repaint();
        
    }
    public void keyPressed(int code) {
    if (car1 != null) {
        car1.keyPressed(code); // Llama al método de keyPressed de la clase Car
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
                car1 = new Car(0, 0, 10, 10, "Carro1", image, imageUrl1,paint);
                t1=new Thread(carEngine);
                t1.start();
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
