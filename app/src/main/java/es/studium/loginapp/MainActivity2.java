package es.studium.loginapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button btn;
    public static final String MyPREFERENCES = "LoginCredentials";
    public static final String Usuario  = "nombreKey";
    public static final String Clave = "claveKey";
    public static final String Pulsador = "switchKey";


    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        btn = findViewById(R.id.btnBorrar);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Al pulsar en el botón de borrar, se nos borrarán los datos guardados y volveremos
        //a la pantalla de registros

        //Borramos los datos
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Usuario);
        editor.remove(Clave);
        editor.remove(Pulsador);
        editor.apply();

        //Mensaje para indicar que los datos se han borrado correctamente
        Toast.makeText(MainActivity2.this,"Datos Borrados", Toast.LENGTH_SHORT).show();
        //Volvemos al login para el registro
        Intent intentMain = new Intent(this, MainActivity.class);
        startActivity(intentMain);
    }
}