/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public abstract class Player {
    protected String name;
    protected Car car;
    private int cpCurrent;
    private Timer timerCar;
    
    public Player(String name, ArrayList <BufferedImage> carImages, Paintable paintable, Movable movable){
        this.name = name;
        this.cpCurrent = -1;
        car = new Car(900 / 2 - 250, 900 / 2, 34, 60, name, carImages, null, paintable, movable);
        timerCar = new Timer(10, e -> car.actualizar());
        timerCar.start();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
