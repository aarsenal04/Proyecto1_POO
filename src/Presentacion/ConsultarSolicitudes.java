package Presentacion;

import Conceptos.Clientes;
import Conceptos.Servicios;
import Conceptos.Solicitud;
import Util.XMLCliente;
import Util.XMLServicio;
import Util.XMLSolicitud;
import Util.XMLEstado;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.List;

public class ConsultarSolicitudes extends javax.swing.JDialog {

    private List<Solicitud> listaCompletaSolicitudes;
    private DefaultTableModel modeloTabla;
    private XMLSolicitud xmlSolicitudes;
    private XMLServicio xmlServicios;
    private XMLCliente xmlClientes;
    private Util.XMLEstado xmlEstados;

    public ConsultarSolicitudes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        inicializarLogica();
    }
    
    private void inicializarLogica() {
        this.xmlSolicitudes = new XMLSolicitud();
        this.xmlServicios = new XMLServicio();
        this.xmlClientes = new XMLCliente();
        this.xmlEstados = new XMLEstado();
        
        this.setLocationRelativeTo(getParent());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.modeloTabla = (DefaultTableModel) jTable1.getModel();
        
        cargarEspecialidades();
        cargarDatosIniciales();
        
        salirBoton1.addActionListener(e -> this.dispose());
    }

    private void cargarEspecialidades() {
        comboEspecialidad.removeAllItems();
        comboEspecialidad.addItem("Todos"); // Opción por defecto
        
        List<Servicios> servicios = xmlServicios.cargarServicios("Data/servicios.xml");
        for (Servicios s : servicios) {
            comboEspecialidad.addItem(s.getNombreServicio());
        }
    }
    
    private void cargarDatosIniciales() {
        List<Clientes> todosLosClientes = xmlClientes.cargarClientes("Data/clientes.xml");
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");

        this.listaCompletaSolicitudes = xmlSolicitudes.cargarSolicitudes("Data/solicitudes.xml", todosLosClientes, todosLosServicios);
        
        actualizarTabla(this.listaCompletaSolicitudes);
    }
    
    /**
     * Recibe una lista de solicitudes y refresca la JTable para mostrarlas.
     */
    private void actualizarTabla(List<Solicitud> solicitudesAMostrar) {
        modeloTabla.setRowCount(0); // Limpia la tabla

        if (solicitudesAMostrar == null) return;

        List<Clientes> todosLosClientes = xmlClientes.cargarClientes("Data/clientes.xml");
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");
        List<Conceptos.Estado> todosLosEstados = xmlEstados.cargarEstados("Data/estados.xml");

        for (Solicitud s : solicitudesAMostrar) {
            String nombreCliente = todosLosClientes.stream()
                .filter(c -> c.getidCliente().equals(s.getCliente()))
                .map(Clientes::getNombreCliente)
                .findFirst().orElse("N/A");

            String nombreServicio = todosLosServicios.stream()
                .filter(serv -> serv.getidServicio().equals(s.getServicio()))
                .map(Servicios::getNombreServicio)
                .findFirst().orElse("N/A");

            String nombreEstado = todosLosEstados.stream()
                    .filter(est -> est.getId().equals(s.getEstado()))
                    .map(Conceptos.Estado::getNombre)
                    .findFirst().orElse("N/A");

            Object[] fila = new Object[5];
            fila[0] = s.getId();
            fila[1] = nombreCliente;
            fila[2] = s.getFechaHora();
            fila[3] = nombreServicio;
            fila[4] = nombreEstado;

            modeloTabla.addRow(fila);
        }
    }

