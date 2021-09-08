/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Pasajero;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.pasajeroJpaController;
import static vista.PrincipalFrame.reproducirS;

/**
 *
 * @author Nicolas Ospitia
 */
public class CrearPasajeroPanel extends javax.swing.JPanel {

    private Image imagen;
    protected List <Pasajero> pasajeros = pasajeroJpaController.findPasajeroEntities();
    private Pasajero pasajero = new Pasajero();
    /**
     * Creates new form CrearPasajeroPanel
     */
    public CrearPasajeroPanel() {
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

        AtrasB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        CrearPasajeroB = new javax.swing.JButton();
        ReservacionT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idpasajero = new javax.swing.JTextField();
        NombreL = new javax.swing.JLabel();
        TipoDocumentoL = new javax.swing.JLabel();
        nombreT = new javax.swing.JTextField();
        tipoDocumentoCB = new javax.swing.JComboBox<>();

        AtrasB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras.png"))); // NOI18N
        AtrasB.setContentAreaFilled(false);
        AtrasB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras_G.png"))); // NOI18N
        AtrasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        CrearPasajeroB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CrearPasajeroB.setText("Crear");
        CrearPasajeroB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CrearPasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearPasajeroBActionPerformed(evt);
            }
        });

        ReservacionT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ReservacionT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReservacionT.setText("Crear pasajero");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel1.setText("ID pasajero");

        idpasajero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idpasajero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        NombreL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        NombreL.setText("Nombre");

        TipoDocumentoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        TipoDocumentoL.setText("Tipo de documento");

        nombreT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        nombreT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tipoDocumentoCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tipoDocumentoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de documento", "Cedula de ciudadanía", "Pasaporte extranjero" }));
        tipoDocumentoCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tipoDocumentoCB, javax.swing.GroupLayout.Alignment.TRAILING, 0, 243, Short.MAX_VALUE)
                                    .addComponent(nombreT, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idpasajero, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NombreL)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TipoDocumentoL)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(CrearPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idpasajero, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreL)
                    .addComponent(nombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoDocumentoL)
                    .addComponent(tipoDocumentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(CrearPasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBActionPerformed
        // TODO add your handling code here:
        PasajeroPanel PasajeroP = new PasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(PasajeroP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        reproducirS("backS.mp3");
        System.gc();
    }//GEN-LAST:event_AtrasBActionPerformed

    private void CrearPasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPasajeroBActionPerformed
        // TODO add your handling code here:
        boolean repetido = false;
        for(Pasajero p : pasajeros){
            if(idpasajero.getText().equals(String.valueOf(p.getCedula()))) repetido = true;
        }
        if(repetido == false){
            pasajero.setCedula(Long.parseLong(idpasajero.getText()));
            pasajero.setNombre(nombreT.getText());
            pasajero.setTipoDeDocumento(tipoDocumentoCB.getSelectedItem().toString());
            try {
                pasajeroJpaController.create(pasajero);
                JOptionPane.showMessageDialog(this, "Se ha creado el pasajero con exito");
                CrearPasajeroPanel CrearP = new CrearPasajeroPanel();
                PrincipalPanel.setVisible(false);
                PrincipalPanel.removeAll();
                PrincipalPanel.add(CrearP);
                PrincipalPanel.setVisible(true);
                this.setBounds(500,100,780, 700);
                reproducirS("bonkS.mp3");
                System.gc();
            } catch (Exception ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error. "+ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "El ID de pasajero esta repetido, por favor ingrese uno diferente");
        }
    }//GEN-LAST:event_CrearPasajeroBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JButton CrearPasajeroB;
    private javax.swing.JLabel NombreL;
    private javax.swing.JLabel ReservacionT;
    private javax.swing.JLabel TipoDocumentoL;
    private javax.swing.JTextField idpasajero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreT;
    private javax.swing.JComboBox<String> tipoDocumentoCB;
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
