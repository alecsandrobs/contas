package com.stolk.alecsandro.contas.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Iterator;
import java.util.List;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@XmlRootElement
@XmlAccessorType(FIELD)
public class Fornecedor extends EntidadeId {

    private String nome;
    private String documento;
    private List<Contato> contatos;
    private List<Conta> contas;

    public Fornecedor() {
    }

    public Fornecedor(String nome, String documento, List<Contato> contatos, List<Conta> contas) {
        this.nome = nome;
        this.documento = documento;
        this.contatos = contatos;
        this.contas = contas;
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

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public Fornecedor adicionaConta(Conta conta) {
        contas.add(conta);
        return this;
    }

    public Fornecedor adicionaContato(Contato contato) {
        contatos.add(contato);
        return this;
    }

    public void removeConta(Long id) {
        for (Iterator iterator = contas.iterator(); iterator.hasNext(); ) {
            Conta conta = (Conta) iterator.next();
            if (conta.getId() == id) {
                iterator.remove();

            }
        }
    }

    public void removeContato(Long id) {
        for (Iterator iterator = contas.iterator(); iterator.hasNext(); ) {
            Contato contato = (Contato) iterator.next();
            if (contato.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void trocaConta(Conta conta) {
        removeConta(conta.getId());
        adicionaConta(conta);
    }

    public void trocaContato(Contato contato) {
        removeContato(contato.getId());
        adicionaContato(contato);
    }

    public String toXml() {
        return new XStream().toXML(this);
    }

    public String toJson() {
        return new Gson().toJson(this);
    }
}
