package com.ifsc.contaclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class ExibeNotaActivity extends AppCompatActivity {

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
        bancoDados = openOrCreateDatabase("banco", MODE_PRIVATE, null);
        //Handler de eventos
        buttonCancelar.setOnClickListener(view -> {
            finish();
        });
        buttonUpdate.setOnClickListener((view -> {
            updateNota();
            Toast.makeText(this, "Nota atualizada", Toast.LENGTH_SHORT).show();
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
        bancoDados.update("notas", cv, "id=?", new String[]{String.valueOf(nota.id)});
    }

}