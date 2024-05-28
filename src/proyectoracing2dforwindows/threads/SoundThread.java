/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import proyectoracing2dforwindows.specialsounds.Sound;

/**
* clase encargada de reproducir un sonido determinado en bucle,ya sea la música del menú inicial 
* o el sonido del motor de los carros
* 
* @author david 
*/
public class SoundThread extends Thread{
    
   
    private boolean running;
    private volatile boolean paused;
    private Sound sound;

    public SoundThread(Sound sound){
        
        this.running = true;
        this.paused = false;
        this.sound=sound;
    }
    
/**
* threads.CarEngine#run()
* éste método aplica el efecto correspondiente el cual fue enviado
* mediante la interfaz Applicable
* @david
*/
    public void halt(){
        this.running = false;
    }
/**
* threads.CarEngine#run()
* éste método aplica el efecto correspondiente el cual fue enviado
* mediante la interfaz Applicable
* @david
*/
    public void pause(){
        this.paused = !this.paused;
        sound.stopSound();

    }
/**
* threads.CarEngine#run()
* éste método aplica el efecto correspondiente el cual fue enviado
* mediante la interfaz Applicable
* @david
*/
    @Override
    public void run(){
        
        while(running){
            
            if(paused){
                continue;
            }
            
            sound.playSound();
            
        }
    }
}