package co.edu.poli.ces3.models;

import java.util.List;

public class Bliblioteca {


    private String nombre;

    private String centro;

    private List<Libro> libros;

    private String  portada;

    public Bliblioteca(String nombre, String centro, String portada, List<Libro> libros) {
        this.nombre = nombre;
        this.centro = centro;
        this.libros = libros;
        this.portada = portada;
    }

    public void imprimirDatos() {
        System.out.println("Biblioteca: " + nombre + ", Centro: " + centro);
        System.out.println("Portada: " + portada);

        System.out.println("--------------------------------------------------");

        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autores: " + libro.getAutor());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Año de publicación: " + libro.getAnyo());
            System.out.println("Precio: " + libro.getPrecio());
            System.out.println("--------------------------------------------------");
        }
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public List<Libro> getLibro() {
        return libros;
    }

    public void setLibro(List<Libro> libro) {
        this.libros = libro;
    }
}