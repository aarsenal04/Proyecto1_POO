package Presentacion;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    // Constructor de la ventana principal de la aplicación
    public Principal() {
        initComponents();
        // Configuración inicial de la ventana
        setLocationRelativeTo(null);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(null);
        
        // Organizar y configurar elementos de la UI
        centrarElementosPrincipal();
        cargarImagenDeFondo();
        
        // Listener para recentrar elementos al redimensionar la ventana
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                centrarElementosPrincipal();
            }
        });

        setVisible(true);
    }

    // Centrar y distribuir el título, imagen y botón de salir
    private void centrarElementosPrincipal() {
        int ventanaAncho = getContentPane().getWidth();
        int ventanaAlto = getContentPane().getHeight();
        int margen = 20;

        int botonSalirAnchoPreferido = 100;
        int botonSalirAltoPreferido = 40;
        int imagenAnchoPreferido = 400;
        int imagenAltoPreferido = 450;

        jLabel1.setBounds((ventanaAncho - jLabel1.getPreferredSize().width) / 2, margen, jLabel1.getPreferredSize().width, jLabel1.getPreferredSize().height);

        int salirBotonY = ventanaAlto - botonSalirAltoPreferido - margen;
        salirBoton.setBounds((ventanaAncho - botonSalirAnchoPreferido) / 2, salirBotonY, botonSalirAnchoPreferido, botonSalirAltoPreferido);

        int limiteSuperior = jLabel1.getY() + jLabel1.getHeight();
        int limiteInferior = salirBoton.getY();
        int alturaDisponible = limiteInferior - limiteSuperior;
        int imagenY = limiteSuperior + (alturaDisponible - imagenAltoPreferido) / 2;
        int imagenX = (ventanaAncho - imagenAnchoPreferido) / 2;
        jLabel2.setBounds(imagenX, imagenY, imagenAnchoPreferido, imagenAltoPreferido);

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    // Cargar y escalar la imagen de fondo para el JLabel
    private void cargarImagenDeFondo() {
        java.net.URL imageURL = getClass().getResource("/Imagenes/fondo.png");
        if (imageURL != null) {
            ImageIcon imagenIconoOriginal = new ImageIcon(imageURL);
            Image imagenOriginal = imagenIconoOriginal.getImage();
            int anchoDeseado = 400;
            int altoDeseado = 450;
            Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
            ImageIcon imagenIconoEscalado = new ImageIcon(imagenEscalada);
            jLabel2.setIcon(imagenIconoEscalado);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        salirBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Sistema de Gestión de Despacho de Abogados");

        salirBoton.setBackground(new java.awt.Color(255, 102, 102));
        salirBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jMenu1.setText("Servicios");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem5.setText("Consultar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem4.setText("Solicitar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem6.setText("Atender");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Util");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem1.setText("Servicios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem3.setText("Abogados");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuItem2.setText("Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(salirBoton)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(154, 154, 154))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 537, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(71, 71, 71)
                .addComponent(salirBoton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Acción del botón Salir
    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirBotonActionPerformed

    // Acción del menú para abrir la ventana de gestión de servicios
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Presentacion.Servicio ventanaServicios = new Presentacion.Servicio();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    // Acción del menú para abrir la la ventana de gestión de clientes
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Presentacion.Cliente ventanaCliente = new Presentacion.Cliente();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    // Acción del menú para abrir la ventana de gestión de abogados
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // Cargar datos necesarios para la ventana de abogados
        Util.XMLServicio xmlServicio = new Util.XMLServicio();
        java.util.List<Conceptos.Servicios> listaServicios = xmlServicio.cargarServicios("Data/servicios.xml");
        Util.XMLAbogado xmlAbogado = new Util.XMLAbogado();
        java.util.List<Conceptos.Abogados> listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);
        
        Presentacion.Abogado ventanaAbogados = new Presentacion.Abogado(listaAbogados, listaServicios, xmlAbogado);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Acción del menú para abrir la ventana de creación de solicitudes
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CrearSolicitudes crearSolicitudes = new CrearSolicitudes();
        crearSolicitudes.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    // Acción del menú para abrir la ventana de consulta de solicitudes
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ConsultarSolicitudes consultarSolicitudes = new ConsultarSolicitudes();
        consultarSolicitudes.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    // Acción del menú para abrir la ventana de atención de solicitudes
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        AtenderSolicitudes atenderSolicitudes = new AtenderSolicitudes();
        atenderSolicitudes.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    // Método principal para iniciar la aplicación
    public static void main(String args[]) {
        // Establecer apariencia visual Nimbus
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Lanzar la interfaz de usuario principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}