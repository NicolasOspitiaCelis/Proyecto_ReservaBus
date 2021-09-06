/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import static vista.PrincipalFrame.PrincipalPanel;

/**
 *
 * @author Nicolas Ospitia
 */
public class MenuPrincipal extends javax.swing.JPanel {

    private Image imagen;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuB = new javax.swing.JButton();
        ReservaB = new javax.swing.JButton();
        RutasB = new javax.swing.JButton();

        MenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Titulo.png"))); // NOI18N
        MenuB.setContentAreaFilled(false);
        MenuB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Logo_G.png"))); // NOI18N
        MenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBActionPerformed(evt);
            }
        });

        ReservaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Treserva.png"))); // NOI18N
        ReservaB.setContentAreaFilled(false);
        ReservaB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Treserva_G.png"))); // NOI18N
        ReservaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaBActionPerformed(evt);
            }
        });

        RutasB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Trutas.png"))); // NOI18N
        RutasB.setContentAreaFilled(false);
        RutasB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Trutas_G.png"))); // NOI18N
        RutasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutasBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(MenuB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(RutasB, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ReservaB))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(ReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RutasB, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ReservaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaBActionPerformed
        // TODO add your handling code here:
        ReservaPanel ReservaP = new ReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ReservaP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
    }//GEN-LAST:event_ReservaBActionPerformed

    private void RutasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutasBActionPerformed
        // TODO add your handling code here:
        RutasPanel RutasP = new RutasPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(RutasP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
    }//GEN-LAST:event_RutasBActionPerformed

    private void MenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBActionPerformed
        // TODO add your handling code here:
        OtroMenu Menu = new OtroMenu();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(Menu);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
    }//GEN-LAST:event_MenuBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuB;
    private javax.swing.JButton ReservaB;
    private javax.swing.JButton RutasB;
    // End of variables declaration//GEN-END:variables
        
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondo.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
}