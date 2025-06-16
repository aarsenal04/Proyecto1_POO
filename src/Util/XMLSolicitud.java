package Util;

import Conceptos.Solicitud;
import Conceptos.Clientes;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLSolicitud {

    // Cargar solicitudes desde XML
    public static List<Solicitud> cargarSolicitudes(String rutaArchivo, List<Conceptos.Clientes> todosLosClientes, List<Conceptos.Servicios> todosLosServicios) {
        List<Solicitud> listaSolicitudes = new ArrayList<>();

        try {
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) return listaSolicitudes;

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivo);

            doc.getDocumentElement().normalize();

            NodeList solicitudes = doc.getElementsByTagName("solicitud");

            for (int i = 0; i < solicitudes.getLength(); i++) {
                Node nodo = solicitudes.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;

                    String id = elemento.getAttribute("id");
                    String fechaHora = getTagValue("fecha_hora", elemento);
                    String servicio = getTagValue("servicio", elemento);
                    String cliente = getTagValue("cliente", elemento);
                    String abogado = getTagValue("abogado", elemento);
                    String estado = getTagValue("estado", elemento);
                    String observaciones = getTagValue("observaciones", elemento);

                    List<String> otrosServicios = new ArrayList<>();
                    NodeList otros = elemento.getElementsByTagName("otros_servicios");

                    if (otros.getLength() > 0) {
                        Node otrosNode = otros.item(0);
                        if (otrosNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element otrosElem = (Element) otrosNode;
                            NodeList ids = otrosElem.getElementsByTagName("id");
                            for (int j = 0; j < ids.getLength(); j++) {
                                otrosServicios.add(ids.item(j).getTextContent());
                            }
                        }
                    }

                    Solicitud s = new Solicitud(id, fechaHora, servicio, cliente, abogado, estado, observaciones, otrosServicios);
                    listaSolicitudes.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaSolicitudes;
    }

    // Añadir nueva solicitud al XML
    public static void guardarSolicitud(Solicitud nueva, String rutaArchivo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;
            Element root;

            File archivo = new File(rutaArchivo);

            if (archivo.exists()) {
                doc = builder.parse(archivo);
                root = doc.getDocumentElement();
            } else {
                doc = builder.newDocument();
                root = doc.createElement("solicitudes");
                doc.appendChild(root);
            }

            Element solicitudElem = doc.createElement("solicitud");
            solicitudElem.setAttribute("id", nueva.getId());

            crearElementoConTexto(doc, solicitudElem, "fecha_hora", nueva.getFechaHora());
            crearElementoConTexto(doc, solicitudElem, "servicio", nueva.getServicio());
            crearElementoConTexto(doc, solicitudElem, "cliente", nueva.getCliente());
            crearElementoConTexto(doc, solicitudElem, "abogado", nueva.getAbogado());
            crearElementoConTexto(doc, solicitudElem, "estado", nueva.getEstado());
            crearElementoConTexto(doc, solicitudElem, "observaciones", nueva.getObservaciones());

            if (nueva.getOtrosServicios() != null && !nueva.getOtrosServicios().isEmpty()) {
                Element otrosElem = doc.createElement("otros_servicios");
                for (String id : nueva.getOtrosServicios()) {
                    crearElementoConTexto(doc, otrosElem, "id", id);
                }
                solicitudElem.appendChild(otrosElem);
            }

            root.appendChild(solicitudElem);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Guardar lista completa de solicitudes al XML
    public static void guardarListaCompleta(List<Solicitud> lista, String rutaArchivo) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element root = doc.createElement("solicitudes");
            doc.appendChild(root);

            for (Solicitud s : lista) {
                Element solicitudElem = doc.createElement("solicitud");
                solicitudElem.setAttribute("id", s.getId());

                crearElementoConTexto(doc, solicitudElem, "fecha_hora", s.getFechaHora());
                crearElementoConTexto(doc, solicitudElem, "servicio", s.getServicio());
                crearElementoConTexto(doc, solicitudElem, "cliente", s.getCliente());
                crearElementoConTexto(doc, solicitudElem, "abogado", s.getAbogado());
                crearElementoConTexto(doc, solicitudElem, "estado", s.getEstado());
                crearElementoConTexto(doc, solicitudElem, "observaciones", s.getObservaciones());

                if (s.getOtrosServicios() != null && !s.getOtrosServicios().isEmpty()) {
                    Element otrosElem = doc.createElement("otros_servicios");
                    for (String id : s.getOtrosServicios()) {
                        crearElementoConTexto(doc, otrosElem, "id", id);
                    }
                    solicitudElem.appendChild(otrosElem);
                }

                root.appendChild(solicitudElem);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(rutaArchivo));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear elemento con texto
    private static void crearElementoConTexto(Document doc, Element padre, String etiqueta, String texto) {
        Element elem = doc.createElement(etiqueta);
        elem.appendChild(doc.createTextNode(texto != null ? texto : ""));
        padre.appendChild(elem);
    }

    // Obtener valor de una etiqueta XML
    private static String getTagValue(String tag, Element elemento) {
        NodeList nl = elemento.getElementsByTagName(tag);
        if (nl.getLength() == 0) return "";
        Node n = nl.item(0);
        return (n != null) ? n.getTextContent() : "";
    }

    // Obtener fecha y hora de la solicitud
    public static String getFechaHora(Solicitud s) {
        return s.getFechaHora();
    }

    // Obtener cliente de la solicitud
    public static String getCliente(Solicitud s) {
        return s.getCliente();
    }

    // Obtener servicio principal de la solicitud
    public static String getServicio(Solicitud s) {
        return s.getServicio();
    }

    // Obtener ID de la solicitud
    public static String getIdSolicitud(Solicitud s) {
        return s.getId();
    }

    // Obtener estado de la solicitud
    public static String getEstado(Solicitud s) {
        return s.getEstado();
    }
}