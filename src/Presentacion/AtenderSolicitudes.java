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
import java.awt.Color; // Importamos la clase Color
import javax.swing.JFrame; // Importamos JFrame para usar sus constantes
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class AtenderSolicitudes extends javax.swing.JFrame {
    
    private List<Conceptos.Solicitud> listaSolicitudes;
    private List<Conceptos.Abogados> listaAbogados;
    private List<Conceptos.Servicios> listaServicios;
    private List<Conceptos.Estado> listaEstados;
    private Conceptos.Solicitud solicitudSeleccionada;

    public AtenderSolicitudes() {
        initComponents();
        cargarDatos();        // 1. Primero, cargamos toda la información de los archivos XML.
        configuracionInicial(); // 2. Después, configuramos la interfaz, que ahora sí puede usar los datos cargados.
    }

    private void organizarComponentes() {
    getContentPane().removeAll();
    getContentPane().setLayout(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();

    gbc.insets = new java.awt.Insets(5, 5, 5, 5);

    javax.swing.JPanel panelSuperior = new javax.swing.JPanel(new java.awt.GridBagLayout());
    java.awt.GridBagConstraints gbcSuperior = new java.awt.GridBagConstraints();
    gbcSuperior.insets = new java.awt.Insets(5, 5, 5, 5);
    gbcSuperior.anchor = java.awt.GridBagConstraints.WEST;

    gbcSuperior.gridy = 0;
    gbcSuperior.gridx = 0; panelSuperior.add(jLabelIDServicio, gbcSuperior);
    gbcSuperior.gridx = 2; panelSuperior.add(jLabelID, gbcSuperior);

    gbcSuperior.gridy = 1;
    gbcSuperior.gridx = 0; panelSuperior.add(jLabelServicio, gbcSuperior);
    gbcSuperior.gridx = 2; panelSuperior.add(jLabelFechaHora, gbcSuperior);

    gbcSuperior.gridy = 2;
    gbcSuperior.gridx = 0; panelSuperior.add(jLabelAbogado, gbcSuperior);
    gbcSuperior.gridx = 2; panelSuperior.add(jLabelEstado, gbcSuperior);

    gbcSuperior.fill = java.awt.GridBagConstraints.HORIZONTAL;
    gbcSuperior.weightx = 1.0;

    gbcSuperior.gridy = 0;
    gbcSuperior.gridx = 1; panelSuperior.add(comboIDServicio, gbcSuperior);
    gbcSuperior.gridx = 3; panelSuperior.add(jTextFieldID, gbcSuperior);

    gbcSuperior.gridy = 1;
    gbcSuperior.gridx = 1; panelSuperior.add(comboServicio, gbcSuperior);
    gbcSuperior.gridx = 3; panelSuperior.add(dateChooser, gbcSuperior);

    gbcSuperior.gridy = 2;
    gbcSuperior.gridx = 1; panelSuperior.add(comboAbogado, gbcSuperior);
    gbcSuperior.gridx = 3; panelSuperior.add(comboEstado, gbcSuperior);

    gbc.gridy = 0;
    gbc.gridx = 0;
    gbc.weightx = 1.0;
    gbc.anchor = java.awt.GridBagConstraints.NORTH;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
    getContentPane().add(panelSuperior, gbc);

    gbc.gridy = 1;
    gbc.anchor = java.awt.GridBagConstraints.WEST;
    gbc.fill = java.awt.GridBagConstraints.NONE;
    getContentPane().add(jLabelObservaciones, gbc);

    gbc.gridy = 2;
    gbc.weighty = 0.4;
    gbc.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(new javax.swing.JScrollPane(jTextAreaObservaciones), gbc);
    
    javax.swing.JPanel panelOtrosServiciosHeader = new javax.swing.JPanel(new java.awt.BorderLayout());
    panelOtrosServiciosHeader.add(jLabelOtrosServicios, java.awt.BorderLayout.WEST);
    javax.swing.JPanel panelBotonesMasMenos = new javax.swing.JPanel(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
    panelBotonesMasMenos.add(btnAgregarServicio);
    panelBotonesMasMenos.add(btnEliminarServicio);
    panelOtrosServiciosHeader.add(panelBotonesMasMenos, java.awt.BorderLayout.EAST);
    
    gbc.gridy = 3;
    gbc.weighty = 0;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
    getContentPane().add(panelOtrosServiciosHeader, gbc);

    gbc.gridy = 4;
    gbc.weighty = 0.6;
    gbc.fill = java.awt.GridBagConstraints.BOTH;
    getContentPane().add(jScrollPaneOtrosServicios, gbc);

    javax.swing.JPanel panelBotonesInferiores = new javax.swing.JPanel(new java.awt.BorderLayout(10, 10));
    panelBotonesInferiores.add(jButtonSalvar, java.awt.BorderLayout.WEST);
    panelBotonesInferiores.add(jButtonCancelar, java.awt.BorderLayout.EAST);

    gbc.gridy = 5;
    gbc.weighty = 0;
    gbc.fill = java.awt.GridBagConstraints.HORIZONTAL;
    getContentPane().add(panelBotonesInferiores, gbc);

    getContentPane().revalidate();
    getContentPane().repaint();
}
    
    private void configuracionInicial() {
        // --- INICIO DE MODIFICACIÓN 1: TAMAÑO Y ESTADO DE LA VENTANA ---
        // 1. Se establece el tamaño que tendrá la ventana en su estado "normal".
        this.setSize(1024, 768);
        
        // 2. Se le dice que inicie maximizada, ocupando toda la pantalla.
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        // 3. Cuando se restaure a su estado normal, se centrará.
        this.setLocationRelativeTo(null);
        // --- FIN DE MODIFICACIÓN 1 ---

        organizarComponentes();

        RenderizadorCeldasNegrita renderizador = new RenderizadorCeldasNegrita();
        for (int i = 0; i < jTableOtrosServicios.getColumnCount(); i++) {
            jTableOtrosServicios.getColumnModel().getColumn(i).setCellRenderer(renderizador);
        }

        // Aseguramos que los botones de la tabla tengan el texto correcto
        btnAgregarServicio.setText("+");
        btnEliminarServicio.setText("-");
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

    private void cargarDatosDeSolicitud(String idSeleccionado) {
        if (idSeleccionado == null) {
            return;
        }

        this.solicitudSeleccionada = listaSolicitudes.stream()
                .filter(s -> s.getId().equals(idSeleccionado))
                .findFirst()
                .orElse(null);

        if (this.solicitudSeleccionada != null) {
            jTextFieldID.setText(solicitudSeleccionada.getCliente());

            String fechaTexto = solicitudSeleccionada.getFechaHora();
            if (fechaTexto != null && !fechaTexto.trim().isEmpty()) {
                try {
                    dateChooser.setDateTimePermissive(java.time.LocalDateTime.parse(fechaTexto));
                } catch (Exception e) {
                    dateChooser.clear();
                    System.err.println("Error al parsear la fecha: " + fechaTexto);
                }
            } else {
                dateChooser.clear();
            }

            jTextAreaObservaciones.setText(solicitudSeleccionada.getObservaciones());

            listaServicios.stream()
                    .filter(s -> s.getidServicio().equals(solicitudSeleccionada.getServicio()))
                    .findFirst()
                    .ifPresent(s -> comboServicio.setSelectedItem(s.getNombreServicio()));

            listaEstados.stream()
                    .filter(e -> e.getId().equals(solicitudSeleccionada.getEstado()))
                    .findFirst()
                    .ifPresent(e -> comboEstado.setSelectedItem(e.getNombre()));

            String abogadoId = solicitudSeleccionada.getAbogado();
            if (abogadoId != null && !abogadoId.trim().isEmpty()) {
                listaAbogados.stream()
                        .filter(a -> a.getidAbogado().equals(abogadoId))
                        .findFirst()
                        .ifPresent(a -> comboAbogado.setSelectedItem(a.getNombreAbogado()));
            } else {
                comboAbogado.setSelectedIndex(-1);
            }

            jTextFieldID.setEditable(false);
            dateChooser.setEnabled(false);
            comboServicio.setEnabled(false);

            jTextAreaObservaciones.setEditable(true);
            comboAbogado.setEnabled(true);
            comboEstado.setEnabled(true);
            jButtonSalvar.setEnabled(true);
            btnAgregarServicio.setEnabled(true);
            btnEliminarServicio.setEnabled(true);

            actualizarTablaOtrosServicios();

        } else {
            // Limpia y deshabilita si no se encuentra la solicitud
            jTextFieldID.setText("");
            dateChooser.clear();
            jTextAreaObservaciones.setText("");
            comboServicio.setSelectedIndex(-1);
            comboEstado.setSelectedIndex(-1);
            comboAbogado.setSelectedIndex(-1);

            jTextAreaObservaciones.setEditable(false);
            comboAbogado.setEnabled(false);
            comboEstado.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            btnAgregarServicio.setEnabled(false);
            btnEliminarServicio.setEnabled(false);
        }
    }

    // --- INICIO DE MODIFICACIÓN 2: RENDERIZADOR DE CELDAS ---
    class RenderizadorCeldasNegrita extends javax.swing.table.DefaultTableCellRenderer {
        
        private final Color COLOR_VERDE_CLARO = new Color(153, 255, 153);

        @Override
        public java.awt.Component getTableCellRendererComponent(javax.swing.JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

            // Se llama al método padre para que maneje las propiedades por defecto (colores de selección, etc.)
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (solicitudSeleccionada == null || solicitudSeleccionada.getOtrosServicios() == null) {
                // Si no hay solicitud, se usa la fuente normal
                setFont(getFont().deriveFont(java.awt.Font.PLAIN));
                return this;
            }

            // Se obtiene el servicio correspondiente a la fila que se está pintando
            Servicios servicioDeFila = listaServicios.get(row);

            // Se comprueba si el servicio de esta fila está en la lista de servicios adicionales de la solicitud
            boolean esServicioAdicional = solicitudSeleccionada.getOtrosServicios().stream()
                    .anyMatch(id -> id.equals(servicioDeFila.getidServicio()));

            // Se aplican los estilos basados en la condición
            if (esServicioAdicional) {
                setFont(getFont().deriveFont(java.awt.Font.BOLD));
                // Si la celda no está seleccionada, se pinta de verde. Si está seleccionada, se mantiene el color de selección.
                if (!isSelected) {
                    setBackground(COLOR_VERDE_CLARO);
                }
            } else {
                // Si no es un servicio adicional, se asegura de que la fuente sea normal y el fondo el por defecto.
                setFont(getFont().deriveFont(java.awt.Font.PLAIN));
                 if (!isSelected) {
                    setBackground(table.getBackground());
                }
            }

            return this;
        }
    }
    // --- FIN DE MODIFICACIÓN 2 ---
        
    private void actualizarTablaOtrosServicios() {
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTableOtrosServicios.getModel();
    model.setRowCount(0);

    if (listaServicios != null) {
        for (Servicios s : listaServicios) {
            // CORRECCIÓN: La primera columna ahora es el ID del servicio.
            model.addRow(new Object[]{s.getidServicio(), s.getNombreServicio(), s.getPrecioServicio()});
        }
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
        dateChooser = new com.github.lgooddatepicker.components.DateTimePicker(
            new com.github.lgooddatepicker.components.DatePickerSettings(new java.util.Locale("es")), 
            new com.github.lgooddatepicker.components.TimePickerSettings(new java.util.Locale("es"))
        );
        jLabelEstado = new javax.swing.JLabel();
        jTextAreaObservaciones = new javax.swing.JTextArea();
        comboEstado = new javax.swing.JComboBox<>();
        jLabelServicio = new javax.swing.JLabel();
        comboServicio = new javax.swing.JComboBox<>();
        jLabelAbogado = new javax.swing.JLabel();
        comboAbogado = new javax.swing.JComboBox<>();
        jLabelOtrosServicios = new javax.swing.JLabel();
        jLabelObservaciones = new javax.swing.JLabel();
        btnEliminarServicio = new javax.swing.JButton();
        btnAgregarServicio = new javax.swing.JButton();
        jScrollPaneOtrosServicios = new javax.swing.JScrollPane();
        jTableOtrosServicios = new javax.swing.JTable();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atender Solicitud de Servicio");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabelID.setText("ID");
        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 493, 0, 0);
        getContentPane().add(jLabelID, gridBagConstraints);

        jTextFieldID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jLabelIDServicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 7, 0, 0);
        getContentPane().add(jLabelIDServicio, gridBagConstraints);

        comboIDServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jLabelFechaHora.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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

        comboEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jLabelServicio.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 6, 0, 0);
        getContentPane().add(jLabelServicio, gridBagConstraints);

        comboServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jLabelAbogado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(36, 6, 0, 0);
        getContentPane().add(jLabelAbogado, gridBagConstraints);

        comboAbogado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        jLabelOtrosServicios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(27, 6, 0, 0);
        getContentPane().add(jLabelOtrosServicios, gridBagConstraints);

        jLabelObservaciones.setText("Observaciones");
        jLabelObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(54, 16, 0, 0);
        getContentPane().add(jLabelObservaciones, gridBagConstraints);

        btnEliminarServicio.setText("-");
        btnEliminarServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEliminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarServicioActionPerformed(evt);
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
        getContentPane().add(btnEliminarServicio, gridBagConstraints);

        btnAgregarServicio.setText("+");
        btnAgregarServicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnAgregarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarServicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 22;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 72, 0, 0);
        getContentPane().add(btnAgregarServicio, gridBagConstraints);

        jTableOtrosServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Servicio"
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
        jButtonCancelar.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
        jButtonSalvar.setBackground(new java.awt.Color(204, 255, 153));
        jButtonSalvar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void btnEliminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarServicioActionPerformed
        int filaSeleccionada = jTableOtrosServicios.getSelectedRow();

        if (solicitudSeleccionada == null || filaSeleccionada == -1) {
            return;
        }
        if (solicitudSeleccionada.getOtrosServicios() == null) {
            return;
        }

        Servicios servicioParaEliminar = listaServicios.get(filaSeleccionada);

        boolean fueEliminado = solicitudSeleccionada.getOtrosServicios().remove(servicioParaEliminar.getidServicio());

        if (fueEliminado) {
            jTableOtrosServicios.repaint();
        }
    }//GEN-LAST:event_btnEliminarServicioActionPerformed

    private void comboIDServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboIDServicioActionPerformed
        if (comboIDServicio.getSelectedIndex() != -1) {
            String idSeleccionado = (String) comboIDServicio.getSelectedItem();
            cargarDatosDeSolicitud(idSeleccionado);
        }
    }//GEN-LAST:event_comboIDServicioActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if (solicitudSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "No hay ninguna solicitud seleccionada para guardar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombreAbogado = (String) comboAbogado.getSelectedItem();
        String nombreEstado = (String) comboEstado.getSelectedItem();
        String nuevasObservaciones = jTextAreaObservaciones.getText();

        if (nombreAbogado == null || nombreEstado == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un abogado y un estado para la solicitud.", "Datos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nuevoAbogadoId = listaAbogados.stream()
                .filter(a -> a.getNombreAbogado().equals(nombreAbogado))
                .map(Abogados::getidAbogado).findFirst().orElse("");
        solicitudSeleccionada.setAbogado(nuevoAbogadoId);

        String nuevoEstadoId = listaEstados.stream()
                .filter(e -> e.getNombre().equals(nombreEstado))
                .map(Estado::getId).findFirst().orElse("000");
        solicitudSeleccionada.setEstado(nuevoEstadoId);

        solicitudSeleccionada.setObservaciones(nuevasObservaciones);

        Conceptos.Atender.actualizarYGuardar(listaSolicitudes, solicitudSeleccionada, "Data/solicitudes.xml");

        JOptionPane.showMessageDialog(this, "Solicitud actualizada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        this.dispose();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void btnAgregarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarServicioActionPerformed
        int filaSeleccionada = jTableOtrosServicios.getSelectedRow();

        if (solicitudSeleccionada == null || filaSeleccionada == -1) {
            return;
        }

        Servicios servicioParaAgregar = listaServicios.get(filaSeleccionada);

        if (solicitudSeleccionada.getOtrosServicios() == null) {
            solicitudSeleccionada.setOtrosServicios(new ArrayList<>());
        }

        boolean yaExiste = solicitudSeleccionada.getOtrosServicios().stream()
                .anyMatch(id -> id.equals(servicioParaAgregar.getidServicio()));

        if (!yaExiste) {
            solicitudSeleccionada.getOtrosServicios().add(servicioParaAgregar.getidServicio());
            jTableOtrosServicios.repaint();
        }
    }//GEN-LAST:event_btnAgregarServicioActionPerformed

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
    private javax.swing.JButton btnAgregarServicio;
    private javax.swing.JButton btnEliminarServicio;
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