/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mayte
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setTitle("Servicios");
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1024, 768));
        this.pack();
        agregarImagenDeFondo();
        establecerPosicionesCentradas();
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                establecerPosicionesCentradas();
            }
        });
        this.setVisible(true);
    }
    
    private void agregarImagenDeFondo() {
        try {
            // 1. Cargar la imagen
            ImageIcon imagenIcono = new ImageIcon(getClass().getResource("/imagenes/fondo.png"));
            // 2. Crear un JLabel para mostrar la imagen
            JLabel imagenLabel = new JLabel(imagenIcono);

            // 3. Establecer el layout del JFrame en BorderLayout para que la imagen ocupe todo el espacio
            this.getContentPane().setLayout(new BorderLayout());

            // 4. Agregar el JLabel al centro del JFrame
            this.getContentPane().add(imagenLabel, BorderLayout.CENTER);

            // Asegurarse de que los cambios se reflejen
            this.revalidate();
            this.repaint();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }
        
private void establecerPosicionesCentradas() {
    int ventanaAncho = getContentPane().getWidth();
    int ventanaAlto = getContentPane().getHeight();

    // Posicionar el JLabel (título) en la parte superior centrada
    int tituloAncho = jLabel1.getPreferredSize().width;
    int tituloX = (ventanaAncho - tituloAncho) / 2;
    jLabel1.setBounds(tituloX, 50, tituloAncho, jLabel1.getPreferredSize().height);

    // Calcular la altura total de los botones con espaciado
    int botonAlto = jButton1.getPreferredSize().height;
    int espacioEntreBotones = 15;
    int alturaTotalBotones = (botonAlto * 3) + (espacioEntreBotones * 2);

    // Calcular la coordenada Y inicial para el primer botón para centrar el grupo verticalmente
    int botonesYInicial = (ventanaAlto - alturaTotalBotones) / 2;

    // *** MODIFICACIÓN: Desplazar los botones el doble del último desplazamiento ***
    int desplazamientoAbajo = 150 * 2 * 2; // Ahora el desplazamiento es el doble del anterior (600)
    botonesYInicial += desplazamientoAbajo;

    // Centrar cada botón horizontalmente y posicionarlos verticalmente
    int boton1Ancho = jButton1.getPreferredSize().width;
    int boton1X = (ventanaAncho - boton1Ancho) / 2;
    jButton1.setBounds(boton1X, botonesYInicial, boton1Ancho, botonAlto);

    int boton2Ancho = jButton2.getPreferredSize().width;
    int boton2X = (ventanaAncho - boton2Ancho) / 2;
    jButton2.setBounds(boton2X, botonesYInicial + botonAlto + espacioEntreBotones, boton2Ancho, botonAlto);

    int boton3Ancho = jButton3.getPreferredSize().width;
    int boton3X = (ventanaAncho - boton3Ancho) / 2;
    jButton3.setBounds(boton3X, botonesYInicial + (2 * botonAlto) + (2 * espacioEntreBotones), boton3Ancho, botonAlto);

    // Posicionar el botón "Salir" en la parte inferior derecha con un margen
    int salirAncho = salirBoton.getPreferredSize().width;
    int salirAlto = salirBoton.getPreferredSize().height;
    int margen = 20;
    salirBoton.setBounds(ventanaAncho - salirAncho - margen, ventanaAlto - salirAlto - margen, salirAncho, salirAlto);
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
        setSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(null);

        salirBoton.setText("Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });
        getContentPane().add(salirBoton);
        salirBoton.setBounds(934, 741, 72, 23);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 710, 114, 32);

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Abogados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(590, 710, 114, 32);

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("Servicios");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(440, 710, 114, 32);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Sistema de Gestión de Despacho de Abogados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(264, 56, 499, 32);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Presentacion.Cliente ventanaClientes = new Presentacion.Cliente();
    ventanaClientes.setVisible(true);    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    Presentacion.Abogado ventanaAbogados = new Presentacion.Abogado();
    ventanaAbogados.setVisible(true);    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Presentacion.Servicio ventanaServicios = new Presentacion.Servicio();
    ventanaServicios.setVisible(true);    }//GEN-LAST:event_jButton3ActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
    this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_salirBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
