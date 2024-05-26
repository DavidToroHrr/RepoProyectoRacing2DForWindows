/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialobjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
* specialobject.StoppedMovement
* Clase encargada de almacenar la información del poder de detener el movimiento del carro por un determinado
* tiempo y encargada de aplicar su determinado efecto
* @david
*/
public class StoppedMovement extends SpecialObject{

    public StoppedMovement(int x, int y, int width, int height, String id, BufferedImage image, URL url, Paintable paintable,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url, paintable,specialMovable);
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
    public void applyEfect(CarCustomable cb, ArrayList<Sound> sound) {
        
        long startTime = System.currentTimeMillis();//nos indica nuestro tiempo inicial
        long currentTime = System.currentTimeMillis();//nos indica el tiempo actual
        sound.get(3).playSound();
        while(currentTime-startTime < 500){
            cb.setVelocityX(0);//detenemos el movimiento del carro en x
            cb.setVelocityY(0);//detenemos el movimiento del carro en y
            currentTime = System.currentTimeMillis();//hacemos la actualización del tiempo actual
        }
        try {
            Thread.sleep(2000);//hacemos que el hilo el cual es independiente al hilo pricipal
                               //se detenga unos segundos para que no pueda recibir varios poderes
        } catch (InterruptedException ex) {
            Logger.getLogger(StoppedMovement.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
}
