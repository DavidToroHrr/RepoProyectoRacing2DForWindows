/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class CellCheckPoint extends Cell{
     public static final String CELL_ID="cellcheckpoint";
    public CellCheckPoint(int x, int y, BufferedImage image) throws IOException {
        super(x, y, CELL_ID, image);
    }
    
}
