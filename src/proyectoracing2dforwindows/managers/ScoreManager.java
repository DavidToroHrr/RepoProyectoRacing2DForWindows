/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.exceptions.DuplicateScoreException;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;

/**
 *
 * @author usuario
 */
public class ScoreManager {
    FileManager fileManager;
    ArrayList<String> names;//Se guardan los nombres de los jugadores
    ArrayList<Integer> scores;//Se guardan los puntajes de los jugadores
    int player1ScoreSelected;//Se guarda la posicion del puntaje y nombre del primer juagdor
    int player2ScoreSelected;//Se guarda la posicion del puntaje y nombre del segundo juagdor
    
    
    //Valores estaticos
    public static final String PATH_SCORES = "src/data/scores/scores.csv";//Ubicacion del archivo donde se guardan los puntajes
    
    public ScoreManager(){
        fileManager = new FileManager();
        names = new ArrayList<>();
        scores = new ArrayList<>();
        player1ScoreSelected = 0;
        player2ScoreSelected = 1;
    }
    
    public void loadScores() throws FileManagerException, MapFileNotFoundException{//Se leen los puntajes guardados en el archivo
        ArrayList<String> dataScores = fileManager.readFile(PATH_SCORES);
        readScores(dataScores);
    }
    
    private void readScores(ArrayList<String> dataScores){//Se separan los nombres de los puntajes
        
        for(int i = 1; i < dataScores.size(); i++){
            String line = dataScores.get(i);
            String[] data = line.split(",");
            String name = data[0];
            int score = Integer.parseInt(data[1]);
            names.add(name);
            scores.add(score);
        }
    }
    
    public boolean addScore(String name, int score) throws DuplicateScoreException{//Se agrega un nuevo nombre a los puntajes
        //Thomas haga una exception para el caso en que ya exista un puntaje registrado con el mismo nombre
        for(String nameS : names){
            if (nameS.equals(name)){
                throw new DuplicateScoreException("Ya existe un puntaje registrado con el nombre '" + name + "'.");
            }
        }
        names.add(name);
        scores.add(score);
        return true;
    }
    
    public void updateScore(String name, int score){//Se actualiza un puntaje ya existente
        for(int i = 0; i < names.size(); i++){
            if (names.get(i).equals(name)){
                scores.set(i, score);
            }
        }
        
        saveScores();
        try {
            loadScores();
        } catch (FileManagerException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapFileNotFoundException ex) {
            Logger.getLogger(ScoreManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveScores(){//Se guardan los puntajes en el archivo scores.csv
        ArrayList<String> dataScores = new ArrayList<>();
        String head = "name,score";
        dataScores.add(head);
        for(int i = 0; i < names.size(); i++){
            String line = names.get(i)+","+scores.get(i);
            dataScores.add(line);
        }
        fileManager.writeFile(dataScores, PATH_SCORES);
    }
    
    public String getNameSelectedPlayer(int player){//Se obtiene el nombre del player seleccionado que se pida
        if(player == 1){
            return names.get(player1ScoreSelected);
        }else {
            return names.get(player2ScoreSelected);
        }
    }
    
    public int getScorePlayer(String name){//Se obtiene el puntaje que corresponda al nombre que se pida
        for(int i = 0; i < names.size(); i++){
            if (names.get(i).equals(name)){
                return scores.get(i);
            }
        }
        return -1;
    }
    
    public void setSelectedPlayers(int player, String name){//se asigna el nombre a cada player
        int scoreIndex = -1;
        for(int i = 0; i < names.size(); i++){
            if (names.get(i).equals(name)){
                scoreIndex = i;
            }
        }
        if(scoreIndex == -1){
            //Exception indicando que no se encuentra el nombre seleccionado
            return;
        }
        if(player == 1){
            player1ScoreSelected = scoreIndex;
        }else{
            player2ScoreSelected = scoreIndex;
        }
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }
    
    
}
