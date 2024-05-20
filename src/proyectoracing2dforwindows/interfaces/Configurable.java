/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.exceptions.DuplicateScoreException;

/**
 *
 * @author usuario
 */
public interface Configurable {
    public String getScorePlayerName(int player);
    public void selectScorePlayerName(int player, String name);
    public void addScorePlayer(int player, String name)throws DuplicateScoreException;
    public void selectCarPlayer(int player, String carname);
}