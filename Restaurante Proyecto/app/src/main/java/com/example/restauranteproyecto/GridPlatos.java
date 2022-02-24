package com.example.restauranteproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
    final ArrayList<PlatoModel> listaPlato = new ArrayList<PlatoModel>();
    GridView gridView;
    //String[] resources = {"Churrasco", "Chiva", "Pollo", "Pescado"};
    //int[] images = {R.drawable.plaone, R.drawable.platwo, R.drawable.platree, R.drawable.plafour};
    //String[] cost = {"2.50$ c/u","4.50$ c/u","3.00$ c/u","3.50$ c/u"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_platos);
        getData();

        for (int i = 0; i < listaPlato.size(); i++) {
            Log.d(TAG, "datos lista" + listaPlato.get(i).getNombre());
        }

        gridView = findViewById(R.id.gridMatrix);
        CustomAdapter customAdap = new CustomAdapter();
        gridView.setAdapter(customAdap);
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

    private void getData(){
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
        reference.child("PlatosFuertes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Iterable<DataSnapshot> children = snapshot.getChildren();

                for (DataSnapshot child : children) {
                    PlatoModel plato =  child.getValue(PlatoModel.class);
                    listaPlato.add(plato);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

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
    }
}