/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialobjetcs;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;
import proyectoracing2dforwindows.models.Object;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
 *
 * @author david
 */
public abstract class SpecialObject extends Object implements Applicable{
    public Paintable paintable;
    
    protected int velocityY;
    protected int directionY; 
    private SpecialMovable specialMovable;
    
    public SpecialObject(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable paintable,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url);
        
        this.specialMovable=specialMovable;
        
        this.paintable=paintable;
        this.velocityY=1; // esta es la velocidad inicial del objeto
        this.directionY=-1; // esta es la dirección del objeto 1 es para abajo y -1 es para arriba
        
        
    }
    
    @Override
    public abstract void applyEfect(CarCustomable cb,ArrayList <Sound>sound);
    
     public void updatePosition() {
        int newY = y + velocityY * directionY;
        
        specialMovable.verifySpecialObjectCollision(this, newY);
        y = newY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getDirectionY() {
        return directionY;
    }
    
    
    
    
    
}
