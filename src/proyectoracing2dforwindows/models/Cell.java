/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

/**
 *
 * @author usuario
 */
public abstract class Cell extends Object{

    public static final int SIZE = 36;
    
    public Cell(int x, int y, String id) {
        super(x, y, SIZE, SIZE, id,null,null);
        
    }
    

}