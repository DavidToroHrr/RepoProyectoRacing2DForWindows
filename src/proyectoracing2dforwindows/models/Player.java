/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author david
 */
public abstract class Player {
    protected String name;
    protected Car car;
    private int cpCurrent;
    
    public Player(String name, BufferedImage carImage){
        this.name = name;
        this.cpCurrent = -1;
    }
    
    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);

    public void draw(Graphics g) {
        car.draw(g);
    }
    
    public void actualizar(){
        car.actualizar();
    }

    public int getCpCurrent() {
        return cpCurrent;
    }

    public void setCpCurrent(int cpCurrent) {
        this.cpCurrent = cpCurrent;
    }
    
    
}
