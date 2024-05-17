/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author david
 */
public class Car1 extends Car{

    public Car1(int x, int y, int width, int height, String id, BufferedImage image, URL url, Paintable p1, Movable movable) {
        super(x, y, width, height, id, image, url, p1, movable);
    }
    
    public void keyPressed(KeyEvent e) {
        paint.repaint(x,y,width,height);
        
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
        
    }

    public void keyReleased(KeyEvent e) {
                paint.repaint(x,y,width,height);

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
}
