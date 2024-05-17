/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.util.ArrayList;
import proyectoracing2dforwindows.exceptions.DuplicateScoreException;
import proyectoracing2forwindows.exceptions.FileManagerException;
import proyectoracing2forwindows.exceptions.MapFileNotFoundException;

/**
 *
 * @author usuario
 */
public class ScoreManager {
    FileManager fileManager;
    ArrayList<String> names;
    ArrayList<Integer> scores;
    
    //Valores estaticos
    public static final String PATH_SCORES = "src/data/scores/scores.csv";
    
    public ScoreManager(){
        fileManager = new FileManager();
        names = new ArrayList<>();
        scores = new ArrayList<>();
    }
    
    public void loadScores() throws FileManagerException, MapFileNotFoundException{
        ArrayList<String> dataScores = fileManager.readFile(PATH_SCORES);
        readScores(dataScores);
    }
    
    private void readScores(ArrayList<String> dataScores){
        
        for(int i = 1; i < dataScores.size(); i++){
            String line = dataScores.get(i);
            String[] data = line.split(",");
            String name = data[0];
            int score = Integer.parseInt(data[1]);
            names.add(name);
            scores.add(score);
        }
    }
    
    public boolean addScore(String name, int score) throws DuplicateScoreException{
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
    
    public boolean updateScore(String name, int score){
        for(int i = 0; i < names.size(); i++){
            if (names.get(i).equals(name)){
                scores.set(i, score);
                return true;
            }
        }
        
        return false;
    }
    
    public void saveScores(){
        ArrayList<String> dataScores = new ArrayList<>();
        String head = "name,score";
        dataScores.add(head);
        for(int i = 0; i < names.size(); i++){
            String line = names.get(i)+","+scores.get(i);
            dataScores.add(line);
        }
        fileManager.writeFile(dataScores, PATH_SCORES);
    }
}
