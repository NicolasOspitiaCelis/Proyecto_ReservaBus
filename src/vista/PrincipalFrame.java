package vista;

/*
Se realiza el import de todos los elementos necesarios de otros paquetes como los controladores del servidor,
los elementos para la interfaz grafica y la lectura de imagenes y archivos
*/
import controlador.AutobusJpaController;
import controlador.EquipajeJpaController;
import controlador.PasajeroJpaController;
import controlador.ReservaJpaController;
import controlador.RutasJpaController;
import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ImageIcon;

public class PrincipalFrame extends javax.swing.JFrame{

    //Se declaran todas las variables de manipulación del servidor que nos permiten interactuar con la información de este
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ReservaBusPU");
    protected static RutasJpaController rutasJpaController = new RutasJpaController(emf);
    protected static AutobusJpaController autobusJpaController = new AutobusJpaController(emf);
    protected static PasajeroJpaController pasajeroJpaController = new PasajeroJpaController(emf);
    protected static ReservaJpaController reservaJpaController = new ReservaJpaController(emf);
    protected static EquipajeJpaController equipajeJpaController = new EquipajeJpaController(emf);
    
    //Constructor del JFrame que inicializa todos los componentes del mismo, en este caso solo el panel principal
    public PrincipalFrame() {
        initComponents();
        
        //Se le asigna un titulo al JFrame
        this.setTitle("Rollanding");
        
        //Se le asigna un icono al JFrame designado en la ruta especificada
        this.setIconImage(new ImageIcon(getClass().getResource("/vista/Imagenes/FrameIcon.png")).getImage());
        
        /*
        Se inicializa un nuevo panel de menu principal, para ello se quita la visibilidad del panel principal, se remueven todos los
        elementos que esta conteniendo y se le agrega dicho panel que se acaba de crear
        */
        MenuPrincipal Menu = new MenuPrincipal();
        PrincipalPanel.setVisible(false);
        PrincipalPanel.removeAll();
        PrincipalPanel.add(Menu);
        PrincipalPanel.setVisible(true);
        
        //Se le asigna un valor de tamaño y una posición inicial y también se impide que se pueda cambiar de tamaño
        this.setBounds(500,100,780, 700);
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrincipalPanel = new MenuPrincipal();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PrincipalPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalFrame().setVisible(true);
            }
        });
    }
    
    //Función para reproducir un sonido dentro del programa, como entrada maneja el nombre del archivo mp3 a reproducir
    public static void reproducirS(String dir){
        try {
                new JFXPanel();
                String sonido = new File(dir).toURI().toString();
                new MediaPlayer(new Media(sonido)).play();
            } catch (Exception e) {
                System.out.println("Ha ocurrido un error. " + e);
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected static javax.swing.JPanel PrincipalPanel;
    // End of variables declaration//GEN-END:variables
}
