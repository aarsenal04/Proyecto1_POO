package Presentacion;

import Conceptos.Abogados;
import Conceptos.Clientes;
import Conceptos.Servicios;
import Conceptos.Solicitud;
import Util.XMLAbogado;
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

public class ConsultarSolicitudes extends javax.swing.JFrame {

    // --- Atributos de la clase ---
    private List<Solicitud> listaCompletaSolicitudes; // Lista completa de solicitudes en memoria
    private DefaultTableModel modeloTabla; // Modelo para la tabla de resultados
    private XMLSolicitud xmlSolicitudes; // Manejador para el archivo XML de solicitudes
    private XMLServicio xmlServicios; // Manejador para el archivo XML de servicios
    private XMLCliente xmlClientes; // Manejador para el archivo XML de clientes
    private Util.XMLEstado xmlEstados; // Manejador para el archivo XML de estados

    // Constructor de la ventana de consulta de solicitudes
    public ConsultarSolicitudes() {
        initComponents();
        organizarComponentes();
        inicializarLogica();
    }

    // Organizar y distribuir los componentes en la ventana
    private void organizarComponentes() {
        javax.swing.JPanel panelFiltros = new javax.swing.JPanel(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

        gbc.insets = new java.awt.Insets(5, 8, 5, 8);
        gbc.anchor = java.awt.GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.weightx = 0.1; panelFiltros.add(new javax.swing.JLabel(), gbc);
        gbc.weightx = 0;

        gbc.gridy = 0; gbc.gridx = 1; gbc.gridwidth = 4;
        gbc.anchor = java.awt.GridBagConstraints.CENTER;
        panelFiltros.add(jLabel10, gbc);
        gbc.gridwidth = 1; gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.gridy = 1; gbc.gridx = 1; panelFiltros.add(jLabel6, gbc);
        gbc.gridx = 3; panelFiltros.add(jLabel11, gbc);
        gbc.gridy = 2; gbc.gridx = 1; panelFiltros.add(jLabel7, gbc);
        gbc.gridx = 3; panelFiltros.add(jLabel8, gbc);

        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridy = 1; gbc.gridx = 2; panelFiltros.add(txtID, gbc);
        gbc.gridx = 4; panelFiltros.add(txtNombre, gbc);
        gbc.gridy = 2; gbc.gridx = 2; panelFiltros.add(txtEmail, gbc);
        gbc.gridx = 4; panelFiltros.add(txtTelefono, gbc);
        gbc.weightx = 0; gbc.fill = java.awt.GridBagConstraints.NONE;

        gbc.anchor = java.awt.GridBagConstraints.EAST;
        gbc.gridy = 0; gbc.gridx = 6; panelFiltros.add(jLabel9, gbc);
        gbc.gridy = 1; gbc.gridx = 6; panelFiltros.add(jLabel12, gbc);
        
        gbc.anchor = java.awt.GridBagConstraints.WEST;
        gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridy = 0; gbc.gridx = 7; panelFiltros.add(comboEspecialidad, gbc);
        gbc.gridy = 1; gbc.gridx = 7; panelFiltros.add(datePicker1, gbc);
        gbc.weightx = 0; gbc.fill = java.awt.GridBagConstraints.NONE;

        gbc.gridx = 8; gbc.gridy = 0; gbc.gridheight = 2;
        gbc.fill = java.awt.GridBagConstraints.VERTICAL;
        panelFiltros.add(btnBuscar, gbc);
        gbc.gridheight = 1; gbc.fill = java.awt.GridBagConstraints.NONE;

        gbc.gridx = 9; gbc.weightx = 0.1; panelFiltros.add(new javax.swing.JLabel(), gbc);
        gbc.weightx = 0;

        jPanel6.removeAll();
        jPanel6.setLayout(new java.awt.GridBagLayout());
        java.awt.GridBagConstraints gbcMain = new java.awt.GridBagConstraints();

        gbcMain.gridy = 0; gbcMain.gridx = 0; gbcMain.weightx = 1.0;
        gbcMain.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gbcMain.anchor = java.awt.GridBagConstraints.NORTH;
        gbcMain.insets = new java.awt.Insets(20, 10, 10, 10);
        jPanel6.add(panelFiltros, gbcMain);

        gbcMain.gridy = 1; gbcMain.weighty = 1.0;
        gbcMain.fill = java.awt.GridBagConstraints.BOTH;
        gbcMain.insets = new java.awt.Insets(0, 10, 0, 10);
        jPanel6.add(jScrollPane1, gbcMain);

        gbcMain.gridy = 2; gbcMain.weighty = 0;
        gbcMain.fill = java.awt.GridBagConstraints.NONE;
        gbcMain.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gbcMain.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel6.add(salirBoton1, gbcMain);
    }

    // Inicializar manejadores XML, configurar ventana y cargar datos iniciales
    private void inicializarLogica() {
        this.xmlSolicitudes = new XMLSolicitud();
        this.xmlServicios = new XMLServicio();
        this.xmlClientes = new XMLCliente();
        this.xmlEstados = new XMLEstado();

        this.setTitle("Consultar Solicitudes de Servicio");
        this.setSize(1024, 768);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.modeloTabla = (DefaultTableModel) jTable1.getModel();

        cargarEspecialidades();
        cargarDatosIniciales();

        salirBoton1.addActionListener(e -> this.dispose());
    }

    // Cargar las especialidades de servicios en el ComboBox
    private void cargarEspecialidades() {
        comboEspecialidad.removeAllItems();
        List<Servicios> servicios = xmlServicios.cargarServicios("Data/servicios.xml");
        for (Servicios s : servicios) {
            comboEspecialidad.addItem(s.getNombreServicio());
        }
        comboEspecialidad.setSelectedIndex(-1);
    }

    // Cargar todas las solicitudes y mostrarlas en la tabla
    private void cargarDatosIniciales() {
        List<Clientes> todosLosClientes = xmlClientes.cargarClientes("Data/clientes.xml");
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");
        this.listaCompletaSolicitudes = xmlSolicitudes.cargarSolicitudes("Data/solicitudes.xml", todosLosClientes, todosLosServicios);
        actualizarTabla(this.listaCompletaSolicitudes);
    }

    // Refrescar la tabla con una lista de solicitudes
    private void actualizarTabla(List<Solicitud> solicitudesAMostrar) {
        modeloTabla.setRowCount(0);
        if (solicitudesAMostrar == null) return;

        // Definir formato de fecha para la tabla
        java.time.format.DateTimeFormatter formatoSalida =
                java.time.format.DateTimeFormatter.ofPattern("d 'de' MMMM 'de' uuuu, HH:mm 'h'", new java.util.Locale("es", "ES"));

        // Cargar datos necesarios para obtener nombres
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");
        List<Conceptos.Estado> todosLosEstados = xmlEstados.cargarEstados("Data/estados.xml");
        List<Abogados> todosLosAbogados = new XMLAbogado().cargarAbogados("Data/abogados.xml", todosLosServicios);

        for (Solicitud s : solicitudesAMostrar) {
            // Buscar nombre del servicio por ID
            String nombreServicio = todosLosServicios.stream()
                    .filter(serv -> serv.getidServicio().equals(s.getServicio()))
                    .map(Servicios::getNombreServicio)
                    .findFirst().orElse("N/A");

            // Buscar nombre del estado por ID
            String nombreEstado = todosLosEstados.stream()
                    .filter(est -> est.getId().equals(s.getEstado()))
                    .map(Conceptos.Estado::getNombre)
                    .findFirst().orElse("N/A");

            // Buscar nombre del abogado por ID, o mostrar "No asignado"
            String abogadoId = s.getAbogado();
            String nombreAbogado;
            if (abogadoId == null || abogadoId.trim().isEmpty()) {
                nombreAbogado = "No asignado";
            } else {
                nombreAbogado = todosLosAbogados.stream()
                        .filter(a -> a.getidAbogado().equals(abogadoId))
                        .map(Abogados::getNombreAbogado)
                        .findFirst()
                        .orElse("ID Abogado no encontrado");
            }

            // Formatear la fecha para visualización
            String fechaFormateada = "Fecha inválida";
            try {
                java.time.LocalDateTime fechaHora = java.time.LocalDateTime.parse(s.getFechaHora());
                fechaFormateada = fechaHora.format(formatoSalida);
            } catch (Exception e) {
                System.err.println("No se pudo parsear la fecha: " + s.getFechaHora());
            }
            
            // Añadir fila a la tabla
            Object[] fila = new Object[5];
            fila[0] = s.getId();
            fila[1] = nombreAbogado;
            fila[2] = fechaFormateada;
            fila[3] = nombreServicio;
            fila[4] = nombreEstado;
            modeloTabla.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        salirBoton1 = new javax.swing.JButton();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker(
            new com.github.lgooddatepicker.components.DatePickerSettings(new java.util.Locale("es"))
        );
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar Solicitudes de Servicio");

        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("ID");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        jPanel6.add(jLabel6, gridBagConstraints);

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel6.add(txtID, gridBagConstraints);

        jLabel7.setText("Email");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 84, 0, 0);
        jPanel6.add(jLabel7, gridBagConstraints);

        jLabel8.setText("Teléfono");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 52, 0, 0);
        jPanel6.add(jLabel8, gridBagConstraints);

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 28;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        jPanel6.add(txtTelefono, gridBagConstraints);

        btnBuscar.setText("Buscar");
        btnBuscar.setBackground(new java.awt.Color(204, 255, 153));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 12, 0, 0);
        jPanel6.add(btnBuscar, gridBagConstraints);

