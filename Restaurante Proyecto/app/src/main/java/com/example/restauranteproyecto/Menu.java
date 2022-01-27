package com.example.restauranteproyecto;

public class Menu {
    private String nombre;
    private String descripcion;

    public Menu(String nombre, String descripcion) {
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
