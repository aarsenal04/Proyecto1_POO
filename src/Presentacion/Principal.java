package Presentacion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Servicios");
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.pack();
        agregarImagenDeFondo();
        agregarComponentesCentrados();
        this.setVisible(true);
    }
    
private void agregarImagenDeFondo() {
    try {
        ImageIcon imagenIconoOriginal = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
        Image imagenOriginal = imagenIconoOriginal.getImage();

        int anchoDeseado = 400;
        int altoDeseado = 450;

        Image imagenEscalada = imagenOriginal.getScaledInstance(anchoDeseado, altoDeseado, Image.SCALE_SMOOTH);
        ImageIcon imagenIconoEscalado = new ImageIcon(imagenEscalada);
        JLabel imagenLabel = new JLabel(imagenIconoEscalado);
        imagenLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // *** CAMBIO: Usar GridBagConstraints para la imagen ***
        GridBagConstraints gbcImagen = new GridBagConstraints();
        gbcImagen.gridx = 0;
        gbcImagen.gridy = 3; // Colocar debajo del botón salir (que está en gridy=2)
        gbcImagen.weightx = 1.0; // Para que ocupe todo el ancho
        gbcImagen.anchor = GridBagConstraints.SOUTH; // Alinear al sur
        gbcImagen.insets = new Insets(10, 10, 10, 10); // Ajustar márgenes

        getContentPane().add(imagenLabel, gbcImagen);

        this.revalidate();
        this.repaint();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + e.getMessage());
        e.printStackTrace();
    }
}    
    
private void agregarComponentesCentrados() {
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 10, 10); // *** CAMBIO: Reducir el espacio superior del título ***
        gbc.anchor = GridBagConstraints.NORTH;
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(jLabel1, gbc);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 0));
        panelBotones.setOpaque(false);

        Dimension botonDimension = new Dimension(160, 45);
        jButton1.setPreferredSize(botonDimension);
        jButton2.setPreferredSize(botonDimension);
        jButton3.setPreferredSize(botonDimension);

        panelBotones.add(jButton1);
        panelBotones.add(jButton3);
        panelBotones.add(jButton2);

        gbc.gridy = 1; // Los botones siguen en la fila 1
        getContentPane().add(panelBotones, gbc);

        gbc.gridy = 2; // El botón salir sigue en la fila 2
        salirBoton.setPreferredSize(new Dimension(100, 40));
        getContentPane().add(salirBoton, gbc);
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        salirBoton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        salirBoton.setBackground(new java.awt.Color(51, 153, 255));
        salirBoton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        getContentPane().add(salirBoton);
        salirBoton.setBounds(930, 710, 75, 39);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 310, 114, 39);

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Abogados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(620, 310, 137, 39);

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Servicios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(410, 310, 114, 39);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Sistema de Gestión de Despacho de Abogados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 60, 985, 64);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Presentacion.Cliente ventanaClientes = new Presentacion.Cliente();
    ventanaClientes.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        Util.XMLServicio xmlServicio = new Util.XMLServicio();
        java.util.List<Conceptos.Servicios> listaServicios = xmlServicio.cargarServicios("Data/servicios.xml");

        Util.XMLAbogado xmlAbogado = new Util.XMLAbogado();
        java.util.List<Conceptos.Abogados> listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);

        Presentacion.Abogado ventanaAbogados = new Presentacion.Abogado(listaAbogados, listaServicios, xmlAbogado);

    ventanaAbogados.setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Presentacion.Servicio ventanaServicios = new Presentacion.Servicio();
    ventanaServicios.setVisible(true);    }//GEN-LAST:event_jButton3ActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
    this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_salirBotonActionPerformed


    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
