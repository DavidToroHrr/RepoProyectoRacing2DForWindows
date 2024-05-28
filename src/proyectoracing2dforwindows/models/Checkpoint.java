/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

/**
 * models.Checkpoint 
 * Esta clase representa los checkpoints por los cuales 
 * debe pasar el carro para que se cuente una vuelta
 */
public class Checkpoint extends Sprite{
    
    private int priority;//Guarda la prioridad u orden del checkpoint con respecto al resto
    
    public Checkpoint(int x, int y, int width, int height, int priority) {
        super(x, y, width, height);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
    
    
    
}
