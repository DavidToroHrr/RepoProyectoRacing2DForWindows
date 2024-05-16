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

    /**
     * @return the circuit
     */
    public ArrayList<ArrayList<Cell>> getCircuit() {
        return circuit;
    }

    /**
     * @param circuit the circuit to set
     */
    public void setCircuit(ArrayList<ArrayList<Cell>> circuit) {
        this.circuit = circuit;
    }
    private String name;
    private String description;
    private ArrayList<ArrayList<String>> circuitStr;
    private ArrayList<ArrayList<Cell>> circuit;

    public Runway(int x, int y, int width, int height, String name, String description, ArrayList<ArrayList<String>> circuitStr) {
        super(x, y, width, height);
        this.name = name;
        this.description = description;
        this.circuit = new ArrayList<>();
        this.circuitStr = circuitStr;
    }
    
    public void configCircuit(){
        int x = this.getX();
        int y = this.getY();
        int size = Cell.SIZE;
        
        for(ArrayList<String> rowS : circuitStr){
            
            ArrayList<Cell> rowC = new ArrayList<>();
            try{
                for (String item : rowS) {
                    Cell cell;
                    cell = new CellGrass(x, y);

                    if (item.equals("G")) {
                        cell = new CellGrass(x, y);
                    }
                    if (item.equals("W")) {
                        cell = new CellWall(x, y);
                    }
                    if (item.equals("T")) {
                        cell = new CellTrail(x, y);
                    }
                    if (item.equals("F")) {
                        cell = new CellFinish(x, y);
                    }
                    if (item.equals("C")) {
                        cell = new CellCheckPoint(x, y);
                    }

                    rowC.add(cell);
                    x += size;
                }
                
                this.getCircuit().add(rowC);
                x = this.getX();
                y += size;
            } catch (IOException ex) {
                    Logger.getLogger(Runway.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }
    public boolean verifyPoint(int x,int y){//aqui vamos a recorrer la pista
        for (ArrayList<Cell> arrayList : circuit) {
            for (Cell cell : arrayList) {
                    if (cell.verifyTouchCell(x, y) & cell.getId().equals("celltrail")) {
                            return true;

                    }
                     
                     
                
            }
        }
        return false;
    
    }
    public void verifyCell(){}

    @Override
    public void draw(Graphics g) {
        for(ArrayList<Cell> row : getCircuit()){
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
    public void recorrerPista(int x,int y){}//le paso las cooordenadas de random y si
    //el get id es de tipo celltrail que me lo retorne y que me ponga el objeto allí
    //hacer hilo para ir colocando objetos
    
    
    
}
