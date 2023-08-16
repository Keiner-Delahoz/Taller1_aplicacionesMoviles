package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button btnMatematicas, btnFisica, btnTexto, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        matematicas();
        fisica();
        texto();
        salir();
    }

    private void initView(){
        btnMatematicas = findViewById(R.id.btnMatematicas);
        btnFisica = findViewById(R.id.btnFisica);
        btnTexto = findViewById(R.id.btnTexto);
        btnSalir = findViewById(R.id.btnSalir);
    }

    private void matematicas() {
        btnMatematicas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, MatematicaActivity.class);
                startActivity(i);
            }
        });
    }

    private void fisica() {
        btnFisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,FisicaActivity.class);
                startActivity(i);
            }
        });
    }

    private void texto() {
        btnTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this,TextoActivity.class);
                startActivity(i);
            }
        });
    }

    private void salir() {
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity.limpiarCampos();
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_area_triangulo) {
            // Código para manejar la opción "Área triángulo"
            // Por ejemplo, puedes iniciar una nueva actividad aquí
            return true;
        } else if (id == R.id.action_celsius_fahrenheit) {
            // Código para manejar la opción "Celsius a Farenheit"
            // Por ejemplo, puedes iniciar otra actividad aquí
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}