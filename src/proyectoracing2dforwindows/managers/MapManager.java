/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.xml.stream.events.Namespace;
import proyectoracing2dforwindows.exceptions.CheckpointException;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;
import proyectoracing2dforwindows.models.Cell;
import proyectoracing2dforwindows.models.Runway;
import proyectoracing2dforwindows.models.Sprite;

/**
* managers.MapManager
* Clase encargada de manejar el cargado de mapas
* y sus partes
*/
public class MapManager {
    FileManager fileManager;//Para manejo de archivos de texto plano
    ArrayList<Runway> runways;//Para guardar las pistas que se contruyan a partir de los archivos
    
    //Valores estaticos:
    public static final String PATH_MAPS = "src/data/maps/";

    public MapManager() {
        this.fileManager = new FileManager();
        this.runways = new ArrayList<>();
    }
    
    /**
     * managers.MapManager#loadRunways()
     * Este metodo obtiene todos los archivos de la carpeta maps y llama a readRunways para que este lea cada uno de ellos
     * @param x:Coordenada en x donde se ubicara la pista una vez construida
     * @param y:Coordenada en y donde se ubicara la pista una vez construida
     * @throws proyectoracing2dforwindows.exceptions.FileManagerException
     * @throws proyectoracing2dforwindows.exceptions.MapFileNotFoundException
     * @throws proyectoracing2dforwindows.exceptions.InvalidMapFormatException
     * @throws proyectoracing2dforwindows.exceptions.CheckpointException
    */
    public void loadRunways(int x, int y) throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException{
        ArrayList<String> mapsNames = fileManager.searchFiles(PATH_MAPS);
        if(runways.size()<=0){
            for(String mapName : mapsNames){
                Runway runway = readRunway(mapName, x, y);
                runways.add(runway);
            }
        }
    }
    
    /**
     * managers.MapManager#readRunway()
     * Este metodo se encarga de leer y contruir cada pista
     * @param mapName:Nombre del archivo de mapa
     * @param x:Coordenada en x donde se ubicara la pista una vez construida
     * @param y:Coordenada en y donde se ubicara la pista una vez construida
     * @return : Retorna una pista ya contruida
    */
    private Runway readRunway(String mapName, int x, int y) throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException {
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
        for (int i = 2; i < 27; i++) {
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
        ArrayList<String> checkpoints_measures = new ArrayList<>();
        for (int i = 28; i < map.size(); i++) {
            checkpoints_measures.add(map.get(i));
        }

        // Verifica la existencia y formato de los checkpoints
        if (map.size() <= 27 || !map.get(27).equals("checkpoints")) {
            throw new CheckpointException("The map must contain a 'checkpoints' section.");
        }

        

        if (checkpoints_measures.size() < 3) {
            throw new CheckpointException("The map must contain at least three checkpoints.");
        }

        // Verifica el formato de cada checkpoint
        for (String checkpoint : checkpoints_measures) {
            if (!checkpoint.matches("\\d+:\\d+:\\d+:\\d+")) {
                throw new CheckpointException("Each checkpoint must be in the format x:y:width:height.");
            }
        }

        Runway runway = new Runway(x, y, trackWidth * Cell.SIZE, trackHeight * Cell.SIZE, name, description, circuitStr, checkpoints_measures);
        return runway;
    }





    /**
     * managers.MapManager#getRunwaysNames()
     * Este metodo se encarga de obtener los nombres y descripciones de cada pista
     * @return 
    */
    public ArrayList<String> getRunwaysNames(){
        ArrayList<String> names = new ArrayList<>();
        for(Runway runway : runways){
            names.add(runway.getName()+"|"+runway.getDescription());
        }
        
        return names;
    }
    /**
     * managers.MapManager#getRunway()
     * Busca la pista seleccionada y la retorna
     * @param name:Nombre de la pista que se quiere obtener
     * @return : Retorna la pista solicitada
    */
    
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
