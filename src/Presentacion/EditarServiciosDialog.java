package Presentacion;

import Conceptos.Abogados;
import Conceptos.Servicios;
import Util.XMLAbogado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class EditarServiciosDialog extends JDialog {

    // --- Atributos de la clase ---
    private Abogados abogadoSeleccionado; // Abogado cuyos servicios se están editando
    private List<Servicios> listaServiciosDisponibles; // Lista de todos los servicios que se pueden asignar
    private List<JCheckBox> listaCheckBoxes; // Lista de los JCheckBox para la selección
    private XMLAbogado xmlAbogado; // Manejador para guardar los cambios en el XML
    private List<Abogados> listaAbogados; // Lista completa de abogados (referencia)

    // Constructor del diálogo para editar servicios de un abogado
    public EditarServiciosDialog(Frame owner, Abogados abogado, List<Servicios> serviciosDisponibles, XMLAbogado xmlAbogado, List<Abogados> listaAbogados) {
        super(owner, "Editar Servicios", true);
        this.abogadoSeleccionado = abogado;
        this.listaServiciosDisponibles = serviciosDisponibles;
        this.listaCheckBoxes = new ArrayList<>();
        this.xmlAbogado = xmlAbogado;
        this.listaAbogados = listaAbogados;

        // Construir la interfaz y configurar la ventana
        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(owner);
    }

    // Construir y organizar los componentes de la interfaz
    private void initComponents() {
        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));

        // Crear un JCheckBox por cada servicio disponible
        for (Servicios servicio : listaServiciosDisponibles) {
            JCheckBox checkBox = new JCheckBox(servicio.getNombreServicio());
            // Marcar el checkbox si el abogado ya tiene el servicio asignado
            for (Servicios servicioAbogado : abogadoSeleccionado.getListaServiciosAbogado()) {
                if (servicioAbogado.getidServicio().equals(servicio.getidServicio())) {
                    checkBox.setSelected(true);
                    break;
                }
            }
            listaCheckBoxes.add(checkBox);
            panelServicios.add(checkBox);
        }

        JScrollPane scrollPane = new JScrollPane(panelServicios);

        // Configurar botones de acción
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarCambios());

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(e -> dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        // Ensamblar el diálogo
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    // Guardar los servicios seleccionados para el abogado
    private void guardarCambios() {
        ArrayList<Servicios> nuevosServicios = new ArrayList<>();

        // Recopilar los servicios de los checkboxes marcados
        for (int i = 0; i < listaCheckBoxes.size(); i++) {
            JCheckBox checkBox = listaCheckBoxes.get(i);
            if (checkBox.isSelected()) {
                nuevosServicios.add(listaServiciosDisponibles.get(i));
            }
        }

        // Actualizar la lista de servicios en el objeto del abogado
        abogadoSeleccionado.setListaServiciosAbogado(nuevosServicios);

        // Guardar el abogado actualizado en el archivo XML
        xmlAbogado.actualizarAbogado(abogadoSeleccionado);

        JOptionPane.showMessageDialog(this, "Servicios actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}