package com.example.taller1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private static EditText txtUsuario;
    private static EditText txtContrasena;
    private CheckBox checkTerminos;
    private Button btnIngresar;
    private Button btnCancelar;

    private static TextInputLayout txtContrasenaLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        estadoCheckBox();
        ingresar();
        cancelar();
    }

    private void initView(){
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContrasena = findViewById(R.id.txtContrasena);
        checkTerminos = findViewById(R.id.checkboxTerminos);
        btnIngresar = findViewById(R.id.btnIngresar);
        btnCancelar = findViewById(R.id.btnCancelar);
        txtContrasenaLayout = findViewById(R.id.txtContrasenaLayout);
        progressBar = findViewById(R.id.progressBar);
    }

    private void estadoCheckBox() {
        checkTerminos.setOnCheckedChangeListener((buttonView, isChecked) -> {
            btnIngresar.setEnabled(isChecked); // Habilita/deshabilita el botón
        });
    }

    private void ingresar() {
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtContrasenaLayout.setHelperText(null);
                if (!validarCamposVacios()) {
                    Toast.makeText(LoginActivity.this, "Digite todos los campos requeridos", Toast.LENGTH_LONG).show();
                    return;
                }
                if(txtUsuario.getText().toString().equals("Admin")&& txtContrasena.getText().toString().equals("admin123")) {

                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {    // Simular la verificación de credenciales durante 2 segundos
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(i);
                        }
                    }, 2000); // 2000 milisegundos (2 segundos)

                } else {

                    progressBar.setVisibility(View.VISIBLE);
                    new Handler().postDelayed(new Runnable() {    // Simular la verificación de credenciales durante 2 segundos
                        @Override
                        public void run() {
                            progressBar.setVisibility(View.GONE);
                            txtContrasenaLayout.setHelperText("Credenciales incorrectas");
                            txtContrasenaLayout.setHelperTextTextAppearance(R.style.HelperTextStyle);
                        }
                    }, 2000); // 2000 milisegundos (2 segundos)
                }
            }
        });
    }


    private void cancelar() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtUsuario.setText("");
                txtContrasena.setText("");
                txtUsuario.requestFocus();
            }
        });
    }

    private boolean validarCamposVacios() {
        boolean retorno = true;
        String campoUsuario = txtUsuario.getText().toString();
        String campoContraseña = txtContrasena.getText().toString();
        if (campoUsuario.isEmpty()) {
            txtUsuario.setError("El usuario no puede estar vacio");
            retorno = false;
        }
        if (campoContraseña.isEmpty()){
            txtContrasena.setError("La contraseña no puede estar vacia");
            retorno = false;
        }
        return retorno;
    }

    public static void limpiarCampos() {
        if (txtUsuario != null) {
            txtUsuario.setText("");
        }
        if (txtContrasena != null) {
            txtContrasena.setText("");
            txtContrasenaLayout.setHelperText(null);
        }
        txtUsuario.requestFocus();
    }
}