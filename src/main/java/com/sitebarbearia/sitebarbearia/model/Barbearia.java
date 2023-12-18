package com.sitebarbearia.sitebarbearia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Barbearias")
public class Barbearia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BarbeariaID")
    private Long barbeariaID;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Senha", nullable = false)
    private String senha;

    @Column(name = "Descricao", nullable = false)
    private String descricao;

    @Column(name = "Endereco", nullable = false)
    private String endereco;

    @Column(name = "Contato", nullable = false)
    private String contato;

    public Long getBarbeariaID() {
        return barbeariaID;
    }

    public void setBarbeariaID(Long barbeariaID) {
        this.barbeariaID = barbeariaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}