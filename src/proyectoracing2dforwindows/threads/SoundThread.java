/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import proyectoracing2dforwindows.models.Sound;

/**
 *
 * @author david
 */
public class SoundThread extends Thread{
    
    //debo de ir pasando el hilo por map selector y que cuando lo detenga lo pause y pause también el sonido
    
    private boolean running;
    private volatile boolean paused;
    private volatile boolean play;
    private Sound sound;
    
    public SoundThread(Sound sound){
        
        this.running = true;
        this.paused = false;
        this.play = true;
        this.sound=sound;
    }
    

    public void halt(){
        this.running = false;
    }
    
    public void pause(){
        this.paused = !this.paused;
        this.play=!this.play;
        if (!play) {
            sound.stopSound();
            return;
        }
        sound.playSound();
        

    }
    
    @Override
    public void run(){
        
        while(running){
            
            if(paused){
                                continue;
            }
            
            sound.playSound();
            System.out.println("salgo y creo otro");
        }
    }
}
