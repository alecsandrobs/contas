package com.stolk.alecsandro.contas.controle.fornecedor;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");

        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setNome(nome);
        fornecedor.setDocumento(documento);

        ListaFornecedor lista = new ListaFornecedor();
        fornecedor = lista.busca(id);
        fornecedor.setNome(nome);
        fornecedor.setDocumento(documento);

        return "redirect:Listar";
    }
}
