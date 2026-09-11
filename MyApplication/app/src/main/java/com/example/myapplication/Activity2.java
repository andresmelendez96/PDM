package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    TextView tvMensaje;
    Button btnRecibir;
    Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tvMensaje = findViewById(R.id.tvMensaje);
        btnRecibir = findViewById(R.id.btnRecibir);
        btnCancelar = findViewById(R.id.btnCancelar);

        String mensaje = getIntent().getStringExtra("mensaje");

        tvMensaje.setText("Mensaje recibido: " + mensaje);

        btnRecibir.setOnClickListener(v -> {
            setResult(RESULT_OK);
            finish();
        });

        btnCancelar.setOnClickListener(v -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }
}