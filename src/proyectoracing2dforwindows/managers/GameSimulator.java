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
public class GameSimulator {
    private MapManager mapManager;
    private Runway currentRunway;
    
    public GameSimulator(){
        this.mapManager = new MapManager();
        this.currentRunway = null;
    }
    
    public ArrayList<String> showMaps(){
        mapManager.loadRunways(0, 0);
        return mapManager.getRunwaysNames();
    }
    
    public Runway loadMap(String nameMap){
        Runway runway = mapManager.getRunway(nameMap);
        return runway;
    }
}
