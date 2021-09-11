package vista;

/*
Se realiza el import de todos los elementos necesarios de otros paquetes como los controladores del servidor,
los elementos para la interfaz grafica, manejo de listas, manejo de fechas y la lectura de imagenes
*/
import controlador.exceptions.IllegalOrphanException;
import controlador.exceptions.NonexistentEntityException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Equipaje;
import modelo.EquipajePK;
import modelo.Reserva;
import modelo.Rutas;
import modelo.ReservaPK;
import static vista.CrearReservaPanel.convertirFecha;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.equipajeJpaController;
import static vista.PrincipalFrame.reproducirS;
import static vista.PrincipalFrame.reservaJpaController;
import static vista.PrincipalFrame.rutasJpaController;

public class EditarReservaPanel extends javax.swing.JPanel {

    //Se declaran variables para guardar la imagen de fondo, lista auxiliar de String t para ingresar varoles dentro de un ComboBox
    private Image imagen;
    private List<String> t = new ArrayList();
    
    //Se tienen objetos de Reserva: reservaP un objeto auxiliar y reserva y reservaPK como elementos principales
    private Reserva reservaP = new Reserva();
    private Reserva reserva = new Reserva();
    private ReservaPK reservaPK = new ReservaPK();
    
    //Luego unas litas de fechas y horas para obtener, organizar y mostrar todos estos elementos de tipo Date
    private ArrayList <Date> fechas;
    private ArrayList <Date> fechasNoRep;
    private ArrayList <Date> horas;
    private ArrayList <Date> horasNoRep;
    
    //Finalmente las listas actuales de todos los elementos que tiene la base de datos
    private final List <Rutas> RUTAS = rutasJpaController.findRutasEntities();
    private final List <Reserva> RESERVAS = reservaJpaController.findReservaEntities();
    

    public EditarReservaPanel() {
        initComponents();
        
        //Se esconden todos los componente dentro de la función
        this.setInvisible();
    }

    //Función para ocultar todos los elementos de la interfaz grafica que se especifican dentro de ella
    public void setInvisible() {
        pasajeroCedula.setVisible(false);
        TipoDePagoCB.setVisible(false);
        CiudadOrigenCB.setVisible(false);
        CiudadDestinoCB.setVisible(false);
        FechaViajeCB.setVisible(false);
        HoraViajeCB.setVisible(false);
        AutobusCB.setVisible(false);
        EditarReservaB.setVisible(false);
    }

