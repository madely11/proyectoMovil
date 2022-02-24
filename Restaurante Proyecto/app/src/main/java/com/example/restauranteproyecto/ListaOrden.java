package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaOrden extends AppCompatActivity {

    Bundle b=new Bundle();
    ArrayList<PlatoModel> listaPlato;
    PlatoModel plato = new PlatoModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=this.getIntent().getExtras();
        listaPlato = new ArrayList<>(b.getParcelableArrayList("list"));
        setContentView(R.layout.activity_lista_orden);
        ListView lv1 = findViewById(R.id.listOrder);
        AdaptadorMenu adaptor = new AdaptadorMenu(this);
        lv1.setAdapter(adaptor);
    }

    class AdaptadorMenu extends ArrayAdapter<PlatoModel> {
        AppCompatActivity appCompatActivity;
        AdaptadorMenu(AppCompatActivity context) {
            super(context, R.layout.activity_lista_orden_item, listaPlato);
            appCompatActivity = context;
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater inflater = appCompatActivity.getLayoutInflater();
        //View item = inflater.inflate(R.layout.activity_lista_orden_item, null);
        View view = getLayoutInflater().inflate(R.layout.activity_lista_orden_item, null);

        TextView textView1 = view.findViewById(R.id.tx1);
        TextView textView2 = view.findViewById(R.id.tx2);
        TextView textView3 = view.findViewById(R.id.tx3);
        textView1.setText(listaPlato.get(position).getNombre());
        textView2.setText(listaPlato.get(position).getPrecio());
        textView3.setText(listaPlato.get(position).getCantidad());
        return(view);
    }
}