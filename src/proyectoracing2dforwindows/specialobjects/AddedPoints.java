/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialobjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
* specialobject.AddedPoints
* Clase encargada de reproducir el sonido correspondiente al poder
* de ganar puntos 
* @david
*/
public class AddedPoints extends SpecialObject{

    public AddedPoints(int x, int y, int width, int height, String id, BufferedImage image, URL url, Paintable paintable, SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url, paintable, specialMovable);
    }
/**
* specialobject.AddedPoints#applyEfect(CarCustomable cb, ArrayList <Sound>sound)
* éste método aplica el efecto correspondiente, en este caso, aumenta el tamaño del carro
* @param cb:interfaz que contiene los atributos del carro para poder modificarlos
* @param sound:arreglo de sonidos de tipo Sound para ejecutar el sonido correspondiente
* al poder
* @david
*/
    @Override
    public void applyEfect(CarCustomable cb, ArrayList<Sound> sound) {
        sound.get(4).playSound();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AddedPoints.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
