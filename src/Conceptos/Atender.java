package Conceptos;

import Util.XMLSolicitud;
import java.util.List;

public class Atender {

    public static void actualizarYGuardar(List<Solicitud> solicitudes, Solicitud modificada, String rutaArchivo) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId().equals(modificada.getId())) {
                solicitudes.set(i, modificada); // Reemplaza la solicitud vieja por la modificada
                break;
            }
        }
        XMLSolicitud.guardarListaCompleta(solicitudes, rutaArchivo);
    }
}