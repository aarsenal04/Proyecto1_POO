
package Presentacion;

import java.util.List;
import Util.XMLSolicitud;
import Util.XMLAbogado;
import Util.XMLEstado;
import Util.XMLServicio;
import Conceptos.Solicitud;
import Conceptos.Abogados;
import Conceptos.Servicios;
import Conceptos.Estado;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AtenderSolicitudes extends javax.swing.JFrame {
    
    // variables globales
    private List<Conceptos.Solicitud> listaSolicitudes;
    private List<Conceptos.Abogados> listaAbogados;
    private List<Conceptos.Servicios> listaServicios;
    private List<Conceptos.Estado> listaEstados;
    private Conceptos.Solicitud solicitudSeleccionada;

    public AtenderSolicitudes() {
        initComponents();
        cargarDatos();
    }
    
    private void cargarDatos() {
        listaSolicitudes = Util.XMLSolicitud.cargarSolicitudes("Data/solicitudes.xml", null, null);
        
        XMLServicio xml = new XMLServicio();
        listaServicios = xml.cargarServicios("Data/servicios.xml");
        
        XMLAbogado xmlAbogado = new XMLAbogado();
        listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);
        
        XMLEstado xmlEstado = new XMLEstado();
        listaEstados = xmlEstado.cargarEstados("Data/estados.xml");

        for (Conceptos.Solicitud s : listaSolicitudes) {
            comboIDServicio.addItem(s.getId());
        }

        for (Conceptos.Abogados a : listaAbogados) {
            comboAbogado.addItem(a.getNombreAbogado());
        }

        for (Conceptos.Estado e : listaEstados) {
            comboEstado.addItem(e.getNombre());
        }

        for (Conceptos.Servicios srv : listaServicios) {
            comboServicio.addItem(srv.getNombreServicio());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabelID = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelIDServicio = new javax.swing.JLabel();
        comboIDServicio = new javax.swing.JComboBox<>();
        jLabelFechaHora = new javax.swing.JLabel();
        dateChooser = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabelEstado = new javax.swing.JLabel();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        comboEstado = new javax.swing.JComboBox<>();
        jLabelServicio = new javax.swing.JLabel();
        comboServicio = new javax.swing.JComboBox<>();
        jLabelAbogado = new javax.swing.JLabel();
        comboAbogado = new javax.swing.JComboBox<>();
        jLabelOtrosServicios = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        btnNuevoCliente1 = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPaneOtrosServicios = new javax.swing.JScrollPane();
        jTableOtrosServicios = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atender Solicitud de Servicio");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelID.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 493, 0, 0);
        getContentPane().add(jLabelID, gridBagConstraints);

        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 9, 0, 0);
        getContentPane().add(jTextFieldID, gridBagConstraints);

        jLabelIDServicio.setText("#Servicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 7, 0, 0);
        getContentPane().add(jLabelIDServicio, gridBagConstraints);

        comboIDServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIDServicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 12, 0, 0);
        getContentPane().add(comboIDServicio, gridBagConstraints);

        jLabelFechaHora.setText("Fecha / Hora");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 439, 0, 0);
        getContentPane().add(jLabelFechaHora, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 12, 0, 0);
        getContentPane().add(dateChooser, gridBagConstraints);

        jLabelEstado.setText("Estado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 467, 0, 0);
        getContentPane().add(jLabelEstado, gridBagConstraints);

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.ipadx = 1023;
        gridBagConstraints.ipady = 170;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 13, 0, 6);
        getContentPane().add(jTextAreaObservaciones, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 13, 0, 0);
        getContentPane().add(comboEstado, gridBagConstraints);

        jLabelServicio.setText("Servicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 6, 0, 0);
        getContentPane().add(jLabelServicio, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 4, 0, 0);
        getContentPane().add(comboServicio, gridBagConstraints);

        jLabelAbogado.setText("Abogado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        getContentPane().add(jLabelAbogado, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(33, 12, 0, 0);
        getContentPane().add(comboAbogado, gridBagConstraints);

        jLabelOtrosServicios.setText("Otros Servicios (Adicionales)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        getContentPane().add(jLabelOtrosServicios, gridBagConstraints);

        jLabelObservaciones.setText("Observaciones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 16, 0, 0);
        getContentPane().add(jLabelObservaciones, gridBagConstraints);

        btnNuevoCliente1.setText("-");
        btnNuevoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliente1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 22;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 12, 0, 0);
        getContentPane().add(btnNuevoCliente1, gridBagConstraints);

        btnNuevoCliente.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 72, 0, 0);
        getContentPane().add(btnNuevoCliente, gridBagConstraints);

        jTableOtrosServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "", "Tipo", "Servicio"
            }
        ));
        jScrollPaneOtrosServicios.setViewportView(jTableOtrosServicios);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 24;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1027;
        gridBagConstraints.ipady = 208;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 6);
        getContentPane().add(jScrollPaneOtrosServicios, gridBagConstraints);

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 12, 6, 6);
        getContentPane().add(jButtonCancelar, gridBagConstraints);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 28, 6, 0);
        getContentPane().add(jButtonSalvar, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void btnNuevoCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoCliente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoCliente1ActionPerformed

    private void comboIDServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIDServicioActionPerformed
        String idSeleccionado = (String) comboIDServicio.getSelectedItem();

        solicitudSeleccionada = listaSolicitudes.stream()
            .filter(s -> s.getId().equals(idSeleccionado))
            .findFirst().orElse(null);

        if (solicitudSeleccionada != null) {
            jTextFieldID.setText(solicitudSeleccionada.getCliente());
            String fechaTexto = solicitudSeleccionada.getFechaHora();
            
            if (fechaTexto != null && !fechaTexto.trim().isEmpty()) {
                dateChooser.setDateTimePermissive(java.time.LocalDateTime.parse(fechaTexto));
            } else {
                dateChooser.clear();
            }

            comboServicio.setSelectedItem(solicitudSeleccionada.getServicio());
            jTextAreaObservaciones.setText(solicitudSeleccionada.getObservaciones());

            listaEstados.stream()
                .filter(e -> e.getId().equals(solicitudSeleccionada.getEstado()))
                .findFirst()
                .ifPresent(e -> comboEstado.setSelectedItem(e.getNombre()));

            listaAbogados.stream()
                .filter(a -> a.getidAbogado().equals(solicitudSeleccionada.getAbogado()))
                .findFirst()
                .ifPresent(a -> comboAbogado.setSelectedItem(a.getNombreAbogado()));
        }
    }//GEN-LAST:event_comboIDServicioActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (solicitudSeleccionada == null) return;

        String nombreAbogado = (String) comboAbogado.getSelectedItem();
        String nombreEstado = (String) comboEstado.getSelectedItem();
        String nombreServicioExtra = (String) comboServicio.getSelectedItem();
        String nuevasObservaciones = jTextAreaObservaciones.getText();
        
        if (nombreAbogado == null || nombreEstado == null || nombreServicioExtra == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar abogado, estado y servicio.");
            return;
        }

        String nuevoEstado = listaEstados.stream()
                .filter(e -> e.getNombre().equals(nombreEstado))
                .map(Estado::getId).findFirst().orElse("000");

        String nuevoAbogado = listaAbogados.stream()
                .filter(a -> a.getNombreAbogado().equals(nombreAbogado))
                .map(Abogados::getidAbogado).findFirst().orElse("");

        List<String> nuevosServicios = new ArrayList<>();
        listaServicios.stream()
            .filter(s -> s.getNombreServicio().equals(nombreServicioExtra))
            .findFirst()
            .ifPresent(s -> nuevosServicios.add(s.getidServicio()));

        solicitudSeleccionada.setAbogado(nuevoAbogado);
        solicitudSeleccionada.setEstado(nuevoEstado);
        solicitudSeleccionada.setObservaciones(nuevasObservaciones);
        solicitudSeleccionada.setOtrosServicios(nuevosServicios);

        Conceptos.Atender.actualizarYGuardar(listaSolicitudes, solicitudSeleccionada, "Data/solicitudes.xml");

        javax.swing.JOptionPane.showMessageDialog(this, "Solicitud actualizada correctamente.");
        //this.dispose();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AtenderSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtenderSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtenderSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtenderSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtenderSolicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnNuevoCliente1;
    private javax.swing.JComboBox<String> comboAbogado;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JComboBox<String> comboIDServicio;
    private javax.swing.JComboBox<String> comboServicio;
    private com.github.lgooddatepicker.components.DateTimePicker dateChooser;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelAbogado;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelFechaHora;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelIDServicio;
    private javax.swing.JLabel jLabelObservaciones;
    private javax.swing.JLabel jLabelOtrosServicios;
    private javax.swing.JLabel jLabelServicio;
    private javax.swing.JScrollPane jScrollPaneOtrosServicios;
    private javax.swing.JTable jTableOtrosServicios;
    private javax.swing.JTextArea jTextAreaObservaciones;
    private javax.swing.JTextField jTextFieldID;
    // End of variables declaration//GEN-END:variables
}