    //Se realiza el procedimiento inverso de la función anterior, se muestran todos los elementos
    public void setVisibleA() {
        pasajeroCedula.setVisible(true);
        TipoDePagoCB.setVisible(true);
        CiudadOrigenCB.setVisible(true);
        CiudadDestinoCB.setVisible(true);
        FechaViajeCB.setVisible(true);
        HoraViajeCB.setVisible(true);
        AutobusCB.setVisible(true);
        EditarReservaB.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AtrasB = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pasajeroCedula = new javax.swing.JTextField();
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
        EditarReservaB = new javax.swing.JButton();
        TipoDePagoCB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        AutobusCB = new javax.swing.JComboBox<>();
        ReservacionT = new javax.swing.JLabel();
        BuscarB = new javax.swing.JButton();

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

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        jLabel1.setText("Cedula pasajero");

        pasajeroCedula.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        pasajeroCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        EditarReservaB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EditarReservaB.setText("Editar");
        EditarReservaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EditarReservaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarReservaBActionPerformed(evt);
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
        ReservacionT.setText("Editar reserva");

        BuscarB.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        BuscarB.setText("Buscar");
        BuscarB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        BuscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idreserva)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pasajeroCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(HoraViajeCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FechaViajeCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CiudadDestinoCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TipoDePagoCB, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CiudadOrigenCB, javax.swing.GroupLayout.Alignment.LEADING, 0, 258, Short.MAX_VALUE)
                                .addComponent(AutobusCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 299, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(EditarReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(ReservacionT, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(BuscarB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(pasajeroCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TipoDePagoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CiudadOrigenCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CiudadDestinoCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(FechaViajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(HoraViajeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(AutobusCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(EditarReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasB)
                .addGap(49, 49, 49)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
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

    private void BuscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarBActionPerformed
        //Presionado el botón de buscar se verifica la existencia del id de reserva ingresado con ayuda de found y el ciclo for
        boolean found = false;
        
        //Se limpia el panel
        this.Clean();
        for (Reserva r : RESERVAS) {
            
            //Se verifica si alguna reserva coincide con el valor ingresado en la interfaz
            if (r.getReservaPK().getIdreserva().equals(idreserva.getText())) {
                
                //En caso de encontrar una coincidencia entonces se procede a llenar todos los TextFields y ComboBoxes
                this.LlenarCB(r);
                
                //Se confirma que se encontró una coincidencia
                found = true;
                
                //Se muestran todos los elementos no visibles 
                this.setVisibleA();
                
                //Se reproduce un sonido
                reproducirS("bonkS.mp3");
                
                //Se sale del ciclo
                break;
            }
        }
        
        //En caso de no encontrar ninguna coincidencia
        if (found == false) {
            
            //Limpia el panel
            this.Clean();
            
            //Se reproduce un sonido
            reproducirS("errorS.mp3");
            
            //Se muestra una ventana emergente dando el aviso
            JOptionPane.showMessageDialog(this, "No se ha encontrado la reservación");
        }
    }//GEN-LAST:event_BuscarBActionPerformed

    private void EditarReservaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarReservaBActionPerformed
        //Se asignan los valores de reservaPK a los de la reserva a editar
        reserva.setPrecioAndIdruta(RUTAS);
        reserva.setReservaPK(reservaPK);

        //Una vez se presiona el botón de editar se corrobora primero que la reserva auxiliar y la reserva principal no sean iguales
        if(reserva.equals2(reservaP)){
            
            //Dado el caso de ser iguales entonces quiere decir que no se ha cambiado información y no tiene gracia editar un elemento sin cambiar información
            reproducirS("errorS.mp3");
            JOptionPane.showMessageDialog(this, "No ha cambiado información de la reservación, realice un cambio.");
        }
        
        //En caso de haber encontrado diferencias entonces procede
        else{
            
            //Se presentan otros 2 casos, este primer caso considera que la reserva si tiene coleccion de equipajes
            if(reserva.getEquipajeCollection().size() > 0){
                
                eliminarEquipaje(reserva);
                
                reserva.setEquipajeCollection(null);
                
                try {
                    reservaJpaController.destroy(reservaP.getReservaPK());
                    reservaJpaController.create(reserva);
                } catch (Exception ex) {
                    Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                boolean duplicated = false;
                Collection <Equipaje> equipajes = null;
                
                //Se recorren todos estos equipajes asociados a la reserva
                for(Equipaje equipaje : reservaP.getEquipajeCollection()){
                    try {
                        
                        //Se crea un equipajePK con la nueva información del equipaje
                        EquipajePK equipajePK = new EquipajePK(equipaje.getEquipajePK().getIdequipaje(), reserva.getReservaPK().getIdreserva(), reserva.getReservaPK().getPasajeroCedula(), reserva.getReservaPK().getCiudadOrigen(), reserva.getReservaPK().getCiudadDestino(), reserva.getReservaPK().getAutobusidautobus(), reserva.getReservaPK().getIdrutas());
                        Equipaje equipa = new Equipaje(equipajePK, equipaje.getPeso(), equipaje.getTipoDeEquipaje(), equipaje.getEstado());
                        equipa.setReserva(reserva);
                        
                        //Se crea el equipaje nuevo
                        equipajeJpaController.create(equipa);
                        
                        
                        reserva.getEquipajeCollection().add(equipa);
                        
                    //En caso de no poder ejecutar el edit entonces reproduce un sonido y muestra una ventana emergente con el error
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                        reproducirS("errorS.mp3");
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
                    } catch (Exception ex) {
                        Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                        reproducirS("errorS.mp3");
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
                    }
                    
                    //Al final de cada ciclo agrega cada equipaje creado a la lista de equipajes auxiliar
//                    duplicated = equipajes.;
                }
                
                //Ahora se procede a eliminar la reserva anterior e ingresar la nueva reserva
                try {
                    reservaJpaController.edit(reserva);
                    //En caso de todo ir correctamente entonces muestra una ventana emergente confirmando la acción
                    JOptionPane.showMessageDialog(this, "Se ha editado la reserva con éxito");

                    //Inicializa de nuevo el panel para limpiarlo y actualizar toda la información
                    EditarReservaPanel EditarRP = new EditarReservaPanel();
                    PrincipalPanel.setVisible(false);
                    PrincipalPanel.removeAll();
                    PrincipalPanel.add(EditarRP);
                    PrincipalPanel.setVisible(true);

                    //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
                    reproducirS("bonkS.mp3");
                    System.gc();
                    
                //En caso de no poder ejecutar el edit entonces reproduce un sonido y muestra una ventana emergente con el error
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    reproducirS("errorS.mp3");
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    reproducirS("errorS.mp3");
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
                } catch (Exception ex) {
                    Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    reproducirS("errorS.mp3");
                    JOptionPane.showMessageDialog(this, "Ha ocurrido un error. " + ex);
                }
                
            }
            else {
                //Primero ejecuta la función edit del controlador de reservas
                try {
                    reservaJpaController.destroy(reservaP.getReservaPK());
                    reservaJpaController.create(reserva);

                    //En caso de todo ir correctamente entonces muestra una ventana emergente confirmando la acción
                    JOptionPane.showMessageDialog(this, "Se ha editado la reserva con éxito");

                    //Inicializa de nuevo el panel para limpiarlo y actualizar toda la información
                    EditarReservaPanel EditarRP = new EditarReservaPanel();
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
        }
    }//GEN-LAST:event_EditarReservaBActionPerformed

    /*
    La función LlenarCB permite mover la información de las reserva ingresada "r" y mostrarla en los TextFields y ComboBoxes
    Esta función no solo permite mover la información a los elementos dentro de la interfaz, sino también permite llenar 
    con toda la información correspondiente de los ComboBoxes
    */
    public void LlenarCB(Reserva r) {
        
        //Primero se guarda la información disponible de todas las ciudades de origen
        for (Rutas ru : RUTAS) {
            t.add(ru.getCiudad().getNombreCiudad());
        }
        
        //Luego se eliminan todos los elementos repetidos
        List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
        
        //Y seguidamente se agregan al ComboBox de CiudadOrigen
        for (String s : noRep) {
            this.CiudadOrigenCB.addItem(s);
        }
        
        //Se llena el TextField de cedula de pasajero con la información de r
        pasajeroCedula.setText(String.valueOf(r.getReservaPK().getPasajeroCedula()));
        
        //Se selecciona el elemento del ComboBox correspondiente al que trae r
        TipoDePagoCB.setSelectedItem(r.getTipoDePago());
        
        /*
        Se selecciona el elemento del ComboBox correspondiente al que trae r
        Esta acción también desencadena que se ejecute la función de cambio de elemento seleccionado del comboBox CiudadOrigen
        */
        CiudadOrigenCB.setSelectedItem(r.getReservaPK().getCiudadOrigen());
        
        /*
        Se selecciona el elemento del ComboBox correspondiente al que trae r
        Esta acción también desencadena que se ejecute la función de cambio de elemento seleccionado del comboBox CiudadDestino
        */
        CiudadDestinoCB.setSelectedItem(r.getReservaPK().getCiudadDestino());
        
        /*
        Se selecciona el elemento del ComboBox correspondiente al que trae r
        Esta acción también desencadena que se ejecute la función de cambio de elemento seleccionado del comboBox FechaViaje
        */
        try {
            FechaViajeCB.setSelectedItem(convertirFecha(r.getFechaViaje().toString()));
        } catch (ParseException ex) {
            Logger.getLogger(EditarReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        Se selecciona el elemento del ComboBox correspondiente al que trae r
        Esta acción también desencadena que se ejecute la función de cambio de elemento seleccionado del comboBox HoraViaje
        */
        HoraViajeCB.setSelectedItem(r.getHoraSalida().toString().substring(11, 16));
        
        /*
        Se selecciona el elemento del ComboBox correspondiente al que trae r
        Esta acción también desencadena que se ejecute la función de cambio de elemento seleccionado del comboBox Autobus
        */
        AutobusCB.setSelectedItem(String.valueOf(r.getReservaPK().getAutobusidautobus()));
        
        //Finalmente se guardan todos los valores recogidos dentro de reserva, reservaPK y reservaP
        reservaPK.setPasajeroCedula(Long.parseLong(pasajeroCedula.getText()));
        reservaPK.setIdreserva(idreserva.getText());
        reserva.setReservaPK(reservaPK);
        reserva.setPuesto(r.getPuesto());
        reserva.setPrecioAndIdruta(RUTAS);
        reserva.setEquipajeCollection(r.getEquipajeCollection());
        reserva.setRutas(r.getRutas());
        reservaP.setReservaPK(new ReservaPK(idreserva.getText(), Long.parseLong(pasajeroCedula.getText()), CiudadOrigenCB.getSelectedItem().toString(), CiudadDestinoCB.getSelectedItem().toString(), Integer.parseInt(AutobusCB.getSelectedItem().toString()), reserva.getReservaPK().getIdrutas()));
        reservaP.setPuesto(r.getPuesto());
        reservaP.setPrecio(reserva.getPrecio());
        reservaP.setEquipajeCollection(r.getEquipajeCollection());
        reservaP.setRutas(r.getRutas());
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

    //Función para limpiar todos los elementos dentro de la interfaz grafica
        public void Clean() {
        pasajeroCedula.setText("");
        TipoDePagoCB.setSelectedIndex(0);
        CiudadOrigenCB.setSelectedIndex(0);
        CiudadDestinoCB.removeAllItems();
        FechaViajeCB.removeAllItems();
        HoraViajeCB.removeAllItems();
        AutobusCB.removeAllItems();
        fechas = null;
        horas = null;
        reserva = new Reserva();
        reservaPK = new ReservaPK();
}
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasB;
    private javax.swing.JComboBox<String> AutobusCB;
    private javax.swing.JButton BuscarB;
    private javax.swing.JComboBox<String> CiudadDestinoCB;
    private javax.swing.JComboBox<String> CiudadOrigenCB;
    private javax.swing.JButton EditarReservaB;
    private javax.swing.JComboBox<String> FechaViajeCB;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField pasajeroCedula;
    // End of variables declaration//GEN-END:variables
    //Se tiene un override de la función paint para que esta dibuje en el fondo la imagen dentro de la dirección especificada    
    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondogeneral.png")).getImage();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

        setOpaque(false);

        super.paint(g);
    }
}
