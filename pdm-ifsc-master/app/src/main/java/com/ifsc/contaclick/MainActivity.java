package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    int i=0;
    EditText edpeso,edaltura;
    TextView tvresulado;
    Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida","metodo onCreate");
        setContentView(R.layout.activity_main);
        edpeso=findViewById(R.id.edpeso);
        edpeso.setText("60");
        edaltura=findViewById(R.id.edaltura);
        edaltura.setText("1.58");

        buttonCalcular=findViewById(R.id.button);
        //define um tratamento para o click do botão
        buttonCalcular.setOnClickListener(v->{
            Intent intent = new Intent(getApplicationContext(), MainActivityB.class);
            Double peso= Double.parseDouble(edpeso.getText().toString());
            Double altura= Double.parseDouble(edaltura.getText().toString());
            //Definindi parametros para o bundle peso e altura
            intent.putExtra("peso", peso);
            intent.putExtra("altura", altura);

            startActivity(intent);
        });
    }

}