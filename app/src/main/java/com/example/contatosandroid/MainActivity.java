package com.example.contatosandroid;

import android.os.Bundle;
import android.util.Log;
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

        //XML é uma "estrutura vazia" achatada em texto, e inflar é dar "volume" a ela, criando os objetos de verdade.

        //inflate() é um método que precisa de uma ferramenta pra fazer esse trabalho — essa ferramenta é o LayoutInflater,
        // uma classe do próprio Android especializada em ler XML e gerar as Views
        binding = ActivityMainBinding.inflate(getLayoutInflater());// transforma XML em objetos de View de verdade na memoria
                                                                    // e guarda a referencia de cada u dentro de binging
        setContentView(binding.getRoot());// Use essa arvore de views como conteudo de tela

        Log.d("MainActivity","App iniciado");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.buttonCumprimentar.setOnClickListener(v -> {
            String nome = binding.editTextNome.getText().toString().trim();

            if(nome.isEmpty()){
                Toast.makeText(this,"Digite o nome antes de continuar", Toast.LENGTH_SHORT).show();
                return;
            }

            binding.textViewResultado.setText("Olá, " + nome + "!");
        });
    }
}