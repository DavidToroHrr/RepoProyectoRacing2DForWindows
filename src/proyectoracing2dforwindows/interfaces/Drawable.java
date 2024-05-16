/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import java.awt.Graphics;

/**
 *
 * @author usuario
 */
public interface Drawable {
    public void drawElements(Graphics g) throws InterruptedException;
    public void setPaint(Paintable paint);
}
