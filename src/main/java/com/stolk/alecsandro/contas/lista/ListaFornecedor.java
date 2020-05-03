package com.stolk.alecsandro.contas.lista;

import com.stolk.alecsandro.contas.modelo.Fornecedor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Arrays.asList;

public class ListaFornecedor {

    private static AtomicLong contador = new AtomicLong(1L);
    public static List<Fornecedor> fornecedores = new ArrayList<>();

    static {
        adiciona(new Fornecedor("Madereira Madeira LTDA", "26315520658700", asList(ListaContato.contatos.get(1), ListaContato.contatos.get(0)), asList(ListaConta.contas.get(3), ListaConta.contas.get(2), ListaConta.contas.get(1))));
        adiciona(new Fornecedor("Olaria Tijolada ME", "42305910346185", asList(ListaContato.contatos.get(5), ListaContato.contatos.get(4)), asList(ListaConta.contas.get(5))));
        adiciona(new Fornecedor("Materiais de construção Construtivo EPP", "65468294543502", asList(ListaContato.contatos.get(6)), null));
        adiciona(new Fornecedor("Empreiteira Dia-a-dia LTDA", "87613260861612", null, asList(ListaConta.contas.get(0), ListaConta.contas.get(4))));
        adiciona(new Fornecedor("Revestimentos sem Ânimos EPP", "25216885251607", null, asList(ListaConta.contas.get(6))));
        adiciona(new Fornecedor("Ferragens Ferrado LTDA ME", "51671360140837", asList(ListaContato.contatos.get(2), ListaContato.contatos.get(3)), null));
        adiciona(new Fornecedor("Caixa Econômica Federal", null, null, null));
    }

    public static void adiciona(Fornecedor fornecedor) {
        fornecedor.setId(contador.getAndIncrement());
        fornecedores.add(fornecedor);
    }

    public List<Fornecedor> busca() {
        return fornecedores;
    }

    public Fornecedor busca(Long id) {
        for (Fornecedor fornecedor : fornecedores) {
            if (id.equals(fornecedor.getId())) {
                return fornecedor;
            }
        }
        return null;
    }

    public void edita(Fornecedor fornecedor) {
        remove(fornecedor.getId());
        adiciona(fornecedor);
    }

    public void remove(Long id) {
        fornecedores.removeIf(fornecedor -> id.equals(fornecedor.getId()));
    }
}
