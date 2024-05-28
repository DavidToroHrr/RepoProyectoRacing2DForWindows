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
import proyectoracing2dforwindows.specialsounds.Sound;
import proyectoracing2dforwindows.threads.SoundThread;

/**
 *
 * @author usuario
 */
public class Player1 extends Player{

    public Player1(String name, ArrayList <BufferedImage> carImages, Paintable paintable, Movable movable, int score, int x, int y,Sound sounds,SoundThread st) {
        super(name, carImages, paintable, movable, score, x, y,sounds,st);
    }

    public void keyPressed(KeyEvent e) {
        if(brake){
            return;
        }
        int tecla = e.getKeyCode();
        // Acelerar el carro hacia la izquierda
        if (tecla == KeyEvent.VK_LEFT) {
            getCar().keyPressed('L');
        }
        // Acelerar el carro hacia la derecha
        else if (tecla == KeyEvent.VK_RIGHT) {
            getCar().keyPressed('R');
        }
        // Acelerar el carro hacia arriba
        else if (tecla == KeyEvent.VK_UP) {
            getCar().keyPressed('U');
        }
        // Acelerar el carro hacia abajo
        else if (tecla == KeyEvent.VK_DOWN) {
            getCar().keyPressed('D');
        }
        
    }

    
}
