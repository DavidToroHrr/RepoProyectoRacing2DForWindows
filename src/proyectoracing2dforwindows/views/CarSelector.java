/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package proyectoracing2dforwindows.views;

import proyectoracing2dforwindows.interfaces.Configurable;

/**
 *
 * @author david
 */
public class CarSelector extends javax.swing.JPanel {
    private int player;
    private Configurable configurable;
    /**
     * Creates new form CarSelector
     */
    public CarSelector(int player, Configurable configurable) {
        initComponents();
        this.player=player;
        this.configurable=configurable;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bSelectPinkCar = new javax.swing.JButton();
        bSelectBlackCar = new javax.swing.JButton();
        bSelectBlueCar = new javax.swing.JButton();
        bSelectGreenCar = new javax.swing.JButton();
        bSelectRedCar = new javax.swing.JButton();
        bSelectYellowCar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 900));

        jPanel1.setMinimumSize(new java.awt.Dimension(900, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 900));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/carblackmenu.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/carbluemenu.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/carpinkmenu.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/carredmenu.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/caryellowmenu.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/carselector/cargreenmenu.png"))); // NOI18N

        bSelectPinkCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectPinkCar.setText("SELECT");
        bSelectPinkCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectPinkCarActionPerformed(evt);
            }
        });

        bSelectBlackCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectBlackCar.setText("SELECT");
        bSelectBlackCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectBlackCarActionPerformed(evt);
            }
        });

        bSelectBlueCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectBlueCar.setText("SELECT");
        bSelectBlueCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectBlueCarActionPerformed(evt);
            }
        });

        bSelectGreenCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectGreenCar.setText("SELECT");
        bSelectGreenCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectGreenCarActionPerformed(evt);
            }
        });

        bSelectRedCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectRedCar.setText("SELECT");
        bSelectRedCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectRedCarActionPerformed(evt);
            }
        });

        bSelectYellowCar.setFont(new java.awt.Font("Tw Cen MT", 0, 40)); // NOI18N
        bSelectYellowCar.setText("SELECT");
        bSelectYellowCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectYellowCarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSelectPinkCar)
                            .addComponent(bSelectBlackCar))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bSelectBlueCar)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bSelectGreenCar, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(240, 240, 240)
                                .addComponent(bSelectRedCar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSelectYellowCar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSelectBlackCar)
                    .addComponent(bSelectBlueCar)
                    .addComponent(bSelectGreenCar))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSelectPinkCar)
                    .addComponent(bSelectRedCar)
                    .addComponent(bSelectYellowCar))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bSelectPinkCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectPinkCarActionPerformed
        // TODO add your handling code here:
        String nameCar="pinkcar";
        configurable.selectCarPlayer(player, nameCar);
        
        
    }//GEN-LAST:event_bSelectPinkCarActionPerformed

    private void bSelectBlackCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectBlackCarActionPerformed
        // TODO add your handling code here:
        String nameCar="blackcar";
        configurable.selectCarPlayer(player, nameCar);
    }//GEN-LAST:event_bSelectBlackCarActionPerformed

    private void bSelectBlueCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectBlueCarActionPerformed
        // TODO add your handling code here:
        String nameCar="bluecar";
        configurable.selectCarPlayer(player, nameCar);
    }//GEN-LAST:event_bSelectBlueCarActionPerformed

    private void bSelectGreenCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectGreenCarActionPerformed
        // TODO add your handling code here:
        String nameCar="greencar";
        configurable.selectCarPlayer(player, nameCar);
    }//GEN-LAST:event_bSelectGreenCarActionPerformed

    private void bSelectRedCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectRedCarActionPerformed
        // TODO add your handling code here:
        String nameCar="redcar";
        configurable.selectCarPlayer(player, nameCar);
    }//GEN-LAST:event_bSelectRedCarActionPerformed

    private void bSelectYellowCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectYellowCarActionPerformed
        // TODO add your handling code here:
        String nameCar="yellowcar";
        configurable.selectCarPlayer(player, nameCar);
    }//GEN-LAST:event_bSelectYellowCarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSelectBlackCar;
    private javax.swing.JButton bSelectBlueCar;
    private javax.swing.JButton bSelectGreenCar;
    private javax.swing.JButton bSelectPinkCar;
    private javax.swing.JButton bSelectRedCar;
    private javax.swing.JButton bSelectYellowCar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
