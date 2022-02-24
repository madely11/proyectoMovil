package com.example.restauranteproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GridPlatos extends AppCompatActivity {

    private static final String TAG = "PRUEBA";
    FirebaseDatabase database;
    DatabaseReference reference;


    //GridView gridView;
    //String[] resources = {"Churrasco", "Chiva", "Pollo", "Pescado"};
    //int[] images = {R.drawable.plaone, R.drawable.platwo, R.drawable.platree, R.drawable.plafour};
    //String[] cost = {"2.50$ c/u","4.50$ c/u","3.00$ c/u","3.50$ c/u"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_platos);
        ArrayList<PlatoModel> listaPlato = getData();

        //Log.d(TAG, "size " + listaPlato.size());
        for (int i = 0; i < listaPlato.size(); i++) {
            Log.d(TAG, "DENTRO FOR");
            Log.d(TAG, "datos lista" + listaPlato.get(i).getNombre());
        }



       /* gridView = findViewById(R.id.gridMatrix);
        CustomAdapter customAdap = new CustomAdapter();
        gridView.setAdapter(customAdap);*/
        /*gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent in = new Intent(getApplicationContext(), GridItemPlato.class);
                in.putExtra("name", listaPlato.get(i).getNombre());
                in.putExtra("image", listaPlato.get(i).getImagen());
                in.putExtra("cost", listaPlato.get(i).getPrecio());
                startActivity(in);
            }
        } );*/
    }

    private ArrayList<PlatoModel> getData(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        ArrayList<PlatoModel> lista = new ArrayList<PlatoModel>();

        reference.child("PlatosFuertes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap : snapshot.getChildren()) {
                    PlatoModel plato = new PlatoModel();
                    plato.setNombre(snap.child("Name").getValue().toString());
                    plato.setImagen(snap.child("Image").getValue().toString());
                    plato.setDescripcion(snap.child("Description").getValue().toString());
                    plato.setPrecio(snap.child("Price").getValue().toString());
                    lista.add(plato);
                }
                for (int i = 0; i < lista.size(); i++) {
                    Log.d(TAG, "datos lista" + lista.get(i).getNombre());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        SystemClock.sleep(5000);
        Log.d(TAG, "PRUEBAAA");

        return lista;
    }

    /*private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return listaPlato.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.grid_matrix, null);
            //TextView name = view.findViewById(R.id.imageItemText);
            ImageView image = view.findViewById(R.id.imageGrid);

            //name.setText(resources[position]);
            //Uri imageUri = new Uri(listaPlato.get(position).getImagen());
            Uri imageUri = Uri.parse(listaPlato.get(position).getImagen());
            image.setImageURI(imageUri);
            //image.setImageResource(images[position]);
            return view;
        }
    }*/
}