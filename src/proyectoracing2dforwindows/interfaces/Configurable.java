/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.exceptions.DuplicateScoreException;

/**
* interfaces.Configurable
* Interfaz que permite editar los valores basicos del juego, como color de carro
* nombre de player, o vueltas por carrera
*/
public interface Configurable {
    public String getScorePlayerName(int player);
    public void selectScorePlayerName(int player, String name);
    public void addScorePlayer(int player, String name)throws DuplicateScoreException;
    public void selectCarPlayer(int player, String carname);
    public int getNumLaps();
    public void setNumLaps(int numLaps);
    public int getNumPowers();
    public void setNumPowers(int numPowers);
}
