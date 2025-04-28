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
    EditText editText1,editText2;
    TextView textName, textDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ciclo de vida","metodo onCreate");
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.editText1);
        editText1.setText("60");
        editText2=findViewById(R.id.editText2);
        editText2.setText("1.58");

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