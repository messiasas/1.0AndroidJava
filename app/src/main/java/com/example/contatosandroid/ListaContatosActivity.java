package com.example.contatosandroid;

import static android.widget.Toast.LENGTH_SHORT;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.contatosandroid.databinding.ActivityListaContatosBinding;

import java.util.ArrayList;
import java.util.List;


public class ListaContatosActivity extends AppCompatActivity {

    private ActivityListaContatosBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityListaContatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Contato> listaContatos = new ArrayList<>();
        listaContatos.add(new Contato("Ana luiza", "11929203119"));
        listaContatos.add(new Contato("Bruno Costa", "21 99876-5432"));
        listaContatos.add(new Contato("Carla Souza", "31 98765-4321"));

        ContatoAdapter adapter = new ContatoAdapter(listaContatos);
        binding.recyclerViewContatos.setAdapter(adapter); // Diz "os dados e os itens visuais que você vai exibir vêm daqui"
        binding.recyclerViewContatos.setLayoutManager(new LinearLayoutManager(this)); // Diz como os itens vão ser posicionados na tela — em lista vertical, horizontal, em grade, etc.

        binding.buttonAdicionar.setOnClickListener( v -> {
            String nome = binding.editTextNome.getText().toString();
            String telefone = binding.editTextTelefone.getText().toString();

            if(nome.isEmpty() || telefone.isEmpty()){
                Toast.makeText(this,"Preencha os campos", LENGTH_SHORT).show();
                return;
            }

            adapter.adicionarContatos(new Contato(nome, telefone));
            Toast.makeText(this,"Contato adicionado", LENGTH_SHORT).show();

            binding.editTextNome.setText("");
            binding.editTextTelefone.setText("");
        });




    }
}