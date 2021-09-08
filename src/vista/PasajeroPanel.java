/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.PasajeroJpaController;
import java.awt.Graphics;
import java.awt.Image;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Pasajero;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.reproducirS;

/**
 *
 * @author Nicolas Ospitia
 */
public class PasajeroPanel extends javax.swing.JPanel {

    private final Pasajero pasajero;
    private final PasajeroJpaController pasajeroControlador;
    private final EntityManagerFactory emf;
    private Image imagen;
    /**
     * Creates new form RutasPanel
     */
    public PasajeroPanel() {
        initComponents();
        pasajero = new Pasajero();
        emf = Persistence.createEntityManagerFactory("ReservaBusPU");
        pasajeroControlador = new PasajeroJpaController(emf);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloRuta = new javax.swing.JLabel();
        CrearPasajeroB = new javax.swing.JButton();
        ConsultarPasajeroB = new javax.swing.JButton();
        EditarPasajeroB = new javax.swing.JButton();
        EliminarPasajeroB = new javax.swing.JButton();
        AtrasRuta = new javax.swing.JButton();

        TituloRuta.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        TituloRuta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/PasajeroT.png"))); // NOI18N

        CrearPasajeroB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CrearPasajeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/RutasIcon.png"))); // NOI18N
        CrearPasajeroB.setText("Crear pasajero");
        CrearPasajeroB.setAlignmentX(100.0F);
        CrearPasajeroB.setAlignmentY(100.0F);
        CrearPasajeroB.setContentAreaFilled(false);
        CrearPasajeroB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CrearPasajeroB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/RutasIcon_G.png"))); // NOI18N
        CrearPasajeroB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CrearPasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPasajeroBActionPerformed(evt);
            }
        });

        ConsultarPasajeroB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ConsultarPasajeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon.png"))); // NOI18N
        ConsultarPasajeroB.setText("Consultar pasajero");
        ConsultarPasajeroB.setContentAreaFilled(false);
        ConsultarPasajeroB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConsultarPasajeroB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon_G_G.png"))); // NOI18N
        ConsultarPasajeroB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConsultarPasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarPasajeroBActionPerformed(evt);
            }
        });

        EditarPasajeroB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EditarPasajeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon.png"))); // NOI18N
        EditarPasajeroB.setText("Editar pasajero");
        EditarPasajeroB.setContentAreaFilled(false);
        EditarPasajeroB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarPasajeroB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon_G_G.png"))); // NOI18N
        EditarPasajeroB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarPasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarPasajeroBActionPerformed(evt);
            }
        });

        EliminarPasajeroB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EliminarPasajeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EliminarIcon.png"))); // NOI18N
        EliminarPasajeroB.setText("Eliminar pasajero");
        EliminarPasajeroB.setContentAreaFilled(false);
        EliminarPasajeroB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarPasajeroB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EliminarIcon_G_G.png"))); // NOI18N
        EliminarPasajeroB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarPasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarPasajeroBActionPerformed(evt);
            }
        });

        AtrasRuta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras.png"))); // NOI18N
        AtrasRuta.setContentAreaFilled(false);
        AtrasRuta.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras_G.png"))); // NOI18N
        AtrasRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EliminarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasRuta)
                .addGap(131, 131, 131)
                .addComponent(TituloRuta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AtrasRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TituloRuta))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrearPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CrearPasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPasajeroBActionPerformed
        // TODO add your handling code here:
        CrearPasajeroPanel CrearP = new CrearPasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(CrearP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("buttonS.mp3");
        System.gc();
    }//GEN-LAST:event_CrearPasajeroBActionPerformed

    private void ConsultarPasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarPasajeroBActionPerformed
        // TODO add your handling code here:
        ConsultarPasajeroPanel ConsultarP = new ConsultarPasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ConsultarP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("buttonS.mp3");
        System.gc();
    }//GEN-LAST:event_ConsultarPasajeroBActionPerformed

    private void EditarPasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarPasajeroBActionPerformed
        // TODO add your handling code here:
        EditarPasajeroPanel EditarP = new EditarPasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(EditarP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("buttonS.mp3");
        System.gc();
    }//GEN-LAST:event_EditarPasajeroBActionPerformed

    private void EliminarPasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPasajeroBActionPerformed
        // TODO add your handling code here:
        EliminarPasajeroPanel EliminarP = new EliminarPasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(EliminarP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("buttonS.mp3");
        System.gc();
    }//GEN-LAST:event_EliminarPasajeroBActionPerformed

    private void AtrasRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasRutaActionPerformed
        // TODO add your handling code here:
        MenuPrincipal Menu = new MenuPrincipal();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(Menu);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("backS.mp3");
        System.gc();
    }//GEN-LAST:event_AtrasRutaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasRuta;
    private javax.swing.JButton ConsultarPasajeroB;
    private javax.swing.JButton CrearPasajeroB;
    private javax.swing.JButton EditarPasajeroB;
    private javax.swing.JButton EliminarPasajeroB;
    private javax.swing.JLabel TituloRuta;
    // End of variables declaration//GEN-END:variables
    @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondogeneral.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
}
