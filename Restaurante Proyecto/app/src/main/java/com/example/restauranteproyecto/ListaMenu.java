package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaMenu extends AppCompatActivity {
    private ArrayList<Menu> menus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu);
        menus=new ArrayList<Menu>();
        menus.add(new Menu("Platos Fuertes", "Encontraras los mejores platos para su degustación"));
        menus.add(new Menu("Bebidas","Todo tipo de bebidas"));
        menus.add(new Menu("Postres","Los mas deliciosos postres"));

        AdaptadorMenu adaptador = new AdaptadorMenu(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if(i==0){
                    intent = new Intent(ListaMenu.this, GridPlatos.class);
                    Toast.makeText(ListaMenu.this,menus.get(i).getNombre(), Toast.LENGTH_LONG).show();}
                else if(i==2){
                    Toast.makeText(ListaMenu.this,menus.get(i).getNombre(), Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ListaMenu.this,menus.get(i).getNombre(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    class AdaptadorMenu extends ArrayAdapter<Menu> {

        AppCompatActivity appCompatActivity;

        AdaptadorMenu(AppCompatActivity context) {
            super(context, R.layout.menu, menus);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.menu, null);

            TextView textView1 = item.findViewById(R.id.tx1);
            TextView textView2 = item.findViewById(R.id.tx2);
            textView1.setText(menus.get(position).getNombre());
            textView2.setText(menus.get(position).getDescripcion());
            ImageView imageView1 = item.findViewById(R.id.img1);
            if (menus.get(position).getNombre()=="Platos Fuertes")
                imageView1.setImageResource(R.mipmap.platofuerte);
            else if(menus.get(position).getNombre()=="Bebidas")
                imageView1.setImageResource(R.mipmap.bebidas);
            else{
                imageView1.setImageResource(R.mipmap.postres);
            }
            return(item);
        }
    }
}