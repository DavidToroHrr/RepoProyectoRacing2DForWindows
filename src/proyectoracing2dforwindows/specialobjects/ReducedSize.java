/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
* specialobject.ReducedSize
* Clase encargada de almacenar la información del poder de reducir tamaño
* y encargada de aplicar su determinado efecto
* @david
*/

public class ReducedSize extends SpecialObject implements Applicable{
    
    public ReducedSize(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable p1,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url,p1,specialMovable);
    }
    
    

    
/**
* specialobject.ReducedSize#applyEfect(CarCustomable cb, ArrayList <Sound>sound)
* éste método aplica el efecto correspondiente, en este caso, aumenta el tamaño del carro
* @param cb:interfaz que contiene los atributos del carro para poder modificarlos
* @param sound:arreglo de sonidos de tipo Sound para ejecutar el sonido correspondiente
* al poder
* @david
*/
    @Override
    public void applyEfect(CarCustomable cb,ArrayList <Sound>sound) {
        //paintable.repaint(cb.getX(), cb.getY(), width, height);

        int temporalHeight=cb.getHeight();
        int temporalWidth=cb.getWidth();
        
        cb.setHeight(10);
        cb.setWidth(34);
        
        cb.setImage(cb.getcarImages().get(1));
        
        paintable.repaint();
        
        sound.get(0).playSound();
        
        System.out.println(cb.getWidth()+"ancho despues");
        System.out.println(cb.getHeight()+"ancho despues");
        
        try {
            Thread.sleep(3000);//hacemos que el hilo el cual es independiente al hilo pricipal
                               //se detenga unos segundos para que no pueda recibir varios poderes
        } catch (InterruptedException ex) {
            Logger.getLogger(ReducedSize.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cb.setHeight(temporalHeight);
        cb.setWidth(temporalWidth);
        
        cb.setImage(cb.getcarImages().get(0));
        
        paintable.repaint(cb.getX(), cb.getY(), width, height);

    }
    
}
