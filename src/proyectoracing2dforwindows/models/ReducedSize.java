/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.net.URL;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public class ReducedSize extends SpecialObject{
    Paintable p1;
    public ReducedSize(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1) {
        super(x, y, width, height, id, image, url);
    }
    
    public void shrinkPlayer(Car car,Graphics g) throws InterruptedException{
        
        int temporalHeight=car.getHeight();
        int temporalWidth=car.getWidth();
        car.setHeight(10);
        car.setWidth(34);
        car.draw(g);
        
        p1.repaint(x, y, width, height);
        
        Thread.sleep(1000);
        
        
        car.setHeight(temporalHeight);
        car.setWidth(temporalWidth);
        
        //p1.repaint();
    };
    
}
