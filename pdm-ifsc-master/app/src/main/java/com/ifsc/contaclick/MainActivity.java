package com.ifsc.contaclick;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i=0;

    SQLiteDatabase db;
    Button buttonInsere;
    EditText editText;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonInsere = findViewById(R.id.buttonInsere);
        editText = findViewById(R.id.editText);
        listView = findViewById(R.id.listView);

        db = openOrCreateDatabase("banco", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas(id INTEGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");
        this.listagemNotas();


        buttonInsere.setOnClickListener(v -> {
            String texto = editText.getText().toString();
            if(!texto.isEmpty()){
                insereNota(texto);
            }
           // insereNota(nota);
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Nota nota = (Nota) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(MainActivity.this, ExibeNotaActivity.class);
                intent.putExtra("nota", nota);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        listagemNotas();
    }


    public void insereNota(String texto){
        //   db.execSQL("INSERT INTO NOTAS(txt) VALUES(" + " ); ");
        ContentValues cv=new ContentValues();
        cv.put("txt", texto);
        db.insert("notas", null, cv);
        editText.setText("");
        this.listagemNotas();
        //  listagemNotas();
        // db.insert("notas", null, cv);

    }

    public void atualizaListagemNotas(ArrayList<Nota> lista) {
        AdapterNotas adapter = new AdapterNotas(this, R.layout.item_nota, lista);
        listView.setAdapter(adapter);
    }


    public void listagemNotas(){
        ArrayList<Nota> lista = new ArrayList<Nota>();

        Cursor cursor=db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

//ArrayList<String> listaNotas=new ArrayList<String>();
        Nota n ;
        while (!cursor.isAfterLast()) {
            n = new Nota(cursor.getInt(0), cursor.getString(1));
            lista.add(n);
            cursor.moveToNext();

        }
        cursor.close();
        atualizaListagemNotas(lista);

           // int coluna=cursor.getColumnIndex( "txt");
        //    listaNotas.add(cursor.getString(coluna));
         //   cursor.moveToNext();
        }

      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
          //      android.R.layout.simple_list_item_1,
             //   android.R.id.text1,
              //  listaNotas);

   //     listView.setAdapter(adapter);
        //}






}