        jLabel10.setText("Filtros con datos del Cliente");
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 108, 0, 0);
        jPanel6.add(jLabel10, gridBagConstraints);

        jLabel9.setText("Servicios");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 18, 0, 0);
        jPanel6.add(jLabel9, gridBagConstraints);

        comboEspecialidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 246;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 12, 0, 0);
        jPanel6.add(comboEspecialidad, gridBagConstraints);

        jLabel12.setText("Fecha");
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 16;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 18, 0, 0);
        jPanel6.add(jLabel12, gridBagConstraints);

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
                "ID", "Abogado a cargo", "Fecha / Hora", "Servicio", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 29;
        gridBagConstraints.gridwidth = 27;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 996;
        gridBagConstraints.ipady = 497;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(16, 0, 0, 0);
        jPanel6.add(jScrollPane1, gridBagConstraints);

        salirBoton1.setText("Salir");
        salirBoton1.setBackground(new java.awt.Color(255, 102, 102));
        salirBoton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 25;
        gridBagConstraints.gridy = 30;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 47, 15, 0);
        jPanel6.add(salirBoton1, gridBagConstraints);

        datePicker1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 24;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 129;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 29, 0, 0);
        jPanel6.add(datePicker1, gridBagConstraints);

        jLabel11.setText("Nombre");
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 30, 0, 0);
        jPanel6.add(jLabel11, gridBagConstraints);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 18, 0, 0);
        jPanel6.add(txtNombre, gridBagConstraints);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.ipadx = 73;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 6, 0, 0);
        jPanel6.add(txtEmail, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 1173, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    }//GEN-LAST:event_txtNombreActionPerformed

    // Acción del botón Buscar para filtrar las solicitudes
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String idCliente = txtID.getText().trim();
        String nombreCliente = txtNombre.getText().trim().toLowerCase();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim().toLowerCase();
        Object especialidadSeleccionada = comboEspecialidad.getSelectedItem();
        LocalDate fechaSeleccionada = datePicker1.getDate();

        List<Clientes> todosLosClientes = xmlClientes.cargarClientes("Data/clientes.xml");
        List<Servicios> todosLosServicios = xmlServicios.cargarServicios("Data/servicios.xml");
        List<Solicitud> resultados = new ArrayList<>();

        for (Solicitud solicitud : listaCompletaSolicitudes) {
            boolean pasaFiltro = true;

            Clientes clienteDeSolicitud = todosLosClientes.stream()
                    .filter(c -> c.getidCliente().equals(solicitud.getCliente()))
                    .findFirst().orElse(null);
            Servicios servicioDeSolicitud = todosLosServicios.stream()
                    .filter(s -> s.getidServicio().equals(solicitud.getServicio()))
                    .findFirst().orElse(null);

            if (clienteDeSolicitud == null || servicioDeSolicitud == null) continue;
            
            if (pasaFiltro && !idCliente.isEmpty() && !clienteDeSolicitud.getidCliente().contains(idCliente)) pasaFiltro = false;
            if (pasaFiltro && !nombreCliente.isEmpty() && !clienteDeSolicitud.getNombreCliente().toLowerCase().contains(nombreCliente)) pasaFiltro = false;
            if (pasaFiltro && !telefono.isEmpty() && !clienteDeSolicitud.getTelefonoCliente().contains(telefono)) pasaFiltro = false;
            if (pasaFiltro && !email.isEmpty() && !clienteDeSolicitud.getEmailCliente().toLowerCase().contains(email)) pasaFiltro = false;
            if (pasaFiltro && especialidadSeleccionada != null) {
                if (!servicioDeSolicitud.getNombreServicio().equals(especialidadSeleccionada.toString())) pasaFiltro = false;
            }
            if (pasaFiltro && fechaSeleccionada != null) {
                try {
                    LocalDate fechaSolicitud = LocalDate.parse(solicitud.getFechaHora().substring(0, 10));
                    if (!fechaSolicitud.equals(fechaSeleccionada)) pasaFiltro = false;
                } catch (Exception e) {
                    pasaFiltro = false;
                }
            }

            if (pasaFiltro) {
                resultados.add(solicitud);
            }
        }

        boolean hayFiltroDeTexto = !idCliente.isEmpty() || !nombreCliente.isEmpty() || !telefono.isEmpty() || !email.isEmpty();
        if (resultados.isEmpty() && (hayFiltroDeTexto || especialidadSeleccionada != null || fechaSeleccionada != null)) {
            JOptionPane.showMessageDialog(this, "No se encontraron solicitudes que coincidan con los filtros aplicados.", "Búsqueda sin Resultados", JOptionPane.INFORMATION_MESSAGE);
        }

        actualizarTabla(resultados);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
    }//GEN-LAST:event_txtIDActionPerformed

    // Método principal para ejecución independiente de la ventana
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
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Lanzar la interfaz de usuario
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarSolicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> comboEspecialidad;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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