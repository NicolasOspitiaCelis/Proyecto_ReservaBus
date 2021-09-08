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
public class EditarPasajeroPanel extends javax.swing.JPanel {

    private Image imagen;
    private Pasajero pasajeroP;
    private Pasajero pasajero;
    protected List <Pasajero> pasajeros = pasajeroJpaController.findPasajeroEntities();
    /**
     * Creates new form EditarPasajeroPanel
     */
    public EditarPasajeroPanel() {
        initComponents();
        nombreT.setVisible(false);
        tipoDeDocumentoCB.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        nombreL = new javax.swing.JLabel();
        idreservaL = new javax.swing.JLabel();
        tipoDeDocumentoL = new javax.swing.JLabel();
        idpasajeroT = new javax.swing.JTextField();
        BuscarB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EditarB = new javax.swing.JButton();
        nombreT = new javax.swing.JTextField();
        tipoDeDocumentoCB = new javax.swing.JComboBox<>();
        AtrasB = new javax.swing.JButton();

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));

        nombreL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        nombreL.setText("Nombre");

        idreservaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idreservaL.setText("ID pasajero");

        tipoDeDocumentoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tipoDeDocumentoL.setText("Tipo de documento");

        idpasajeroT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idpasajeroT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BuscarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        BuscarB.setText("Buscar");
        BuscarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BuscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar pasajero");

        EditarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EditarB.setText("Editar");
        EditarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBActionPerformed(evt);
            }
        });

        nombreT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        nombreT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tipoDeDocumentoCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tipoDeDocumentoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de documento", "Cedula de ciudadanía", "Pasaporte extranjero" }));
        tipoDeDocumentoCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idreservaL)
                    .addComponent(tipoDeDocumentoL)
                    .addComponent(nombreL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idpasajeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tipoDeDocumentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(EditarB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpasajeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addComponent(idreservaL)
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDeDocumentoL)
                    .addComponent(tipoDeDocumentoCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(EditarB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        AtrasB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras.png"))); // NOI18N
        AtrasB.setContentAreaFilled(false);
        AtrasB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras_G.png"))); // NOI18N
        AtrasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AtrasB))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBActionPerformed
        // TODO add your handling code here:
        boolean found = false;
        String reservas = "";
        for(Pasajero p : pasajeros){
            if(p.getCedula().toString().equals(idpasajeroT.getText())){
                nombreT.setText(p.getNombre());
                tipoDeDocumentoCB.setSelectedItem(p.getTipoDeDocumento());
                found = true;
                reproducirS("bonkS.mp3");
                pasajeroP = new Pasajero(p.getCedula(), p.getNombre(), p.getTipoDeDocumento());
                if(p.getReservaCollection() != null) pasajeroP.setReservaCollection(p.getReservaCollection());
                nombreT.setVisible(true);
                tipoDeDocumentoCB.setVisible(true);
                break;
            }
        }
        if(found == false){
            this.Clean();
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No se ha encontrado al pasajero");
        }
    }//GEN-LAST:event_BuscarBActionPerformed

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

    private void EditarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBActionPerformed
        // TODO add your handling code here:
        pasajero = new Pasajero(Long.parseLong(idpasajeroT.getText()), nombreT.getText(), tipoDeDocumentoCB.getSelectedItem().toString());
        if(pasajeroP.getReservaCollection() != null) pasajero.setReservaCollection(pasajeroP.getReservaCollection());
        if(pasajero.equals2(pasajeroP)){
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No ha cambiado información de la reservación, realice un cambio.");
        }
        else{
            try {
                pasajeroJpaController.edit(pasajero);
                JOptionPane.showMessageDialog(this, "Se ha editado el pasajero con éxito");
                EditarPasajeroPanel EditarRP = new EditarPasajeroPanel();
                PrincipalPanel.setVisible(false);
                PrincipalPanel.removeAll();
                PrincipalPanel.add(EditarRP);
                PrincipalPanel.setVisible(true);
                this.setBounds(500, 100, 780, 700);
                reproducirS("bonkS.mp3");
                System.gc();
            } catch (Exception ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
            }
        }
    }//GEN-LAST:event_EditarBActionPerformed

    public void Clean(){
        idpasajeroT.setText("");
        nombreT.setText("");
        tipoDeDocumentoCB.setSelectedItem("Seleccione un tipo de documento");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JButton BuscarB;
    private javax.swing.JButton EditarB;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField idpasajeroT;
    private javax.swing.JLabel idreservaL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreL;
    private javax.swing.JTextField nombreT;
    private javax.swing.JComboBox<String> tipoDeDocumentoCB;
    private javax.swing.JLabel tipoDeDocumentoL;
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