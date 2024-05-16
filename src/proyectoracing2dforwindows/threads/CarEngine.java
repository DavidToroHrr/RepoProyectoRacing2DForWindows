/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;

/**
 *
 * @author david
 */
public class CarEngine implements Runnable {
    Applicable applicabe;
    CarCustomable carCustomable;
    private boolean control=false;
    public CarEngine(Applicable applicabe,CarCustomable carCustomable) {
        this.applicabe=applicabe;
        this.carCustomable=carCustomable;
         
    }
    
    @Override
    public void run() {
        applicabe.applyEfect(carCustomable);
        control=true;
        
    }

    /**
     * @return the control
     */
    public boolean isControl() {
        return control;
    }
    
    
    
}
