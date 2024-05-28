/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.car;

import proyectoracing2dforwindows.specialsounds.Sound;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import proyectoracing2dforwindows.interfaces.Applicable;
import proyectoracing2dforwindows.interfaces.CarCustomable;
import proyectoracing2dforwindows.interfaces.Movable;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.models.GameObject;
import proyectoracing2dforwindows.threads.CarEngine;
import proyectoracing2dforwindows.threads.SoundThread;

public class Car extends GameObject implements CarCustomable {
    Paintable paint;
    protected CarEngine ce;//motor que me permite aplicar los efectos en el carro
    
    protected Thread t1;//hilo el cual es vacío y en donde se mete el motor
    
    protected Movable movable;//
    
    protected int maxSpeed;//indica la velocidad máxima de los carros en determinado tramo
    
    
    private boolean movement;//me indica si el carro está o no en movimiento
    
    int initialX;//velocidad inicial en x
    int initialY;//velocidad inicial en y
    
    protected int velocityX; // Velocidad horizontal del carro
    protected int velocityY; // Velocidad vertical del carro
    protected final int SPEED_INCREMENT = 1; // Incremento de velocidad al presionar una tecla
    public static final int MAX_SPEED_TRAIL = 3; // Velocidad máxima del carro
    public static final int MAX_SPEED_BORDER = 2; // Velocidad máxima del carro
    public static final int MAX_SPEED_GRASS = 1; // Velocidad máxima del carro
    
    private ArrayList <BufferedImage> carImages;//arreglo de imagenes del carro respectivo
    
     
     
    private int degree;//grados del carro, depende de sys velocidades en x e y
     
     private SoundThread st;//hilo que permite ejecutar sonidos en bucle
     private Sound sound;//sonido respectivo del motor del carro
     
    public Car(int x, int y, int width, int height, String id, ArrayList <BufferedImage> carImages, URL url,Paintable p1,Movable movable,Sound sound,SoundThread st) {
        super(x, y, width, height, id, carImages.get(0), url);
        movement=true;
        st=new SoundThread(sound);
        this.st=st;
        st.start();
        this.sound=sound;
        maxSpeed = MAX_SPEED_TRAIL;
        this.carImages=new ArrayList<>();
        this.carImages=carImages;
        this.velocityX = 0;
        this.velocityY = 0;
        this.paint=p1;
        this.movable = movable;
        degree=0;
        initialX=x;
        initialY=y;
        
    }
    public void actualizar() {
        paint.repaint(x,y,width,height);
        
        int xNuevo = x;
        int yNuevo = y;
        // Actualizar la posición del carro
        xNuevo += getVelocityX();
        yNuevo += getVelocityY();
        
        if(xNuevo != x || yNuevo != y){
            movement=true;
            movable.verifyRunwayCollision(xNuevo, yNuevo, this);
            paint.repaint();   
        }else{movement=false;}
        
        // Limitar la velocidad máxima
        if (getVelocityX() > maxSpeed) {
            setVelocityX(maxSpeed);   
        }
        if (getVelocityX() < -maxSpeed) {
            setVelocityX(-maxSpeed);
        }
        if (getVelocityY() > maxSpeed) {
            setVelocityY(maxSpeed);
        }
        if (getVelocityY() < -maxSpeed) {
            setVelocityY(-maxSpeed);
        }
        x += getVelocityX();
        y += getVelocityY();
        
        movable.verifyObjectCollision(this);

        paint.repaint(x,y,width,height);

        movable.verifyCheckpoints(x, y, width, height, id);
        rotateCar();
        verifyMovement();
        
    }
    public void verifyMovement(){
        
        if (movement==false &&(initialX!=x && initialY!=y)) {
            st.pause();
        }
    }
    public void keyPressed(char key){
        paint.repaint(x,y,width,height);
        
        // Acelerar el carro hacia la izquierda
        if (key == 'L') {
            setVelocityX(getVelocityX() - SPEED_INCREMENT);
        }
        // Acelerar el carro hacia la derecha
        else if (key == 'R') {
            setVelocityX(getVelocityX() + SPEED_INCREMENT);
        }
        // Acelerar el carro hacia arriba
        else if (key == 'U') {
            setVelocityY(getVelocityY() - SPEED_INCREMENT);
        }
        // Acelerar el carro hacia abajo
        else if (key == 'D') {
            setVelocityY(getVelocityY() + SPEED_INCREMENT);
        }
    }

    
    
    public boolean receiveEffect(Applicable ap,ArrayList <Sound>sound){
        if (ce==null || ce.isControl() ) {
            ce=new CarEngine(ap, this,sound);
            t1=new Thread(ce);
            t1.start();
            return true;
        }
        //System.out.println("no se pudo crear");
        return false;
        
        
        
    }
    public void rotateCar(){
        if(velocityX>0 && velocityY<0){
            degree=45;
        }
        else if(velocityX>0 && velocityY>0){
            degree=125;
        }
        else if(velocityX<0 && velocityY>0){
            degree=225;
        }
        else if(velocityX<0 && velocityY<0){
            degree=-45;
        }
        else if (velocityX>0) {
            degree =90;
        } else if (velocityX<0) {
            degree =-90;
        } 
        else if (velocityY>0) {
            degree=180;
        } else if (velocityY<0) {
            degree=0;
        }
    }
    @Override
        public void draw(Graphics g) {
       
        // Dibuja el carro en su posición actual
        Graphics2D g2d =(Graphics2D)g.create(); // Crear una copia del contexto gráfico
        g2d.rotate(Math.toRadians(degree),x+width/2, y+height/2);

        super.draw(g2d);
        

        g2d.dispose(); // Liberar el contexto gráfico
        
        
        
        paint.repaint();
    }

    /**
     * @return the velocityX
     */
    public int getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public int getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return the CarImages
     */
    public ArrayList <BufferedImage> getcarImages() {
        return carImages;
    }

    public void setCarImages(ArrayList<BufferedImage> carImages) {
        this.carImages = carImages;
        setImage(carImages.get(0));
    }

    /**
     * @return the st
     */
    public SoundThread getSt() {
        return st;
    }

    /**
     * @param st the st to set
     */
    public void setSt(SoundThread st) {
        this.st = st;
    }
    
    
    
}

