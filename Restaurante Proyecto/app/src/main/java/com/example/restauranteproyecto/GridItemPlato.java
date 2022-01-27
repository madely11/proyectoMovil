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
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GridItemPlato extends AppCompatActivity {

    private TextView name;
    private TextView cost;
    private ImageView image;
    private Button btnSend;

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

        btnSend = findViewById(R.id.buttonSendGrid);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
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