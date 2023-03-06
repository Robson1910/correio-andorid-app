package io.github.robson.correioandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.github.robson.correioandroid.controller.CorreioController;
import io.github.robson.correioandroid.model.Correio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CorreioController controller = new CorreioController();

        Button buscarCep = findViewById(R.id.buscarCep);
        TextView cep = findViewById(R.id.textCep);
        TextView uf = findViewById(R.id.textUf);
        TextView cidade = findViewById(R.id.textCidade);
        TextView bairro = findViewById(R.id.textBairro);
        TextView endereco = findViewById(R.id.textEndereco);
        EditText enviarCep = findViewById(R.id.editTextCep);

        buscarCep.setOnClickListener(view -> {
            Correio correio = controller.getCorreioCep(String.valueOf(enviarCep.getText()));
            if(correio != null) {
                cep.setText(correio.getCep());
                uf.setText(correio.getUf());
                cidade.setText(correio.getLocalidade());
                bairro.setText(correio.getBairro());
                endereco.setText(correio.getLogradouro());
            }else{
                Log.d("Error", "Registros vazio!");
            }
        });
    }
}