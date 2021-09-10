package vista;

/*
Se realiza el import de todos los elementos necesarios de otros paquetes como los controladores del servidor,
los elementos para la interfaz grafica y la lectura de imagenes
*/
import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Equipaje;
import modelo.Pasajero;
import modelo.Reserva;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.equipajeJpaController;
import static vista.PrincipalFrame.pasajeroJpaController;
import static vista.PrincipalFrame.reproducirS;
import static vista.PrincipalFrame.reservaJpaController;

public class EliminarPasajeroPanel extends javax.swing.JPanel {

    //Se declaran las variables de la imagen, la lista de pasajeros actual y un pasajero auxiliar
    private Image imagen;
    private Pasajero pasajero;
    protected List <Pasajero> pasajeros = pasajeroJpaController.findPasajeroEntities();

    public EliminarPasajeroPanel() {
        initComponents();
        
        //Se oculta el Label de reservas, el TextArea y el boton de Eliminar
        reservasL.setVisible(false);
        jScrollPane1.setVisible(false);
        EliminarB.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        pasajeroCedulaL = new javax.swing.JLabel();
        idreservaL = new javax.swing.JLabel();
        tipoDePagoL = new javax.swing.JLabel();
        reservasL = new javax.swing.JLabel();
        idpasajeroT = new javax.swing.JTextField();
        BuscarB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        EliminarB = new javax.swing.JButton();
        NombreT = new javax.swing.JLabel();
        tipoDocumentoT = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservasList = new javax.swing.JTextArea();
        AtrasB = new javax.swing.JButton();

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));

        pasajeroCedulaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        pasajeroCedulaL.setText("Nombre");

        idreservaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idreservaL.setText("ID pasajero");

        tipoDePagoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tipoDePagoL.setText("Tipo de documento");

        reservasL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        reservasL.setText("Reservas");

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
        jLabel1.setText("Eliminar pasajero");

        EliminarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EliminarB.setText("Eliminar");
        EliminarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarBActionPerformed(evt);
            }
        });

        NombreT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        tipoDocumentoT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        reservasList.setColumns(15);
        reservasList.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        reservasList.setRows(5);
        reservasList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(reservasList);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idreservaL)
                            .addComponent(pasajeroCedulaL)
                            .addComponent(tipoDePagoL)
                            .addComponent(reservasL))
                        .addGap(34, 34, 34)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NombreT)
                            .addComponent(tipoDocumentoT)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(idpasajeroT, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(EliminarB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idreservaL)
                            .addComponent(idpasajeroT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addComponent(pasajeroCedulaL, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NombreT))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDePagoL)
                    .addComponent(tipoDocumentoT))
                .addGap(22, 22, 22)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reservasL)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(EliminarB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBActionPerformed
        //Se verifica con un ciclo la existencia del pasajero que se busca con ayuda de la variable found
        boolean found = false;
        
        //Variable auxiliar de reservas del pasajero
        String reservas = "";
        
        //Se recorre la lista de pasajeros actuales de la base de datos
        for(Pasajero p : pasajeros){
            
            //En caso de encontrar una coincidencia entonces procede a ejecutar lo siguiente
            if(p.getCedula().toString().equals(idpasajeroT.getText())){
                
                //Muestra la información del pasajero con coincidencia y procede a mostrarla dentro de los respectivos Labels
                NombreT.setText(p.getNombre());
                tipoDocumentoT.setText(p.getTipoDeDocumento());
                
                //Confirma que encontró el pasajero
                found = true;
                
                //Se inicializa el pasajero auxiliar con la información obtenida de la interfaz grafica
                pasajero = new Pasajero(Long.parseLong(idpasajeroT.getText()), p.getNombre(), p.getTipoDeDocumento());
                
                //En caso de que el pasajero encontrado contenga reservas a su nombre entonces procede esta condicional
                if(p.getReservaCollection() != null){
                    
                    //Muestra el Label de reservas y su correspondiente TextArea
                    pasajero.setReservaCollection(p.getReservaCollection());
                    reservasL.setVisible(true);
                    jScrollPane1.setVisible(true);
                    
                    //Recorre todas las reservas que tiene dicho pasajero y guarda sus id de reserva dentro de la variable reservas
                    for(Reserva r : p.getReservaCollection()){
                        reservas += r.getReservaPK().getIdreserva() + "\n";
                    }
                    
                    //Luego inserta esta información de reservas dentro del TextArea correspondiente a las reservas
                    reservasList.setText(reservas);
                }
                
                //Reproduce un sonido y sale del ciclo
                reproducirS("bonkS.mp3");
                
                //Se muestra el botón de Eliminar
                EliminarB.setVisible(true);
                
                //Se sale del ciclo
                break;
            }
        }
        
        //En caso de no entontrar coincidencia entonces limpia los Labels, reproduce un sonido y muestra la ventana emergente avisando que no encontro al pasajero
        if(found == false){
            this.Clean();
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No se ha encontrado al pasajero");
        }
    }//GEN-LAST:event_BuscarBActionPerformed

    private void EliminarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarBActionPerformed
        //Cuando se ejecuta la función de eliminar pasajero se procede con lo siguiente
        try {
            
            //Primero se verifica si el pasajero en cuestion posee reservaciones a su nombre ya que sin eliminar estas antes entonces genera un error
            //En caso de poseer reservas entonces se procede a eliminar las reservas
            if(pasajero.getReservaCollection() != null) eliminarReservas(pasajero);
            
            //Elimina el pasajero ingresado
            pasajeroJpaController.destroy(Long.parseLong(idpasajeroT.getText()));
            
            //En caso de todo ir correctamente entonces muestra una ventana emergente confirmando la acción
            JOptionPane.showMessageDialog(this, "Se ha eliminado la reserva con éxito");
            
            //Inicializa de nuevo el panel para limpiarlo y actualizar toda la información
            EliminarPasajeroPanel EliminarP = new EliminarPasajeroPanel();
            PrincipalPanel.setVisible(false);
            PrincipalPanel.removeAll();
            PrincipalPanel.add(EliminarP);
            PrincipalPanel.setVisible(true);
            
            //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
            reproducirS("bonkS.mp3");
            System.gc();
            
        //En caso de arrojar algun error entonces lo muestra a traves de una ventana emergente y reproduce un sonido
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(EliminarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "Se ha producido un error: " + ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(EliminarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "La reserva que desea eliminar no existe.");
        }
    }//GEN-LAST:event_EliminarBActionPerformed

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

    //La función de eliminar reservas toma al pasajero y recorre todos las reservas que contiene, para eliminarlas y verificar a su vez si tienen equipajes relacionados
    public void eliminarReservas(Pasajero pasajero) {
        
        //Se recorren todas las reservas del pasajero
        for (Reserva reserva : pasajero.getReservaCollection()) {
            
            //Se verifica si la reserva contiene algún equipaje relacionado y procede a eliminarlo en ese caso
            if(reserva.getEquipajeCollection() != null) eliminarEquipaje(reserva);
            
            //Una vez que se eliminen todos los equipajes si existen, entonces procede a eliminar las reservas
            try {
                reservaJpaController.destroy(reserva.getReservaPK());
                
            //En caso de encontrar algun error lo muestra en una ventana emergente
            } catch (IllegalOrphanException ex) {
                Logger.getLogger(EliminarPasajeroPanel.class.getName()).log(Level.SEVERE, null, ex);
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "Se ha producido un error: " + ex);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(EliminarPasajeroPanel.class.getName()).log(Level.SEVERE, null, ex);
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "Se ha producido un error: " + ex);
            }
        }

    }
    
    //Esta función permite la eliminación del equipaje asociado a la reserva de entrada
    public void eliminarEquipaje(Reserva reserva){
        
        //Se recorren todos los equipajes que tiene dicha reserva
        for(Equipaje equipaje : reserva.getEquipajeCollection()){
            
            //Se procede a ejecutar la eliminación con el controlador del equipaje
            try {
                equipajeJpaController.destroy(equipaje.getEquipajePK());
            
            //En caso de encontrar algun error lo muestra en una ventana emergente
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(EliminarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //Se limpian los elementos dentro de la interfaz grafica y pone invisibles los elementos Label de reservas, TextArea de reservas y el botón de Eliminar
    public void Clean(){
        idpasajeroT.setText("");
        NombreT.setText("");
        tipoDocumentoT.setText("");
        reservasL.setVisible(false);
        jScrollPane1.setVisible(false);
        EliminarB.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JButton BuscarB;
    private javax.swing.JButton EliminarB;
    private javax.swing.JLabel NombreT;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField idpasajeroT;
    private javax.swing.JLabel idreservaL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel pasajeroCedulaL;
    private javax.swing.JLabel reservasL;
    private javax.swing.JTextArea reservasList;
    private javax.swing.JLabel tipoDePagoL;
    private javax.swing.JLabel tipoDocumentoT;
    // End of variables declaration//GEN-END:variables
    //Se tiene un override de la función paint para que esta dibuje en el fondo la imagen dentro de la dirección especificada
    @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondogeneral.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
}
