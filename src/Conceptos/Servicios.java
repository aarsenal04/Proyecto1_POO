package Conceptos;

public class Servicios {
    
    private String idServicio;
    private String nombreServicio;
    private int precioServicio;

    // constructor de Servicios
    public Servicios(String idServicio, String nombreServicio, int precioServicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.precioServicio = precioServicio;
    }
    
    // constructor por default
    public Servicios() {
    }
    
    // ********** setters y getters **********

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
    
    @Override
    public String toString(){
        return nombreServicio + " " + idServicio + ".";
    }
    
}