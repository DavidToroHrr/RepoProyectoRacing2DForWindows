/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
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
    protected BufferedImage image;
    protected URL url;

    public Object(int x, int y, int width, int height, String id,BufferedImage image,URL url) {
        super(x, y, width, height);
        this.id = id;
        this.image=image;
        this.url=url;
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
        g.drawImage(image, getX(), getY(), null);
    }
    public void verifyCollision(){}
}
