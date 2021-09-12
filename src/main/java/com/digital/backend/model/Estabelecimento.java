package com.digital.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "estabelecimentos")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "razaoSocial")
    private String razaoSocial;

    @Column(name = "telefone")
    private String telefone;

    public Estabelecimento(){

    }

    public Estabelecimento(String nome, String endereco, String cnpj, String razaoSocial, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Estabelecimento [id=" + id + ", nome=" + nome + ", endereço=" + endereco + ", cnpj=" + cnpj + ", razaoSocial=" + razaoSocial + ", telefone=" + telefone +"]";
    }
}
