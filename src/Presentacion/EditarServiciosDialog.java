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

    private Abogados abogadoSeleccionado;
    private List<Servicios> listaServiciosDisponibles;
    private List<JCheckBox> listaCheckBoxes;
    private XMLAbogado xmlAbogado; // guardar cambios
    private List<Abogados> listaAbogados; // lista completa

    public EditarServiciosDialog(Frame owner, Abogados abogado, List<Servicios> serviciosDisponibles, XMLAbogado xmlAbogado, List<Abogados> listaAbogados) {
        super(owner, "Editar Servicios", true);
        this.abogadoSeleccionado = abogado;
        this.listaServiciosDisponibles = serviciosDisponibles;
        this.listaCheckBoxes = new ArrayList<>();
        this.xmlAbogado = xmlAbogado;
        this.listaAbogados = listaAbogados;

        initComponents();
        setSize(400, 400);
        setLocationRelativeTo(owner);
    }

    private void initComponents() {
        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));

        // checkbox por cada servicio disponible
        for (Servicios servicio : listaServiciosDisponibles) {
            JCheckBox checkBox = new JCheckBox(servicio.getNombreServicio());
            // marcar si el abogado ya tiene este servicio
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

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelBotones, BorderLayout.SOUTH);
    }

    private void guardarCambios() {
        ArrayList<Servicios> nuevosServicios = new ArrayList<>();

        for (int i = 0; i < listaCheckBoxes.size(); i++) {
            JCheckBox checkBox = listaCheckBoxes.get(i);
            if (checkBox.isSelected()) {
                nuevosServicios.add(listaServiciosDisponibles.get(i));
            }
        }

        // actualizar servicios del abogado
        abogadoSeleccionado.setListaServiciosAbogado(nuevosServicios);

        // guardar en el XML
        xmlAbogado.actualizarAbogado(abogadoSeleccionado);

        JOptionPane.showMessageDialog(this, "Servicios actualizados correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }
}