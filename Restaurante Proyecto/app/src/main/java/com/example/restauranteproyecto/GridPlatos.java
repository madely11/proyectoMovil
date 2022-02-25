package com.example.restauranteproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GridPlatos extends AppCompatActivity {

    //private static final String TAG = "PRUEBA";

    GridView gridView;
    //String[] resources = {"Churrasco", "Chiva", "Pollo", "Pescado"};
    int[] images = {R.drawable.plaone, R.drawable.platwo, R.drawable.platree, R.drawable.plafour};
    //String[] cost = {"2.50$ c/u","4.50$ c/u","3.00$ c/u","3.50$ c/u"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_platos);
        ArrayList<PlatoModel> lista = new ArrayList<PlatoModel>();


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference();
        reference = reference.child("PlatosFuertes");

        reference.addValueEventListener(new ValueEventListener() {
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
                //CUSTOM
                gridView = findViewById(R.id.gridMatrix);
                CustomAdapter customAdap = new CustomAdapter(GridPlatos.this, lista);
                gridView.setAdapter(customAdap);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent in = new Intent(getApplicationContext(), GridItemPlato.class);
                        in.putExtra("name", lista.get(i).getNombre());
                        in.putExtra("image", images[i]);
                        in.putExtra("cost", lista.get(i).getPrecio());
                        startActivity(in);
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {
        private Context context;
        private ArrayList<PlatoModel> lista;

        public CustomAdapter(Context context, ArrayList<PlatoModel> lista) {
            this.context = context;
            this.lista = lista;
        }

        @Override
        public int getCount() {
            return images.length;
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
            //Uri imageUri = Uri.parse(lista.get(position).getImagen());
            //image.setImageURI(imageUri);
            image.setImageResource(images[position]);
            return view;
        }
    }
}

