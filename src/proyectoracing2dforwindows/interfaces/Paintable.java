/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import java.awt.Graphics;

/**
 *
 * @author david
 */
public interface Paintable {
    public void repaint();
    public void revalidate();
    public void repaint(int x, int y, int width, int height);
   
}
