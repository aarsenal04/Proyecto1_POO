package Conceptos;

import java.util.ArrayList;
import java.util.List;

public class Consultar {

    // Filtrar solicitudes por cliente y/o estado
    public static List<Solicitud> filtrar(List<Solicitud> solicitudes, String idCliente, String idEstado) {
        List<Solicitud> filtradas = new ArrayList<>();

        for (Solicitud s : solicitudes) {
            boolean coincideCliente = (idCliente == null || idCliente.isEmpty()) || s.getCliente().equals(idCliente);
            boolean coincideEstado = (idEstado == null || idEstado.isEmpty()) || s.getEstado().equals(idEstado);

            if (coincideCliente && coincideEstado) {
                filtradas.add(s);
            }
        }

        return filtradas;
    }
}