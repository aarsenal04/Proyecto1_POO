package Presentacion;

import Conceptos.Servicios;
import Util.XMLServicio;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Servicio extends javax.swing.JFrame {

    private XMLServicio xmlServicio = new XMLServicio(); // Manejo de XML para servicios
    private DefaultTableModel tablaModelServicios; // Modelo de la tabla de servicios
    private List<Servicios> listaServiciosEnMemoria; // Lista de servicios cargados
    private Servicios servicioSeleccionado = null; // Servicio seleccionado en la tabla
    private String archivoServicios = "Data/servicios.xml"; // Archivo XML de servicios

public Servicio() {
        initComponents(); // Inicializa componentes de la interfaz
        setSize(1024, 768);
        setLocationRelativeTo(null); // Centra la ventana
        setTitle("Servicios");
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

        // Inicializa el modelo de la tabla
        tablaModelServicios = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Precio"} // Columnas de la tabla
        );
        jTable1.setModel(tablaModelServicios);

        cargarServiciosEnTabla(); // Carga y muestra los servicios

        // Listener para la selección de filas en la tabla
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int filaSeleccionada = jTable1.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        servicioSeleccionado = listaServiciosEnMemoria.get(filaSeleccionada);
                        // Llena los campos con el servicio seleccionado
                        jTextField1.setText(servicioSeleccionado.getidServicio());
                        jTextField2.setText(servicioSeleccionado.getNombreServicio());
                        jTextField3.setText(String.valueOf(servicioSeleccionado.getPrecioServicio()));
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

        // Posiciona el panel de entrada de datos
        int panelAncho = jPanel1.getPreferredSize().width;
        int panelAlto = jPanel1.getPreferredSize().height;
        int panelX = (ventanaAncho - panelAncho) / 2;
        int panelY = 20;
        jPanel1.setBounds(panelX, panelY, panelAncho, panelAlto);

        // Ajusta la tabla
        int tablaX = 50;
        int tablaY = panelY + panelAlto + 20;
        int tablaAncho = ventanaAncho - 100;
        int tablaAlto = ventanaAlto - tablaY - 80;
        jScrollPane1.setBounds(tablaX, tablaY, tablaAncho, tablaAlto);

        // Posiciona botón "Salir"
        int salirAncho = jButton1.getPreferredSize().width;
        int salirAlto = jButton1.getPreferredSize().height;
        int margen = 20;
        jButton1.setBounds(ventanaAncho - salirAncho - margen, ventanaAlto - salirAlto - margen, salirAncho, salirAlto);

        // Posiciona botón "Guardar"
        int guardarAncho = jButtonGuardar.getPreferredSize().width;
        int guardarAlto = jButtonGuardar.getPreferredSize().height;
        jButtonGuardar.setBounds(margen, ventanaAlto - guardarAlto - margen, guardarAncho, guardarAlto);

        getContentPane().revalidate();
        getContentPane().repaint();
    }

