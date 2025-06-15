package Presentacion;

import Conceptos.Clientes;
import Util.XMLCliente;
import java.awt.*;
import javax.swing.*;

public class CrearNuevoClienteDialog extends JDialog {

    // Campos para la entrada de datos
    private JTextField txtId, txtNombre, txtTelefono, txtEmail;

    // Utilitario para guardar el nuevo cliente en el XML
    private XMLCliente xmlCliente;
    
    // Referencia al ComboBox de la ventana anterior para poder actualizarlo
    private JComboBox<String> comboCliente;

    /**
     * Constructor para el diálogo de creación de clientes.
     * @param owner El Frame padre (la ventana principal).
     * @param xmlCliente El manejador de XML para guardar los datos.
     * @param comboCliente El JComboBox que se actualizará después de guardar.
     */
    public CrearNuevoClienteDialog(Frame owner, XMLCliente xmlCliente, JComboBox<String> comboCliente) {
        super(owner, "Agregar Nuevo Cliente", true); // Título y modal
        this.xmlCliente = xmlCliente;
        this.comboCliente = comboCliente;

        initComponents(); // Construye la interfaz
        
        setSize(400, 250); // Tamaño del diálogo
        setLocationRelativeTo(owner); // Centrar respecto al padre
    }

    /**
     * Construye todos los componentes visuales del diálogo.
     */
    private void initComponents() {
        // Usamos un panel principal con GridBagLayout para alinear el formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Márgenes entre componentes
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda

        // --- Fila 1: ID ---
        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hacer que el campo de texto se estire
        gbc.weightx = 1.0; // Permitir que la columna del campo de texto crezca
        txtId = new JTextField(15);
        panelFormulario.add(txtId, gbc);

        // --- Fila 2: Nombre ---
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtNombre = new JTextField(15);
        panelFormulario.add(txtNombre, gbc);

        // --- Fila 3: Teléfono ---
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Teléfono:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtTelefono = new JTextField(15);
        panelFormulario.add(txtTelefono, gbc);
        
        // --- Fila 4: Email ---
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panelFormulario.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        txtEmail = new JTextField(15);
        panelFormulario.add(txtEmail, gbc);

        // --- Panel de Botones ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        // --- Añadir ActionListeners a los botones ---
        btnGuardar.addActionListener(e -> guardarNuevoCliente());
        btnCancelar.addActionListener(e -> dispose()); // dispose() simplemente cierra el diálogo

        // --- Ensamblar el diálogo ---
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelFormulario, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     * Valida los datos, guarda el nuevo cliente y actualiza la UI.
     */
    private void guardarNuevoCliente() {
        // 1. Obtener y validar los datos
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String email = txtEmail.getText().trim();

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error de Validación", JOptionPane.WARNING_MESSAGE);
            return; // Detiene la ejecución si hay campos vacíos
        }

        // 2. Crear el objeto Cliente
        Clientes nuevoCliente = new Clientes(id, nombre, telefono, email);

        // 3. Intentar guardar en el XML
        if (xmlCliente.agregarCliente(nuevoCliente)) {
            JOptionPane.showMessageDialog(this, "Cliente guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // 4. Actualizar el JComboBox de la ventana anterior
            comboCliente.addItem(nuevoCliente.getNombreCliente()); // Añade el nuevo cliente a la lista
            comboCliente.setSelectedItem(nuevoCliente.getNombreCliente()); // Lo selecciona automáticamente
            
            dispose(); // Cierra este diálogo
        } else {
            // Esto sucede si el ID ya existe, según la lógica de tu XMLCliente
            JOptionPane.showMessageDialog(this, "El ID del cliente ya existe.", "Error al Guardar", JOptionPane.ERROR_MESSAGE);
        }
    }
}