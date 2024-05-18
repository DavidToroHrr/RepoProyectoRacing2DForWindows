/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.threads.CarEngine;

public abstract class Car extends Object implements CarCustomable {
    Paintable paint;
    protected CarEngine ce;
    protected Thread t1;
    protected Movable movable;
    protected int maxSpeed;
    
    protected int velocityX; // Velocidad horizontal del carro
    protected int velocityY; // Velocidad vertical del carro
    protected final int SPEED_INCREMENT = 1; // Incremento de velocidad al presionar una tecla
    public static final int MAX_SPEED_TRAIL = 3; // Velocidad máxima del carro
    public static final int MAX_SPEED_BORDER = 2; // Velocidad máxima del carro
    public static final int MAX_SPEED_GRASS = 1; // Velocidad máxima del carro
    protected final int BRAKE=0;
    public Car(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1,Movable movable) {
        super(x, y, width, height, id, image, url);
        maxSpeed = MAX_SPEED_TRAIL;
        this.velocityX = 0;
        this.velocityY = 0;
        this.paint=p1;
        this.movable = movable;
        
    }
    public void actualizar() {
        paint.repaint(x,y,width,height);

        int xNuevo = x;
        int yNuevo = y;
        // Actualizar la posición del carro
        xNuevo += getVelocityX();
        yNuevo += getVelocityY();
        
        if(xNuevo != x || yNuevo != y){
            movable.verifyRunwayCollision(xNuevo, yNuevo, this);
            paint.repaint();
            
        }
        
        

        // Limitar la velocidad máxima
        if (getVelocityX() > maxSpeed) {
            setVelocityX(maxSpeed);
            
        }
        if (getVelocityX() < -maxSpeed) {
            setVelocityX(-maxSpeed);
        }
        if (getVelocityY() > maxSpeed) {
            setVelocityY(maxSpeed);
        }
        if (getVelocityY() < -maxSpeed) {
            setVelocityY(-maxSpeed);
        }
        x += getVelocityX();
        y += getVelocityY();
        
        movable.verifyObjectCollision(this);
        
    }

    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);
    public boolean receiveEffect(Applicable ap,ArrayList <Sound>sound){
        if (ce==null || ce.isControl() ) {
            ce=new CarEngine(ap, this,sound);
            t1=new Thread(ce);
            t1.start();
            return true;
        }
        System.out.println("no se pudo crear");
        return false;
        
        
        
    }
    public void rotateCar(){}
    @Override
        public void draw(Graphics g) {
        super.draw(g);
        // Dibuja el carro en su posición actual
        Graphics2D g2d = (Graphics2D) g.create(); // Crea una copia del contexto gráfico
        g2d.rotate(Math.toRadians(90), x + width / 2, y + height / 2); // Rota alrededor del centro de la imagen
        //int temporalWidth=width;
        //width=height;
        //height=width;
        g2d.drawImage(getImage(), x, y, width, height, null);
        
        //paint.repaint();
    }

    /**
     * @return the velocityX
     */
    public int getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public int getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    
}

