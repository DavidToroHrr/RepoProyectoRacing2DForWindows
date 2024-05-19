/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public class IncreasedSize extends SpecialObject{
    public IncreasedSize(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable paintable) {
        super(x, y, width, height, id, image, url,paintable);
        
    }

    @Override
    public void applyEfect(CarCustomable cb,ArrayList <Sound>sound) {
        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        cb.setHeight(57);
        cb.setWidth(101);
        
        cb.setImage(cb.getCarImages().get(2));
        System.out.println("AUMENTAR");
        paintable.repaint(x, y, width, height);
        sound.get(1).playSound();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("AUMENTAR");
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        
        cb.setImage(cb.getCarImages().get(0));
        paintable.repaint(x, y, width, height);

    }
    
}
