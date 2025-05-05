package com.ifsc.contaclick;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    int i=0;
    String [] nomes = new String[] { "Anne","Fernanda", "João1", "João2", "João3"};
   // ListView lv;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperar listView
        lv=findViewById(R.id.listView);

        //ADAPTADOR
        ArrayAdapter<String> a = new ArrayAdapter(this,
                R.layout.item_lista,
                R.id.textView,
                nomes);

        lv.setAdapter(a);

    }
}