package vista;

/*
Se importan todos los elementos de los paquetes necesarios para la generación de listas, la interacción con la base de datos,
lectura de imagenes y ejecucción de ventanas emergentes
*/
import java.awt.Graphics;
import java.awt.Image;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Reserva;
import static vista.CrearReservaPanel.convertirFecha;
import static vista.PrincipalFrame.reservaJpaController;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.reproducirS;

public class ConsultarReservaPanel extends javax.swing.JPanel {

    //Se declara la variable que almacena la imagen del fondo del panel
    private Image imagen;
    
    //Se instancia la lista de todas las reservas disponibles dentro del servidor
    protected List <Reserva> reservas = reservaJpaController.findReservaEntities();

    //Se inician los componentes de la interfaz grafica
    public ConsultarReservaPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        pasajeroCedulaL = new javax.swing.JLabel();
        idreservaL = new javax.swing.JLabel();
        tipoDePagoL = new javax.swing.JLabel();
        ciudadOrigenL = new javax.swing.JLabel();
        ciudadDestinoL = new javax.swing.JLabel();
        fechaViajeL = new javax.swing.JLabel();
        horaViajeL = new javax.swing.JLabel();
        autobusidautobusL = new javax.swing.JLabel();
        puestoL = new javax.swing.JLabel();
        precioL = new javax.swing.JLabel();
        idrutaL = new javax.swing.JLabel();
        idreservaB = new javax.swing.JTextField();
        ConsultarB = new javax.swing.JButton();
        cedulaResult = new javax.swing.JLabel();
        origenResult = new javax.swing.JLabel();
        destinoResult = new javax.swing.JLabel();
        fechaResult = new javax.swing.JLabel();
        horaResult = new javax.swing.JLabel();
        puestoResult = new javax.swing.JLabel();
        precioResult = new javax.swing.JLabel();
        autobusResult = new javax.swing.JLabel();
        rutaResult = new javax.swing.JLabel();
        pagoResult = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        AtrasB = new javax.swing.JButton();

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setForeground(new java.awt.Color(255, 255, 255));

        pasajeroCedulaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        pasajeroCedulaL.setText("Cedula pasajero");

        idreservaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idreservaL.setText("ID reserva");

        tipoDePagoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        tipoDePagoL.setText("Tipo de pago");

        ciudadOrigenL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ciudadOrigenL.setText("Ciudad origen");

        ciudadDestinoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ciudadDestinoL.setText("Ciudad destino");

        fechaViajeL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        fechaViajeL.setText("Fecha de viaje");

        horaViajeL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        horaViajeL.setText("Hora de viaje");

        autobusidautobusL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        autobusidautobusL.setText("ID Autobus");

        puestoL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        puestoL.setText("Puesto");

        precioL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        precioL.setText("Precio");

        idrutaL.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idrutaL.setText("ID Ruta");

