package Presentacion;

import Conceptos.Abogados;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Abogado extends javax.swing.JFrame {

    private java.util.List<Conceptos.Abogados> listaAbogados; // Lista de abogados
    private java.util.List<Conceptos.Servicios> listaServicios; // Lista de servicios
    private Util.XMLAbogado xmlAbogado; // Manejo de XML para abogados
    private Conceptos.Abogados abogadoSeleccionado = null; // Abogado seleccionado en la tabla
    private javax.swing.table.DefaultTableModel tablaModelAbogados; // Modelo de la tabla de abogados
    private String archivoAbogados = "Data/abogados.xml"; // Archivo XML de abogados

    public Abogado(java.util.List<Conceptos.Abogados> listaAbogados, java.util.List<Conceptos.Servicios> listaServicios, Util.XMLAbogado xmlAbogado) {
        initComponents(); // Inicializa componentes de la interfaz
        setSize(1024, 768);
        setLocationRelativeTo(null); // Centra la ventana
        setTitle("Abogados");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Maximiza al inicio
        setPreferredSize(new Dimension(1024, 768));
        pack(); // Ajusta el tamaño
        getContentPane().setLayout(null); // Layout manual
        centrarElementos(); // Posiciona los elementos
        addComponentListener(new ComponentAdapter() { // Listener para redimensionamiento
            @Override
            public void componentResized(ComponentEvent e) {
                centrarElementos(); // Re-posiciona al redimensionar
            }
        });
        setVisible(true);
        this.listaAbogados = listaAbogados;
        this.listaServicios = listaServicios;
        this.xmlAbogado = xmlAbogado;

        // Inicializa el modelo de la tabla
        tablaModelAbogados = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Puesto", "Teléfono"} // Columnas de la tabla
        );
        jTable1.setModel(tablaModelAbogados);

        cargarAbogadosEnTabla(); // Carga y muestra los abogados

        // Listener para la selección de filas en la tabla
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int filaSeleccionada = jTable1.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        abogadoSeleccionado = listaAbogados.get(filaSeleccionada);
                        // Llena los campos con el abogado seleccionado
                        jTextField1.setText(abogadoSeleccionado.getidAbogado());
                        jTextField2.setText(abogadoSeleccionado.getPuestoAbogado());
                        jTextField3.setText(abogadoSeleccionado.getNombreAbogado());
                        jTextField4.setText(abogadoSeleccionado.getTelefonoAbogado());
                        jTextField1.setEnabled(false); // ID no editable al seleccionar
                    }
                }
            }
        });

        deshabilitarCampos(); // Deshabilita los campos al inicio
    }

    private void centrarElementos() {
        int ventanaAncho = getContentPane().getWidth();
        int ventanaAlto = getContentPane().getHeight();
        int margen = 20;

        // Posiciona el panel de entrada de datos
        int panelAncho = jPanel1.getPreferredSize().width;
        int panelAlto = jPanel1.getPreferredSize().height;
        int panelX = (ventanaAncho - panelAncho) / 2;
        int panelY = 100;
        jPanel1.setBounds(panelX, panelY, panelAncho, panelAlto);

        // Posiciona la tabla
        int tablaX = margen;
        int tablaY = panelY + panelAlto + margen;
        int tablaAncho = ventanaAncho - 2 * margen;
        int tablaAlto = ventanaAlto - tablaY - 2 * margen - (jButton1.getPreferredSize().height + margen);
        jScrollPane1.setBounds(tablaX, tablaY, tablaAncho, tablaAlto);

        // Posiciona los botones
        int botonAnchoPreferido = 150;
        int botonAltoPreferido = 40;
        int espacioEntreBotones = 10;

        jButton2.setBounds(margen, ventanaAlto - botonAltoPreferido - margen, botonAnchoPreferido, botonAltoPreferido); // Guardar
        jButton1.setBounds(ventanaAncho - botonAnchoPreferido - margen, ventanaAlto - botonAltoPreferido - margen, botonAnchoPreferido, botonAltoPreferido); // Salir
        jButton3.setBounds(margen, tablaY + tablaAlto + margen, botonAnchoPreferido, botonAltoPreferido); // Nuevo
        jButton4.setBounds((ventanaAncho - botonAnchoPreferido) / 2, tablaY + tablaAlto + margen, botonAnchoPreferido, botonAltoPreferido); // Modificar
        jButton5.setBounds(ventanaAncho - botonAnchoPreferido - margen, tablaY + tablaAlto + margen, botonAnchoPreferido, botonAltoPreferido); // Borrar
        verEditarServicios.setBounds(margen + botonAnchoPreferido + espacioEntreBotones, tablaY + tablaAlto + margen, botonAnchoPreferido + 50, botonAltoPreferido); // Ver/Editar Servicios

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void cargarAbogadosEnTabla() {
        listaAbogados = xmlAbogado.cargarAbogados(archivoAbogados, listaServicios);
        tablaModelAbogados.setRowCount(0); // Limpia la tabla
        for (Conceptos.Abogados abogado : listaAbogados) {
            tablaModelAbogados.addRow(new Object[]{
                    abogado.getidAbogado(),
                    abogado.getNombreAbogado(),
                    abogado.getPuestoAbogado(),
                    abogado.getTelefonoAbogado()
            });
        }
    }

    private void deshabilitarCampos() {
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
        jTextField4.setEnabled(false);
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        verEditarServicios = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Puesto", "Teléfono"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        jTextField1.setBackground(new java.awt.Color(255, 255, 204));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Ingresar ID");

        jTextField2.setBackground(new java.awt.Color(255, 255, 204));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setText("Ingresar puesto");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre");

        jTextField3.setBackground(new java.awt.Color(255, 255, 204));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Ingresar nombre");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Teléfono");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Puesto");

        jTextField4.setBackground(new java.awt.Color(255, 255, 204));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setText("Ingresar teléfono");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 255, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        verEditarServicios.setBackground(new java.awt.Color(255, 255, 102));
        verEditarServicios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        verEditarServicios.setText("Servicios");
        verEditarServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEditarServiciosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3)
                    .addComponent(jTextField2)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(326, 326, 326)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verEditarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verEditarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(339, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose(); // cerrar ventana
    }                                        

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void verEditarServiciosActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un abogado primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // obtener el abogado seleccionado de la lista
        Abogados abogadoSeleccionado = listaAbogados.get(filaSeleccionada);

        // abrir el dialog para editar la lista de abogados
        EditarServiciosDialog dialog = new EditarServiciosDialog(
            this,
            abogadoSeleccionado,
            listaServicios,
            xmlAbogado,
            listaAbogados
        );
        dialog.setVisible(true);
    }                                                  

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        limpiarCampos();
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTable1.clearSelection();
        abogadoSeleccionado = null;
    }                                        

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTextField1.setEnabled(false); // ID no se puede editar
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un abogado para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
}
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    int filaSeleccionada = jTable1.getSelectedRow();
    if (filaSeleccionada != -1) {
        abogadoSeleccionado = listaAbogados.get(filaSeleccionada);

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este abogado?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (xmlAbogado.eliminarAbogado(abogadoSeleccionado.getidAbogado())) {
                cargarAbogadosEnTabla();
                limpiarCampos();
                abogadoSeleccionado = null;
                JOptionPane.showMessageDialog(this, "Abogado eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar el abogado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Seleccione un abogado para borrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String id = jTextField1.getText().trim();
        String puesto = jTextField2.getText().trim();
        String nombre = jTextField3.getText().trim();
        String telefono = jTextField4.getText().trim();

        if (id.isEmpty() || puesto.isEmpty() || nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        } // boton de guardar

        ArrayList<Conceptos.Servicios> serviciosSeleccionados = abogadoSeleccionado != null ? abogadoSeleccionado.getListaServiciosAbogado() : new java.util.ArrayList<>();

        Conceptos.Abogados abogadoNuevo = new Conceptos.Abogados(id, nombre, telefono, puesto, serviciosSeleccionados);


        if (abogadoSeleccionado != null) { // modificar abogado existente
            if (xmlAbogado.actualizarAbogado(abogadoNuevo)) {
                cargarAbogadosEnTabla();
                limpiarCampos();
                jTable1.clearSelection();
                abogadoSeleccionado = null;
                deshabilitarCampos();
                JOptionPane.showMessageDialog(this, "Abogado actualizado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar el abogado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { // nuevo abogado
            if (xmlAbogado.agregarAbogado(abogadoNuevo)) {
                cargarAbogadosEnTabla();
                limpiarCampos();
                jTable1.clearSelection();
                deshabilitarCampos();
                JOptionPane.showMessageDialog(this, "Abogado agregado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "El ID del abogado ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
    }                                        

public static void main(String args[]) {
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception ex) {
        java.util.logging.Logger.getLogger(Abogado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            // crear listas vacías de prueba para no dejar el main sin funcionar
            Util.XMLServicio xmlServicio = new Util.XMLServicio();
            java.util.List<Conceptos.Servicios> listaServicios = xmlServicio.cargarServicios("Data/servicios.xml");

            Util.XMLAbogado xmlAbogado = new Util.XMLAbogado();
            java.util.List<Conceptos.Abogados> listaAbogados = xmlAbogado.cargarAbogados("Data/abogados.xml", listaServicios);

            new Abogado(listaAbogados, listaServicios, xmlAbogado).setVisible(true);
        }
    });
}

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton verEditarServicios;
    // End of variables declaration                   
}
