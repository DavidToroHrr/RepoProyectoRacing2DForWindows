/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectoracing2dforwindows.views;

import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import proyectoracing2dforwindows.interfaces.ClickListener;

/**
 *
 * @author usuario
 */
public class PlayersAndScoresPanel extends javax.swing.JPanel {

    ArrayList<String> names;//Se guardan los nombres de los jugadores
    ArrayList<Integer> scores;//Se guardan los puntajes de los jugadores
    private ClickListener clickListener;
    
    
    public PlayersAndScoresPanel(ArrayList<String> names,
    ArrayList<Integer> scores) {
        initComponents();
        this.names = names;
        this.scores = scores;
    }
    
    public void showScores(){
        int y;
        for(int i = 0; i < names.size(); i++){
            y = (100*i) + 20;
            JLabel labelName = new JLabel(names.get(i));
            labelName.setBounds(30, y, 350, 80);
            labelName.setFont(new Font("Tw Cen MT", Font.PLAIN, 70));
            
            JLabel labelPoint = new JLabel(""+scores.get(i));
            labelPoint.setBounds(520, y, 300, 80);
            labelPoint.setFont(new Font("Tw Cen MT", Font.PLAIN, 70));
            
            PanelScores.add(labelName);
            PanelScores.add(labelPoint);
        }
        PanelScores.setPreferredSize(new Dimension(870, names.size()*100));
        PanelScores.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollScores = new javax.swing.JScrollPane();
        PanelScores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(900, 900));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelScores.setPreferredSize(new java.awt.Dimension(870, 550));

        javax.swing.GroupLayout PanelScoresLayout = new javax.swing.GroupLayout(PanelScores);
        PanelScores.setLayout(PanelScoresLayout);
        PanelScoresLayout.setHorizontalGroup(
            PanelScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        PanelScoresLayout.setVerticalGroup(
            PanelScoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        ScrollScores.setViewportView(PanelScores);

        add(ScrollScores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 900, 420));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 3, 70)); // NOI18N
        jLabel1.setText("Names:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 3, 70)); // NOI18N
        jLabel2.setText("Scores:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelScores;
    private javax.swing.JScrollPane ScrollScores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
