/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

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
import static vista.PrincipalFrame.autobuses;
import static vista.PrincipalFrame.reservaJpaController;
import static vista.PrincipalFrame.reservas;
import static vista.PrincipalFrame.rutas;
import static vista.PrincipalFrame.rutasJpaController;

/**
 *
 * @author Nicolas Ospitia
 */
public class CrearReservaPanel extends javax.swing.JPanel {

    private Image imagen;
    private List <String> t = new ArrayList();
    private Reserva reserva = new Reserva();
    private ReservaPK reservaPK = new ReservaPK();
    private ArrayList <Date> fechas;
    private ArrayList <Date> horas;
    /**
     * Creates new form CrearReservaPanel
     */
    public CrearReservaPanel() {
        initComponents();
        for (Rutas r : rutas){
            t.add(r.getCiudad().getNombreCiudad());
        }
        List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
        for (String s : noRep){
            this.CiudadOrigenCB.addItem(s);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        CiudadOrigenCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CiudadOrigenCBActionPerformed(evt);
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
                .addGap(72, 72, 72)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AtrasB, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBActionPerformed
        // TODO add your handling code here:
        ReservaPanel ReservaP = new ReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ReservaP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
    }//GEN-LAST:event_AtrasBActionPerformed

    private void CiudadOrigenCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CiudadOrigenCBActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_CiudadOrigenCBActionPerformed

    private void CiudadOrigenCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CiudadOrigenCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(CiudadOrigenCB.getSelectedIndex()>0){
                t.clear();
                this.CiudadDestinoCB.addItem("Seleccione una ciudad de destino");
                reservaPK.setCiudadOrigen(CiudadOrigenCB.getSelectedItem().toString());
                for (Rutas r : rutas){
                    if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()))
                        t.add(r.getRutasPK().getCiudadDestino());
                }
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                for (String s : noRep){
                    this.CiudadDestinoCB.addItem(s);
                }
                CiudadDestinoCB.setEnabled(true);
            }
        }
        else{
            CiudadDestinoCB.setEnabled(false);
            this.CiudadDestinoCB.removeAllItems();
        }
    }//GEN-LAST:event_CiudadOrigenCBItemStateChanged

    private void CiudadDestinoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CiudadDestinoCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(CiudadDestinoCB.getSelectedIndex()>0){
                t.clear();
                fechas = new ArrayList <Date>();
                this.FechaViajeCB.addItem("Seleccione una fecha de viaje");
                reservaPK.setCiudadDestino(CiudadDestinoCB.getSelectedItem().toString());
                for (Rutas r : rutas){
                    if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()))
                        try {
                            fechas.add(r.getFechaViaje());
                            t.add(convertirFecha(r.getFechaViaje().toString()));
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                for (String s : noRep){
                    this.FechaViajeCB.addItem(s);
                }
                FechaViajeCB.setEnabled(true);
            }
        }
        else{
            FechaViajeCB.setEnabled(false);
            this.FechaViajeCB.removeAllItems();
        }
    }//GEN-LAST:event_CiudadDestinoCBItemStateChanged

    private void FechaViajeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FechaViajeCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(FechaViajeCB.getSelectedIndex()>0){
                t.clear();
                horas = new ArrayList <Date>();
                this.HoraViajeCB.addItem("Seleccione una hora de viaje");
                reserva.setFechaViaje(fechas.get(FechaViajeCB.getSelectedIndex()-1));
                for (Rutas r : rutas){
                    try { 
                        if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()) && convertirFecha(r.getFechaViaje().toString()).equals(convertirFecha(reserva.getFechaViaje().toString()))){
                            horas.add(r.getHoraViaje());
                            t.add(r.getHoraViaje().toString().substring(11,16));
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                List<String> noRep = new ArrayList(new LinkedHashSet<String>(t));
                for (String s : noRep){
                    this.HoraViajeCB.addItem(s);
                }
                HoraViajeCB.setEnabled(true);
            }
        }
        else{
            HoraViajeCB.setEnabled(false);
            this.HoraViajeCB.removeAllItems();
        }
    }//GEN-LAST:event_FechaViajeCBItemStateChanged

    private void HacerReservaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HacerReservaBActionPerformed
        // TODO add your handling code here:
        boolean repetido = false;
        for(Reserva r : reservas){
            if(idreserva.getText().equals(r.getReservaPK().getIdreserva())) repetido = true;
        }
        if(repetido == false){
            reservaPK.setPasajeroCedula(Long.parseLong(pasajeroCedula.getText()));
            reservaPK.setIdreserva(idreserva.getText());
            reserva.setReservaPK(reservaPK);
            reserva.setPuesto(reservas, autobuses);
            reserva.setPrecioAndIdruta(rutas);
            try {
                reservaJpaController.create(reserva);
                JOptionPane.showMessageDialog(this, "Se ha creado la reserva con exito");
                CrearReservaPanel ReservaP = new CrearReservaPanel();
                PrincipalPanel.setVisible(false);
                PrincipalPanel.removeAll();
                PrincipalPanel.add(ReservaP);
                PrincipalPanel.setVisible(true);
                this.setBounds(500,100,780, 700);
            } catch (Exception ex) {
                Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error. "+ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "El ID de reserva esta repetido, por favor ingrese uno diferente");
        }
    }//GEN-LAST:event_HacerReservaBActionPerformed

    private void HoraViajeCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_HoraViajeCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(HoraViajeCB.getSelectedIndex()>0){
                t.clear();
                this.AutobusCB.addItem("Seleccione un autobus");
                reserva.setHoraSalida(horas.get(HoraViajeCB.getSelectedIndex()-1));
                for (Rutas r : rutas){
                    try {
                        if(r.getRutasPK().getCiudadOrigen().equals(reservaPK.getCiudadOrigen()) && r.getRutasPK().getCiudadDestino().equals(reservaPK.getCiudadDestino()) && convertirFecha(r.getFechaViaje().toString()).equals(convertirFecha(reserva.getFechaViaje().toString())) && r.getHoraViaje().toString().substring(11,16).equals(reserva.getHoraSalida().toString().substring(11,16)))
                            t.add(r.getAutobus().getIdautobus().toString());
                    } catch (ParseException ex) {
                        Logger.getLogger(CrearReservaPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                for (String s : t){
                    this.AutobusCB.addItem(s);
                }
                AutobusCB.setEnabled(true);
            }
        }
        else{
            AutobusCB.setEnabled(false);
            this.AutobusCB.removeAllItems();
        }
    }//GEN-LAST:event_HoraViajeCBItemStateChanged

    private void AutobusCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_AutobusCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(AutobusCB.getSelectedIndex()>0){
                reservaPK.setAutobusidautobus(Integer.parseInt(AutobusCB.getSelectedItem().toString()));
            }
        }
    }//GEN-LAST:event_AutobusCBItemStateChanged

    private void TipoDePagoCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TipoDePagoCBItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange() == ItemEvent.SELECTED){
            if(TipoDePagoCB.getSelectedIndex()>0){
                reserva.setTipoDePago(TipoDePagoCB.getSelectedItem().toString());
            }
        }
    }//GEN-LAST:event_TipoDePagoCBItemStateChanged

    public static String convertirFecha(String fecha) throws ParseException{
        String day = fecha.substring(8,10);
        String month = fecha.substring(4,7);
        String year = fecha.substring(fecha.length()-4, fecha.length());
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
    @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondogeneral.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
}
