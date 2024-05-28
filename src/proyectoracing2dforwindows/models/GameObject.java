/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
public abstract class GameObject extends Sprite{

    /**
     * @return the id
     */
    
    protected String id;
    protected BufferedImage image;
    protected URL url;

    public GameObject(int x, int y, int width, int height, String id,BufferedImage image,URL url) {
        super(x, y, width, height);
        this.id = id;
        this.image=image;
        this.url=url;
    }

    public void loadImage(String path){
        File file = new File(path);
        try {
            setImage(ImageIO.read(file));
        } catch (IOException ex) {
            Logger.getLogger(GameObject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    @Override
    public void draw(Graphics g) {
        g.drawImage(getImage(), getX(), getY(), null);
    }

    /**
     * @return the image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public String getId() {
        return id;
    }
}
