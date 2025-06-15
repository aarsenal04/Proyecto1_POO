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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        verEditarServicios = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        jButton1.setBackground(new java.awt.Color(204, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID");

        jTextField1.setBackground(new java.awt.Color(204, 255, 153));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setText("Ingresar ID");

        jTextField2.setBackground(new java.awt.Color(204, 255, 153));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.setText("Ingresar puesto");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(51, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jTextField3.setBackground(new java.awt.Color(204, 255, 153));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.setText("Ingresar nombre");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(51, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Teléfono");

        jLabel2.setBackground(new java.awt.Color(51, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Puesto");

        jTextField4.setBackground(new java.awt.Color(204, 255, 153));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 0));
        jTextField4.setText("Ingresar teléfono");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        verEditarServicios.setBackground(new java.awt.Color(204, 255, 153));
        verEditarServicios.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        verEditarServicios.setForeground(new java.awt.Color(0, 0, 0));
        verEditarServicios.setText("Ver/Editar Servicios");
        verEditarServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEditarServiciosActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 255, 153));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 255, 153));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(204, 255, 153));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField4))
                        .addGap(50, 50, 50)
                        .addComponent(verEditarServicios)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(verEditarServicios))
                        .addGap(29, 29, 29)
                        .addComponent(jButton5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(204, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
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
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose(); // cerrar ventana
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void verEditarServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEditarServiciosActionPerformed
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
    }//GEN-LAST:event_verEditarServiciosActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        limpiarCampos();
        jTextField1.setEnabled(true);
        jTextField2.setEnabled(true);
        jTextField3.setEnabled(true);
        jTextField4.setEnabled(true);
        jTable1.clearSelection();
        abogadoSeleccionado = null;
    }//GEN-LAST:event_jButton3ActionPerformed

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
    
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
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
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    // End of variables declaration//GEN-END:variables
}
