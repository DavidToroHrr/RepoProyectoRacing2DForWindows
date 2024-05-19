/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoracing2dforwindows.views;

import proyectoracing2dforwindows.interfaces.ClickListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;
import proyectoracing2dforwindows.interfaces.KeyListener;
import proyectoracing2dforwindows.interfaces.Paintable;
import proyectoracing2dforwindows.managers.GameSimulator;
import proyectoracing2dforwindows.models.Runway;




/**
 *
 * @author usuario
 */
public class MainWindow extends javax.swing.JFrame implements ClickListener, KeyListener{

    private GameSimulator game;
    private BufferedImage buffer;
    
    public MainWindow() {
        setUndecorated(true);
        
        initComponents();
        buffer = new BufferedImage(900, 900, BufferedImage.TYPE_INT_ARGB);
    }

    public void setGame(GameSimulator game) {
        this.game = game;
    }
    

    @Override
    public void repaint(int x, int y, int width, int height) {
        super.repaint(x, y, width, height); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

    
    
    public void setCurrentPanel(JPanel currentPanel) {
        this.currentPanel = currentPanel;
        setContentPane(currentPanel);
        revalidate();
    }
    
    public void showMapSelector() throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException {
        MapSelector mapSelector = new MapSelector(this);
        mapSelector.showMaps(game.showMaps());
        setCurrentPanel(mapSelector);
    }

    
    public void showGamePanel(String nameMap) throws IOException{
       
        game.loadMap(nameMap);
        Runway runway =game.getCurrentRunway();
        GamePanel gamePanel = new GamePanel(this, game);
        gamePanel.setRunway(runway);
        
        setCurrentPanel(gamePanel);
        gamePanel.requestFocus(); // Solicitar el foco para recibir eventos de teclado


    }
    
    public void showPlayersAndScoresPanel(){
        PlayersAndScoresPanel playersAndScoresPanel = new PlayersAndScoresPanel(game.getScoreNames(), game.getScorePoints());
        playersAndScoresPanel.showScores();
        setCurrentPanel(playersAndScoresPanel);
    }

    @Override
    public void menuButtonClicked(String nameButton) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void playButtonClicked(String nameMap) {
        try {
            showGamePanel(nameMap);
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void formKeyReleased(KeyEvent evt) {
        //System.out.println("REALEASED");
        if (evt.getKeyCode()==KeyEvent.VK_UP |
                evt.getKeyCode()==KeyEvent.VK_LEFT|
                evt.getKeyCode()==KeyEvent.VK_RIGHT|
                evt.getKeyCode()==KeyEvent.VK_DOWN) 
        {
            try {
                game.keyReleased(evt);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("Nos vamos para arriba");
        }
    }

    @Override
    public void formKeyPressed(KeyEvent evt) {
        // TODO add your handling code here:
        //System.out.println("Nos vamos para arriba");

        // TODO add your handling code here:
        if (evt.getKeyChar()=='q') {
            System.exit(0);
        }
        if (evt.getKeyCode()==KeyEvent.VK_UP |
                evt.getKeyCode()==KeyEvent.VK_LEFT|
                evt.getKeyCode()==KeyEvent.VK_RIGHT|
                evt.getKeyCode()==KeyEvent.VK_DOWN |
                evt.getKeyCode()==KeyEvent.VK_A|
                evt.getKeyCode()==KeyEvent.VK_S|
                evt.getKeyCode()==KeyEvent.VK_W|
                evt.getKeyCode()==KeyEvent.VK_D) 
        {
            try {
                game.keyPressed(evt);
            } catch (InterruptedException ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println("Nos vamos para arriba");
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout currentPanelLayout = new javax.swing.GroupLayout(currentPanel);
        currentPanel.setLayout(currentPanelLayout);
        currentPanelLayout.setHorizontalGroup(
            currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        currentPanelLayout.setVerticalGroup(
            currentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(currentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
    try {
        MainWindow window = new MainWindow();
        GameSimulator game = new GameSimulator();
        window.setGame(game);
        window.showMapSelector();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setAlwaysOnTop(true);
    } catch (FileManagerException | MapFileNotFoundException | InvalidMapFormatException e) {
        JOptionPane.showMessageDialog(null, "Error when starting the game: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentPanel;
    // End of variables declaration//GEN-END:variables

    
    

    
}
