package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FornecedorCadastrar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");

        Fornecedor fornecedor = new Fornecedor(nome, documento, null, null);

        new ListaFornecedor().adiciona(fornecedor);

        return "redirect:FornecedorListar";
    }
}
