/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Runway extends Sprite{
    private String name;
    private String description;
    private ArrayList<ArrayList<Cell>> circuit;

    public Runway(int x, int y, int width, int height, String name, String description, ArrayList<ArrayList<String>> circuit) {
        super(x, y, width, height);
        this.name = name;
        this.description = description;
        this.circuit = new ArrayList<>();
        try {
            configCircuit(circuit);
        } catch (IOException ex) {
            Logger.getLogger(Runway.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void configCircuit(ArrayList<ArrayList<String>> circuit) throws IOException{
        int x = this.x;
        int y = this.y;
        int size = Cell.SIZE;
        
        for(ArrayList<String> rowS : circuit){
            
            ArrayList<Cell> rowC = new ArrayList<>();
            
            for(String item : rowS){
                Cell cell = new CellGrass(x, y);
                
                if(item.equals("G")){
                    cell = new CellGrass(x, y);
                }
                if(item.equals("W")){
                    cell = new CellWall(x, y);
                }
                if(item.equals("T")){
                    cell = new CellTrail(x, y);
                }
                if(item.equals("F")){
                    cell = new CellFinish(x, y);
                }
                if(item.equals("C")){
                    cell = new CellCheckPoint(x, y);
                }
                
                rowC.add(cell);
                x += size;
            }
            
            this.circuit.add(rowC);
            x = this.x;
            y += size;
        }
    }


    @Override
    public void draw(Graphics g) {
        for(ArrayList<Cell> row : circuit){
            for(Cell cell : row){
                cell.draw(g);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    
    
    
}
