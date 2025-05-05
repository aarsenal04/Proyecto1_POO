package Presentacion;

import Conceptos.Clientes;
import Util.XMLCliente;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Cliente extends javax.swing.JFrame {

    private XMLCliente xmlCliente = new XMLCliente(); // Manejo de XML para clientes
    private DefaultTableModel tablaModelClientes; // Modelo de la tabla de clientes
    private List<Clientes> listaClientesEnMemoria; // Lista de clientes cargados
    private Clientes clienteSeleccionado = null; // Cliente seleccionado en la tabla
    private String archivoClientes = "Data/clientes.xml"; // Archivo XML de clientes

    public Cliente() {
        initComponents(); // Inicializa componentes de la interfaz
        setSize(1024, 768);
        setLocationRelativeTo(null); // Centra la ventana
        setTitle("Clientes");
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
        tablaModelClientes = new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Nombre", "Teléfono", "Email"} // Columnas de la tabla
        );
        jTable1.setModel(tablaModelClientes);

        cargarClientesEnTabla(); // Carga y muestra los clientes

        // Listener para la selección de filas en la tabla
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int filaSeleccionada = jTable1.getSelectedRow();
                    if (filaSeleccionada != -1) {
                        clienteSeleccionado = listaClientesEnMemoria.get(filaSeleccionada);
                        // Llena los campos con el cliente seleccionado
                        jTextField1.setText(clienteSeleccionado.getidCliente());
                        jTextField2.setText(clienteSeleccionado.getNombreCliente());
                        jTextField3.setText(clienteSeleccionado.getTelefonoCliente());
                        jTextField4.setText(clienteSeleccionado.getEmailCliente());
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
        jButton1.setBounds(ventanaAncho - salirAncho - margen, ventanaAlto - salirAlto - margen, salirAncho, salirAlto);

        // Posiciona botón "Guardar"
        int guardarAncho = jButtonGuardar.getPreferredSize().width;
        int guardarAlto = jButtonGuardar.getPreferredSize().height;
        jButtonGuardar.setBounds(margen, ventanaAlto - guardarAlto - margen, guardarAncho, guardarAlto);

        getContentPane().revalidate();
        getContentPane().repaint();
    }

    private void cargarClientesEnTabla() {
        listaClientesEnMemoria = xmlCliente.cargarClientes(archivoClientes);
        tablaModelClientes.setRowCount(0); // Limpia la tabla
        for (Clientes cliente : listaClientesEnMemoria) {
            tablaModelClientes.addRow(new Object[]{
                    cliente.getidCliente(),
                    cliente.getNombreCliente(),
                    cliente.getTelefonoCliente(),
                    cliente.getEmailCliente()
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
                "ID", "Nombre", "Teléfono", "Email"
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
        jLabel3.setText("Teléfono");

        jTextField3.setBackground(new java.awt.Color(153, 204, 255));
        jTextField3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField3.setText("Ingresar teléfono");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Nombre");

        jTextField4.setBackground(new java.awt.Color(153, 204, 255));
        jTextField4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField4.setText("Ingresar email");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField4)
                    .addComponent(jTextField1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(15, 15, 15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGap(6, 6, 6)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(9, 9, 9))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(394, Short.MAX_VALUE)
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
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    this.dispose(); // Cierra la ventana actual
    }                                        

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Limpiar todos los campos de texto
          limpiarCampos();

          // Habilitar todos los campos para la edición
          jTextField1.setEnabled(true); // Campo ID
          jTextField2.setEnabled(true); // Campo Nombre
          jTextField3.setEnabled(true); // Campo Teléfono
          jTextField4.setEnabled(true); // Campo Email

          // Deseleccionar cualquier fila que pudiera estar seleccionada en la tabla
          jTable1.clearSelection();

          // Establecer el cliente seleccionado a null, ya que se está creando uno nuevo
          clienteSeleccionado = null;
    }                                        

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = jTable1.getSelectedRow();

        // Verificar si hay alguna fila seleccionada
        if (filaSeleccionada != -1) {
            // Obtener el cliente a eliminar de la lista en memoria
            clienteSeleccionado = listaClientesEnMemoria.get(filaSeleccionada);

            // Mostrar un cuadro de diálogo de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este cliente?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);

            // Si el usuario confirma la eliminación
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Eliminar el cliente del archivo XML
                if (xmlCliente.eliminarCliente(clienteSeleccionado.getidCliente())) {
                    // Recargar los clientes desde el XML y actualizar la tabla
                    cargarClientesEnTabla();
                    // Limpiar los campos de texto
                    limpiarCampos();
                    // Resetear el cliente seleccionado
                    clienteSeleccionado = null;
                    // Mostrar un mensaje de éxito
                    JOptionPane.showMessageDialog(this, "Cliente eliminado correctamente.");
                } else {
                    // Mostrar un mensaje de error si la eliminación falla
                    JOptionPane.showMessageDialog(this, "Error al eliminar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Mostrar un mensaje si no se ha seleccionado ningún cliente
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la tabla para borrar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                        

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // Obtener los datos de los campos de texto
        String id = jTextField1.getText().trim();
        String nombre = jTextField2.getText().trim();
        String telefono = jTextField3.getText().trim();
        String email = jTextField4.getText().trim();

        // Validar que todos los campos estén llenos
        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; // Salir del método si hay campos vacíos
        }

        // Crear un nuevo objeto Cliente con los datos ingresados
        Clientes clienteNuevo = new Clientes(id, nombre, telefono, email);

        // Determinar si se está creando un nuevo cliente o modificando uno existente
        if (clienteSeleccionado != null) { // Modo Modificar
            // Actualizar el cliente existente en la lista en memoria
            if (xmlCliente.actualizarCliente(clienteNuevo)) {
                // Recargar los clientes desde el XML y actualizar la tabla
                cargarClientesEnTabla();
                // Limpiar los campos de texto
                limpiarCampos();
                // Resetear el cliente seleccionado
                clienteSeleccionado = null;
                // Deshabilitar los campos después de guardar
                deshabilitarCampos();
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente.");
            } else {
                // Mostrar un mensaje de error si la actualización falla
                JOptionPane.showMessageDialog(this, "Error al actualizar el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else { // Modo Nuevo
            // Intentar agregar el nuevo cliente al archivo XML
            if (xmlCliente.agregarCliente(clienteNuevo)) {
                // Recargar los clientes desde el XML y actualizar la tabla
                cargarClientesEnTabla();
                // Limpiar los campos de texto
                limpiarCampos();
                // Deshabilitar los campos después de guardar
                deshabilitarCampos();
                // Mostrar un mensaje de éxito
                JOptionPane.showMessageDialog(this, "Cliente agregado correctamente.");
            } else {
                // Mostrar un mensaje de error si el ID ya existe
                JOptionPane.showMessageDialog(this, "El ID del cliente ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }                                              

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Obtener la fila seleccionada en la tabla
        int filaSeleccionada = jTable1.getSelectedRow();

        // Verificar si hay alguna fila seleccionada
        if (filaSeleccionada != -1) {
            // Habilitar la edición de los campos (excepto el ID)
            jTextField2.setEnabled(true); // Campo Nombre
            jTextField3.setEnabled(true); // Campo Teléfono
            jTextField4.setEnabled(true); // Campo Email

            // El campo ID debe permanecer deshabilitado para la modificación
            jTextField1.setEnabled(false);
        } else {
            // Mostrar un mensaje si no se ha seleccionado ningún cliente
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un cliente de la tabla para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }                                        


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButtonGuardar;
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
    // End of variables declaration                   
}
