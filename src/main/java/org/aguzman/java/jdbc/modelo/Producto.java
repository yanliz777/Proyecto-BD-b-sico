package org.aguzman.java.jdbc.modelo;

import java.util.Date;

public class Producto {
    //Atributos
    private Long id;
    private String nombre;
    private int precio;
    private Date fechaRegistro;

    //constructores:
    public Producto(Long id, String nombre, int precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }
    public Producto(){}

    //getters/setter:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    //Para ver la imprsión del objeto completo:
    @Override
    public String toString() {
        return  id +
                " | " +
                nombre +
                " | "+
                precio +
                " | " +
                fechaRegistro;
    }
}
