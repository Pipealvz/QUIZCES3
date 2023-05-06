package co.edu.poli.ces3;

import co.edu.poli.ces3.models.Autor;
import co.edu.poli.ces3.models.Libro;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import co.edu.poli.ces3.models.Bliblioteca;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public  main(){

    }

    public static void main(String[] args) {
        try {
            File file = new File("src\\resources\\biblioteca.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            List<Autor> allAutores = new ArrayList<>();

            Element bibElement = document.getDocumentElement();
            String nombre = bibElement.getAttribute("nombre");
            String centro = bibElement.getAttribute("centro");
            String portada = bibElement.getElementsByTagName("portada").item(0).getTextContent();
            NodeList libroNodes = bibElement.getElementsByTagName("libro");
            List<Libro> libros = new ArrayList<>();
            for (int i = 0; i < libroNodes.getLength(); i++) {
                Element libroElement = (Element) libroNodes.item(i);
                String anyo = libroElement.getAttribute("anyo");
                String titulo = libroElement.getElementsByTagName("titulo").item(0).getTextContent();
                String editorial = libroElement.getElementsByTagName("editorial").item(0).getTextContent();
                String precio = libroElement.getElementsByTagName("precio").item(0).getTextContent();
                NodeList autorNodes = libroElement.getElementsByTagName("autor");
                List<Autor> autores = new ArrayList<>();
                for (int j = 0; j < autorNodes.getLength(); j++) {
                    Element autorElement = (Element) autorNodes.item(j);
                    String foto = autorElement.getAttribute("foto");
                    String apellido = autorElement.getElementsByTagName("apellido").item(0).getTextContent();
                    String nombreA = autorElement.getElementsByTagName("nombre").item(0).getTextContent();
                    String identificacion = autorElement.getAttribute("documento");

                    autores.add(new Autor(foto, apellido, nombreA, identificacion));
                    allAutores.add(new Autor(foto, apellido, nombreA, identificacion));

                }
                libros.add(new Libro(anyo, titulo, autores, editorial, precio));
            }
            Bliblioteca bliblioteca = new Bliblioteca(nombre, centro, portada, libros);


            //Se imprimen los datos iniciales
            bliblioteca.imprimirDatos();
            System.out.println();
            System.out.println();

            //Se realiza busqueda por un precio en especifico
            bucarLibrobyprecio(libros,"6595");
            System.out.println();
            System.out.println();

            //Se muestran todos los autores que la biblioteca
            getAutoresBiblioteca(allAutores);
            System.out.println();
            System.out.println();

            //Se consultan todos los libros y se muestran en orden alfabetico
            getAllLibros(libros);





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void  bucarLibrobyprecio(List<Libro> libros, String precio){
        boolean exist = false;

        for (Libro lib : libros){
            String precioComparar = lib.getPrecio();
            if(precio.equals(precioComparar)){
                System.out.println("--------------------------------------------------");
                System.out.println("El resultando de la busqueda es: ");
                System.out.println("--------------------------------------------------");

                System.out.println(lib.toString());
                exist = true;
            }
        }
        if (exist == false){
            System.out.println("--------------------------------------------------");
            System.out.println("No se encontraron resultados");
            System.out.println("--------------------------------------------------");

        }

    }

    public static void  getAutoresBiblioteca(List<Autor> autores){
        String idenActual = "N/N";
        System.out.println("--------------------------------------------------");
        System.out.println("TODOS LOS AUTORES");
        System.out.println("--------------------------------------------------");

        for (Autor au : autores){
            if(!idenActual.equals(au.getIdentificacion())){
                System.out.println(au.toString());
                idenActual = au.getIdentificacion();
            }
        }
        System.out.println("--------------------------------------------------");

    }
    public static void getAllLibros(List<Libro> libros) {
        // Creamos un comparador personalizado que compara los títulos de los libros
        Comparator<Libro> comparador = new Comparator<Libro>() {
            @Override
            public int compare(Libro libro1, Libro libro2) {
                return libro1.getTitulo().compareTo(libro2.getTitulo());
            }
        };

        // Ordenamos la lista de libros utilizando el comparador personalizado
        Collections.sort(libros, comparador);
        System.out.println("--------------------------------------------------");
        System.out.println("TODOS LOS LIBROS");
        System.out.println("--------------------------------------------------");
        for (Libro lib :libros){
            System.out.println(lib.toString());
        }

    }

    }
