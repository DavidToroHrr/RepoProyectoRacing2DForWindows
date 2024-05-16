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
    private final int SPEED_INCREMENT = 1; // Incremento de velocidad al presionar una tecla
    private final int MAX_SPEED = 3; // Velocidad máxima del carro
    private final int BRAKE=2;
    public Car(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1) {
        super(x, y, width, height, id, image, url);
        this.velocityX = 0;
        this.velocityY = 0;
        this.paint=p1;
        
        
    }
    public void actualizar() {
        // Actualizar la posición del carro
        x += velocityX;
        y += velocityY;

        // Limitar la velocidad máxima
        if (velocityX > MAX_SPEED) {
            velocityX = MAX_SPEED;
        }
        if (velocityX < -MAX_SPEED) {
            velocityX = -MAX_SPEED;
        }
        if (velocityY > MAX_SPEED) {
            velocityY = MAX_SPEED;
        }
        if (velocityY < -MAX_SPEED) {
            velocityY = -MAX_SPEED;
        }

        // Repintar el componente
        paint.repaint();
    }

    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_LEFT) {
            velocityX -= SPEED_INCREMENT;
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_RIGHT) {
            velocityX += SPEED_INCREMENT;
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_UP) {
            velocityY -= SPEED_INCREMENT;
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_DOWN) {
            velocityY += SPEED_INCREMENT;
        }
        paint.repaint();
    }

    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        // Frenar solo si no se está acelerando en esa dirección
        if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) {
            if (velocityX > 0) {
                velocityX -= BRAKE;
            } else if (velocityX < 0) {
                velocityX += BRAKE;
            }
        } else if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            if (velocityY > 0) {
                velocityY -= BRAKE;
            } else if (velocityY < 0) {
                velocityY += BRAKE;
            }
        }
        paint.repaint();
        
    }

    @Override
        public void draw(Graphics g) {
        super.draw(g);
        // Dibuja el carro en su posición actual
        Graphics2D g2d = (Graphics2D) g.create(); // Crea una copia del contexto gráfico
        //g2d.rotate(Math.toRadians(90), x + width / 2, y + height / 2); // Rota alrededor del centro de la imagen
        g2d.drawImage(getImage(), x, y, width, height, null);
        paint.repaint();
    }
}

