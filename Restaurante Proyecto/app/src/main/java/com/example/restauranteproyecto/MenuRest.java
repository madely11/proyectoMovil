package com.example.restauranteproyecto;

public class MenuRest {
    private String nombre;
    private String descripcion;

    public MenuRest(String nombre, String descripcion) {
        this.nombre=nombre;
        this.descripcion=descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
