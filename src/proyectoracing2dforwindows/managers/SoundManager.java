/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.util.ArrayList;
import proyectoracing2dforwindows.specialsounds.Sound;
import proyectoracing2dforwindows.specialsounds.SoundIncrease;
import proyectoracing2dforwindows.specialsounds.SoundInitialMenu;
import proyectoracing2dforwindows.specialsounds.SoundShrink;
import proyectoracing2dforwindows.specialsounds.SoundStopped;

/**
* clase encargada de almacenar todos los efectos especiales del juego
* @author david 
*/
public class SoundManager {
    private ArrayList <Sound> sounds;
    private SoundShrink sh;
    private SoundIncrease si;
    private SoundInitialMenu sm;           
    private SoundStopped ss;           
    
    
    public SoundManager() {
        sounds=new ArrayList<>();
        createSounds();
    }

    
    /**
     * managers.SoundManager#createSounds()
     * Este metodo se encarga de crear los sonidos y almacenarlos en un arraylist de Sounds
     * @autor david
    */
    
    public void createSounds(){
        sh=new SoundShrink("shrink","/data/sounds/desinflar.wav",0);
        getSounds().add(sh);
        si=new SoundIncrease("increase","/data/sounds/inflar.wav",0);
        getSounds().add(si);
        sm=new SoundInitialMenu("soundinitialmenu", "/data/sounds/gameSound.wav",30000);
        getSounds().add(sm);
        ss=new SoundStopped("stopped", "/data/sounds/frenadoCarro.wav",0);
        getSounds().add(ss);
        
    
    }

   /**
     * managers.SoundManager#getSounds()
     * Este metodo se encarga de obtener los nombres sonidos o efectos especiales del juego
     * @return retorna los sonidos
     * @david
    */
    public ArrayList <Sound> getSounds() {
        return sounds;
    }
    
    
    
}
