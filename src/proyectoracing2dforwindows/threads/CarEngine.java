/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
* clase encargada de aplicar el poder del objeto especial correspondiente, 
* en donde dicha tarea se lleva en un hilo diferente al hilo principal gracias a la implementación
* Runnable en la clase
* @author david 
*/
public class CarEngine implements Runnable {
    Applicable applicabe;//método que se aplicará al vehículo en cuestión
    CarCustomable carCustomable;//características del carro que se pueden modificar
    ArrayList <Sound>sound;//arreglo de efectos especiales
    private boolean control=false;//indicador de que se ejecutó el método
    public CarEngine(Applicable applicabe,CarCustomable carCustomable,ArrayList <Sound>sound) {
        this.applicabe=applicabe;
        this.carCustomable=carCustomable;
        this.sound=sound;
         
    }
/**
* threads.CarEngine#run()
* éste método aplica el efecto correspondiente el cual fue enviado
* mediante la interfaz Applicable
* @david
*/
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
