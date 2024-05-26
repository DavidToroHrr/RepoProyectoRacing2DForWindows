/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import java.util.ArrayList;
import proyectoracing2dforwindows.models.Sound;

/**
* interfaces.Applicable
* Interfaz encarga a aplicar efectos sobre los players y carros
*/
public interface Applicable {
    public void applyEfect(CarCustomable cc,ArrayList <Sound>sound);
    
    
}
