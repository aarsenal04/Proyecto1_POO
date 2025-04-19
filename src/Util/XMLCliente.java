package Util;

import Conceptos.Clientes;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLCliente {

    private List<Clientes> listaClientes = new ArrayList<>();

    // Cargar clientes desde XML
    public List<Clientes> cargarClientes(String rutaArchivo) {
        listaClientes.clear();
        try {
            File archivoXML = new File(rutaArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivoXML);

            NodeList clientes = doc.getElementsByTagName("cliente");
            for (int i = 0; i < clientes.getLength(); i++) {
                Element elemento = (Element) clientes.item(i);

                String id = elemento.getAttribute("id");
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String telefono = elemento.getElementsByTagName("telefono").item(0).getTextContent();
                String email = elemento.getElementsByTagName("email").item(0).getTextContent();

                listaClientes.add(new Clientes(id, nombre, telefono, email));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    // Guardar clientes al XML
    public void guardarClientes(String rutaArchivo, List<Clientes> clientes) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("clientes");
            doc.appendChild(root);

            for (Clientes c : clientes) {
                Element cliente = doc.createElement("cliente");
                cliente.setAttribute("id", c.getidCliente());

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(c.getNombreCliente());

                Element telefono = doc.createElement("telefono");
                telefono.setTextContent(c.getTelefonoCliente());

                Element email = doc.createElement("email");
                email.setTextContent(c.getEmailCliente());

                cliente.appendChild(nombre);
                cliente.appendChild(telefono);
                cliente.appendChild(email);

                root.appendChild(cliente);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Buscar cliente por ID
    public Clientes buscarPorId(String id) {
        for (Clientes c : listaClientes) {
            if (c.getidCliente().equals(id)) return c;
        }
        return null;
    }

    // Agregar nuevo cliente
    public boolean agregarCliente(Clientes nuevo) {
        if (buscarPorId(nuevo.getidCliente()) == null) {
            listaClientes.add(nuevo);
            return true;
        }
        return false;
    }

    // Actualizar cliente existente
    public boolean actualizarCliente(Clientes actualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getidCliente().equals(actualizado.getidCliente())) {
                listaClientes.set(i, actualizado);
                return true;
            }
        }
        return false;
    }

    // Eliminar cliente por ID
    public boolean eliminarCliente(String id) {
        Clientes c = buscarPorId(id);
        if (c != null) {
            listaClientes.remove(c);
            return true;
        }
        return false;
    }

    // Obtener lista actual de clientes en memoria
    public List<Clientes> getListaClientes() {
        return listaClientes;
    }
}
