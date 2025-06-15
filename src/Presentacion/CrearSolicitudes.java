package Presentacion;

import Conceptos.Clientes;
import Conceptos.Servicios;
import Conceptos.Solicitud;
import Conceptos.Estado;
import Util.XMLCliente;
import Util.XMLServicio;
import Util.XMLSolicitud;
import Util.XMLEstado;
import java.awt.Frame;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class CrearSolicitudes extends javax.swing.JFrame {
    private Util.XMLCliente xmlCliente;
    private Util.XMLServicio xmlServicio;
    private Util.XMLSolicitud xmlSolicitudes;
    private List<Clientes> listaDeClientes;
    private List<Servicios> listaDeServicios;

public CrearSolicitudes() {
    initComponents();
    organizarComponentes(); // <-- AÑADE ESTA LÍNEA
    inicializarComponentesPersonalizados();
}

    private void organizarComponentes() {
        jPanel6.removeAll();
        jPanel6.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        gbc.insets = new java.awt.Insets(5, 5, 5, 5);

        javax.swing.JPanel panelSuperior = new javax.swing.JPanel(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcSuperior = new java.awt.GridBagConstraints();
        gbcSuperior.insets = new java.awt.Insets(5, 5, 5, 5);
        gbcSuperior.anchor = java.awt.GridBagConstraints.WEST;

        gbcSuperior.gridy = 0;
        gbcSuperior.gridx = 0; panelSuperior.add(jLabel6, gbcSuperior);
        gbcSuperior.gridx = 2; panelSuperior.add(jLabel10, gbcSuperior);

        gbcSuperior.gridy = 1;
        gbcSuperior.gridx = 0; panelSuperior.add(jLabel8, gbcSuperior);

        gbcSuperior.gridy = 2;
        gbcSuperior.gridx = 0; panelSuperior.add(jLabel12, gbcSuperior);

        gbcSuperior.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbcSuperior.weightx = 1.0;
        gbcSuperior.gridy = 0;
        gbcSuperior.gridx = 1; panelSuperior.add(txtId, gbcSuperior);
        gbcSuperior.gridx = 3; panelSuperior.add(comboCliente, gbcSuperior);

        gbcSuperior.gridy = 1;
        gbcSuperior.gridx = 1; panelSuperior.add(comboServicio, gbcSuperior);

        gbcSuperior.gridy = 2;
        gbcSuperior.gridx = 1; panelSuperior.add(dateChooser, gbcSuperior);

        gbcSuperior.fill = java.awt.GridBagConstraints.NONE;
        gbcSuperior.weightx = 0;
        gbcSuperior.gridy = 0;
        gbcSuperior.gridx = 4; panelSuperior.add(btnNuevoCliente, gbcSuperior);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.weightx = 1.0;
        gbc.anchor = java.awt.GridBagConstraints.NORTH;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(panelSuperior, gbc);

        gbc.gridy = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.fill = java.awt.GridBagConstraints.NONE;
        jPanel6.add(jLabel15, gbc);

        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.fill = java.awt.GridBagConstraints.BOTH;
        jPanel6.add(jScrollPane2, gbc);

        javax.swing.JPanel panelBotones = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
        panelBotones.add(btnSalvar, java.awt.BorderLayout.WEST);
        panelBotones.add(btnCancelar, java.awt.BorderLayout.EAST);

        gbc.gridy = 3;
        gbc.weighty = 0;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel6.add(panelBotones, gbc);

        jPanel6.revalidate();
        jPanel6.repaint();
    }
    
private void inicializarComponentesPersonalizados() {
    this.xmlCliente = new XMLCliente();
    this.xmlServicio = new XMLServicio();
    this.xmlSolicitudes = new XMLSolicitud();

    this.setTitle("Crear Solicitud de Servicio");
    this.setSize(1024, 768); // Tamaño deseado al restaurar
    this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Inicia maximizada
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    cargarClientes();
    cargarServicios();

    comboCliente.addActionListener(e -> {});

    txtId.setEditable(false);
}

    private void cargarClientes() {
        comboCliente.removeAllItems();
        this.listaDeClientes = xmlCliente.cargarClientes("Data/clientes.xml");
        for (Clientes cliente : listaDeClientes) {
            comboCliente.addItem(cliente.getNombreCliente());
        }
            if (!this.listaDeClientes.isEmpty()) {
            comboCliente.setSelectedIndex(0); 
            //txtId.setText(this.listaDeClientes.get(0).getidCliente());
        }
    }
    
    private void cargarServicios() {
        comboServicio.removeAllItems();
        this.listaDeServicios = xmlServicio.cargarServicios("Data/servicios.xml");
        for (Servicios servicio : listaDeServicios) {
            comboServicio.addItem(servicio.getNombreServicio());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboServicio = new javax.swing.JComboBox<>();
        comboCliente = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnCancelar = new javax.swing.JButton();
        btnNuevoCliente = new javax.swing.JButton();
        dateChooser = new com.github.lgooddatepicker.components.DateTimePicker(
            new com.github.lgooddatepicker.components.DatePickerSettings(new java.util.Locale("es")), 
            new com.github.lgooddatepicker.components.TimePickerSettings(new java.util.Locale("es"))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crear Solicitudes de Servicio");

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("ID");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 6, 0, 0);
        jPanel6.add(jLabel6, gridBagConstraints);

        txtId.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(37, 12, 0, 0);
        jPanel6.add(txtId, gridBagConstraints);

        jLabel8.setText("Servicio");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 6, 0, 0);
        jPanel6.add(jLabel8, gridBagConstraints);

        jLabel12.setText("Fecha / Hora");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 6, 0, 0);
        jPanel6.add(jLabel12, gridBagConstraints);

        jLabel10.setText("Cliente");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 153, 0, 0);
        jPanel6.add(jLabel10, gridBagConstraints);

        comboServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 0);
        jPanel6.add(comboServicio, gridBagConstraints);

        comboCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 18;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 18, 0, 0);
        jPanel6.add(comboCliente, gridBagConstraints);

        jLabel15.setText("Observaciones");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(39, 6, 0, 0);
        jPanel6.add(jLabel15, gridBagConstraints);

        btnSalvar.setText("Salvar");
        btnSalvar.setBackground(new java.awt.Color(204, 255, 153));
        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(80, 6, 0, 0);
        jPanel6.add(btnSalvar, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jScrollPane2.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 22;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 996;
        gridBagConstraints.ipady = 367;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(38, 6, 0, 6);
        jPanel6.add(jScrollPane2, gridBagConstraints);

        btnCancelar.setText("Cancelar");
        btnCancelar.setBackground(new java.awt.Color(255, 102, 102));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 48, 8, 0);
        jPanel6.add(btnCancelar, gridBagConstraints);

        btnNuevoCliente.setText("+");
        btnNuevoCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 31, 0, 0);
        jPanel6.add(btnNuevoCliente, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 12, 0, 0);
        jPanel6.add(dateChooser, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (comboCliente.getSelectedIndex() == -1 || comboServicio.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente y un servicio.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (dateChooser.getDateTimeStrict() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fecha y hora.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = "SOL" + System.currentTimeMillis(); // ID unico basado en timestamp
        txtId.setText(id);  // mostrar el ID al usuario

        String observaciones = jTextArea1.getText();
        LocalDateTime fechaHora = dateChooser.getDateTimeStrict();
        
        Clientes clienteSeleccionado = listaDeClientes.get(comboCliente.getSelectedIndex());
        Servicios servicioSeleccionado = listaDeServicios.get(comboServicio.getSelectedIndex());
        
        Estado estadoInicial = new Estado("000", "Nuevo");
        
        Solicitud nuevaSolicitud = new Solicitud();
        nuevaSolicitud.setId(id);
        nuevaSolicitud.setCliente(clienteSeleccionado.getidCliente());
        nuevaSolicitud.setServicio(servicioSeleccionado.getidServicio());
        nuevaSolicitud.setEstado(estadoInicial.getId());
        nuevaSolicitud.setFechaHora(fechaHora.toString());
        nuevaSolicitud.setObservaciones(observaciones);
        
        XMLSolicitud.guardarSolicitud(nuevaSolicitud, "Data/solicitudes.xml");
        JOptionPane.showMessageDialog(this, "Solicitud guardada exitosamente con el ID: " + id, "Exito", JOptionPane.INFORMATION_MESSAGE);
        this.dispose();

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        CrearNuevoClienteDialog dialogo = new CrearNuevoClienteDialog(
            (Frame) SwingUtilities.getWindowAncestor(this),
            this.xmlCliente,
            this.comboCliente
        );
        dialogo.setVisible(true);
        
        cargarClientes();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CrearSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearSolicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboServicio;
    private com.github.lgooddatepicker.components.DateTimePicker dateChooser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}