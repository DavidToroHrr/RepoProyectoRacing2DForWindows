/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.players;

import proyectoracing2dforwindows.players.Player;
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
    public Player2(String name, ArrayList <BufferedImage> carImages, Paintable paintable, Movable movable, int score) {
        super(name, carImages, paintable, movable, score);
        car.setX(900 / 2 - 300);
        
    }

    public void keyPressed(KeyEvent e) {
        
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_A) {
            getCar().keyPressed('L');
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_D) {
            getCar().keyPressed('R');
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_W) {
            getCar().keyPressed('U');
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_S) {
            getCar().keyPressed('D');
        }
        
    }

    public void keyReleased(KeyEvent e) {

        System.out.println("entro a keyrealeased");
        int tecla = e.getKeyCode();
        // Frenar solo si no se está acelerando en esa dirección
        if (tecla == KeyEvent.VK_A || tecla == KeyEvent.VK_D) {
            if(tecla == KeyEvent.VK_A){
                getCar().keyReleased('L');
            }else{
                getCar().keyReleased('R');
            }
        } else if (tecla == KeyEvent.VK_W || tecla == KeyEvent.VK_S) {
            if(tecla == KeyEvent.VK_W){
                getCar().keyReleased('U');
            }else{
                getCar().keyReleased('D');
            }
        }
        
    }
}
