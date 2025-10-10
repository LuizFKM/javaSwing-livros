/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.luizfrancisco.biblioteca.model;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Livros {
    private int id;
    private String nome;
    private String editora;
    private String ano;
    private boolean isDisponivel;

    public Livros() {
    }

    public Livros(int id, String nome, String editora, String ano, boolean isDisponivel) {
        this.id = id;
        this.nome = nome;
        this.editora = editora;
        this.ano = ano;
        this.isDisponivel = isDisponivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAno() {
        return ano;
    }

        public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean getIsDisponivel() {
        return isDisponivel;
    }

    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    @Override
    public String toString() {
        return "Livros{" + "id=" + id + ", nome=" + nome + ", editora=" + editora + ", ano=" + ano + ", isDisponivel=" + isDisponivel + '}';
    }
 
    
    
}
