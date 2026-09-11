package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etMensaje;
    Button btnEnviar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMensaje = findViewById(R.id.etMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);
        tvResultado = findViewById(R.id.tvResultado);

        btnEnviar.setOnClickListener(v -> {

            String mensaje = etMensaje.getText().toString();

            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("mensaje", mensaje);

            startActivityForResult(intent, 1);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                tvResultado.setText("Resultado: mensaje recibido");
            } else if (resultCode == RESULT_CANCELED) {
                tvResultado.setText("Resultado: operación cancelada");
            }
        }
    }
}