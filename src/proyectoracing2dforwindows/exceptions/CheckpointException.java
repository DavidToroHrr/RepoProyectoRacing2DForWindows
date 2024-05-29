/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.exceptions;

/**
 *
 * @author thomas
 * Exception.CheckpointExcepcion
 * se encarga de lanzar la excepcion de mala inicializacion de checkpoints o 
 * insificiencia en la creacion de los mismos
 */
public class CheckpointException extends Exception{
    public CheckpointException (String message){
        super(message); 
    }
    
}
