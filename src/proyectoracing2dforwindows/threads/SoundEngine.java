/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.threads;

/**
 *
 * @author david
 */
public class SoundEngine implements Runnable{

    private String nombre;
    
    public SoundEngine(String nombre){//le debo de pasar el arreglo de sonidos o el sonido a reproducir
                                        //el sonido
        this.nombre = nombre;
    }
    
    @Override
    public void run() {
        for(;;){
            System.out.println("Motor " + nombre);//reproducir el sonido
        }

    }
    
}
