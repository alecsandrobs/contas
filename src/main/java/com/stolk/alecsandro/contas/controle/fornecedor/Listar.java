package com.stolk.alecsandro.contas.controle.fornecedor;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Listar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        ListaFornecedor lista = new ListaFornecedor();
        List<Fornecedor> fornecedores = lista.busca();
        request.setAttribute("fornecedores", fornecedores);
        return "forward:lista.jsp";
    }
}
