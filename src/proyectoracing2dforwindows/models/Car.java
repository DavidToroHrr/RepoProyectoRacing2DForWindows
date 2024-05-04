/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoracing2dforwindows.models;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author david
 */
public class Car extends Object{
    private Color color;
    private int amountSpeed;

    public Car(Color color, int amountSpeed, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.color = color;
        this.amountSpeed = amountSpeed;
    }
    
    public void acelerar(){}
    
    public void frenar(){};

    @Override
    public void draw(Graphics g) {
        super.draw(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    
    
    
}
