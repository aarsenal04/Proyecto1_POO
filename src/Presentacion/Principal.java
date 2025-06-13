
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

    // --- Definimos los tamaños fijos para los botones ---
    int espacioEntreBotones = 40;
    int botonAlto = 45; // Altura para todos los botones
    
    // Ancho para los botones con texto corto
    int botonAnchoNormal = 170; 

    // Ancho específico y más grande para el botón con texto largo.
    int botonAnchoLargo = 280; 

    // --- Posiciona el título ---
    jLabel1.setBounds((ventanaAncho - jLabel1.getPreferredSize().width) / 2, margen, jLabel1.getPreferredSize().width, jLabel1.getPreferredSize().height);

    // --- Posiciona los 4 botones ---
    int panelBotonesAnchoTotal = (3 * botonAnchoNormal) + botonAnchoLargo + (3 * espacioEntreBotones);
    int panelBotonesX = (ventanaAncho - panelBotonesAnchoTotal) / 2;
    int panelBotonesY = ventanaAlto / 3;

    // Botón 1: Clientes
    btnClientes.setBounds(panelBotonesX, panelBotonesY, botonAnchoNormal, botonAlto);
    
    // Botón 2: Abogados
    int posX_Boton2 = panelBotonesX + botonAnchoNormal + espacioEntreBotones;
    btnAbogados.setBounds(posX_Boton2, panelBotonesY, botonAnchoNormal, botonAlto);

    // Botón 3: Servicios (con la variable corregida)
    int posX_Boton3 = posX_Boton2 + botonAnchoNormal + espacioEntreBotones;
    btnServicios.setBounds(posX_Boton3, panelBotonesY, botonAnchoNormal, botonAlto); // <-- CORRECCIÓN APLICADA AQUÍ

    // Botón 4: Solicitudes
    int posX_Boton4 = posX_Boton3 + botonAnchoNormal + espacioEntreBotones;
    btnMenuServicios.setBounds(posX_Boton4, panelBotonesY, botonAnchoLargo, botonAlto);

    // --- Posiciona los elementos restantes ---
    int botonSalirAnchoPreferido = 100;
    int botonSalirAltoPreferido = 40;
    salirBoton.setBounds((ventanaAncho - botonSalirAnchoPreferido) / 2, ventanaAlto - botonSalirAltoPreferido - margen, botonSalirAnchoPreferido, botonSalirAltoPreferido);

    int imagenAnchoPreferido = 400;
    int imagenAltoPreferido = 450;
    jLabel2.setBounds((ventanaAncho - imagenAnchoPreferido) / 2, ventanaAlto - imagenAltoPreferido - 2 * margen - botonSalirAltoPreferido, imagenAnchoPreferido, imagenAltoPreferido);

    // --- Refresca la ventana ---
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

        popupMenuSolicitudes = new javax.swing.JPopupMenu();
        popupMenuItemConsultar = new javax.swing.JMenuItem();
        popupMenuItemSolicitar = new javax.swing.JMenuItem();
        popupMenuItemAtender = new javax.swing.JMenuItem();
        btnClientes = new javax.swing.JButton();
        btnServicios = new javax.swing.JButton();
        btnAbogados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        salirBoton = new javax.swing.JButton();
        btnMenuServicios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        popupMenuItemConsultar.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        popupMenuItemConsultar.setText("Consultar");
        popupMenuItemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuItemConsultarActionPerformed(evt);
            }
        });
        popupMenuSolicitudes.add(popupMenuItemConsultar);

        popupMenuItemSolicitar.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        popupMenuItemSolicitar.setText("Solicitar");
        popupMenuItemSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuItemSolicitarActionPerformed(evt);
            }
        });
        popupMenuSolicitudes.add(popupMenuItemSolicitar);

        popupMenuItemAtender.setFont(new java.awt.Font("Segoe UI", 0, 21)); // NOI18N
        popupMenuItemAtender.setText("Atender");
        popupMenuItemAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupMenuItemAtenderActionPerformed(evt);
            }
        });
        popupMenuSolicitudes.add(popupMenuItemAtender);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnClientes.setBackground(new java.awt.Color(51, 153, 255));
        btnClientes.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnServicios.setBackground(new java.awt.Color(255, 102, 102));
        btnServicios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnServicios.setText("Servicios");
        btnServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServiciosActionPerformed(evt);
            }
        });

        btnAbogados.setBackground(new java.awt.Color(255, 255, 102));
        btnAbogados.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnAbogados.setText("Abogados");
        btnAbogados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbogadosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Sistema de Gestión de Despacho de Abogados");

        salirBoton.setBackground(new java.awt.Color(51, 153, 255));
        salirBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });

        btnMenuServicios.setBackground(new java.awt.Color(0, 204, 102));
        btnMenuServicios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnMenuServicios.setText("Solicitudes de servicios");
        btnMenuServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMenuServiciosMouseClicked(evt);
            }
        });
        btnMenuServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuServiciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbogados)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenuServicios))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 576, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientes)
                    .addComponent(btnAbogados)
                    .addComponent(btnServicios)
                    .addComponent(btnMenuServicios))
                .addGap(18, 18, 18)
                .addComponent(salirBoton)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Presentacion.Cliente ventanaClientes = new Presentacion.Cliente();
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServiciosActionPerformed
        Presentacion.Servicio ventanaServicios = new Presentacion.Servicio();
    }//GEN-LAST:event_btnServiciosActionPerformed

    private void btnAbogadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbogadosActionPerformed

        Util.XMLServicio xmlServicio = new Util.XMLServicio();
        java.util.List<Conceptos.Servicios> listaServicios = xmlServicio.cargarServicios("Data/servicios.xml");

        Util.XMLAbogado xmlAbogado = new Util.XMLAbogado();
        java.util.List<Conceptos.Abogados> listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);

        Presentacion.Abogado ventanaAbogados = new Presentacion.Abogado(listaAbogados, listaServicios, xmlAbogado);
    }//GEN-LAST:event_btnAbogadosActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        this.dispose();
    }//GEN-LAST:event_salirBotonActionPerformed

    private void btnMenuServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuServiciosActionPerformed
    }//GEN-LAST:event_btnMenuServiciosActionPerformed

    private void btnMenuServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMenuServiciosMouseClicked
    popupMenuSolicitudes.show(evt.getComponent(), 0, evt.getComponent().getHeight());
    }//GEN-LAST:event_btnMenuServiciosMouseClicked

    private void popupMenuItemSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuItemSolicitarActionPerformed
    new Presentacion.CrearSolicitudes().setVisible(true);
    }//GEN-LAST:event_popupMenuItemSolicitarActionPerformed

    private void popupMenuItemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuItemConsultarActionPerformed
    new ConsultarSolicitudes(this, true).setVisible(true);
    }//GEN-LAST:event_popupMenuItemConsultarActionPerformed

    private void popupMenuItemAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupMenuItemAtenderActionPerformed
    new Presentacion.AtenderSolicitudes().setVisible(true);
    }//GEN-LAST:event_popupMenuItemAtenderActionPerformed

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
    private javax.swing.JButton btnAbogados;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnMenuServicios;
    private javax.swing.JButton btnServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem popupMenuItemAtender;
    private javax.swing.JMenuItem popupMenuItemConsultar;
    private javax.swing.JMenuItem popupMenuItemSolicitar;
    private javax.swing.JPopupMenu popupMenuSolicitudes;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
