package com.example.restauranteproyecto;

import android.os.Parcel;
import android.os.Parcelable;

public class PlatoModel implements Parcelable {
    private String descripcion;
    private String imagen;
    private String nombre;
    private String precio;


    public PlatoModel(String nombre, String imagen, String precio, String descripcion) {
        this.setNombre(nombre);
        this.setImagen(imagen);
        this.setPrecio(precio);
        this.setDescripcion(descripcion);
    }

    public PlatoModel(){

    }

    public PlatoModel(String nombre,String precio) {
        this.setNombre(nombre);
        this.setDescripcion("1");
        this.setPrecio(precio);
    }

    protected PlatoModel(Parcel in) {
        nombre = in.readString();
        imagen = in.readString();
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
        parcel.writeString(imagen);
        parcel.writeString(precio);
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
