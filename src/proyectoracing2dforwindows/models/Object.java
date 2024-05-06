/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author david
 */
public class Object extends Sprite{
    protected String id;
    protected Image image;

    public Object(int x, int y, int width, int height, String id) {
        super(x, y, width, height);
        this.id = id;
    }

    public void loagImage(String path){
        File file = new File(path);
        try {
            image = ImageIO.read(file);
        } catch (IOException ex) {
            Logger.getLogger(Object.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, null);
    }
    public void verifyCollision(){}
}
