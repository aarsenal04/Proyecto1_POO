package Conceptos;

import java.util.ArrayList;

public class Abogados {

    private String idAbogado;
    private String nombreAbogado;
    private String telefonoAbogado;
    private String puestoAbogado;

    private ArrayList<Servicios> listaServiciosAbogado;

    // Constructor por defecto
    public Abogados() {
        this.listaServiciosAbogado = new ArrayList<>();
    }

    // Constructor con parámetros
    public Abogados(String idAbogado, String nombreAbogado, String telefonoAbogado, String puestoAbogado, ArrayList<Servicios> listaServiciosAbogado) {
        this.idAbogado = idAbogado;
        this.nombreAbogado = nombreAbogado;
        this.telefonoAbogado = telefonoAbogado;
        this.puestoAbogado = puestoAbogado;
        this.listaServiciosAbogado = listaServiciosAbogado;
    }

    public void setidAbogado(String idAbogado) {
        this.idAbogado = idAbogado;
    }

    public void setNombreAbogado(String nombreAbogado) {
        this.nombreAbogado = nombreAbogado;
    }

    public void setTelefonoAbogado(String telefonoAbogado) {
        this.telefonoAbogado = telefonoAbogado;
    }

    public void setPuestoAbogado(String puestoAbogado) {
        this.puestoAbogado = puestoAbogado;
    }

    public void setListaServiciosAbogado(ArrayList<Servicios> listaServiciosAbogado) {
        this.listaServiciosAbogado = listaServiciosAbogado;
    }

    public String getidAbogado() {
        return idAbogado;
    }

    public String getNombreAbogado() {
        return nombreAbogado;
    }

    public String getTelefonoAbogado() {
        return telefonoAbogado;
    }

    public String getPuestoAbogado() {
        return puestoAbogado;
    }

    public ArrayList<Servicios> getListaServiciosAbogado() {
        return listaServiciosAbogado;
    }

    // Representación del objeto en texto
    @Override
    public String toString() {
        return nombreAbogado + " " + idAbogado + ".";
    }

}