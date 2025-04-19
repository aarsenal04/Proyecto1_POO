package Util;

import Conceptos.Servicios;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLServicio {

    private List<Servicios> listaServicios = new ArrayList<>();

    public List<Servicios> cargarServicios(String rutaArchivo) {
        listaServicios.clear();
        try {
            File archivoXML = new File(rutaArchivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivoXML);

            NodeList servicios = doc.getElementsByTagName("servicio");
            for (int i = 0; i < servicios.getLength(); i++) {
                Element elemento = (Element) servicios.item(i);

                String id = elemento.getAttribute("id");
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                int precio = Integer.parseInt(elemento.getElementsByTagName("precio").item(0).getTextContent());

                listaServicios.add(new Servicios(id, nombre, precio));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaServicios;
    }

    public void guardarServicios(String rutaArchivo, List<Servicios> servicios) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("servicios");
            doc.appendChild(root);

            for (Servicios s : servicios) {
                Element servicio = doc.createElement("servicio");
                servicio.setAttribute("id", s.getidServicio());

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(s.getNombreServicio());

                Element precio = doc.createElement("precio");
                precio.setTextContent(String.valueOf(s.getPrecioServicio()));

                servicio.appendChild(nombre);
                servicio.appendChild(precio);
                root.appendChild(servicio);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Servicios> getListaServicios() {
        return listaServicios;
    }

    public Servicios buscarPorId(String id) {
        for (Servicios s : listaServicios) {
            if (s.getidServicio().equals(id)) return s;
        }
        return null;
    }
}
