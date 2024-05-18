/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
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
        paintable.repaint(cb.getX(), cb.getY(), width, height);

        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        
        BufferedImage imageCar1 = null;
        URL imageCarUrl1 = getClass().getResource("/data/cars/greencarRedimensionado.png");
        try {
            imageCar1 = javax.imageio.ImageIO.read(imageCarUrl1);
        } catch (IOException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cb.setHeight(10);
        cb.setWidth(34);
        BufferedImage imageOriginar;
        imageOriginar = cb.getImage();
        cb.setImage(imageCar1);
        System.out.println("COLISIONNNNNNNNNNNNNNNN");
        paintable.repaint();
        sound.get(0).playSound();
        System.out.println(cb.getWidth()+"ancho despues");
        System.out.println(cb.getHeight()+"ancho despues");
        
        
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("COLISIONNNNNNNNNNNNNNNN");
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        cb.setImage(imageOriginar);
        paintable.repaint(cb.getX(), cb.getY(), width, height);

    }
    
}
