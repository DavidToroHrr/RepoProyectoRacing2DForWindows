/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.image.BufferedImage;
import java.net.URL;
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
    public void applyEfect(CarCustomable cb) {
        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        cb.setHeight(50);
        cb.setWidth(64);
        System.out.println("AUMENTAR");
        paintable.repaint(x, y, width, height);
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("AUMENTAR");
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        paintable.repaint(x, y, width, height);

    }
    
}