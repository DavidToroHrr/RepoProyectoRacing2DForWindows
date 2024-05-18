/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

/**
 *
 * @author usuario
 */
public class Checkpoint extends Sprite{
    
    private int priority;
    
    public Checkpoint(int x, int y, int width, int height, int priority) {
        super(x, y, width, height);
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
    
    
    
}
