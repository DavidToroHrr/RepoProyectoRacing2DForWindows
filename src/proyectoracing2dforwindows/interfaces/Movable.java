package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.models.Car;
import proyectoracing2dforwindows.models.Sprite;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author usuario
 */
public interface Movable {
    public void verifyObjectCollision(Car car);
    public void verifyRunwayCollision(int newX, int newY, Car car);
}
