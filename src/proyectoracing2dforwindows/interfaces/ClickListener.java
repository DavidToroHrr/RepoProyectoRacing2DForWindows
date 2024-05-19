/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package proyectoracing2dforwindows.interfaces;

import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;

/**
 *
 * @author usuario
 */
public interface ClickListener {
    public void menuButtonClicked(String nameButton);
    public void playButtonClicked(String nameMap);
    public void showAboutUsPanel();
    public void showOptionsPanel();
    //public void OptionsButtonClicked(String nameMap);
    //public void playButtonClicked(String nameMap);
    //public void AboutUsButtonClicked(String nameMap);
    public void showMapSelector()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException ;
    public void showInitialMenu()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException;
}
