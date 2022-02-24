package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ListaOrden extends AppCompatActivity {

    Bundle b=new Bundle();
    Button enviarOrden;
    ArrayList<PlatoModel> listaPlato = new ArrayList<PlatoModel>();
    PlatoModel plato = new PlatoModel();
    FirebaseDatabase database;
    DatabaseReference reference;
    //private static final String TAG = "list Order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        b=this.getIntent().getExtras();
        listaPlato = new ArrayList<>(b.getParcelableArrayList("list"));
        enviarOrden = (Button)findViewById(R.id.btnEnviarOrden);

        setContentView(R.layout.activity_lista_orden);
        ListView lv1 = findViewById(R.id.listOrder);
        AdaptadorMenu adaptor = new AdaptadorMenu(this);
        lv1.setAdapter(adaptor);

    }

    public void enviarABase(View view) {
        try {
            database = FirebaseDatabase.getInstance();
            reference = database.getReference();
            reference.child("Orders").push().setValue(listaPlato.get(0));
            Toast toast1 = Toast.makeText(getApplicationContext(),"La orden ha sido enviada", Toast.LENGTH_SHORT);
            toast1.show();
        }catch (Exception e){
            e.printStackTrace();
            Toast toast1 = Toast.makeText(getApplicationContext(),"No se puede guardar en la base de datos", Toast.LENGTH_SHORT);
            toast1.show();
        }
    }

    class AdaptadorMenu extends ArrayAdapter<PlatoModel> {
        AppCompatActivity appCompatActivity;
        AdaptadorMenu(AppCompatActivity context) {
            super(context, R.layout.activity_lista_orden_item, listaPlato);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.activity_lista_orden_item, null);

            TextView textView1 = item.findViewById(R.id.nombrePlato);
            TextView textView2 = item.findViewById(R.id.precioPlato);
            TextView textView3 = item.findViewById(R.id.cantidadPlato);
            textView1.setText(listaPlato.get(position).getNombre());
            textView2.setText(listaPlato.get(position).getPrecio());
            textView3.setText(listaPlato.get(position).getDescripcion());
            //enviarABase();
            return(item);
        }
    }



}