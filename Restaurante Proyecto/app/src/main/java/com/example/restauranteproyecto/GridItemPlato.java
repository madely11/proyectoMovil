package com.example.restauranteproyecto;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GridItemPlato extends AppCompatActivity {

    private TextView name;
    private TextView cost;
    private ImageView image;
    private Button btnSend;
    //private ArrayList<PlatoModel> listaPlato = new ArrayList<PlatoModel>();
    PlatoModel plato = new PlatoModel();
    Bundle b = new Bundle();
    private MainActivity obj = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item_plato);

        name = findViewById(R.id.imageItemText);
        image = findViewById(R.id.imageViewItem);
        cost = findViewById(R.id.gridPlatoItemCostTxt);

        Intent intent = getIntent();
        name.setText(intent.getStringExtra("name"));
        image.setImageResource(intent.getIntExtra("image", 0));
        cost.setText(intent.getStringExtra("cost"));

        plato.setNombre(name.getText().toString());
        plato.setPrecio(cost.getText().toString());

        btnSend = findViewById(R.id.buttonSendGrid);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                sendArray(intent);
                showNotification();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showNotification() {
        NotificationChannel channel = new NotificationChannel("canal1",
                "NEW", NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        showNewNotification();
    }

    private void sendArray(Intent intent){
        obj.listaPlato.add(plato);
        b.putParcelableArrayList("list", obj.listaPlato);
        intent = new Intent(GridItemPlato.this, ListaOrden.class);
        intent.putExtras(b);
        startActivity(intent);
    }

    private void showNewNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(),
                "canal1")
                .setSmallIcon(R.drawable.ic_baseline_food_bank_24)
                .setContentTitle("Se añadio al carrito: " + name.getText())
                .setContentText("Se paciente, pronto te atenderemos")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(
                getApplicationContext());
        managerCompat.notify(1,builder.build());
    }
}