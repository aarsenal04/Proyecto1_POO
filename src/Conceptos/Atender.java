package Conceptos;

import Util.XMLSolicitud;
import java.util.List;

public class Atender {

    // arregla una solicitud existente en la lista y guarda la lista completa en el XML.
    public static void actualizarYGuardar(List<Solicitud> solicitudes, Solicitud modificada, String rutaArchivo) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId().equals(modificada.getId())) {
                solicitudes.set(i, modificada); // reemplaza la solicitud con la nueva modificacion
                break;
            }
        }

        // guarda todas las solicitudes actualizadas
        XMLSolicitud.guardarListaCompleta(solicitudes, rutaArchivo);
    }
}
