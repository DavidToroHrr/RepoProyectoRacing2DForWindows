/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.xml.stream.events.Namespace;
import proyectoracing2dforwindows.models.Cell;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2forwindows.exceptions.FileManagerException;
import proyectoracing2forwindows.exceptions.InvalidMapFormatException;
import proyectoracing2forwindows.exceptions.MapFileNotFoundException;

/**
 *
 * @author usuario
 */
public class MapManager {
    FileManager fileManager;
    ArrayList<Runway> runways;
    
    //Valores estaticos:
    public static final String PATH_MAPS = "src/data/maps/";

    public MapManager() {
        this.fileManager = new FileManager();
        this.runways = new ArrayList<>();
    }
    
    
    public void loadRunways(int x, int y) throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException{
        ArrayList<String> mapsNames = fileManager.searchFiles(PATH_MAPS);
        for(String mapName : mapsNames){
            Runway runway = readRunway(mapName, x, y);
            runways.add(runway);
        }
    }
    
  private Runway readRunway(String mapName, int x, int y) throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException {
        ArrayList<String> map = fileManager.readFile("src/data/maps/" + mapName);

        // Verifica que el archivo tenga al menos dos líneas
        if (map.size() < 2) {
            throw new InvalidMapFormatException("The map file must contain at least two lines for the name and description.");
        }

        String[] line1 = map.get(0).split(":");
        String[] line2 = map.get(1).split(":");

        // Verifica que las líneas tengan el formato correcto
        if (line1.length < 2 || line2.length < 2) {
            throw new InvalidMapFormatException("The format of the map file is incorrect. Expected 'name:value' in the first two lines.");
        }

        String name = line1[1];
        String description = line2[1];

        ArrayList<String> circuitStr = new ArrayList<>();
        for (int i = 2; i < map.size(); i++) {
            circuitStr.add(map.get(i));
        }

        if (circuitStr.isEmpty() || circuitStr.get(0).isEmpty()) {
            throw new InvalidMapFormatException("The map circuit is empty or incorrectly formatted.");
        }

        // Obtiene el ancho y alto en términos de caracteres
        int trackWidth = circuitStr.get(0).length();
        int trackHeight = circuitStr.size();
        System.out.println(trackHeight);
        System.out.println(trackWidth);

        // Verifica si las dimensiones son menores a 25 caracteres en los ejes X y Y
        for (String row : circuitStr) {
    if (row.length() < 25) {
            throw new InvalidMapFormatException("One row of the circuit has less than 25 characters.");
        }
    }

    // Verifica que haya al menos 25 filas en total
    if (circuitStr.size() < 25) {
        throw new InvalidMapFormatException("The circuit has less than 25 rows.");
    }

        Runway runway = new Runway(x, y, trackWidth * Cell.SIZE, trackHeight * Cell.SIZE, name, description, circuitStr);
        return runway;
    }





    
    public ArrayList<String> getRunwaysNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Runway runway : runways){
            names.add(runway.getName()+"|"+runway.getDescription());
        }
        
        return names;
    }
    
    public Runway getRunway(String name){
        for(Runway runway : runways){
            if(runway.getName().equals(name)){
                runway.configCircuit();
                return runway;
            }
        }
        return null;
    }
}
