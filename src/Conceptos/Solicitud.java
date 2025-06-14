package Conceptos;

import java.util.List;

public class Solicitud {
    
    private String id;
    private String fechaHora;
    private String servicio;
    private String cliente;
    private String abogado;
    private String estado;
    private String observaciones;
    private List<String> otrosServicios;

    // constructor de la clase
    public Solicitud(String id, String fechaHora, String servicio, String cliente, String abogado, String estado, String observaciones, List<String> otrosServicios) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.servicio = servicio;
        this.cliente = cliente;
        this.abogado = abogado;
        this.estado = estado;
        this.observaciones = observaciones;
        this.otrosServicios = otrosServicios;
    }
    
    // constructor por default
    public Solicitud(String id, String fechaHora, String servicio, String cliente, String estado, String observaciones) {
        this(id, fechaHora, servicio, cliente, "", estado, observaciones, null);
    }
    
    // setters y getters de la clase
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getAbogado() {
        return abogado;
    }

    public void setAbogado(String abogado) {
        this.abogado = abogado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<String> getOtrosServicios() {
        return otrosServicios;
    }

    public void setOtrosServicios(List<String> otrosServicios) {
        this.otrosServicios = otrosServicios;
    }

}