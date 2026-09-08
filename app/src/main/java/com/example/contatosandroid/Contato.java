package com.example.contatosandroid;

public class Contato {

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    private String nome;
    private String telefone;

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String tel){
        this.telefone = tel;
    }

}
