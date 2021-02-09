package es.studium.loginapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Switch s1;
    Button b1;

    public static final String MyPREFERENCES = "LoginCredentials";
    public static final String Usuario  = "nombreKey";
    public static final String Clave = "claveKey";
    public static final String Pulsador = "switchKey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.txtUsuario);
        ed2 = findViewById(R.id.txtClave);

        s1 = findViewById(R.id.txtGuardar);

        b1 = findViewById(R.id.btnAcceder);

        cargarPreferencias();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    if (!ed1.getText().toString().equals("") && !ed2.getText().toString().equals("")) {

                        String n = ed1.getText().toString();
                        String c = ed2.getText().toString();

                        String nombre = "moises";
                        String dni = "30696107P";

                        SharedPreferences.Editor editor = sharedPreferences.edit();


                        if (nombre.equals(n) && c.equals(dni)) {
                            //Si el switch es pulsado, generamos los datos
                            if (s1.isChecked()) {
                                editor.putString(Usuario, n);
                                editor.putString(Clave, c);
                                editor.putString(Pulsador, "true");
                                editor.commit();

                                //Si pulsamos boton
                                if (v.getId() == (R.id.btnAcceder)) {
                                    //Escribimos el código necesario para iniciar el
                                    // segundo activity MainActivity2
                                    // Se trata de un Intent explícito
                                    Intent intentMain2 = new Intent(MainActivity.this, MainActivity2.class);
                                    startActivity(intentMain2);

                                    Toast.makeText(MainActivity.this, "Datos salvados", Toast.LENGTH_SHORT).show();
                                }
                            }
                            //En caso de que no hayamos pulsado en el switch
                            else {
                                if (v.getId() == (R.id.btnAcceder)) {
                                    //Escribimos el código necesario para iniciar el
                                    // segundo activity MainActivity2
                                    // Se trata de un Intent explícito
                                    Intent intentMain2 = new Intent(MainActivity.this, MainActivity2.class);
                                    startActivity(intentMain2);

                                    Toast.makeText(MainActivity.this, "Datos salvados", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this,"Las credenciales no son correctas", Toast.LENGTH_SHORT).show();
                        }
                    }

                        else
                            {
                            Toast.makeText(MainActivity.this, "Insertar datos en los campos de Usuario y Clave", Toast.LENGTH_SHORT).show();
                        }


                }

        });

    }

    private void cargarPreferencias() {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String user = sharedPreferences.getString(Usuario, "");

        //¿Hay ya información en las Shared Preferences?
        if(user!= "")
        {
            Intent intentMain2 = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intentMain2);



        }

    }


}