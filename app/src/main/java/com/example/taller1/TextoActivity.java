package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class TextoActivity extends AppCompatActivity {

    private EditText txtTexto;
    private CheckBox checkboxNegrita, checkboxCursiva;
    private Button btnAumentar, btnDisminuir;
    private float textSize = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_texto);
        initView();
        cambiarFormato();
        aumentar();
        disminuir();
    }

    private void initView(){
        txtTexto = findViewById(R.id.txtTexto);
        checkboxNegrita = findViewById(R.id.checkboxNegrita);
        checkboxCursiva = findViewById(R.id.checkboxCursiva);
        btnAumentar = findViewById(R.id.btnAumentar);
        btnDisminuir = findViewById(R.id.btnDisminuir);
    }

    private void cambiarFormato() {

        checkboxNegrita.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            aplicarEstilo();
        });

        checkboxCursiva.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            aplicarEstilo();
        });

    }

    private void aumentar(){
        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSize += 2;
                txtTexto.setTextSize(textSize);
            }
        });
    }

    private void disminuir(){
        btnDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textSize -= 2;
                txtTexto.setTextSize(textSize);
            }
        });
    }

    private void aplicarEstilo() {
        int textStyle = Typeface.NORMAL;

        if (checkboxNegrita.isChecked() && checkboxCursiva.isChecked()) {
            textStyle = Typeface.BOLD_ITALIC;
        } else if (checkboxNegrita.isChecked()) {
            textStyle = Typeface.BOLD;
        } else if (checkboxCursiva.isChecked()) {
            textStyle = Typeface.ITALIC;
        }

        txtTexto.setTypeface(null, textStyle);
    }
}