private void cargarServiciosEnTabla() {
        listaServiciosEnMemoria = xmlServicio.cargarServicios(archivoServicios);
        tablaModelServicios.setRowCount(0); // Limpia la tabla
        for (Servicios servicio : listaServiciosEnMemoria) {
            tablaModelServicios.addRow(new Object[]{
                    servicio.getidServicio(),
                    servicio.getNombreServicio(),
                    servicio.getPrecioServicio(),
            });
        }
    }

    private void deshabilitarCampos() {
        jTextField1.setEnabled(false);
        jTextField2.setEnabled(false);
        jTextField3.setEnabled(false);
    }

    private void limpiarCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
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
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();

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
                "ID", "Nombre", "Precio"
            }
        ));
        jTable1.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("ID");

        jTextField1.setBackground(new java.awt.Color(153, 204, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.setText("Ingresar ID");

        jTextField2.setBackground(new java.awt.Color(153, 204, 255));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField2.setText("Ingresar nombre");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Precio");

        jTextField3.setBackground(new java.awt.Color(153, 204, 255));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Ingresar teléfono");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton3.setText("Nuevo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton4.setText("Modificar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField1))
                .addGap(228, 228, 228)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButtonGuardar.setBackground(new java.awt.Color(51, 153, 255));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(401, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonGuardar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    this.dispose(); // Cierra la ventana actual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
  // Limpiar todos los campos de texto
    limpiarCampos();

    // Habilitar todos los campos para la edición
    jTextField1.setEnabled(true); // Campo ID
    jTextField2.setEnabled(true); // Campo Nombre
    jTextField3.setEnabled(true); // Campo Precio

    // Deseleccionar cualquier fila que pudiera estar seleccionada en la tabla
    jTable1.clearSelection();

    // Establecer el servicio seleccionado a null, ya que se está creando uno nuevo
    servicioSeleccionado = null;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable1.getSelectedRow();

    // Verificar si hay alguna fila seleccionada
    if (filaSeleccionada != -1) {
        // Obtener el servicio a eliminar de la lista en memoria
        servicioSeleccionado = listaServiciosEnMemoria.get(filaSeleccionada);

        // Mostrar un cuadro de diálogo de confirmación
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este servicio?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);

        // Si el usuario confirma la eliminación
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Eliminar el servicio del archivo XML
            if (xmlServicio.eliminarServicio(servicioSeleccionado.getidServicio())) {
                // Recargar los servicios desde el XML y actualizar la tabla
                cargarServiciosEnTabla();
                // Limpiar los campos de texto
                limpiarCampos();
                // Resetear el servicio seleccionado
                servicioSeleccionado = null;
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Servicio eliminado correctamente.");
            } else {
                // Mostrar un mensaje de error si la eliminación falla
                JOptionPane.showMessageDialog(this, "Error al eliminar el servicio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        // Mostrar un mensaje si no se ha seleccionado ningún servicio
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un servicio de la tabla para borrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
    // Obtener los datos de los campos de texto
    String id = jTextField1.getText().trim();
    String nombre = jTextField2.getText().trim();
    String precio = jTextField3.getText().trim();

    // Validar que todos los campos estén llenos
    if (id.isEmpty() || nombre.isEmpty() || precio.isEmpty() ) {
        JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return; // Salir del método si hay campos vacíos
    }

    // Crear un nuevo objeto Servicio con los datos ingresados
    try {
        int precioInt = Integer.parseInt(precio);
        Servicios servicioNuevo = new Servicios(id, nombre, precioInt);
        // Determinar si se está creando un nuevo servicio o modificando uno existente
        if (servicioSeleccionado != null) { // Modo Modificar
            // Actualizar el servicio existente en la lista en memoria
            if (xmlServicio.actualizarServicio(servicioNuevo)) {
                // Recargar los servicios desde el XML y actualizar la tabla
                cargarServiciosEnTabla();
                // Limpiar los campos de texto
                limpiarCampos();
                // Resetear el servicio seleccionado
                servicioSeleccionado = null;
                // Deshabilitar los campos después de guardar
                deshabilitarCampos();
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Servicio actualizado correctamente.");
            } else {
                // Mostrar un mensaje de error si la actualización falla
                JOptionPane.showMessageDialog(this, "Error al actualizar el servicio.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { // Modo Nuevo
            // Intentar agregar el nuevo servicio al archivo XML
            if (xmlServicio.agregarServicio(servicioNuevo)) {
                // Recargar los servicios desde el XML y actualizar la tabla
                cargarServiciosEnTabla();
                // Limpiar los campos de texto
                limpiarCampos();
                // Deshabilitar los campos después de guardar
                deshabilitarCampos();
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Servicio agregado correctamente.");
            } else {
                // Mostrar un mensaje de error si el ID ya existe
                JOptionPane.showMessageDialog(this, "El ID del servicio ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "El precio debe ser un número entero válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // No continuar si el precio no es un entero válido
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    // Obtener la fila seleccionada en la tabla
    int filaSeleccionada = jTable1.getSelectedRow();

    // Verificar si hay alguna fila seleccionada
    if (filaSeleccionada != -1) {
        // Habilitar la edición de los campos (excepto el ID)
        jTextField2.setEnabled(true); // Campo Nombre
        jTextField3.setEnabled(true); // Campo Teléfono

        // El campo ID debe permanecer deshabilitado para la modificación
        jTextField1.setEnabled(false);
    } else {
        // Mostrar un mensaje si no se ha seleccionado ningún servicio
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un servicio de la tabla para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_jButton4ActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
