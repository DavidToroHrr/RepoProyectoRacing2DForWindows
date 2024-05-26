/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialobjects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.interfaces.SpecialMovable;
import proyectoracing2dforwindows.models.Object;
import proyectoracing2dforwindows.specialsounds.Sound;

/**
 *
 * @author david
 */
public abstract class SpecialObject extends Object implements Applicable{
    public Paintable paintable;
    
    protected int velocityY;//velocidad en y del objeto especial
    protected int directionY; //velocidad en x del objeto especial
    private SpecialMovable specialMovable;//interfaz que me permitirá poder actualizar y mover
                                          //la posición de un objeto especial cada que este choque
                                          //con un muro
    
    
    public SpecialObject(int x, int y, int width, int height, String id, BufferedImage image, URL url,Paintable paintable,SpecialMovable specialMovable) {
        super(x, y, width, height, id, image, url);
        
        this.specialMovable=specialMovable;
        
        this.paintable=paintable;
        this.velocityY=1; // esta es la velocidad inicial del objeto
        this.directionY=-1; // esta es la dirección del objeto 1 es para abajo y -1 es para arriba
        
        
    }
/**
* specialobject.SpecialObject#applyEfect(CarCustomable cb, ArrayList <Sound>sound)
* éste método aplica el efecto correspondiente, en este caso, cada clase implementa a su manera el 
* método
* @param cb:interfaz que contiene los atributos del carro para poder modificarlos
* @param sound:arreglo de sonidos de tipo Sound para ejecutar el sonido correspondiente
* al poder
* @david
*/
    @Override
    public abstract void applyEfect(CarCustomable cb,ArrayList <Sound>sound);
    
/**
* specialobject.SpecialObject#updatePosition()
* éste método permite actualizar de manera constante la posición del carro para 
* detectar colisiones con muros y poder cambiar de dirección en el eje y
* @david
*/
    public void updatePosition() {
        int newY = y + velocityY * directionY;//creación de la nueva y del objeto especial
        
        specialMovable.verifySpecialObjectCollision(this, newY);//llamada del método que está
                                                                //contenido en la interfaz
        y = newY;//se actualiza la y del objeto especial
    }
    
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getDirectionY() {
        return directionY;
    }
    
    
    
    
    
}
