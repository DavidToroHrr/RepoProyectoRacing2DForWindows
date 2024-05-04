/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.util.ArrayList;
import proyectoracing2dforwindows.models.Runway;

/**
 *
 * @author usuario
 */
public class MapManager {
    FileManager fileManager;
    ArrayList<Runway> runways;

    public MapManager() {
        this.fileManager = new FileManager();
        this.runways = new ArrayList<>();
    }
    
    
    public void loadRunways(){
        ArrayList<String> mapsNames = fileManager.searchFiles("src/data/maps/");
        for(String mapName : mapsNames){
            Runway runway = readRunway(mapName);
            runways.add(runway);
        }
        for(Runway way : runways){
            way.mostrar();
            System.out.println("\n");
        }
    }
    
    private Runway readRunway(String mapName){
        ArrayList<String> map = fileManager.readFile("src/data/maps/"+mapName);
        String[] line1 = map.get(0).split(":");
        String[] line2 = map.get(1).split(":");
        String name = line1[1];
        String description = line2[1];
        
        ArrayList<ArrayList<String>> circuit = new ArrayList<>();
        for(int i = 2; i < 27; i++){
            ArrayList<String> row = new  ArrayList<>();
            for(String item : map.get(i).split("\\|")){
                row.add(item);
            }
            circuit.add(row);
        }
        
        Runway runway = new Runway(name, description, circuit);
        return runway;
    }
}
