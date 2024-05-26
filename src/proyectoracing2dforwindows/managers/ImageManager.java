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
* managers.ImageManager
* Clase encargada de guardar las imagenes de los principales
* componentes en el sistema
*/
public class ImageManager {
    
/**
* Todos estos arreglos guardan las imagenes que pueden tener color de carro
*/
    private ArrayList <BufferedImage> imagesRedCar;
    private ArrayList <BufferedImage> imagesGreenCar;
    private ArrayList <BufferedImage> imagesPinkCar;
    

    public ImageManager() throws IOException {
        
        imagesRedCar=new ArrayList<>();
        imagesGreenCar=new ArrayList<>();
        imagesPinkCar=new ArrayList<>();
        createCarImages();
        
    }

/**
* managers.ImageManager#createCarImages()
* Metodo encargado de cargar en memoria las imagenes de los carros, 
* en todos sus tamaños
*/
    private void createCarImages() throws IOException{
        //para el carro 1;
        //se debe de crear una variable para img,
            
        for (int i = 0; i < 9; i++) {
            BufferedImage imageCar = null;
            URL Url= null;
            switch (i) {
                case 0:
                    Url = getClass().getResource("/data/cars/greencar.png");
                    break;
                case 1:
                    Url = getClass().getResource("/data/cars/littlegreencar.png");
                    break;
                case 2:
                    Url = getClass().getResource("/data/cars/biggreencar.png");
                    break;
                case 3:
                    Url = getClass().getResource("/data/cars/redcar.png");
                    break;
                case 4:
                    Url = getClass().getResource("/data/cars/littleredcar.png");
                    break;
                case 5:
                    Url = getClass().getResource("/data/cars/bigredcar.png");
                    break;
                case 6:
                    Url = getClass().getResource("/data/cars/pinkcar.png");
                    break;
                case 7:
                    Url = getClass().getResource("/data/cars/littlepinkcar.png");
                    break;
                case 8:
                    Url = getClass().getResource("/data/cars/bigpinkcar.png");
                    break;
                default:
                    break;
            }
            imageCar = javax.imageio.ImageIO.read(Url);
            if (i<=2) {
                getImagesGreenCar().add(imageCar);
            }else if (i<=5) {
                getImagesRedCar().add(imageCar);
            }
            else if (i<=8) {
                getImagesPinkCar().add(imageCar);
            }
            
            
        }
    
    
    }

/**
* managers.ImageManager#getImagesCar()
* Metodo encargado de cargar en memoria las imagenes de los carros, 
* en todos sus tamaños
     * @param car: Nombre del carro del que se requieren las imagenes
     * @return : Un arreglo con todas la imagenes del carro solicitado
*/
    public ArrayList <BufferedImage> getImagesCar(String car){
        switch (car) {
            case "redcar":
                return imagesRedCar;
            case "greencar":
                return imagesGreenCar;
            case "pinkcar":
                return imagesPinkCar;
            default:
                return null;
        }
    }
    
    /**
     * @return the imagesRedCar
     */
    public ArrayList <BufferedImage> getImagesRedCar() {
        return imagesRedCar;
    }

    /**
     * @return the imagesGreenCar
     */
    public ArrayList <BufferedImage> getImagesGreenCar() {
        return imagesGreenCar;
    }
    /**
     * @return the imagesPinkCar
     */
    public ArrayList <BufferedImage> getImagesPinkCar() {
        return imagesPinkCar;
    }

    
    
    
}
