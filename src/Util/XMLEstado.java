package Util;

import Conceptos.Estado;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLEstado {

    // Cargar estados desde XML
    public List<Estado> cargarEstados(String rutaArchivo) {
        List<Estado> listaEstados = new ArrayList<>();

        try {
            File archivoXML = new File(rutaArchivo);
            if (!archivoXML.exists()) {
                System.out.println("Archivo XML no encontrado: " + rutaArchivo);
                return listaEstados;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivoXML);
            doc.getDocumentElement().normalize();

            NodeList nodosEstado = doc.getElementsByTagName("estado");

            for (int i = 0; i < nodosEstado.getLength(); i++) {
                Node nodo = nodosEstado.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    String id = elemento.getAttribute("id");
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();

                    Estado estado = new Estado(id, nombre);
                    listaEstados.add(estado);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaEstados;
    }
}