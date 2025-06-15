package Conceptos;

public class Estado {
    
    private String id;
    private String nombre;

    public Estado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // setters y getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}