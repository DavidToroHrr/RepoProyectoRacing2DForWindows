/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;

/**
 *
 * @author david
 */
public class StoppedMovement extends SpecialObject{

    public StoppedMovement(int x, int y, int width, int height, String id, BufferedImage image, URL url, Paintable paintable,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url, paintable,specialMovable);
    }

    @Override
    public void applyEfect(CarCustomable cb, ArrayList<Sound> sound) {
        
        long startTime = System.currentTimeMillis();
        long currentTime = System.currentTimeMillis();
        
        while(currentTime-startTime < 500){
            cb.setVelocityX(0);
            cb.setVelocityY(0);
            currentTime = System.currentTimeMillis();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(StoppedMovement.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
}
