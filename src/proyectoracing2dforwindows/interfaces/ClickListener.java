/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.exceptions.CheckpointException;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;

/**
* interfaces.ClickListener
* Interfaz para detectar en la mainwindow los botones y acciones realizadas
* en otros paneles
*/
public interface ClickListener {
    public void menuButtonClicked(String nameButton);
    public void playButtonClicked(String nameMap);
    public void showAboutUsPanel();
    public void showOptionsPanel();
    //public void OptionsButtonClicked(String nameMap);
    //public void playButtonClicked(String nameMap);
    //public void AboutUsButtonClicked(String nameMap);
    public void showMapSelector()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException ;
    public void showInitialMenu()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException,CheckpointException;
    public void showCarSelector(int player);
    public void showPlayersAndScoresPanel(int player);
    public void returnMapSelector()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException;
    
}
