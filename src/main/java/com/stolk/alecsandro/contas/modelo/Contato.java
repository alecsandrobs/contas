package com.stolk.alecsandro.contas.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contatos")
public class Contato extends EntidadeId {

    private String nome;
    private String documento;
    private String telefone;
    private String email;

    public Contato() {
    }

    public Contato(String nome, String documento, String telefone, String email) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toXml() {
        return new XStream().toXML(this);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
