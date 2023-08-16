package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FisicaActivity extends AppCompatActivity {

    private EditText txtVelocidad, txtTiempo, txtResultado;
    private Button btnCalcular, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);
        initView();
        calcular();
        limpiarCampos();
    }

    private void initView(){
        txtVelocidad = findViewById(R.id.txtVelocidad);
        txtTiempo = findViewById(R.id.txtTiempo);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
    }

    private void calcular(){
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double velocidad = Double.parseDouble(txtVelocidad.getText().toString());
                    double tiempo = Double.parseDouble(txtTiempo.getText().toString());

                    String resultado = "";

                    if (velocidad >= 0 && tiempo >= 0) {
                        double distancia = velocidad * tiempo;

                        resultado = "Distancia = " + distancia + " metros";

                        txtResultado.setText(String.valueOf(resultado.toString()));
                    } else {
                        throw new IllegalArgumentException("La velocidad y el tiempo deben ser valores no negativos");
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(FisicaActivity.this, "Por favor ingrese valores válidos en velocidad y tiempo", Toast.LENGTH_LONG).show();
                } catch (IllegalArgumentException e) {
                    Toast.makeText(FisicaActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }

    private void limpiarCampos() {
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtVelocidad.setText("");
                txtTiempo.setText("");
                txtResultado.setText("");
                txtVelocidad.requestFocus();
            }
        });
    }
}