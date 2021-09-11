package vista;

//Solamente se declaran elementos para manupalar imagenes y tambien el panel principal
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.reproducirS;

public class ReservaPanel extends javax.swing.JPanel {

    //Se declara la varibale que contendrá la imagen del fondo del panel
    private Image imagen;

    public ReservaPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloReserva = new javax.swing.JLabel();
        CrearReserva = new javax.swing.JButton();
        ConsultarReserva = new javax.swing.JButton();
        EditarReserva = new javax.swing.JButton();
        EliminarReserva = new javax.swing.JButton();
        AtrasReserva = new javax.swing.JButton();

        TituloReserva.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        TituloReserva.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Treserva.png"))); // NOI18N

        CrearReserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        CrearReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ReservarIcon.png"))); // NOI18N
        CrearReserva.setText("Crear reserva");
        CrearReserva.setContentAreaFilled(false);
        CrearReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CrearReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ReservarIcon_G_G.png"))); // NOI18N
        CrearReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CrearReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearReservaActionPerformed(evt);
            }
        });

        ConsultarReserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        ConsultarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon.png"))); // NOI18N
        ConsultarReserva.setText("Consultar reserva");
        ConsultarReserva.setContentAreaFilled(false);
        ConsultarReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConsultarReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/ConsultarIcon_G_G.png"))); // NOI18N
        ConsultarReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConsultarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarReservaActionPerformed(evt);
            }
        });

        EditarReserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EditarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EditarIcon.png"))); // NOI18N
        EditarReserva.setText("Editar reserva");
        EditarReserva.setContentAreaFilled(false);
        EditarReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EditarIcon_G_G.png"))); // NOI18N
        EditarReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarReservaActionPerformed(evt);
            }
        });

        EliminarReserva.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        EliminarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EliminarIcon.png"))); // NOI18N
        EliminarReserva.setText("Eliminar reserva");
        EliminarReserva.setContentAreaFilled(false);
        EliminarReserva.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/EliminarIcon_G_G.png"))); // NOI18N
        EliminarReserva.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarReservaActionPerformed(evt);
            }
        });

        AtrasReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras.png"))); // NOI18N
        AtrasReserva.setContentAreaFilled(false);
        AtrasReserva.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Atras_G.png"))); // NOI18N
        AtrasReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CrearReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ConsultarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(103, 103, 103))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AtrasReserva)
                .addGap(149, 149, 149)
                .addComponent(TituloReserva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TituloReserva)
                    .addComponent(AtrasReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CrearReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarReservaActionPerformed
        //Acción generada al oprimir el botón "Eliminar reserva" dentro del menu de reservaciones

        //Se inicializa un nuevo panel de eliminación de reservaciones
        EliminarReservaPanel EliminarP = new EliminarReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(EliminarP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_EliminarReservaActionPerformed

    private void ConsultarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarReservaActionPerformed
        //Acción generada al oprimir el botón "Consultar reserva" dentro del menu de reservaciones

        //Se inicializa un nuevo panel de consulta de reservaciones
        ConsultarReservaPanel ConsultaP = new ConsultarReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ConsultaP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_ConsultarReservaActionPerformed

    private void AtrasReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasReservaActionPerformed
        // TODO add your handling code here:
        MenuPrincipal Menu = new MenuPrincipal();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(Menu);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("backS.mp3");
    }//GEN-LAST:event_AtrasReservaActionPerformed

    private void EditarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarReservaActionPerformed
        //Acción generada al oprimir el botón "Editar reserva" dentro del menu de reservaciones

        //Se inicializa un nuevo panel de edición de reservaciones
        EditarReservaPanel EditarP = new EditarReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(EditarP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_EditarReservaActionPerformed

    private void CrearReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearReservaActionPerformed
        //Acción generada al oprimir el botón "Crear reserva" dentro del menu de reservaciones

        //Se inicializa un nuevo panel de creacion de reservaciones
        CrearReservaPanel ReservaP = new CrearReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ReservaP);
        PrincipalPanel.setVisible(true);
        
        //Se reproduce un sonido y finalmente se ejecuta el Garbage Collector para liberar espacio en memoria
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_CrearReservaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtrasReserva;
    private javax.swing.JButton ConsultarReserva;
    private javax.swing.JButton CrearReserva;
    private javax.swing.JButton EditarReserva;
    private javax.swing.JButton EliminarReserva;
    private javax.swing.JLabel TituloReserva;
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
