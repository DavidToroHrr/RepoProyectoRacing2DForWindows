/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

/**
 *
 * @author usuario
 */
public abstract class Sprite {

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    

    public Sprite(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
    }
    
    
    public boolean verifyCollision(int x2,int y2,int width2,int height2){
        int izqObj1 = x;
        int derObj1 = x+width;
        int supObj1 = y;
        int infObj1 = y + height;

        int izqObj2 = x2;
        int derObj2 = x2 + width2;
        int supObj2 = y2;
        int infObj2 = y2 + height2;
        return (izqObj1 < derObj2 && derObj1 > izqObj2 && supObj1 < infObj2 && infObj1 > supObj2);
    
    }
    
    public void draw(Graphics g) {
        
        g.setColor(Color.red);
       
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
}
