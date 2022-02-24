package com.example.restauranteproyecto;

public class Orden {
    private String nombre;
    private String cantidad;
    private String precio; 
    public Orden() {
    }

    public Orden( String nombre, String cantidad, String precio) {
        
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
