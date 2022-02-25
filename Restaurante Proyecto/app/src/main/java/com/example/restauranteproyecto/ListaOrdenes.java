package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListaOrdenes extends AppCompatActivity {

    //@Override
    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_ordenes);
        CustomAdapter customAdapter = new CustomAdapter(this, datosOrdenes());
        ListView listView = (ListView) findViewById(R.id.listaOrdenes);
        listView.setAdapter(customAdapter);

        

    }
    //Obtener Ordenes Firebase Realtime
    public List<Orden> datosOrdenes(){
        List<Orden> ordenes = new ArrayList<Orden>();
        //Firebase Realtime
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        myRef = myRef.child("Orders");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Orden orden = new Orden();
                    orden.setNombre(snapshot.child("nombre").getValue().toString());
                    orden.setPrecio(snapshot.child("precio").getValue().toString());
                    ordenes.add(orden);
                }
           }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return ordenes;

    }
    //TODO: Agregar el código de la lista de ordenes
    // Adapter
    private class CustomAdapter extends BaseAdapter {
        private Context context;
        private List<Orden> listaOrdenes;

        public CustomAdapter(Context context, List<Orden> listaOrdenes) {
            this.context = context;
            this.listaOrdenes = listaOrdenes;
        }

        @Override
        public int getCount() {
            return listaOrdenes.size();
        }

        @Override
        public Object getItem(int position) {
            return listaOrdenes.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            
            View view = getLayoutInflater().inflate(R.layout.layout_ordenes, null);
            TextView nombre = (TextView) view.findViewById(R.id.orden_numero);
            TextView precio = (TextView) view.findViewById(R.id.orden_fecha);
            TextView cantidad = (TextView) view.findViewById(R.id.orden_estado);
            //TextView total = (TextView) view.findViewById(R.id.total);
            nombre.setText("Orden " + position);
            precio.setText(listaOrdenes.get(position).getNombre());
            cantidad.setText(listaOrdenes.get(position).getPrecio());

            //total.setText(listaOrdenes.get(position).getTotal());
            return view;
        }
    }*/
    
}