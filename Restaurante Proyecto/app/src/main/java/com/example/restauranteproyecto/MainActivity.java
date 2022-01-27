package com.example.restauranteproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button iniciarSesion;
    EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarSesion = (Button)findViewById(R.id.btnLogin);
        user = (EditText)findViewById(R.id.txtUsername);
        pass = (EditText)findViewById(R.id.txtPassword);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inicio = new Intent(MainActivity.this, ListaMenu.class);

                if(user.getText().toString().equals("") || pass.getText().toString().equals("")){
                    Toast toast1 = Toast.makeText(getApplicationContext(),"El Usuario o la contraseña se encuentran vacios", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{
                        if(user.getText().toString().equals("Carlos") && pass.getText().toString().equals("123")){
                            //intent.putExtra("usuario", user.getText().toString());
                            startActivity(inicio);
                        }else{
                            Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
                            toast1.show();
                        }
                }






            }
        });

    }
}