/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectoracing2dforwindows.views;

import proyectoracing2dforwindows.interfaces.ClickListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import proyectoracing2dforwindows.exceptions.CheckpointException;
import proyectoracing2dforwindows.exceptions.FileManagerException;
import proyectoracing2dforwindows.exceptions.InvalidMapFormatException;
import proyectoracing2dforwindows.exceptions.MapFileNotFoundException;

/**
 *
 * @author usuario
 */
public class MapSelector extends javax.swing.JPanel {

    private String mapSelected;
    private int indexSelected;
    private ArrayList<JPanel> panels;
    private ClickListener clickListener;
    
    public MapSelector(ClickListener clickListener) {
        initComponents();
        this.panels = new ArrayList<>();
        this.clickListener = clickListener;
    }

    public void showMaps(ArrayList<String> strings){
        int i = 0;
        int x;
        for(String text : strings){
            String[] namedesc = text.split("\\|");
            x = (i*300) + 15;
            JPanel background = new JPanel();
            background.setBounds(x, 60, 275, 380);
            background.setBackground(new Color(255, 255, 255));
            JLabel labelName = new JLabel(namedesc[0]);
            labelName.setBounds(30, 15, 150, 80);
            labelName.setFont(new Font("Tw Cen MT", Font.PLAIN, 50));
            
            JLabel labelDesc = new JLabel(namedesc[1]);
            labelDesc.setBounds(30, 120, 200, 20);
            labelDesc.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
            JButton button = new JButton();
            button.setBounds(35, 270, 200, 60);
            button.setText("Select");
            button.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
            button.setFocusPainted(false);
            button.setBackground(new Color(240, 34, 54));
            button.setForeground(Color.WHITE);
            int index = i;
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    selectedMap(index, namedesc[0], background);
                }
            });
            
            
            
            i += 1;
            background.setLayout(null);
            background.add(labelName);
            background.add(labelDesc);
            background.add(button);
            background.revalidate();
            panels.add(background);
            PanelMaps.add(background);
            
        }
        ScrollMaps.setPreferredSize(new Dimension(900, 220));
        PanelMaps.setPreferredSize(new Dimension(strings.size()*300, 200));
        PanelMaps.revalidate();
    }
    
    private void selectedMap(int index, String nameMapSelected, JPanel background){
        indexSelected = index;
        mapSelected = nameMapSelected;
        background.setBackground(new Color(245, 76, 93));
        int j = 0;
        for(JPanel panel : panels){
            if(j!=indexSelected){
                panel.setBackground(new Color(255, 255, 255));
            }
            j += 1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollMaps = new javax.swing.JScrollPane();
        PanelMaps = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bReturn = new javax.swing.JButton();
        bJugar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(900, 900));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelMaps.setBackground(new java.awt.Color(153, 153, 153));
        PanelMaps.setPreferredSize(new java.awt.Dimension(910, 508));

        javax.swing.GroupLayout PanelMapsLayout = new javax.swing.GroupLayout(PanelMaps);
        PanelMaps.setLayout(PanelMapsLayout);
        PanelMapsLayout.setHorizontalGroup(
            PanelMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        PanelMapsLayout.setVerticalGroup(
            PanelMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        ScrollMaps.setViewportView(PanelMaps);

        add(ScrollMaps, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 104, 900, 510));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 70)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Level Selector");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 390, 98));

        bReturn.setBackground(new java.awt.Color(195, 21, 18));
        bReturn.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        bReturn.setForeground(new java.awt.Color(255, 255, 255));
        bReturn.setText("Return");
        bReturn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 5, true));
        bReturn.setFocusPainted(false);
        bReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bReturnActionPerformed(evt);
            }
        });
        add(bReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 192, 104));

        bJugar1.setBackground(new java.awt.Color(195, 21, 18));
        bJugar1.setFont(new java.awt.Font("Tw Cen MT", 0, 48)); // NOI18N
        bJugar1.setForeground(new java.awt.Color(255, 255, 255));
        bJugar1.setText("Start");
        bJugar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 5, true));
        bJugar1.setFocusPainted(false);
        bJugar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJugar1ActionPerformed(evt);
            }
        });
        add(bJugar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 690, 192, 104));
    }// </editor-fold>//GEN-END:initComponents

    private void bReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bReturnActionPerformed
        try {
            clickListener.showInitialMenu();
        } catch (FileManagerException ex) {
            Logger.getLogger(MapSelector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MapFileNotFoundException ex) {
            Logger.getLogger(MapSelector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMapFormatException ex) {
            Logger.getLogger(MapSelector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CheckpointException ex) {
            Logger.getLogger(MapSelector.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bReturnActionPerformed

    private void bJugar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJugar1ActionPerformed
        if (mapSelected != null && !mapSelected.isEmpty()) {
            clickListener.playButtonClicked(mapSelected);
        }
    }//GEN-LAST:event_bJugar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMaps;
    private javax.swing.JScrollPane ScrollMaps;
    private javax.swing.JButton bJugar1;
    private javax.swing.JButton bReturn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
