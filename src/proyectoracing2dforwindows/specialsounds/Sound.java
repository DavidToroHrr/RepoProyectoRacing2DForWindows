/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.specialsounds;

/**
 *
 * @author david
 */
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* specialsounds.Sound
* Clase encargada de manejar la reproducción de los sonidos en el juego
* @david
*/

public class Sound {
    
    protected String id; //nos indica el identificador de nuestros sonidos
    protected String filePath;//nos indica la ruta con la que cuentan nuestros sonidos
    private int timeDuration=0;//nos indica cuánto tiempo debe de pausar el hilo correspondiente
    Clip clip=null;
    public Sound(String id,String filePath,int timeDuration) {
        this.id = id;
        this.filePath=filePath;
        this.timeDuration=timeDuration;
    }
    /**
     * specialsounds.Sound#playSound()
     * este método reproduce el sonido solicitado, en donde gracias al path
     * se puede ejecutar dicha acción
     * @david
    */
    public void playSound() {
    try {
        //Obtiene el archivo de audio como un InputStream desde los recursos.
        InputStream audioSrc = Sound.class.getResourceAsStream(this.filePath);
        if (audioSrc == null) {
            // Verifica si el archivo de audio existe en el path especificado.
            System.out.println("El archivo de audio no se encontró: " + this.filePath);
            return;
        }
        
        //Envuelve el InputStream en un BufferedInputStream para mejorar la eficiencia de lectura.
        InputStream bufferedIn = new BufferedInputStream(audioSrc);
        
        //Obtiene un AudioInputStream del BufferedInputStream.
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
        
        //Obtiene un Clip para reproducir el audio.
        clip = AudioSystem.getClip();
        
        //Abre el audioStream en el clip.
        clip.open(audioStream);
        
        //inicia la reproducción del clip.
        clip.start();
        
        //Espera hasta que el audio se complete.
        clip.drain();
        
        // Duerme el hilo actual por la duración del audio.
        // Nota:timeDuration debe ser una variable que almacena la duración del audio en milisegundos.
        try {
                Thread.sleep(timeDuration);
            } catch (InterruptedException ex) {
                // Maneja la excepción si el hilo es interrumpido durante el sueño.
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedAudioFileException e) {
            // Maneja la excepción si el formato del archivo de audio no es soportado.
            System.out.println("El formato del archivo de audio no es soportado.");
        } catch (IOException e) {
            // Maneja la excepción si hay un error al leer el archivo de audio.
            System.out.println("Error al leer el archivo de audio.");
        } catch (LineUnavailableException e) {
            // Maneja la excepción si la línea de audio no está disponible.
            System.out.println("Línea de audio no disponible.");
        }
    }
    
    public void stopSound(){
        clip.stop();//se detiene la reproducción del clip
        clip.drain();
    
    }
}