        idreservaB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        ConsultarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ConsultarB.setText("Consultar");
        ConsultarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ConsultarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarBActionPerformed(evt);
            }
        });

        cedulaResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        origenResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        destinoResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        fechaResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        horaResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        puestoResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        precioResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        autobusResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        rutaResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        pagoResult.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Consultar reserva");

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
                            .addComponent(ciudadOrigenL)
                            .addComponent(ciudadDestinoL)
                            .addComponent(fechaViajeL)
                            .addComponent(horaViajeL)
                            .addComponent(puestoL)
                            .addComponent(precioL)
                            .addComponent(autobusidautobusL)
                            .addComponent(idrutaL))
                        .addGap(18, 18, 18)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(autobusResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cedulaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(idreservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(ConsultarB, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pagoResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(origenResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinoResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(puestoResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(precioResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rutaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1)))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(idreservaL)
                                                    .addComponent(ConsultarB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(17, 17, 17))
                                            .addGroup(PanelLayout.createSequentialGroup()
                                                .addComponent(idreservaB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                            .addComponent(pasajeroCedulaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                            .addComponent(cedulaResult, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(pagoResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(tipoDePagoL))
                                                                        .addGap(18, 18, 18)
                                                                        .addComponent(ciudadOrigenL))
                                                                    .addComponent(origenResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(ciudadDestinoL))
                                                            .addComponent(destinoResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(18, 18, 18)
                                                        .addComponent(fechaViajeL))
                                                    .addComponent(fechaResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(horaViajeL))
                                            .addComponent(horaResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(puestoL))
                                    .addComponent(puestoResult, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(precioL))
                            .addComponent(precioResult, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(autobusidautobusL))
                    .addComponent(autobusResult, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(idrutaL)
                    .addComponent(rutaResult, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB)
                .addGap(82, 82, 82)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(535, 535, 535))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBActionPerformed
        //La acción a ejecutar por el boton de regresar, el cual ejecuta el procedimiento de eliminación e inserción de un nuevo panel
        ReservaPanel ReservaP = new ReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ReservaP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("backS.mp3");
        System.gc();
    }//GEN-LAST:event_AtrasBActionPerformed

    private void ConsultarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarBActionPerformed
        //Se declara una variable boolean para identificar si se encontró la reserva o no
        boolean found = false;
        
        //Luego se recorre todas las reservas para identificar la coincidencia con el codigo de reserva que se ingresó
        for(Reserva r : reservas){
            
            //Condición de coincidencia
            if(r.getReservaPK().getIdreserva().equals(idreservaB.getText())){
                
                //Se muestran todos los datos encontrados de dicha reserva en sus respectivos Labels
                cedulaResult.setText(String.valueOf(r.getReservaPK().getPasajeroCedula()));
                pagoResult.setText(r.getTipoDePago());
                origenResult.setText(r.getReservaPK().getCiudadOrigen());
                destinoResult.setText(r.getReservaPK().getCiudadDestino());
                try {
                    fechaResult.setText(convertirFecha(r.getFechaViaje().toString()));
                } catch (ParseException ex) {
                    Logger.getLogger(ConsultarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                horaResult.setText(r.getHoraSalida().toString().substring(11,16));
                puestoResult.setText(String.valueOf(r.getPuesto()));
                precioResult.setText(String.valueOf(r.getPrecio()));
                autobusResult.setText(String.valueOf(r.getReservaPK().getAutobusidautobus()));
                rutaResult.setText(String.valueOf(r.getReservaPK().getIdrutas()));
                
                //Se cambia el valor de la variable debido a que se encontró una coincidencia
                found = true;
                
                //Se reproduce un sonido
                reproducirS("bonkS.mp3");
                
                //Se sale del ciclo para evitar gastar tiempo innecesariamente
                break;
            }
        }
        
        //En caso de no encontrar coincidencia entonces recurre a limpiar los Labels, reproduce un sonido y finalmente muestra una ventana avisando que no encontró dicha reservación
        if(found == false){
            this.Clean();
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No se ha encontrado la reservación");
        }
    }//GEN-LAST:event_ConsultarBActionPerformed

    //Función para limpiar todos los Labels dentro de este panel
    public void Clean(){
        cedulaResult.setText("");
        pagoResult.setText("");
        origenResult.setText("");
        destinoResult.setText("");
        fechaResult.setText("");
        horaResult.setText("");
        puestoResult.setText("");
        precioResult.setText("");
        autobusResult.setText("");
        rutaResult.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JButton ConsultarB;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel autobusResult;
    private javax.swing.JLabel autobusidautobusL;
    private javax.swing.JLabel cedulaResult;
    private javax.swing.JLabel ciudadDestinoL;
    private javax.swing.JLabel ciudadOrigenL;
    private javax.swing.JLabel destinoResult;
    private javax.swing.JLabel fechaResult;
    private javax.swing.JLabel fechaViajeL;
    private javax.swing.JLabel horaResult;
    private javax.swing.JLabel horaViajeL;
    private javax.swing.JTextField idreservaB;
    private javax.swing.JLabel idreservaL;
    private javax.swing.JLabel idrutaL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel origenResult;
    private javax.swing.JLabel pagoResult;
    private javax.swing.JLabel pasajeroCedulaL;
    private javax.swing.JLabel precioL;
    private javax.swing.JLabel precioResult;
    private javax.swing.JLabel puestoL;
    private javax.swing.JLabel puestoResult;
    private javax.swing.JLabel rutaResult;
    private javax.swing.JLabel tipoDePagoL;
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
