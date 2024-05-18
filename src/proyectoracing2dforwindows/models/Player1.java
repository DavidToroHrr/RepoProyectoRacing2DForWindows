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
public class Player1 extends Player{

    public Player1(String name, BufferedImage carImage, Paintable paintable, Movable movable,ArrayList <BufferedImage> carImages) {
        super(name, carImage);
        car = new Car(900 / 2 - 250, 900 / 2, 34, 60, name, carImage, null, paintable, movable,carImages);
    }

    public void keyPressed(KeyEvent e) {
        
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_LEFT) {
            car.keyPressed('L');
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_RIGHT) {
            car.keyPressed('R');
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_UP) {
            car.keyPressed('U');
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_DOWN) {
            car.keyPressed('D');
        }
        
    }

    public void keyReleased(KeyEvent e) {

        System.out.println("entro a keyrealeased");
        int tecla = e.getKeyCode();
        // Frenar solo si no se está acelerando en esa dirección
        if (tecla == KeyEvent.VK_LEFT || tecla == KeyEvent.VK_RIGHT) {
            if(tecla == KeyEvent.VK_LEFT){
                car.keyReleased('L');
            }else{
                car.keyReleased('R');
            }
        } else if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            if(tecla == KeyEvent.VK_UP){
                car.keyReleased('U');
            }else{
                car.keyReleased('D');
            }
        }
        
    }
    
}
