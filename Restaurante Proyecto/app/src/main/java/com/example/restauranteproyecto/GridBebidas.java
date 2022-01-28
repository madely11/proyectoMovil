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

public class GridBebidas extends AppCompatActivity {

    GridView gridView;
    String[] resources = {"Limonada", "Jamaica", "J Mora", "Coca cola"};
    int[] images = {R.drawable.beb1, R.drawable.beb2, R.drawable.beb3, R.drawable.beb4};
    String[] cost = {"1.50$ c/u","0.50$ c/u","1.00$ c/u","1.50$ c/u"};

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