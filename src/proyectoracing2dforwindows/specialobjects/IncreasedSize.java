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
* specialobject.IncreasedSize
* Clase encargada de almacenar la información del poder de aumentar tamaño
* y encargada de aplicar su determinado efecto
* @david
*/

public class IncreasedSize extends SpecialObject{
    
    public IncreasedSize(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable paintable,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url,paintable,specialMovable);
        
    }
    
    /**
     * specialobject.IncreasedSize#applyEfect(CarCustomable cb, ArrayList <Sound>sound)
     * éste método aplica el efecto correspondiente, en este caso, aumenta el tamaño del carro
     * @param cb:interfaz que contiene los atributos del carro para poder modificarlos
     * @param sound:arreglo de sonidos de tipo Sound para ejecutar el sonido correspondiente
     * al poder
     * @david
    */
    
    @Override
    public void applyEfect(CarCustomable cb,ArrayList <Sound>sound) {
        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        cb.setHeight(57);
        cb.setWidth(101);
        
        cb.setImage(cb.getcarImages().get(2));
        System.out.println("AUMENTAR");
        paintable.repaint(x, y, width, height);
        sound.get(1).playSound();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("AUMENTAR");
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        
        cb.setImage(cb.getcarImages().get(0));
        paintable.repaint(x, y, width, height);

    }
    
}
