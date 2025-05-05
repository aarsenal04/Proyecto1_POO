package Presentacion;

import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents(); // Inicializa componentes de la interfaz
        setLocationRelativeTo(null); // Centra la ventana
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Maximiza al inicio
        getContentPane().setLayout(null); // Layout manual
        centrarElementosPrincipal(); // Posiciona los elementos
        cargarImagenDeFondo(); // Carga la imagen de fondo

        // Listener para redimensionamiento
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                centrarElementosPrincipal(); // Re-posiciona al redimensionar
            }
        });

        setVisible(true); // Muestra la ventana
    }

    private void centrarElementosPrincipal() {
        int ventanaAncho = getContentPane().getWidth();
        int ventanaAlto = getContentPane().getHeight();
        int margen = 20;
        int espacioEntreBotones = 40;
        int botonAnchoPreferido = 160;
        int botonAltoPreferido = 45;
        int botonSalirAnchoPreferido = 100;
        int botonSalirAltoPreferido = 40;
        int imagenAnchoPreferido = 400;
        int imagenAltoPreferido = 450;

        // Posiciona el título
        jLabel1.setBounds((ventanaAncho - jLabel1.getPreferredSize().width) / 2, margen, jLabel1.getPreferredSize().width, jLabel1.getPreferredSize().height);

        // Posiciona el panel de botones
        int panelBotonesAnchoTotal = 3 * botonAnchoPreferido + 2 * espacioEntreBotones;
        int panelBotonesX = (ventanaAncho - panelBotonesAnchoTotal) / 2;
        int panelBotonesY = ventanaAlto / 3;
        jButton1.setBounds(panelBotonesX, panelBotonesY, botonAnchoPreferido, botonAltoPreferido);
        jButton2.setBounds(panelBotonesX + botonAnchoPreferido + espacioEntreBotones, panelBotonesY, botonAnchoPreferido, botonAltoPreferido);
        jButton3.setBounds(panelBotonesX + 2 * botonAnchoPreferido + 2 * espacioEntreBotones, panelBotonesY, botonAnchoPreferido, botonAltoPreferido);

        // Posiciona el botón de salir
        salirBoton.setBounds((ventanaAncho - botonSalirAnchoPreferido) / 2, ventanaAlto - botonSalirAltoPreferido - margen, botonSalirAnchoPreferido, botonSalirAltoPreferido);

        // Posiciona la imagen de fondo
        jLabel2.setBounds((ventanaAncho - imagenAnchoPreferido) / 2, ventanaAlto - imagenAltoPreferido - 2 * margen - botonSalirAltoPreferido, imagenAnchoPreferido, imagenAltoPreferido);

        getContentPane().revalidate();
        getContentPane().repaint();
    }

private void cargarImagenDeFondo() {
    java.net.URL imageURL = getClass().getResource("/Imagenes/fondo.png");
    if (imageURL != null) {
        ImageIcon imagenIconoOriginal = new ImageIcon(imageURL);
        Image imagenOriginal = imagenIconoOriginal.getImage();
        int anchoDeseado = 400;
        int altoDeseado = 400;
        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        ImageIcon imagenIconoEscalado = new ImageIcon(imagenEscalada);
        jLabel2.setIcon(imagenIconoEscalado);
    }
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        salirBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Sistema de Gestión de Despacho de Abogados");

        jButton1.setBackground(new java.awt.Color(204, 255, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Servicios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 204));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Abogados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        salirBoton.setBackground(new java.awt.Color(255, 102, 102));
        salirBoton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });

        jLabel2.setName("fondoLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(salirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(183, 183, 183)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(116, 116, 116)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jLabel2)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(240, 240, 240)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
                .addComponent(salirBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Presentacion.Cliente ventanaClientes = new Presentacion.Cliente();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Presentacion.Servicio ventanaServicios = new Presentacion.Servicio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Util.XMLServicio xmlServicio = new Util.XMLServicio();
        java.util.List<Conceptos.Servicios> listaServicios = xmlServicio.cargarServicios("Data/servicios.xml");

        Util.XMLAbogado xmlAbogado = new Util.XMLAbogado();
        java.util.List<Conceptos.Abogados> listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);

        Presentacion.Abogado ventanaAbogados = new Presentacion.Abogado(listaAbogados, listaServicios, xmlAbogado);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirBotonActionPerformed

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
