/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public interface CarCustomable {
    public int getX();
    public void setImage(BufferedImage image);
    public BufferedImage getImage();
    public ArrayList <BufferedImage> getcarImages();
    
    public void setX(int x);

   
    public int getY();

    
    public void setY(int y);
    
    public int getVelocityX();

    
    public void setVelocityX(int velocityX);

    
    public int getVelocityY();
    public void setVelocityY(int velocityY);
    
    
    public int getWidth();
    public void setWidth(int width);
    public int getHeight();
    public void setHeight(int height);
}
