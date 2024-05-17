/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import proyectoracing2dforwindows.interfaces.Generateable;

/**
 *
 * @author david
 */
public class SpecialObjectGenerator implements Runnable{
    private Generateable generetable;

    public SpecialObjectGenerator(Generateable generetable) {
        this.generetable = generetable;
    }
    
    @Override
    public void run() {
        while (true) {            
            generetable.createSpecialObject();
        }
        
    }
    
}
