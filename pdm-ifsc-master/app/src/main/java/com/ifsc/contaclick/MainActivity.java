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
        db=openOrCreateDatabase("banco", Context.MODE_PRIVATE,null);

        db.execSQL("CREATE TABLE notas(id INTGER PRIMARY KEY AUTOINCREMENT, txt VARCHAR)");
        buttonInsere=findViewById(R.id.buttonInsere);
        editText=findViewById(R.id.editText);
        listView=findViewById(R.id.listView);
        buttonInsere.setOnClickListener(v->{
            String msg = editText.getText().toString();
            insereNota(msg);
        });
    public void listagemNotas(){
        Cursor cursor=db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();
        ArrayList<String> listaNotas=new ArrayList<String>();
        while (!cursor.isAfterLast()){
            int coluna=cursor.getColumnIndex(columnName "txt");
            listaNotas.add(cursor.getString(coluna));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context this,
                android.R.layout.simple_list_item_1,
                android.R.layout.id.text1,
                listaNotas
        );
        listView.setAdapter(adapter);
        }


    }
    public void insereNota(String txt){
     //   db.execSQL("INSERT INTO NOTAS(txt) VALUES(" + " ); ");
        ContentValues cv=new ContentValues();
        cv.put("txt", txt);
        db.insert("notas", null, cv);
        listagemNotas();
    }
}