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
* sound.specialsounds
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
    
    public void playSound() {//tal cvez tenga que hacer un stop sound
        try {
            InputStream audioSrc = Sound.class.getResourceAsStream(this.filePath);
            if (audioSrc == null) {
                System.out.println("El archivo de audio no se encontró: " + this.filePath);
                return;
            }
            
            // Envuelve el InputStream en un BufferedInputStream.
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            
            clip = AudioSystem.getClip();
            
            clip.open(audioStream);
           
            clip.start();
            clip.drain();
            try {
                Thread.sleep(timeDuration);//hacer una variable dependiendo de las necesidades del sonido
            } catch (InterruptedException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UnsupportedAudioFileException e) {
            System.out.println("El formato del archivo de audio no es soportado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de audio.");
        } catch (LineUnavailableException e) {
            System.out.println("Línea de audio no disponible.");
        }
    }
    
    public void stopSound(){
        clip.stop();
        clip.drain();
    
    }
}
