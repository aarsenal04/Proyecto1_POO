package Conceptos;

public class Clientes {

    private String idCliente;
    private String nombreCliente;
    private String telefonoCliente;
    private String emailCliente;

    // Constructor con parámetros
    public Clientes(String idCliente, String nombreCliente, String telefonoCliente, String emailCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
    }

    // Constructor por defecto
    public Clientes() {
    }

    public void setidCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getidCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    // Representación del objeto en texto
    @Override
    public String toString() {
        return nombreCliente + " " + idCliente + ".";
    }
}