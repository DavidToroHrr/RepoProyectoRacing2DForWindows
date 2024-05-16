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
    
    
    public void loadRunways(int x, int y){
        ArrayList<String> mapsNames = fileManager.searchFiles(PATH_MAPS);
        for(String mapName : mapsNames){
            Runway runway = readRunway(mapName, x, y);
            runways.add(runway);
        }
    }
    
    private Runway readRunway(String mapName, int x, int y){
        ArrayList<String> map = fileManager.readFile(PATH_MAPS+mapName);
        String[] line1 = map.get(0).split(":");
        String[] line2 = map.get(1).split(":");
        String name = line1[1];
        String description = line2[1];
        
        ArrayList<ArrayList<String>> circuit = new ArrayList<>();
        int i = 0;
        for(String line : map){
            ArrayList<String> row = new  ArrayList<>();
            if(i > 1){
                for(String item : line.split("\\|")){
                    row.add(item);
                }
                circuit.add(row);
            }
            i += 1;
        }
        int xLenght = circuit.get(0).size();
        int yLenght = circuit.size();
        int size = Cell.SIZE;
        int width = xLenght * size;
        int height = yLenght * size;

        
        Runway runway = new Runway(x, y, width, height, name, description, circuit);
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
