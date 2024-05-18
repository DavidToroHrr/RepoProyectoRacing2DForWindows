/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public class ReducedSize extends SpecialObject implements Applicable{
    
    public ReducedSize(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1) {
        super(x, y, width, height, id, image, url,p1);
    }
    
    

    

    @Override
    public void applyEfect(CarCustomable cb,ArrayList <Sound>sound) {
        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        cb.setHeight(10);
        cb.setWidth(34);
        System.out.println("COLISIONNNNNNNNNNNNNNNN");
        paintable.repaint(x, y, width, height);
        sound.get(0).playSound();
        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("COLISIONNNNNNNNNNNNNNNN");
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        paintable.repaint(x, y, width, height);
    }
    
}
