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
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.threads.CarEngine;

public class Car extends Object implements CarCustomable {
    Paintable paint;
    private CarEngine ce;
    private Thread t1;
    
    private int velocityX; // Velocidad horizontal del carro
    private int velocityY; // Velocidad vertical del carro
    private final int SPEED_INCREMENT = 1; // Incremento de velocidad al presionar una tecla
    private final int MAX_SPEED = 3; // Velocidad máxima del carro
    private final int BRAKE=0;
    public Car(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1) {
        super(x, y, width, height, id, image, url);
        this.velocityX = 0;
        this.velocityY = 0;
        this.paint=p1;
        
        
    }
    public void actualizar() {
        // Actualizar la posición del carro
        x += getVelocityX();
        y += getVelocityY();

        // Limitar la velocidad máxima
        if (getVelocityX() > MAX_SPEED) {
            setVelocityX(MAX_SPEED);
        }
        if (getVelocityX() < -MAX_SPEED) {
            setVelocityX(-MAX_SPEED);
        }
        if (getVelocityY() > MAX_SPEED) {
            setVelocityY(MAX_SPEED);
        }
        if (getVelocityY() < -MAX_SPEED) {
            setVelocityY(-MAX_SPEED);
        }

        // Repintar el componente
        paint.repaint(x,y,width,height);
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_LEFT) {
            setVelocityX(getVelocityX() - SPEED_INCREMENT);
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_RIGHT) {
            setVelocityX(getVelocityX() + SPEED_INCREMENT);
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_UP) {
            setVelocityY(getVelocityY() - SPEED_INCREMENT);
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_DOWN) {
            setVelocityY(getVelocityY() + SPEED_INCREMENT);
        }
        paint.repaint(x,y,width,height);
        
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("entro a keyrealeased");
        int tecla = e.getKeyCode();
        // Frenar solo si no se está acelerando en esa dirección
        if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) {
            if (getVelocityX() > 0) {
                setVelocityX(getVelocityX() - BRAKE);
            } else if (getVelocityX() < 0) {
                setVelocityX(getVelocityX() + BRAKE);
            }
        } else if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            if (getVelocityY() > 0) {
                setVelocityY(getVelocityY() - BRAKE);
            } else if (getVelocityY() < 0) {
                setVelocityY(getVelocityY() + BRAKE);
            }
        }
        paint.repaint(x,y,width,height);
        
    }
    public boolean receiveEffect(Applicable ap){
        if (ce==null || ce.isControl() ) {
            ce=new CarEngine(ap, this);
            t1=new Thread(ce);
            t1.start();
            return true;
        }
        System.out.println("no se pudo crear");
        return false;
        
        
        
    }

    @Override
        public void draw(Graphics g) {
        super.draw(g);
        // Dibuja el carro en su posición actual
        Graphics2D g2d = (Graphics2D) g.create(); // Crea una copia del contexto gráfico
        //g2d.rotate(Math.toRadians(90), x + width / 2, y + height / 2); // Rota alrededor del centro de la imagen
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
}

