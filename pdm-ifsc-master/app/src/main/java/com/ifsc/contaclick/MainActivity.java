package com.ifsc.contaclick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    Integer i = 0;

    EditText edpeso, edaltura;
    TextView tvresultado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida","metodo onCreate" );

        setContentView(R.layout.activity_main);

        edpeso = findViewById(R.id.edpeso);

        edaltura = findViewById(R.id.edaltura);

        tvresultado = findViewById(R.id.tvresultadoimc);

        buttonCalcular = findViewById(R.id.button);

        buttonCalcular.setOnClickListener(v -> {
            double peso, altura, imc;

            peso = Double.parseDouble(edpeso.getText().toString());
            altura= Double.parseDouble(edaltura.getText().toString());
            imc = peso/(altura*altura);
            //formatando numero
            DecimalFormat decimalFormat=new DecimalFormat("##.##");

            tvresultado.setText(decimalFormat.format(imc));
            TextView tv = findViewById(R.id.tvpeso);
            tv.setText(getString(R.string.app_name));

            Button b = findViewById(R.id.button);

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tv.setText(Integer.toString(i));
                    i++;
                }
            });

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo de vida","metodo onStart" );

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo de vida","metodo onResume" );

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("ciclo de vida","metodo onStop" );

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo de vida","metodo onPause" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("ciclo de vida","metodo onDestroy" );

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("ciclo de vida","metodo onRestart" );

    }




    }
