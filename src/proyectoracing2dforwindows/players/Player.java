/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.players;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.Timer;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.car.Car;
import proyectoracing2dforwindows.specialsounds.Sound;
import proyectoracing2dforwindows.threads.SoundThread;

/**
 *
 * @author david
 */
public abstract class Player {
    protected String name;
    protected Car car;
    private int cpCurrent;
    private int lap;
    private int score;
    private Timer timerCar;
    
    
    public Player(String name, ArrayList <BufferedImage> carImages, Paintable paintable, Movable movable, int score, int x, int y,Sound sounds,SoundThread st){
        
        this.name = name;
        this.cpCurrent = -1;
        this.lap = 0;
        this.score = score;
        
        car = new Car(x, y, 34, 60, name, carImages, null, paintable, movable,sounds,st);
        timerCar = new Timer(10, e -> getCar().actualizar());
        timerCar.start();
    }
    
    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);

    public void draw(Graphics g) {
        
        getCar().draw(g);
        g.setColor(Color.WHITE); // Establece el color del texto
        g.setFont(new Font("Arial", Font.PLAIN, 15)); // Establece la fuente del texto
        g.drawString(name, getCar().getX(), getCar().getY()-10); // Dibuja el texto en las coordenadas (50, 50)

    }
    
    public void actualizar(){
        getCar().actualizar();
    }

    public int getCpCurrent() {
        return cpCurrent;
    }

    public void setCpCurrent(int cpCurrent) {
        this.cpCurrent = cpCurrent;
        if(cpCurrent == 0){
            lap += 1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setImages(ArrayList<BufferedImage> carImages){
        getCar().setCarImages(carImages);
    }

    public int getLap() {
        return lap;
    }

    /**
     * @param lap the lap to set
     */
    public void setLap(int lap) {
        this.lap = lap;
    }

    /**
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }
    
    public void stopCar(){
        timerCar.stop();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
    
    
}
