package com.example.contatosandroid;

import android.os.Bundle;

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
        binding.recyclerViewContatos.setAdapter(adapter);
        binding.recyclerViewContatos.setLayoutManager(new LinearLayoutManager(this));
    }
}