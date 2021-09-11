package vista;

/*
Se realiza el import de todos los elementos necesarios de otros paquetes como los controladores del servidor,
los elementos para la interfaz grafica y la lectura de imagenes
*/
import java.awt.Graphics;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Pasajero;
import modelo.Reserva;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.pasajeroJpaController;
import static vista.PrincipalFrame.reproducirS;

public class ConsultarPasajeroPanel extends javax.swing.JPanel {

    //Se declaran las variables de la imagen y la lista de pasajeros actual
    private Image imagen;
    private final List <Pasajero> PASAJEROS = pasajeroJpaController.findPasajeroEntities();

    public ConsultarPasajeroPanel() {
        initComponents();
        reservasL.setVisible(false);
        jScrollPane1.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        nombreL = new javax.swing.JLabel();
        idreservaL = new javax.swing.JLabel();
        tipoDeDocumentoL = new javax.swing.JLabel();
        idpasajeroT = new javax.swing.JTextField();
        ConsultarB = new javax.swing.JButton();
        nombreResult = new javax.swing.JLabel();
        tipoDeDocumentoResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        reservasL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservasList = new javax.swing.JTextArea();
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

        ConsultarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ConsultarB.setText("Consultar");
        ConsultarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ConsultarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBActionPerformed(evt);
            }
        });

        nombreResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        tipoDeDocumentoResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar pasajero");

        reservasL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        reservasL.setText("Reservas");

        reservasList.setEditable(false);
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
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idreservaL)
                            .addComponent(nombreL)
                            .addComponent(tipoDeDocumentoL))
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tipoDeDocumentoResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(reservasL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(idpasajeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(ConsultarB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(idreservaL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombreL, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idpasajeroT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConsultarB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nombreResult, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(tipoDeDocumentoL))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(tipoDeDocumentoResult, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reservasL)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void ConsultarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBActionPerformed
        //Se verifica con un ciclo la existencia del pasajero que se busca con ayuda de la variable found
        boolean found = false;
        
        //Se ocualtan las elementos que inicialmente estaban ocultos en caso de que la nueva consulta no tenga elementos
        reservasL.setVisible(false);
        jScrollPane1.setVisible(false);
        
        //Se limpia el TextArea donde se muestran las reservas
        reservasList.setText("");
        
        //Variable auxiliar de reservas del pasajero
        String reservas = "";
        
        //Se recorre la lista de pasajeros actuales de la base de datos
        for(Pasajero p : PASAJEROS){
            
            //En caso de encontrar una coincidencia entonces procede a ejecutar lo siguiente
            if(p.getCedula().toString().equals(idpasajeroT.getText())){
                
                //Muestra la información del pasajero con coincidencia y procede a mostrarla dentro de los respectivos Labels
                nombreResult.setText(p.getNombre());
                tipoDeDocumentoResult.setText(p.getTipoDeDocumento());
                
                //Confirma que encontró el pasajero
                found = true;
                
                //En caso de que el pasajero encontrado contenga reservas a su nombre entonces procede esta condicional
                if(p.getReservaCollection().size() > 0){
                    
                    //Muestra el Label de reservas y su correspondiente TextArea
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
                break;
            }
        }
        
        //En caso de no entontrar coincidencia entonces limpia los Labels, reproduce un sonido y muestra la ventana emergente avisando que no encontro al pasajero
        if(found == false){
            this.Clean();
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No se ha encontrado al pasajero");
        }
    }//GEN-LAST:event_ConsultarBActionPerformed

    //Función para limpiar los Labels del panel
    public void Clean(){
        idpasajeroT.setText("");
        nombreResult.setText("");
        tipoDeDocumentoResult.setText("");
        reservasL.setVisible(false);
        jScrollPane1.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JButton ConsultarB;
    private javax.swing.JPanel Panel;
    private javax.swing.JTextField idpasajeroT;
    private javax.swing.JLabel idreservaL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel nombreResult;
    private javax.swing.JLabel reservasL;
    private javax.swing.JTextArea reservasList;
    private javax.swing.JLabel tipoDeDocumentoL;
    private javax.swing.JLabel tipoDeDocumentoResult;
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
