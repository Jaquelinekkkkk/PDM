package com.ifsc.contaclick;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_b);
        Bundle bundle=getIntent().getExtras();
        Double peso= bundle.getDouble("peso");
        Double altura= bundle.getDouble("altura");
        Double imc=(peso/(altura*altura));

        TextView tvIMC =findViewById(R.id.textViewIMC);
        TextView tvaltura =findViewById(R.id.tvAlturaResult);
        TextView tvpeso =findViewById(R.id.tvpesoResult);
        TextView tvDescricao =findViewById(R.id.textViewDescricaoIMC);
        ImageView imageView=findViewById(R.id.imageViewPerfil);


        //valor do IMC no TextView
        tvIMC.setText(String.format("%.2f", imc)+" kg/m²");
        //valor da altura no TextView
        tvaltura.setText(String.format("%.2f", altura)+" m");
        // valor do peso no TextView
        tvpeso.setText(String.format("%.2f", peso)+" kg");
/*
IMC abaixo de 18,5: Abaixo do peso
IMC entre 18,5 e 24,9: Peso normal
IMC entre 25 e 29,9: Sobrepeso
IMC entre 30 e 34,9: Obesidade grau 1
IMC entre 35 e 39,9: Obesidade grau 2
IMC acima de 40: Obesidade grau 3
 */
        if (imc<18.5){
            tvDescricao.setText("Atenção! Você estoá abaixo do peso ideal!");
            imageView.setImageResource(R.drawable.abaixopeso);
        }else if (imc>=18.5 && imc<=24.9){
            tvDescricao.setText("Parabéns! O seu peso está normal!");
            imageView.setImageResource(R.drawable.normal);
        }else if (imc>=25 && imc<=29.9){
            tvDescricao.setText("Atenção! Você está com sobrepeso!");
            imageView.setImageResource(R.drawable.sobrepeso);
        }else if (imc>=30 && imc<=34.9){
            tvDescricao.setText("Atenção! Você está com obesidade grau 1!");
            imageView.setImageResource(R.drawable.obesidade1);
        }else if (imc>=35 && imc<=39.9){
            tvDescricao.setText("Atenção! Voc~e está com obesidade grau 2!");
            imageView.setImageResource(R.drawable.obesidade2);
        }else {
            tvDescricao.setText("Atenção! Voc~e está com pbesidade grau 3!");
            imageView.setImageResource(R.drawable.obesidade3);
        }
        tvaltura.setText(altura.toString());
        tvpeso.setText(peso.toString());




    }
}