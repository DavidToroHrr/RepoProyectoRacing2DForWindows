 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;


/**
 *
 * @author usuario
 */
public class FileManager {
    
    public FileManager(){
        
    }
    
    public ArrayList<String> readFile(String path) throws MapFileNotFoundException, FileManagerException {
    ArrayList<String> text = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
        String line;
        while ((line = reader.readLine()) != null) {
            text.add(line);
        }
    } catch (FileNotFoundException e) {
        throw new MapFileNotFoundException("File not found: " + path);
    } catch (IOException e) {
        throw new FileManagerException("An error occurred while reading the file " + path + ": " + e.getMessage());
    }
    return text;
}
    
    public void writeFile(ArrayList<String> text, String path){
        try {
            FileWriter route = new FileWriter(path);
            BufferedWriter writer = new BufferedWriter(route);
            for(String line : text){
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> searchFiles(String path) throws FileManagerException{
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
        }else{
            throw new FileManagerException("");
        }
        return filesNames;
    }
}
