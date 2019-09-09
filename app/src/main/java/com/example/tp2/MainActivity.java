package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private int flag = 1;
    private TextView monedaUno, monedaDos, tvResultado;
    private EditText etValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monedaUno = findViewById(R.id.tvMoneda1);
        monedaDos = findViewById(R.id.tvMoneda2);
        tvResultado = findViewById(R.id.tvResultado);
        etValor = findViewById(R.id.etValor);
    }

    public void invertir(View v) {

        if (flag == 1) {
            monedaUno.setText("Euros");
            monedaDos.setText("Dólares");
            flag = 2;
        } else {
            monedaUno.setText("Dólares");
            monedaDos.setText("Euros");
            flag = 1;
        }

        tvResultado.setText("");
        etValor.setText("");

    }

    public void convertir(View v) {
        double valor = Double.parseDouble(etValor.getText().toString());
        double resultado;
        String signo;

        if (flag == 1) {
            resultado = valor * 0.9070;
            signo = "€";
        } else {
            resultado = valor * 1.1027;
            signo = "u$s";
        }

        DecimalFormat format = new DecimalFormat("#.00");
        String resString = signo + format.format(resultado);
        tvResultado.setText(resString);
    }
}
