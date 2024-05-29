/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.exceptions;

/**
 *
 * @author thomas
 * Exception.FileManagerException 
 * esta excepcion se da cuando ocurre un error de lectura o busqueda de archivos
 */
public class FileManagerException extends Exception{
    public FileManagerException (String message){
        super(message); 
    }
    
}
