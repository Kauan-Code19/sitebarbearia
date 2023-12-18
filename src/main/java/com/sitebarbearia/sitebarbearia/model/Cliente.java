package com.sitebarbearia.sitebarbearia.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ClienteID")
    private Long clienteID;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "Senha", nullable = false)
    private String senha;

    @Column(name = "Endereco", nullable = false)
    private String endereco;

    @Column(name = "Latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}