@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comboEspecialidad = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        salirBoton1 = new javax.swing.JButton();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Solicitudes de Servicio");

        jLabel6.setText("ID");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel7.setText("Email");

        jLabel8.setText("Teléfono");

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Cliente");

        jLabel9.setText("Servicios");

        jLabel12.setText("Fechas");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setText("Desde");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setText("Hasta");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Fecha", "Servicio", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        salirBoton1.setBackground(new java.awt.Color(51, 153, 255));
        salirBoton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        salirBoton1.setText("Salir");

        jLabel11.setText("Nombre");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addContainerGap(13, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(29, 29, 29)
                                                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(salirBoton1)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(comboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel14)
                                            .addComponent(datePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salirBoton1)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idCliente = txtID.getText().trim();
        String nombreCliente = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();
        String especialidad = comboEspecialidad.getSelectedItem().toString();
        LocalDate fechaDesde = datePicker1.getDate();
        LocalDate fechaHasta = datePicker2.getDate();
        
        boolean hayFiltroActivo = !idCliente.isEmpty() || !nombreCliente.isEmpty() || !telefono.isEmpty() || !email.isEmpty() ||
                                  !especialidad.equals("Todos") || fechaDesde != null || fechaHasta != null;

        List<Solicitud> resultados = new ArrayList<>();
        
        if (listaCompletaSolicitudes == null) {
            JOptionPane.showMessageDialog(this, "No hay datos de solicitudes para filtrar.", "Datos no cargados", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        List<Clientes> todosLosClientes = xmlClientes.cargarClientes("Data/clientes.xml");
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");
        
        for (Solicitud solicitud : listaCompletaSolicitudes) {
            boolean pasaFiltro = true;

            // buscar cliente real desde su ID
            Clientes clienteReal = todosLosClientes.stream()
                .filter(c -> c.getidCliente().equals(solicitud.getCliente()))
                .findFirst()
                .orElse(null);

            // buscar servicio real desde su ID
            Servicios servicioReal = todosLosServicios.stream()
                .filter(s -> s.getidServicio().equals(solicitud.getServicio()))
                .findFirst()
                .orElse(null);

            if (pasaFiltro && !idCliente.isEmpty() && (clienteReal == null || !clienteReal.getidCliente().contains(idCliente))) {
                pasaFiltro = false;
            }
            if (pasaFiltro && !nombreCliente.isEmpty() && (clienteReal == null || !clienteReal.getNombreCliente().toLowerCase().contains(nombreCliente.toLowerCase()))) {
                pasaFiltro = false;
            }
            if (pasaFiltro && !telefono.isEmpty() && (clienteReal == null || !clienteReal.getTelefonoCliente().contains(telefono))) {
                pasaFiltro = false;
            }
            if (pasaFiltro && !email.isEmpty() && (clienteReal == null || !clienteReal.getEmailCliente().contains(email))) {
                pasaFiltro = false;
            }
            if (pasaFiltro && !especialidad.equals("Todos") && (servicioReal == null || !servicioReal.getNombreServicio().equals(especialidad))) {
                pasaFiltro = false;
            }

            // filtro por fecha
            if (pasaFiltro && (fechaDesde != null || fechaHasta != null)) {
                try {
                    LocalDate fechaSolicitud = LocalDate.parse(solicitud.getFechaHora().substring(0, 10));
                    if (fechaDesde != null && fechaSolicitud.isBefore(fechaDesde)) {
                        pasaFiltro = false;
                    }
                    if (pasaFiltro && fechaHasta != null && fechaSolicitud.isAfter(fechaHasta)) {
                        pasaFiltro = false;
                    }
                } catch (Exception ex) {
                    pasaFiltro = false;
                }
            }

            if (pasaFiltro) {
                resultados.add(solicitud);
            }
        }
        
        if (resultados.isEmpty() && hayFiltroActivo) {
            JOptionPane.showMessageDialog(this, "No se encontraron coincidencias para los filtros aplicados.", "Búsqueda sin Resultados", JOptionPane.INFORMATION_MESSAGE);
            actualizarTabla(listaCompletaSolicitudes);
        } else {
            actualizarTabla(resultados);
        }       
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed

    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed


    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarSolicitudes(null, false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> comboEspecialidad;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton salirBoton1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
