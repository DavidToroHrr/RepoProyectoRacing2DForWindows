/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.image.BufferedImage;
import java.net.URL;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public abstract class SpecialObject extends Object implements Applicable{
    Paintable paintable;
    public SpecialObject(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable paintable) {
        super(x, y, width, height, id, image, url);
        this.paintable=paintable;
    }
    
    public abstract void applyEfect(CarCustomable cb);
    
    
}
