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
import proyectoracing2dforwindows.interfaces.Paintable;

public class Car extends Object {
    Paintable paint;

    private int velocityX; // Velocidad horizontal del carro
    private int velocityY; // Velocidad vertical del carro
    private static final int SPEED_INCREMENT = 1; // Incremento de velocidad al presionar una tecla
    private static final int MAX_SPEED = 5; // Velocidad máxima del carro
    private static final int MIN_SPEED = -5; // Velocidad mínima del carro

    public Car(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1) {
        super(x, y, width, height, id, image, url);
        this.velocityX = 0;
        this.paint=p1;
        this.velocityY = 0;
    }

    public void keyPressed(int code) {
        // Maneja el evento de teclado y ajusta la velocidad del carro
        switch (code) {
            case KeyEvent.VK_UP:
                // Acelera hacia arriba
                velocityY -= SPEED_INCREMENT;
                System.out.println("Acelera");
                
               
                break;
            case KeyEvent.VK_DOWN:
                // Acelera hacia abajo
                velocityY += SPEED_INCREMENT;
                System.out.println("Frena");

                break;
            case KeyEvent.VK_LEFT:
                // Acelera hacia la izquierda
                velocityX -= SPEED_INCREMENT;
                 System.out.println("izqu");
                break;
            case KeyEvent.VK_RIGHT:
                // Acelera hacia la derecha
                velocityX += SPEED_INCREMENT;
                System.out.println("derecha");

                break;
        }
        // Limita la velocidad del carro
        velocityX = Math.min(MAX_SPEED, Math.max(MIN_SPEED, velocityX));
        velocityY = Math.min(MAX_SPEED, Math.max(MIN_SPEED, velocityY));
    }

    public void keyReleased(int code) {
        // Maneja el evento de teclado cuando se suelta la tecla
        switch (code) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                // Detiene el movimiento vertical
                velocityY = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                // Detiene el movimiento horizontal
                velocityX = 0;
                break;
        }
    }

    public void move() {
        // Actualiza la posición del carro según su velocidad
        x += velocityX;
        y += velocityY;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        // Dibuja el carro en su posición actual
        Graphics2D g2d=(Graphics2D)g;
        g2d.rotate(Math.toRadians(90));
        g2d.drawImage(image, x, y, width, height, null);
        paint.repaint();
        
        
       
        
    }
}

