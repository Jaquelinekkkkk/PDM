package com.ifsc.contaclick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int i=0;
    String [] nomes = new String[] { "Mercurio","Venus", "Marte", "Saturno", "Plutão", "Terra", "Urano", "Netuno", "Júpter"};
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
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i= new Intent(getApplicationContext(), PlanetActivity.class);
                i.putExtra("nome", nomes[position]);

                startActivity(i);


            }

        });

    }
}