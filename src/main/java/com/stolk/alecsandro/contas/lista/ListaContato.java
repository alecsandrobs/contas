package com.stolk.alecsandro.contas.lista;

import com.stolk.alecsandro.contas.modelo.Contato;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ListaContato {

    private static AtomicLong contador = new AtomicLong(1L);
    public static List<Contato> contatos = new ArrayList<>();

    static {
        adiciona(new Contato("José da Silva de Alencar", "12345678909", "57995876341", "josesa@email.com"));
        adiciona(new Contato("Maria Souza de Alencar", null, "23977931594", "mariasa@email.com"));
        adiciona(new Contato("Maurício Aquino Rego", null, "46931782597", null));
        adiciona(new Contato("Flávia Madeira Rego", "98765432100", "10932594621", "rego.flavia@regomail.com.br"));
        adiciona(new Contato("Rui Barba Rosa", "41378847698253", "60991734682", "rbarbarosa@barbamail.com.br"));
        adiciona(new Contato("Joana Flores Rosa", null, null, "hfloresrosa@barbamail.com.br"));
        adiciona(new Contato("Amim Amou Amado", "89512792061900", null, null));
    }

    public static void adiciona(Contato contato) {
        contato.setId(contador.getAndIncrement());
        contatos.add(contato);
    }

    public List<Contato> busca() {
        return contatos;
    }

    public Contato busca(Long id) {
        for (Contato contato : contatos) {
            if (contato.getId() == id) {
                return contato;
            }
        }
        return null;
    }

    public void edita(Contato contato) {
        remove(contato.getId());
        adiciona(contato);
    }

    public void remove(Long id) {
        Iterator<Contato> iterator = contatos.iterator();
        while (iterator.hasNext()) {
            Contato contato = iterator.next();
            if (contato.getId() == id) {
                iterator.remove();
            }
        }
    }
}
