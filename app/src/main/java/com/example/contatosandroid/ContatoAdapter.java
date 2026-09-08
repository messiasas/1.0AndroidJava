package com.example.contatosandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ContatoAdapterHolder> {

    private List<Contato> listaContatos;

    public ContatoAdapter(List<Contato> listaContato){
        this.listaContatos = listaContato;
    }

    @NonNull
    @Override
    /*
    * onCreateViewHolder é um método qe constroi fisicamente um novo item na lista.
    * Isso é, pega o molde item_contato.xml, transforma ele numa View(item de exibição), e devolve
    * essa view já embrulhada num ContatoAdapterHolder, pronta para ser exibida ( mas ainda sem dados preenchidos, iss é função do onBindViewHolder
    *
    * */
    public ContatoAdapter.ContatoAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // segunda chamada, cada chamada infla um item_contato.xml novo e devolve um ContatoAdapterHolder
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contato, parent, false); // assinatura

        return new ContatoAdapterHolder(itemView);
    }

    /*
    * Pega o contato certo da lista, de acordo com a posição, e preenche os TextViws daquele item
    * visual especifico com o nome e telefone dele
    * */
    @Override
    public void onBindViewHolder(@NonNull ContatoAdapter.ContatoAdapterHolder holder, int position) { // terceira chamada, aqui é onde cada holder recem criado entra numa posição que aquele item deve representar
        Contato contatoAtual = listaContatos.get(position);
        holder.textViewNome.setText(contatoAtual.getNome());
        holder.textViewTelefone.setText(contatoAtual.getTelefone());
    }

    @Override
    public int getItemCount() { // primeira chamada
        return listaContatos.size();
    }

    public static class ContatoAdapterHolder extends RecyclerView.ViewHolder{
        TextView textViewNome;
        TextView textViewTelefone;
        public ContatoAdapterHolder(@NonNull View itemView){
            super(itemView);
            textViewNome = itemView.findViewById(R.id.textViewNome);
            textViewTelefone = itemView.findViewById(R.id.textViewTelefone);
        }
    }
}
