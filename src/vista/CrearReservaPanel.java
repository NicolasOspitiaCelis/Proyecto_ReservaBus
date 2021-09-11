package vista;

import controlador.exceptions.NoSpaceEntityException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.util.Date;
import modelo.Autobus;
import modelo.Reserva;
import modelo.ReservaPK;
import modelo.Rutas;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.autobusJpaController;
import static vista.PrincipalFrame.reproducirS;
import static vista.PrincipalFrame.reservaJpaController;
import static vista.PrincipalFrame.rutasJpaController;
import static vista.PrincipalFrame.pasajeroJpaController;

public class CrearReservaPanel extends javax.swing.JPanel {

    private Image imagen;
    private List <String> t = new ArrayList();
    private Reserva reserva = new Reserva();
    private ReservaPK reservaPK = new ReservaPK();
    private ArrayList <Date> fechas;
    private ArrayList <Date> fechasNoRep;
    private ArrayList <Date> horas;
    private ArrayList <Date> horasNoRep;
    private final List <Rutas> RUTAS = rutasJpaController.findRutasEntities();
    private final List <Autobus> AUTOBUSES = autobusJpaController.findAutobusEntities();
    private final List <Reserva> RESERVAS = reservaJpaController.findReservaEntities();

    public CrearReservaPanel() {
        initComponents();
        for (Rutas r : RUTAS){
            t.add(r.getCiudad().getNombreCiudad());
        }
        List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
        for (String s : noRep){
            this.CiudadOrigenCB.addItem(s);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        AtrasB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idreserva = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CiudadOrigenCB = new javax.swing.JComboBox<>();
        CiudadDestinoCB = new javax.swing.JComboBox<>();
        FechaViajeCB = new javax.swing.JComboBox<>();
        HoraViajeCB = new javax.swing.JComboBox<>();
        HacerReservaB = new javax.swing.JButton();
        TipoDePagoCB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        AutobusCB = new javax.swing.JComboBox<>();
        ReservacionT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pasajeroCedula = new javax.swing.JTextField();

        jLabel9.setText("jLabel9");

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

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel2.setText("ID reserva");

        idreserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        idreserva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel3.setText("Tipo de pago");

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel4.setText("Ciudad origen");

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel5.setText("Ciudad destino");

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel6.setText("Fecha de viaje");

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel7.setText("Hora de viaje");

        CiudadOrigenCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CiudadOrigenCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una ciudad de origen" }));
        CiudadOrigenCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CiudadOrigenCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CiudadOrigenCBItemStateChanged(evt);
            }
        });

        CiudadDestinoCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CiudadDestinoCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CiudadDestinoCB.setEnabled(false);
        CiudadDestinoCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CiudadDestinoCBItemStateChanged(evt);
            }
        });

        FechaViajeCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        FechaViajeCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        FechaViajeCB.setEnabled(false);
        FechaViajeCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FechaViajeCBItemStateChanged(evt);
            }
        });

        HoraViajeCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        HoraViajeCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HoraViajeCB.setEnabled(false);
        HoraViajeCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HoraViajeCBItemStateChanged(evt);
            }
        });

        HacerReservaB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        HacerReservaB.setText("Reservar");
        HacerReservaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HacerReservaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HacerReservaBActionPerformed(evt);
            }
        });

        TipoDePagoCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        TipoDePagoCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un metodo de pago", "Efectivo", "Tarjeta débito", "Tarjeta crédito", "Transacción online" }));
        TipoDePagoCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TipoDePagoCB.setEditor(null);
        TipoDePagoCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TipoDePagoCBItemStateChanged(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel8.setText("ID Autobus");

        AutobusCB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        AutobusCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        AutobusCB.setEnabled(false);
        AutobusCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                AutobusCBItemStateChanged(evt);
            }
        });

        ReservacionT.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        ReservacionT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ReservacionT.setText("Crear reserva");

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel1.setText("Cedula pasajero");

        pasajeroCedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        pasajeroCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CiudadOrigenCB, 0, 270, Short.MAX_VALUE)
                            .addComponent(CiudadDestinoCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FechaViajeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(HoraViajeCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TipoDePagoCB, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AutobusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(HacerReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(71, 71, 71)
                        .addComponent(idreserva))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(pasajeroCedula)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pasajeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(TipoDePagoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(CiudadOrigenCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(CiudadDestinoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(FechaViajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(HoraViajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(AutobusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(HacerReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB)
                .addGap(102, 102, 102)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
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

    private void CiudadOrigenCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CiudadOrigenCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox deCiudadOrigen
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(CiudadOrigenCB.getSelectedIndex()>0){
                
                //Luego se limpia la lista auxiliar
                t.clear();
                
                //Siempre se agrega como primer elemento "Seleccione una ciudad de destino" al ComboBox de CiudadDestino una vez que se cambia de estado este ComboBox
                this.CiudadDestinoCB.addItem("Seleccione una ciudad de destino");
                
                //Luego se guarda ese valor de CiudadOrigen seleccionado
                reservaPK.setCiudadOrigen(CiudadOrigenCB.getSelectedItem().toString());
                
                //Seguidamente se recorren todas las rutas de la base de datos y se almacenan todos los elementos que coincidad con una CiudadOrigen igual a la seleccionada
                for (Rutas r : RUTAS){
                    if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()))
                        t.add(r.getRutasPK().getCiudadDestino());
                }
                
                //Luego se organizan todos los elementos dentro de t eliminando los repetidos
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                
                //Luego se agregan todos los elementos de noRep dentro del ComboBox de CiudadDestino
                for (String s : noRep){
                    this.CiudadDestinoCB.addItem(s);
                }
                
                //Se habilita el acceso a el ComboBox de CiudadDestino
                CiudadDestinoCB.setEnabled(true);
            }
        }
        
        //En caso de que el elemento seleccionado sea el primer elemento de este ComboBox entonces inhabilita el ComboBox de CiudadDestino y elimina todos sus elementos
        else{
            CiudadDestinoCB.setEnabled(false);
            this.CiudadDestinoCB.removeAllItems();
        }
    }//GEN-LAST:event_CiudadOrigenCBItemStateChanged

    private void CiudadDestinoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CiudadDestinoCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox de CiudadDestino
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(CiudadDestinoCB.getSelectedIndex()>0){
                
                //Luego se limpia la lista auxiliar
                t.clear();
                
                //Se inicializa o limpia la lista de fechas
                fechas = new ArrayList <Date>();
                
                //Siempre se agrega como primer elemento "Seleccione una fecha de viaje" al ComboBox de FechaViaje una vez que se cambia de estado este ComboBox
                this.FechaViajeCB.addItem("Seleccione una fecha de viaje");
                
                //Luego se guarda ese valor de CiudadDestino seleccionado
                reservaPK.setCiudadDestino(CiudadDestinoCB.getSelectedItem().toString());
                
                //Seguidamente se recorren todas las rutas de la base de datos y se almacenan todos los elementos que coincidad con una CiudadOrigen y CiudadDestino igual a la seleccionadas
                for (Rutas r : RUTAS){
                    if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()))
                        try {
                            
                            //Se almacenan todos los elementos dentro de fechas para poder guardarlos dentro de la variables Reservas
                            fechas.add(r.getFechaViaje());
                            //Se ejecuta la funcion convertirFecha para mostrar en String la información obtenida
                            t.add(convertirFecha(r.getFechaViaje().toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                //Luego se eliminan los repetidos en las listas de fechas y t
                fechasNoRep = new ArrayList(new LinkedHashSet<Date>(fechas));
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                
                //Se agrega los elementos de noRep al ComboBox de FechaViaje
                for (String s : noRep){
                    this.FechaViajeCB.addItem(s);
                }
                
                //Se habilita el acceso al ComboBox de FechaViaje
                FechaViajeCB.setEnabled(true);
            }
        }
        
        //En caso de que el elemento seleccionado sea el primer elemento de este ComboBox entonces inhabilita el ComboBox de FechaViaje y elimina todos sus elementos
        else{
            FechaViajeCB.setEnabled(false);
            this.FechaViajeCB.removeAllItems();
        }
    }//GEN-LAST:event_CiudadDestinoCBItemStateChanged

    private void FechaViajeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FechaViajeCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox de FechaViaje
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(FechaViajeCB.getSelectedIndex()>0){
                
                //Luego se limpia la lista auxiliar
                t.clear();
                
                //Se inicializa o limpia la lista de horas
                horas = new ArrayList <Date>();
                
                //Siempre se agrega como primer elemento "Seleccione una hora de viaje" al ComboBox de HoraViaje una vez que se cambia de estado este ComboBox
                this.HoraViajeCB.addItem("Seleccione una hora de viaje");
                
                //Luego se guarda ese valor de FechaViaje seleccionado
                reserva.setFechaViaje(fechasNoRep.get(FechaViajeCB.getSelectedIndex()-1));
                
                /*
                Seguidamente se recorren todas las rutas de la base de datos y se almacenan todos los elementos que coincidad con una CiudadOrigen,
                CiudadDestino y FechaViaje igual a la seleccionadas
                */
                for (Rutas r : RUTAS){
                    try { 
                        if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()) && convertirFecha(r.getFechaViaje().toString()).equals(convertirFecha(reserva.getFechaViaje().toString()))){
                            
                            //Se almacenan todos los elementos dentro de horas para poder guardarlos dentro de la variables Reservas
                            horas.add(r.getHoraViaje());
                            t.add(r.getHoraViaje().toString().substring(11,16));
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                //Luego se eliminan los repetidos en las listas de horas y t
                horasNoRep = new ArrayList(new LinkedHashSet<Date>(horas));
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                
                //Se agregan todos los elementos de noRep al ComboBox HoraViaje
                for (String s : noRep){
                    this.HoraViajeCB.addItem(s);
                }
                
                //Se habilita el acceso al ComboBox HoraViaje
                HoraViajeCB.setEnabled(true);
            }
        }
        
        //En caso de que el elemento seleccionado sea el primer elemento de este ComboBox entonces inhabilita el ComboBox de HoraViaje y elimina todos sus elementos
        else{
            HoraViajeCB.setEnabled(false);
            this.HoraViajeCB.removeAllItems();
        }
    }//GEN-LAST:event_FechaViajeCBItemStateChanged

    private void HacerReservaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerReservaBActionPerformed
        //Primero se verifica si el id de reserva ingresado no esta repetido, esto con la variable repetido
        boolean repetido = false;
        
        //Luego se recorren todas las reservas buscando si existe coincidencia
        for(Reserva r : RESERVAS){
            
            //En caso de encontrar una coincidencia entonces cambia el estado de repetido, reproduce un sonido y muestra una ventana emergente dando el aviso
            if(idreserva.getText().equals(r.getReservaPK().getIdreserva())){
                repetido = true;
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "El ID de reserva esta repetido, por favor ingrese uno diferente");
                
                //Finalmente se sale del ciclo
                break;
            }
        }
        
        //En caso de no encontrar repetido entonces procede a crear la reesrva
        if(repetido == false){
            
            //Primero toma todos los componentes de la interfaz grafica que no se asignaron desde algún ComboBox y los asigna a las correspondientes variables dentro de la reserva auxiliar
            reservaPK.setPasajeroCedula(Long.parseLong(pasajeroCedula.getText()));
            reservaPK.setIdreserva(idreserva.getText());
            reserva.setReservaPK(reservaPK);
            
            //Con esta función se detecta el precio de la ruta asignada a la reservación y el id de la ruta y se asignan a la reserva
            reserva.setPrecioAndIdruta(RUTAS);
            
            try {
                //esta función permite ubicar un puesto disponible a la reserva entre los puesto no utilizados de una ruta
                reserva.setPuesto(RESERVAS, AUTOBUSES);
            } catch (NoSpaceEntityException ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            reserva.setPasajero(pasajeroJpaController.findPasajero(Long.parseLong(pasajeroCedula.getText())));
            try {
                
                //Se ejecuta la función del controlador de reservas para crear una nueva reserva
                reservaJpaController.create(reserva);
                
                //En caso de todo ir correctamente entonces muestra una ventana emergente confirmando la acción
                JOptionPane.showMessageDialog(this, "Se ha creado la reserva con exito");
                
                //Inicializa de nuevo el panel para limpiarlo y actualizar toda la información
                CrearReservaPanel ReservaP = new CrearReservaPanel();
                PrincipalPanel.setVisible(false);
                PrincipalPanel.removeAll();
                PrincipalPanel.add(ReservaP);
                PrincipalPanel.setVisible(true);
                
                //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
                reproducirS("bonkS.mp3");
                System.gc();
                
                //En caso de no poder ejecutar el edit entonces reproduce un sonido y muestra una ventana emergente con el error
            } catch (Exception ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                reproducirS("errorS.mp3");
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error. "+ex);
            }
        }
    }//GEN-LAST:event_HacerReservaBActionPerformed

    private void HoraViajeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraViajeCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox de HoraViaje
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(HoraViajeCB.getSelectedIndex()>0){
                
                //Luego se limpia la lista auxiliar
                t.clear();
                
                //Siempre se agrega como primer elemento "Seleccione un autobus" al ComboBox de Autobus una vez que se cambia de estado este ComboBox
                this.AutobusCB.addItem("Seleccione un autobus");
                
                //Luego se guarda ese valor de FechaViaje seleccionado
                reserva.setHoraSalida(horasNoRep.get(HoraViajeCB.getSelectedIndex()-1));
                
                /*
                Seguidamente se recorren todas las rutas de la base de datos y se almacenan todos los elementos que coincidad con una CiudadOrigen,
                CiudadDestino, FechaViaje y HoraViaje igual a la seleccionadas
                */
                for (Rutas r : RUTAS){
                    try {
                        if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()) && convertirFecha(r.getFechaViaje().toString()).equals(convertirFecha(reserva.getFechaViaje().toString())) && r.getHoraViaje().toString().substring(11,16).equals(reserva.getHoraSalida().toString().substring(11,16)))
                            t.add(r.getAutobus().getIdautobus().toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
                //Se agregan todos los elementos de noRep al ComboBox Autobus
                for (String s : t){
                    this.AutobusCB.addItem(s);
                }
                
                //Se habilita el acceso al ComboBox Autobus
                AutobusCB.setEnabled(true);
            }
        }
        
        //En caso de que el elemento seleccionado sea el primer elemento de este ComboBox entonces inhabilita el ComboBox de Autobus y elimina todos sus elementos
        else{
            AutobusCB.setEnabled(false);
            this.AutobusCB.removeAllItems();
        }
    }//GEN-LAST:event_HoraViajeCBItemStateChanged

    private void AutobusCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AutobusCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox de Autobus
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(AutobusCB.getSelectedIndex()>0){
                
                //Simplemente se guarda ese valor de Autobus seleccionado
                reservaPK.setAutobusidautobus(Integer.parseInt(AutobusCB.getSelectedItem().toString()));
            }
        }
    }//GEN-LAST:event_AutobusCBItemStateChanged

    private void TipoDePagoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoDePagoCBItemStateChanged
        //Función que se ejecuta cuando se cambia el valor del ComboBox de TipoDePago
        //Primero se detecta si la selección fue a un elemento diferente al primero del ComboBox
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(TipoDePagoCB.getSelectedIndex()>0){
                
                //Simplemente se guarda ese valor de TipoDePago seleccionado
                reserva.setTipoDePago(TipoDePagoCB.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_TipoDePagoCBItemStateChanged

    //Esta función permite convertir un string con un formato de fecha a un formato fecha más facil de interpretar
    public static String convertirFecha(String fecha) throws ParseException{
        
        //Primero se declaran los valores que obtendrán cada variable string de la fecha
        String day = fecha.substring(8,10);
        String month = fecha.substring(4,7);
        String year = fecha.substring(fecha.length()-4, fecha.length());
        
        //Luego se evalua en nombre del mes que se tiene de la fecha para cambiarlo a un numero
        if(month.equals("Jan")) month = "01";
        else if(month.equals("Feb")) month = "02";
        else if(month.equals("Mar")) month = "03";
        else if(month.equals("Apr")) month = "04";
        else if(month.equals("May")) month = "05";
        else if(month.equals("Jun")) month = "06";
        else if(month.equals("Jul")) month = "07";
        else if(month.equals("Aug")) month = "08";
        else if(month.equals("Sep")) month = "09";
        else if(month.equals("Oct")) month = "10";
        else if(month.equals("Nov")) month = "11";
        else if(month.equals("Dec")) month = "12";
        
        //Finalmente se retorna un texto de la fecha convertida
        return year+"/"+month+"/"+day;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JComboBox<String> AutobusCB;
    private javax.swing.JComboBox<String> CiudadDestinoCB;
    private javax.swing.JComboBox<String> CiudadOrigenCB;
    private javax.swing.JComboBox<String> FechaViajeCB;
    private javax.swing.JButton HacerReservaB;
    private javax.swing.JComboBox<String> HoraViajeCB;
    private javax.swing.JLabel ReservacionT;
    private javax.swing.JComboBox<String> TipoDePagoCB;
    private javax.swing.JTextField idreserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pasajeroCedula;
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
