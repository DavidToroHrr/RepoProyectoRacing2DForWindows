/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

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

public class Sound {
    
    protected String id;
    protected String filePath;
    public Sound(String id,String filePath) {
        this.id = id;
        this.filePath=filePath;
    }
    
    public void playSound() {
        try {
            InputStream audioSrc = Sound.class.getResourceAsStream(this.filePath);
            if (audioSrc == null) {
                System.out.println("El archivo de audio no se encontró: " + this.filePath);
                return;
            }
            
            // Envuelve el InputStream en un BufferedInputStream.
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
           
            clip.start();
            clip.drain();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("El formato del archivo de audio no es soportado.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de audio.");
        } catch (LineUnavailableException e) {
            System.out.println("Línea de audio no disponible.");
        }
    }
}
