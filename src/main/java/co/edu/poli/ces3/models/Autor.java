package co.edu.poli.ces3.models;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Autor {

    private String foto;

    private String apellido;

    private String nombre;

    private String documento;


    public Autor(String foto, String apellido, String nombre, String documento) {
        this.foto = foto;
        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getIdentificacion() {
        return documento;
    }

    public void setIdentificacion(String identificacion) {
        this.documento = identificacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Nombre completo: "+nombre+" "+apellido+"  "+"Foto"+foto;
    }
}
