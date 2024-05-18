/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.models.Sound;

/**
 *
 * @author david
 */
public class CarEngine implements Runnable {
    Applicable applicabe;
    CarCustomable carCustomable;
    ArrayList <Sound>sound;
    private boolean control=false;
    public CarEngine(Applicable applicabe,CarCustomable carCustomable,ArrayList <Sound>sound) {
        this.applicabe=applicabe;
        this.carCustomable=carCustomable;
        this.sound=sound;
         
    }
    
    @Override
    public void run() {
        applicabe.applyEfect(carCustomable,sound);
        control=true;
        
    }

    /**
     * @return the control
     */
    public boolean isControl() {
        return control;
    }
    
    
    
}
