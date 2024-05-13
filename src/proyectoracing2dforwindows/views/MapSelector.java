/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectoracing2dforwindows.views;

import proyectoracing2dforwindows.interfaces.ClickListener;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
            background.setBackground(new Color(204, 204, 204));
            JLabel labelName = new JLabel(namedesc[0]);
            labelName.setBounds(30, 15, 150, 80);
            labelName.setFont(new Font("Tw Cen MT", Font.PLAIN, 50));
            
            JLabel labelDesc = new JLabel(namedesc[1]);
            labelDesc.setBounds(30, 120, 200, 20);
            labelDesc.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
            JButton button = new JButton();
            button.setBounds(35, 270, 200, 60);
            button.setText("Seleccionar");
            button.setFont(new Font("Tw Cen MT", Font.PLAIN, 24));
            button.setFocusPainted(false);
            button.setBackground(new Color(0, 153, 255));
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
        background.setBackground(new Color(153, 204, 255));
        int j = 0;
        for(JPanel panel : panels){
            if(j!=indexSelected){
                panel.setBackground(new Color(204, 204, 204));
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
        bJugar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 780));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout PanelMapsLayout = new javax.swing.GroupLayout(PanelMaps);
        PanelMaps.setLayout(PanelMapsLayout);
        PanelMapsLayout.setHorizontalGroup(
            PanelMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        PanelMapsLayout.setVerticalGroup(
            PanelMapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );

        ScrollMaps.setViewportView(PanelMaps);

        add(ScrollMaps, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 104, 920, 510));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 0, 718, 98));

        bJugar.setBackground(new java.awt.Color(0, 153, 0));
        bJugar.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        bJugar.setForeground(new java.awt.Color(255, 255, 255));
        bJugar.setText("Jugar");
        bJugar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 0), 5, true));
        bJugar.setFocusPainted(false);
        bJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJugarActionPerformed(evt);
            }
        });
        add(bJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 690, 192, 104));
    }// </editor-fold>//GEN-END:initComponents

    private void bJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJugarActionPerformed
        clickListener.playButtonClicked(mapSelected);
        
    }//GEN-LAST:event_bJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMaps;
    private javax.swing.JScrollPane ScrollMaps;
    private javax.swing.JButton bJugar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
