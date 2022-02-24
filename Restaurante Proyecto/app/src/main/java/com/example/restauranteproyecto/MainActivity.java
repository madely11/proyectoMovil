package com.example.restauranteproyecto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button iniciarSesion;
    EditText user, pass;
    FirebaseAuth mAuth;
    String email = "";
    String contra = "";
    ArrayList<PlatoModel> listaPlato = new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        iniciarSesion = (Button)findViewById(R.id.btnLogin);
        user = (EditText)findViewById(R.id.txtUsername);
        pass = (EditText)findViewById(R.id.txtPassword);

        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent inicio = new Intent(MainActivity.this, ListaMenu.class);
                email = user.getText().toString();
                contra = pass.getText().toString();
                if(!email.isEmpty() && !contra.isEmpty() && !email.equals("Admin")){
                    loginUser();
                }else if(email.equals("Admin") && contra.equals("admin")){
                    Intent inicio = new Intent(MainActivity.this, ListaOrdenes.class);
                    startActivity(inicio);
                }
                else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),"El Usuario o la contraseña se encuentran vacios", Toast.LENGTH_SHORT);
                    toast1.show();
                }

            }
        });

    }

    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(MainActivity.this, ListaMenu.class));
                    finish();
                }
                else{
                    Toast toast1 = Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrectos", Toast.LENGTH_SHORT);
                    toast1.show();
                }
            }
        });
    }
}