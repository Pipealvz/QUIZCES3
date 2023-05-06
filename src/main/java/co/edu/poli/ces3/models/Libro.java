package co.edu.poli.ces3.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.List;

public class Libro {


    private String anyo;

    private String titulo;

    private List<Autor> autor;

    private String editorial;

    private String precio;

    public Libro(String anyo, String titulo, List<Autor> autor, String editorial, String precio) {
        this.anyo = anyo;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.precio = precio;
    }

    public Libro() {

    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        System.out.println("Titulo: "+titulo);
        System.out.println("año: "+anyo);
        System.out.println("Autores: " + getAutor());


        return "----------------------------------------------------------------";
    }

}
