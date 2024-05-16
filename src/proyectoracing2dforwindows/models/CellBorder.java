/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

/**
 *
 * @author david
 */
public class CellBorder extends Cell{
    public static final String CELL_ID="cellborder";
    public CellBorder(int x, int y) {
        super(x, y, CELL_ID);
        loagImage("src/data/resources/runway/finish.jpg");
        
    }
    
    
    
}
