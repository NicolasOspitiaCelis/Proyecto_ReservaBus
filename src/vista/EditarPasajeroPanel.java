package vista;

/*
Se realiza el import de todos los elementos necesarios de otros paquetes como los controladores del servidor,
los elementos para la interfaz grafica y la lectura de imagenes
*/
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

public class EditarPasajeroPanel extends javax.swing.JPanel {

    //Se declaran variables para guardar la imagen de fondo, un pasajero auxiliar, un pasajero principal y una lista de pasajeros actual
    private Image imagen;
    private Pasajero pasajeroP;
    private Pasajero pasajero;
    protected List <Pasajero> pasajeros = pasajeroJpaController.findPasajeroEntities();

    public EditarPasajeroPanel() {
        initComponents();
        
        //Se esconden el TExtFiel del nombre, el ComboBox de los tipos de documentos y el botón de Editar
        nombreT.setVisible(false);
        tipoDeDocumentoCB.setVisible(false);
        EditarB.setVisible(false);
    }

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
                .addContainerGap()
                .addComponent(AtrasB)
                .addContainerGap(697, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(252, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBActionPerformed
        //Presionado el botón de buscar se verifica la existencia del id de pasajero ingresado con ayuda de found y el ciclo for
        boolean found = false;
        for(Pasajero p : pasajeros){
            
            //Se verifica si algún pasajero coincide con el valor ingresado en la interfaz
            if(p.getCedula().toString().equals(idpasajeroT.getText())){
                
                //Al encontrar una coincidencia procede a asignar los valores del pasajero en el TextField y ComboBox del panel
                nombreT.setText(p.getNombre());
                tipoDeDocumentoCB.setSelectedItem(p.getTipoDeDocumento());
                
                //Se confirma que se encontró
                found = true;
                
                //Se reproduce un sonido
                reproducirS("bonkS.mp3");
                
                //Se inicializa el pasajero auxiliar con los valores que se traen del pasajero del ciclo
                pasajeroP = new Pasajero(p.getCedula(), p.getNombre(), p.getTipoDeDocumento());
                
                //En caso de que el pasajero tenga reservas asignadas entonces procede a llevarlas al pasajero auxiliar
                if(p.getReservaCollection() != null) pasajeroP.setReservaCollection(p.getReservaCollection());
                
                //Muestra los elementos que estaban escondidos
                nombreT.setVisible(true);
                tipoDeDocumentoCB.setVisible(true);
                EditarB.setVisible(true);
                
                //Se sale del ciclo al encontrar una coincidencia
                break;
            }
        }
        
        //En caso de no encontrar alguna coincidencia entonces reproduce un sonido y muestra la ventana emergente avisandolo
        if(found == false){
            this.Clean();
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No se ha encontrado al pasajero");
        }
    }//GEN-LAST:event_BuscarBActionPerformed

    private void AtrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBActionPerformed
        //La acción a ejecutar por el boton de regresar, el cual ejecuta el procedimiento de eliminación e inserción de un nuevo panel
        PasajeroPanel PasajeroP = new PasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(PasajeroP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("backS.mp3");
        System.gc();
    }//GEN-LAST:event_AtrasBActionPerformed

    private void EditarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBActionPerformed
        //Una vez se presiona el botón de editar se corrobora primero que el pasajer auxiliar y el pasajero principal no sean iguales
        //Pero primero se inicializa el pasajero principal
        pasajero = new Pasajero(Long.parseLong(idpasajeroT.getText()), nombreT.getText(), tipoDeDocumentoCB.getSelectedItem().toString());
        
        //Luego se verifica si el pasajero auxiliar tiene reservas asociadas, en ese caso se pasan las reservas al pasajero principal
        if(pasajeroP.getReservaCollection() != null) pasajero.setReservaCollection(pasajeroP.getReservaCollection());
        
        //Seguido se verifica que el pasajero principal y el auxiliar sean diferentes
        if(pasajero.equals2(pasajeroP)){
            
            //En caso de ser iguales reproduce un sonido y muestra la ventana emergente avisando que se debe cambiar algun valor
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No ha cambiado información del pasajero, realice un cambio.");
        }
        
        //En caso de que no sean iguales procede a editar el pasajero
        else{
            
            //Se toma el controlador de pasajero y se ejecuta la función de edit del pasajero principal
            try {
                pasajeroJpaController.edit(pasajero);
                
                //En caso de todo ir correctamente entonces muestra una ventana emergente confirmando la acción
                JOptionPane.showMessageDialog(this, "Se ha editado el pasajero con éxito");
                
                //Inicializa de nuevo el panel para limpiarlo y actualizar toda la información
                EditarPasajeroPanel EditarRP = new EditarPasajeroPanel();
                PrincipalPanel.setVisible(false);
                PrincipalPanel.removeAll();
                PrincipalPanel.add(EditarRP);
                PrincipalPanel.setVisible(true);
                
                //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
                reproducirS("bonkS.mp3");
                System.gc();
                
            //En caso de no poder ejecutar el edit entonces reproduce un sonido y muestra una ventana emergente con el error
            } catch (Exception ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
            }
        }
    }//GEN-LAST:event_EditarBActionPerformed

    //Función para limpiar todos los elementos dentro de la interfaz grafica
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
