/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class FileManager {
    
    public FileManager(){
        
    }
    
    public ArrayList<String> readFile(String path){
        ArrayList<String> text = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
    
    public void overrideFile(ArrayList<String> text, String path){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for(String line : text){
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> searchFiles(String path){
        // Especifica la ruta de la carpeta
        
        // Crea un objeto File para la carpeta
        File folder = new File(path);
        ArrayList<String> filesNames = new ArrayList<>();
        // Verifica si la carpeta existe
        if (folder.exists() && folder.isDirectory()) {
            // Obtiene una matriz de archivos y subdirectorios dentro de la carpeta
            File[] files = folder.listFiles();
            
            // Itera sobre la matriz de archivos
            for (File file : files) {
                // Imprime el nombre del archivo o subdirectorio
                filesNames.add(file.getName());
            }
        }
        return filesNames;
    }
}
