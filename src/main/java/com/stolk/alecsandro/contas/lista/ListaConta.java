package com.stolk.alecsandro.contas.lista;

import com.stolk.alecsandro.contas.modelo.Conta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ListaConta {

    private static AtomicLong contador = new AtomicLong(1L);
    public static List<Conta> contas = new ArrayList<>();

    static {
        adiciona(new Conta("Nu Pagamentos", "1", "1234567"));
        adiciona(new Conta("Banco Inter", "1", "7654321"));
        adiciona(new Conta("Itaú", "2662", "12647"));
        adiciona(new Conta("Bradesco", "1677", "45679"));
        adiciona(new Conta("Santander", "6543", "165450"));
        adiciona(new Conta("Banco do Brasil", "5460", "65404"));
        adiciona(new Conta("Caixa Econômica Federal", "6506", "65460"));
    }

    public static void adiciona(Conta conta) {
        conta.setId(contador.getAndIncrement());
        contas.add(conta);
    }

    public List<Conta> busca() {
        return contas;
    }

    public Conta busca(Long id) {
        for (Conta conta : contas) {
            if (id.equals(conta.getId())) {
                return conta;
            }
        }
        return null;
    }

    public void edita(Conta conta) {
        Conta contaLista = busca(conta.getId());
        contaLista.setBanco(conta.getBanco());
        contaLista.setAgencia(conta.getAgencia());
        contaLista.setNumero(conta.getNumero());
    }

    public void remove(Long id) {
        contas.removeIf(conta -> id.equals(conta.getId()));
    }
}
