/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.exceptions;

/**
 *
 * @author thomas
 * Exception.MapFilNotFoundException
 * esta excepcion se da cuando en la ruta especificada no es correcta o 
 * el mapa no existe
 */
public class MapFileNotFoundException extends Exception{
    public MapFileNotFoundException (String message){
        super(message); 
    }
    
}
