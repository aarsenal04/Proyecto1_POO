package Presentacion;

import Conceptos.Clientes;
import Util.XMLCliente;
import java.awt.*;
import javax.swing.*;

public class CrearNuevoClienteDialog extends JDialog {

    // --- Atributos de la clase ---
    private JTextField txtId, txtNombre, txtTelefono, txtEmail; // Campos de texto del formulario
    private XMLCliente xmlCliente; // Manejador para el archivo XML de clientes
    private JComboBox<String> comboCliente; // Referencia al ComboBox de la ventana principal para actualizarlo

    // Constructor del diálogo para crear un nuevo cliente
    public CrearNuevoClienteDialog(Frame owner, XMLCliente xmlCliente, JComboBox<String> comboCliente) {
        super(owner, "Agregar Nuevo Cliente", true);
        this.xmlCliente = xmlCliente;
        this.comboCliente = comboCliente;

        // Construir la interfaz y configurar la ventana
        initComponents();
        setSize(400, 250);
        setLocationRelativeTo(owner);
    }

    // Construir y organizar los componentes de la interfaz
    private void initComponents() {
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Fila para el ID
        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtId = new JTextField(15);
        panelFormulario.add(txtId, gbc);

        // Fila para el Nombre
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtNombre = new JTextField(15);
        panelFormulario.add(txtNombre, gbc);

        // Fila para el Teléfono
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtTelefono = new JTextField(15);
        panelFormulario.add(txtTelefono, gbc);

        // Fila para el Email
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtEmail = new JTextField(15);
        panelFormulario.add(txtEmail, gbc);

        // Panel para los botones de acción
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        // Asignar acciones a los botones
        btnGuardar.addActionListener(e -> guardarNuevoCliente());
        btnCancelar.addActionListener(e -> dispose()); // Cierra el diálogo

        // Ensamblar el diálogo
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelFormulario, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    // Validar y guardar los datos del nuevo cliente
    private void guardarNuevoCliente() {
        // Obtener y validar datos de entrada
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Intentar guardar el nuevo cliente
        Clientes nuevoCliente = new Clientes(id, nombre, telefono, email);
        if (xmlCliente.agregarCliente(nuevoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Actualizar ComboBox en ventana principal y cerrar
            comboCliente.addItem(nuevoCliente.getNombreCliente());
            comboCliente.setSelectedItem(nuevoCliente.getNombreCliente());
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "El ID del cliente ya existe.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
        }
    }
}