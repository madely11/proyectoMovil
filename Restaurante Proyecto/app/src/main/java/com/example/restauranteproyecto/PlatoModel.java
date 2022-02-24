package com.example.restauranteproyecto;

import android.os.Parcel;
import android.os.Parcelable;

public class PlatoModel implements Parcelable {
    private String nombre;
    private String cantidad;
    private String precio;


    public PlatoModel(String nombre, String cantidad, String precio) {
        this.setNombre(nombre);
        this.setCantidad(cantidad);
        this.setPrecio(precio);
    }

    public PlatoModel(){

    }

    public PlatoModel(String nombre,String precio) {
        this.setNombre(nombre);
        this.setCantidad("1");
        this.setPrecio(precio);
    }

    protected PlatoModel(Parcel in) {
        nombre = in.readString();
        cantidad = in.readString();
        precio = in.readString();
    }

    public static final Creator<PlatoModel> CREATOR = new Creator<PlatoModel>() {
        @Override
        public PlatoModel createFromParcel(Parcel in) {
            return new PlatoModel(in);
        }

        @Override
        public PlatoModel[] newArray(int size) {
            return new PlatoModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeString(cantidad);
        parcel.writeString(precio);
    }
}
