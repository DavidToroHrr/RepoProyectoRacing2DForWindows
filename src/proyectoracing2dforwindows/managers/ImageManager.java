/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.managers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoracing2dforwindows.models.ReducedSize;

/**
 *
 * @author david
 */
public class ImageManager {
    private ArrayList <BufferedImage> carsImages;
    

    public ImageManager() {
        this.carsImages = carsImages;
        
        
    }
    public void createCarImages(ArrayList <BufferedImage> carsImages) throws IOException{
        //para el carro 1;
        //se debe de crear una variable para img,
            
        for (int i = 0; i < 4; i++) {
            BufferedImage imageCar = null;
            URL Url= null;
            switch (i) {
                case 0:
                    Url = getClass().getResource("/data/cars/greencar.png");
                    break;
                case 1:
                    Url = getClass().getResource("/data/cars/greencar.png");
                    break;
                case 2:
                    Url = getClass().getResource("/data/cars/redcar.png");
                    break;
                case 3:
                    Url = getClass().getResource("/data/cars/redcarRedimensionado.png");
                    break;
                default:
                    break;
            }
            
            imageCar = javax.imageio.ImageIO.read(Url);
            carsImages.add(imageCar);
        }
    
    
    }

    /**
     * @return the carsImages
     */
    public ArrayList <BufferedImage> getCarsImages() {
        return carsImages;
    }
    
    
}
