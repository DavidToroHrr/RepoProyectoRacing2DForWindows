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
import proyectoracing2dforwindows.exceptions.CheckpointException;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;
import proyectoracing2dforwindows.interfaces.KeyListener;
import proyectoracing2dforwindows.managers.GameSimulator;
import proyectoracing2dforwindows.specialsounds.Sound;
import proyectoracing2dforwindows.threads.SoundThread;




/**
 *
 * @author usuario
 */
public class MainWindow extends javax.swing.JFrame implements ClickListener, KeyListener{

    private GameSimulator game;
    private static SoundThread h1;
    private BufferedImage buffer;
    private static ArrayList <Sound> sounds;
    
    public MainWindow() {
        setUndecorated(true);
        
        initComponents();
        
        buffer = new BufferedImage(900, 900, BufferedImage.TYPE_INT_ARGB);
        sounds=new ArrayList<>();
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
        pack();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void showMapSelector() throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException {
        
        MapSelector mapSelector = new MapSelector(this);
        mapSelector.showMaps(game.showMaps());
        setCurrentPanel(mapSelector);

    }
    @Override
    public void showInitialMenu() throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException {
        
        System.out.println("Pasando por el menú inicial");
        InitialMenu initialMenu = new InitialMenu(this);
        
        
        setCurrentPanel(initialMenu);
        initialMenu.requestFocus();
        //h1.pause();
        
        
        
        
        
        
    }
    
    @Override
    public void showAboutUsPanel(){
        AboutUsPanel aboutUsPanel = new AboutUsPanel(this);
        
    
        setCurrentPanel(aboutUsPanel);
        aboutUsPanel.requestFocus();
    }
    
    @Override
    public void showOptionsPanel(){
        OptionsPanel optionsPanel = new OptionsPanel(this,game);
        
    
        setCurrentPanel(optionsPanel);
        optionsPanel.requestFocus();
    
    }
    
    public void showGamePanel(String nameMap) throws IOException{
        
        System.out.println("paso por gamePanelq");
        game.loadMap(nameMap);
        GamePanel gamePanel = new GamePanel(this, game);
        
        setCurrentPanel(gamePanel);
        gamePanel.requestFocus(); // Solicitar el foco para recibir eventos de teclado
        
        h1.pause();//puedo despausar cuando regrese al map selector de nuevo
        
        

    }
    @Override
    public void showCarSelector(int player){
    
        CarSelector carSelector = new CarSelector(player,game,this);
        
    
        setCurrentPanel(carSelector);
        carSelector.requestFocus();
    
    
    }
    




    @Override
    public void showPlayersAndScoresPanel(int player){
        PlayersAndScoresPanel playersAndScoresPanel = new PlayersAndScoresPanel(game.getScoreNames(), game.getScorePoints(), player, game,this);
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
    
    @Override
    public void returnMapSelector()throws FileManagerException, MapFileNotFoundException, InvalidMapFormatException, CheckpointException{
            
            h1.pause();
            showMapSelector();
            JOptionPane.showMessageDialog(this, "The winner is: "+game.getWinner()+".\nHis score was: "+game.getScoreWinner()+".", "Finished game", JOptionPane.INFORMATION_MESSAGE);
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
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException, FileManagerException, MapFileNotFoundException, InvalidMapFormatException {
        
        MainWindow window = new MainWindow();
        h1=null;
        GameSimulator game = new GameSimulator(window,h1);
        window.setGame(game);
        sounds=game.getSounds();
        //System.out.println("paso por la main");
        //window.showPlayersAndScoresPanel();
        h1= new SoundThread(sounds.get(2));
        //window.showMapSelector();
        h1.start();
        window.showInitialMenu();
         
        
        
        

        
        window.setVisible(true);
        window.setAlwaysOnTop(true);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel currentPanel;
    // End of variables declaration//GEN-END:variables

    
    

    
}
