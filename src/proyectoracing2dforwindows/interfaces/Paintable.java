/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import java.awt.Graphics;


/**
* interfaces.Paintable
* Interfaz que sirve para repintar los cambios o para dibujar los elementos del juego
*/
public interface Paintable {
    public void repaint();//repinta toda la pantalla
    public void repaint(int x, int y, int width, int height);//repinta una posición específica de la pantalla
   
}
