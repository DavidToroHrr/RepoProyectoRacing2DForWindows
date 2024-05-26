/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.specialobjetcs.SpecialObject;

/**
 *
 * @author david
 */
public interface SpecialMovable {
    public void verifySpecialObjectCollision(SpecialObject specialObject, int newY);
}
