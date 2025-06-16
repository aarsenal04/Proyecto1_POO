package Conceptos;

public class Servicios {

    private String idServicio;
    private String nombreServicio;
    private int precioServicio;

    // Constructor con parámetros
    public Servicios(String idServicio, String nombreServicio, int precioServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }

    // Constructor por defecto
    public Servicios() {
    }

    public void setidServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecioServicio(int precioServicio) {
        this.precioServicio = precioServicio;
    }

    public String getidServicio() {
        return idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public int getPrecioServicio() {
        return precioServicio;
    }

    // Representación del objeto en texto
    @Override
    public String toString() {
        return nombreServicio + " " + idServicio + ".";
    }

}