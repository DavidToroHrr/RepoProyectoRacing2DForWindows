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

/**
 *
 * @author david
 */
public class StoppedMovement extends SpecialObject{

    public StoppedMovement(int x, int y, int width, int height, String id, BufferedImage image, URL url, Paintable paintable) {
        super(x, y, width, height, id, image, url, paintable);
    }

    @Override
    public void applyEfect(CarCustomable cb, ArrayList<Sound> sound) {
          
            
    cb.setVelocityX(0);
    
    cb.setVelocityY(0);
          
    }
    
}
