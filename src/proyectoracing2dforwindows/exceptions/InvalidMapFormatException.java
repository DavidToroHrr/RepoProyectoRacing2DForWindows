/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.exceptions;

/**
 *
 * @author thomas
 * Exception.InvalidMapFormatException
 * esta excepcion se da cuando el mapa esta mal inicializado , ya sea por sus dimensiones o por 
 * filas incompletas
 */
public class InvalidMapFormatException extends Exception{
    public InvalidMapFormatException (String message){
        super(message); 
    }
    
}
