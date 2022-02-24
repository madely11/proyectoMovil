package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    private ArrayList<MenuRest> menuRests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_menu);
        menuRests =new ArrayList<MenuRest>();
        menuRests.add(new MenuRest("Platos Fuertes", "Encontraras los mejores platos para su degustación"));
        menuRests.add(new MenuRest("Bebidas","Todo tipo de bebidas"));
        menuRests.add(new MenuRest("Postres","Los mas deliciosos postres"));

        AdaptadorMenu adaptador = new AdaptadorMenu(this);
        ListView lv1 = findViewById(R.id.list1);
        lv1.setAdapter(adaptador);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                if(i==0){
                    intent = new Intent(ListaMenu.this, GridPlatos.class);
                    Toast.makeText(ListaMenu.this, menuRests.get(i).getNombre(), Toast.LENGTH_LONG).show();
                    startActivity(intent);}
                else if(i==2){
                    intent = new Intent(ListaMenu.this, GridPostres.class);
                    Toast.makeText(ListaMenu.this, menuRests.get(i).getNombre(), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }else {
                    intent = new Intent(ListaMenu.this, GridBebidas.class);
                    Toast.makeText(ListaMenu.this, menuRests.get(i).getNombre(), Toast.LENGTH_LONG).show();
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
                switch (item.getItemId()) {
            case R.id.Salir:
                 intent = new Intent(ListaMenu.this,MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.ir_menu:
                 intent = new Intent(ListaMenu.this,GridPlatos.class);
                 startActivity(intent);
                return true;
            case R.id.ir_carrito:
                intent = new Intent(ListaMenu.this,ListaOrden.class);
                startActivity(intent);
            return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    class AdaptadorMenu extends ArrayAdapter<MenuRest> {

        AppCompatActivity appCompatActivity;

        AdaptadorMenu(AppCompatActivity context) {
            super(context, R.layout.menu, menuRests);
            appCompatActivity = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
            View item = inflater.inflate(R.layout.menu, null);

            TextView textView1 = item.findViewById(R.id.tx1);
            TextView textView2 = item.findViewById(R.id.tx2);
            textView1.setText(menuRests.get(position).getNombre());
            textView2.setText(menuRests.get(position).getDescripcion());
            ImageView imageView1 = item.findViewById(R.id.img1);
            if (menuRests.get(position).getNombre()=="Platos Fuertes")
                imageView1.setImageResource(R.mipmap.platofuerte);
            else if(menuRests.get(position).getNombre()=="Bebidas")
                imageView1.setImageResource(R.mipmap.bebidas);
            else{
                imageView1.setImageResource(R.mipmap.postres);
            }
            return(item);
        }
    }
}