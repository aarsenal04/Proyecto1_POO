
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atender Solicitud de Servicio");

        jLabelID.setText("ID");

        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        jLabelIDServicio.setText("#Servicio");

        comboIDServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboIDServicioActionPerformed(evt);
            }
        });

        jLabelFechaHora.setText("Fecha / Hora");

        jLabelEstado.setText("Estado");

        jTextAreaObservaciones.setColumns(20);
        jTextAreaObservaciones.setRows(5);

        jLabelServicio.setText("Servicio");

        jLabelAbogado.setText("Abogado");

        jLabelOtrosServicios.setText("Otros Servicios (Adicionales)");

        jLabelObservaciones.setText("Observaciones");

        btnNuevoCliente1.setText("-");
        btnNuevoCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoCliente1ActionPerformed(evt);
            }
        });

        btnNuevoCliente.setText("+");

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

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelIDServicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboIDServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabelAbogado)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(comboAbogado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelServicio)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(comboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(493, 493, 493)
                                        .addComponent(jLabelID)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(439, 439, 439)
                                        .addComponent(jLabelFechaHora)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(467, 467, 467)
                                        .addComponent(jLabelEstado)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 65, Short.MAX_VALUE))
                            .addComponent(jScrollPaneOtrosServicios)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jTextAreaObservaciones)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelOtrosServicios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCancelar)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabelObservaciones)
                    .addContainerGap(962, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDServicio)
                    .addComponent(comboIDServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelID)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelServicio)
                    .addComponent(comboServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaHora)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAbogado)
                    .addComponent(comboAbogado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addComponent(jTextAreaObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOtrosServicios)
                    .addComponent(btnNuevoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevoCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneOtrosServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonSalvar))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(jLabelObservaciones)
                    .addContainerGap(560, Short.MAX_VALUE)))
        );

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
        this.dispose();
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