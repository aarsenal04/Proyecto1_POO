package Util;

import Conceptos.Abogados;
import Conceptos.Servicios;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLAbogado {

    private List<Abogados> listaAbogados = new ArrayList<>();
    // Para tener la ruta disponible para guardar
    private String rutaArchivoGuardado;

    // Constructor vacío
    public XMLAbogado() {
    }

    // Cargar abogados desde XML
    public List<Abogados> cargarAbogados(String rutaArchivo, List<Servicios> serviciosDisponibles) {
        // Guardar la ruta para usarla al guardar
        this.rutaArchivoGuardado = rutaArchivo;
        listaAbogados.clear();
        try {
            File archivoXML = new File(rutaArchivo);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(archivoXML);

            NodeList abogados = doc.getElementsByTagName("abogado");
            for (int i = 0; i < abogados.getLength(); i++) {
                Element abg = (Element) abogados.item(i);
                String id = abg.getAttribute("id");
                String nombre = abg.getElementsByTagName("nombre").item(0).getTextContent();
                String telefono = abg.getElementsByTagName("telefono").item(0).getTextContent();
                String puesto = abg.getElementsByTagName("puesto").item(0).getTextContent();

                List<Servicios> serviciosAsignados = new ArrayList<>();
                NodeList idsServicios = ((Element) abg.getElementsByTagName("servicios").item(0)).getElementsByTagName("id");
                for (int j = 0; j < idsServicios.getLength(); j++) {
                    String idServicio = idsServicios.item(j).getTextContent();
                    for (Servicios serv : serviciosDisponibles) {
                        if (serv.getidServicio().equals(idServicio)) {
                            serviciosAsignados.add(serv);
                            break;
                        }
                    }
                }
                listaAbogados.add(new Abogados(id, nombre, telefono, puesto, new ArrayList<>(serviciosAsignados)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaAbogados;
    }

    // Guardar abogados al XML
    public void guardarAbogados(String rutaArchivo, List<Abogados> abogados) {
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Element root = doc.createElement("abogados");
            doc.appendChild(root);

            for (Abogados ab : abogados) {
                Element abg = doc.createElement("abogado");
                abg.setAttribute("id", ab.getidAbogado());

                Element nombre = doc.createElement("nombre");
                nombre.setTextContent(ab.getNombreAbogado());
                abg.appendChild(nombre);

                Element telefono = doc.createElement("telefono");
                telefono.setTextContent(ab.getTelefonoAbogado());
                abg.appendChild(telefono);

                Element puesto = doc.createElement("puesto");
                puesto.setTextContent(ab.getPuestoAbogado());
                abg.appendChild(puesto);

                Element servicios = doc.createElement("servicios");
                for (Servicios serv : ab.getListaServiciosAbogado()) {
                    Element id = doc.createElement("id");
                    id.setTextContent(serv.getidServicio());
                    servicios.appendChild(id);
                }
                abg.appendChild(servicios);
                root.appendChild(abg);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(new File(rutaArchivo)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Agregar nuevo abogado
    public boolean agregarAbogado(Abogados nuevo) {
        if (buscarPorId(nuevo.getidAbogado()) == null) {
            listaAbogados.add(nuevo);
            // Guardar al XML
            guardarAbogados(this.rutaArchivoGuardado, listaAbogados);
            return true;
        }
        return false;
    }

    // Actualizar abogado existente
    public boolean actualizarAbogado(Abogados actualizado) {
        for (int i = 0; i < listaAbogados.size(); i++) {
            if (listaAbogados.get(i).getidAbogado().equals(actualizado.getidAbogado())) {
                listaAbogados.set(i, actualizado);
                // Guardar al XML
                guardarAbogados(this.rutaArchivoGuardado, listaAbogados);
                return true;
            }
        }
        return false;
    }

    // Eliminar abogado por ID
    public boolean eliminarAbogado(String id) {
        Abogados abogadoAEliminar = buscarPorId(id);
        if (abogadoAEliminar != null) {
            listaAbogados.remove(abogadoAEliminar);
            // Guardar al XML
            guardarAbogados(this.rutaArchivoGuardado, listaAbogados);
            return true;
        }
        return false;
    }

    // Buscar abogado por ID
    public Abogados buscarPorId(String id) {
        for (Abogados ab : listaAbogados) {
            if (ab.getidAbogado().equals(id)) return ab;
        }
        return null;
    }

    // Obtener lista actual de abogados en memoria
    public List<Abogados> getListaAbogados() {
        return listaAbogados;
    }
}