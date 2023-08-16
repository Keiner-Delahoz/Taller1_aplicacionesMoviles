package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MatematicaActivity extends AppCompatActivity {

    private EditText txtValorA, txtValorB, txtValorC, txtResultado;
    private Button btnCalcular, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematicas);
        initView();
        calcular();
        limpiarCampos();
    }

    private void initView(){
        txtValorA = findViewById(R.id.txtValorA);
        txtValorB = findViewById(R.id.txtValorB);
        txtValorC = findViewById(R.id.txtValorC);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
    }

    private void calcular() {
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double a = Double.parseDouble(txtValorA.getText().toString());
                    double b = Double.parseDouble(txtValorB.getText().toString());
                    double c = Double.parseDouble(txtValorC.getText().toString());

                    double discriminante = b * b - 4 * a * c;
                    String resultado = "";

                    if (discriminante > 0) {
                        double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                        double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);

                        String raiz1Redondeada = String.format("%.4f", raiz1);
                        String raiz2Redondeada = String.format("%.4f", raiz2);

                        resultado = "Las raíces son reales y distintas:"+ "" +
                                "\nRaíz 1: " + raiz1Redondeada + "\nRaíz 2: " + raiz2Redondeada;

                        txtResultado.setText(String.valueOf(resultado.toString()));

                    } else if (discriminante == 0) {
                        double raiz = -b / (2 * a);
                        String raizRedondeada = String.format("%.4f", raiz);

                        resultado = "Las raíces son reales e iguales:"+ "" + "\nRaízes: " + raizRedondeada;
                        txtResultado.setText(String.valueOf(resultado.toString()));

                    } else {
                        Toast.makeText(MatematicaActivity.this, "El discriminante es negativo, no hay raíces reales.", Toast.LENGTH_LONG).show();
                        resultado = "Las raíces son complejas";

                        txtResultado.setText(String.valueOf(resultado.toString()));
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MatematicaActivity.this, "Por favor ingrese valores válidos para a, b y c.", Toast.LENGTH_LONG).show();
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
                txtValorA.setText("");
                txtValorB.setText("");
                txtValorC.setText("");
                txtResultado.setText("");
                txtValorA.requestFocus();
            }
        });
    }
}