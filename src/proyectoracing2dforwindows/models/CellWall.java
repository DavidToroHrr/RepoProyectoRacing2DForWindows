/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.io.IOException;

/**
 *
 * @author usuario
 */
public class CellWall extends Cell{
    
    public CellWall(int x, int y) throws IOException {
        super(x, y, "cellwall");
        loagImage("src/data/resources/runway/wall.jpg");
    }
    
}
