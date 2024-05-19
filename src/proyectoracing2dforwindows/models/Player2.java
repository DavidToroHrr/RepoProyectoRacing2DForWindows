/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;

/**
 *
 * @author usuario
 */
public class Player2 extends Player{
    public Player2(String name, BufferedImage carImage, Paintable paintable, Movable movable,ArrayList <BufferedImage> carImages) {
        super(name, carImage);
        car = new Car(900 / 2 - 300, 900 / 2, 34, 60, name, carImage, null, paintable, movable,carImages);
    }

    public void keyPressed(KeyEvent e) {
        
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_A) {
            car.keyPressed('L');
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_D) {
            car.keyPressed('R');
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_W) {
            car.keyPressed('U');
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_S) {
            car.keyPressed('D');
        }
        
    }

    public void keyReleased(KeyEvent e) {

        System.out.println("entro a keyrealeased");
        int tecla = e.getKeyCode();
        // Frenar solo si no se está acelerando en esa dirección
        if (tecla == KeyEvent.VK_A || tecla == KeyEvent.VK_D) {
            if(tecla == KeyEvent.VK_A){
                car.keyReleased('L');
            }else{
                car.keyReleased('R');
            }
        } else if (tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_S) {
            if(tecla == KeyEvent.VK_W){
                car.keyReleased('U');
            }else{
                car.keyReleased('D');
            }
        }
        
    }
}