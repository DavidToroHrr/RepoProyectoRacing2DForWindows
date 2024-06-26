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
public class Player2 extends Player{
    public Player2(String name, ArrayList <BufferedImage> carImages, Paintable paintable, Movable movable, int score, int x, int y,Sound sounds,SoundThread st) {
        super(name, carImages, paintable, movable, score, x, y,sounds,st);
        
    }
    /**
     * players.player1#KeyPressed
     * al tratarse del player 2 reconoce solo las letras (A,S,D,W)
     * @param e Orden enviada por el usuario
     */
    public void keyPressed(KeyEvent e) {
        if(brake){
            return;
        }
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

    
}
