package vista;

//Solamente se declaran elementos para manupalar imagenes y tambien el panel principal
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import static vista.PrincipalFrame.PrincipalPanel;
import static vista.PrincipalFrame.reproducirS;

public class MenuPrincipal extends javax.swing.JPanel {

    //Variable para contener la imagen de fondo del panel
    private Image imagen;

    //Inicialización de todos los componentes de la parte de diseño de este panel (codigo generado automaticamente)
    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuB = new javax.swing.JButton();
        ReservaB = new javax.swing.JButton();
        PasajeroB = new javax.swing.JButton();

        MenuB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Titulo.png"))); // NOI18N
        MenuB.setContentAreaFilled(false);
        MenuB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Logo_G.png"))); // NOI18N
        MenuB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuBActionPerformed(evt);
            }
        });

        ReservaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Treserva.png"))); // NOI18N
        ReservaB.setContentAreaFilled(false);
        ReservaB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/Treserva_G.png"))); // NOI18N
        ReservaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservaBActionPerformed(evt);
            }
        });

        PasajeroB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/PasajeroT.png"))); // NOI18N
        PasajeroB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PasajeroB.setBorderPainted(false);
        PasajeroB.setContentAreaFilled(false);
        PasajeroB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PasajeroB.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/Imagenes/PasajeroT_G.png"))); // NOI18N
        PasajeroB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasajeroBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(MenuB)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ReservaB)
                .addGap(215, 215, 215))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuB, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(ReservaB, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasajeroB, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ReservaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservaBActionPerformed
        //Acción generada al oprimir el botón "Reserva" dentro del menu principal

        //Se inicializa un nuevo panel de reservaciones
        ReservaPanel ReservaP = new ReservaPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(ReservaP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        //Se reproduce el sonido correspondiente asignado para este boton - buttonS.mp3
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_ReservaBActionPerformed

    private void MenuBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuBActionPerformed
        //Acción generada al oprimir el botón del Titulo "Rollanding" dentro del menu principal
        
        //Se inicializa un nuevo panel de Profe chismoso
        OtroMenu Menu = new OtroMenu();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(Menu);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        //Se reproduce el sonido correspondiente asignado para este boton - buttonS.mp3
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_MenuBActionPerformed

    private void PasajeroBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasajeroBActionPerformed
        //Acción generada al oprimir el botón "Pasajero" dentro del menu principal
        
        //Se inicializa un nuevo panel de gestión de base de datos de pasajeros
        PasajeroPanel PasajeroP = new PasajeroPanel();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(PasajeroP);
        PrincipalPanel.setVisible(true);
        this.setBounds(500,100,780, 700);
        
        //Se reproduce el sonido correspondiente asignado para este boton - buttonS.mp3
        reproducirS("buttonS.mp3");
    }//GEN-LAST:event_PasajeroBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MenuB;
    private javax.swing.JButton PasajeroB;
    private javax.swing.JButton ReservaB;
    // End of variables declaration//GEN-END:variables
        //Se tiene un override de la función paint para que esta dibuje en el fondo la imagen dentro de la dirección especificada
        @Override
        public void paint(Graphics g)
        {
            imagen = new ImageIcon(getClass().getResource("./Imagenes/Fondo.png")).getImage();
            
            g.drawImage(imagen,0, 0, getWidth(), getHeight(),this);
            
            setOpaque(false);
            
            super.paint(g);
        }
}
