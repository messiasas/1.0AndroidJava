package com.example.contatosandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.contatosandroid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding; // Tradutor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Primeiro monta a tela

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("MainActivity","App iniciado");

        binding.buttonCumprimentar.setOnClickListener(v -> {
            String nome = binding.editTextNome.getText().toString().trim();

            if(nome.isEmpty()){
                Toast.makeText(this,"Digite o nome antes de continuar", Toast.LENGTH_SHORT).show();
                return;
            }

            //binding.textViewResultado.setText("Olá, " + nome + "!");

            Intent intent = new Intent(MainActivity.this,TelaDetalheActivity.class);
            intent.putExtra("nome_enviar",nome);
            startActivity(intent);
        });
    }

}