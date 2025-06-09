package com.ifsc.contaclick;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExibeNotaActivity extends AppCompatActivity {
    SQLiteDatabase db;

    TextView tvid;
    EditText editText;
    Nota nota;
    Button buttonUpdate, buttonDelete, buttonCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exibe_nota);

        Bundle b= getIntent().getExtras();
        if( b.containsKey("nota")){
            nota = (Nota) b.getSerializable("nota");
        }else{
            Toast.makeText(this, "Nota vazia", Toast.LENGTH_SHORT).show();
            finish();
        }
        //associando os componentes com váriaveis locais
        tvid= findViewById(R.id.textViewId);
        editText= findViewById(R.id.edNota);
        buttonCancelar = findViewById(R.id.buttonCancelar);
        buttonDelete= findViewById(R.id.buttonDeletar);
        buttonUpdate= findViewById(R.id.buttonSalvar);

        //Configura o banco de dados
        db = openOrCreateDatabase("banco", MODE_PRIVATE, null);
        //Handler de eventos
        buttonCancelar.setOnClickListener(view -> {
            finish();
        });
        buttonUpdate.setOnClickListener((view -> {
            updateNota();
            Toast.makeText(this, "Nota atualizada", Toast.LENGTH_SHORT).show();
            finish();
        }));
        buttonDelete.setOnClickListener((view -> {
            db.delete("notas", "id=?", new String[]{String.valueOf(nota.id)});
            Toast.makeText(this, "Nota deletada", Toast.LENGTH_SHORT).show();
            finish();
        }));

        exibeNota(nota);
    }
    public void exibeNota(Nota nota) {
        tvid.setText(String.valueOf(nota.id));
        editText.setText(nota.texto);
    }

    public void updateNota(){
        nota.texto= editText.getText().toString();
        ContentValues cv = new ContentValues();
        cv.put("txt", nota.texto);
        db.update("notas", cv, "id=?", new String[]{String.valueOf(nota.id)});
    }

}