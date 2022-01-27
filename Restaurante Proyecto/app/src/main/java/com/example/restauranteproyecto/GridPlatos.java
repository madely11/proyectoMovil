package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridPlatos extends AppCompatActivity {

    GridView gridView;
    String[] resources = {"Churrasco", "Chiva", "Pollo", "Pescado"};
    int[] images = {R.drawable.plaone, R.drawable.platwo, R.drawable.platree, R.drawable.plafour};
    String[] cost = {"2.50$ c/u","4.50$ c/u","3.00$ c/u","3.50$ c/u"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_platos);

        gridView = findViewById(R.id.gridMatrix);
        CustomAdapter customAdap = new CustomAdapter();
        gridView.setAdapter(customAdap);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent in = new Intent(getApplicationContext(), GridItemPlato.class);
                in.putExtra("name", resources[i]);
                in.putExtra("image", images[i]);
                in.putExtra("cost", cost[i]);
                startActivity(in);
            }
        } );

    }

    private class CustomAdapter extends BaseAdapter {

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
            image.setImageResource(images[position]);
            return view;
        }
    }
}