/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.util.ArrayList;
import proyectoracing2dforwindows.models.Sound;
import proyectoracing2dforwindows.models.SoundIncrease;
import proyectoracing2dforwindows.models.SoundInitialMenu;
import proyectoracing2dforwindows.models.SoundShrink;

/**
 *
 * @author david
 */
public class SoundManager {
    private ArrayList <Sound> sounds;
    private SoundShrink sh;
    private SoundIncrease si;
    private SoundInitialMenu sm;           

    public SoundManager() {
        sounds=new ArrayList<>();
        createSounds();
    }

    
    
    public void createSounds(){
        sh=new SoundShrink("shrink","/proyectoracing2dforwindows/sounds/desinflar.wav",0);
        getSounds().add(sh);
        si=new SoundIncrease("increase","/proyectoracing2dforwindows/sounds/inflar.wav",0);
        getSounds().add(si);
        sm=new SoundInitialMenu("soundinitialmenu", "/proyectoracing2dforwindows/sounds/gameSound.wav",110000);
        getSounds().add(sm);
        
    
    }

    /**
     * @return the sounds
     */
    public ArrayList <Sound> getSounds() {
        return sounds;
    }
    
    
    
}
