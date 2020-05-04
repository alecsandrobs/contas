package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FornecedorListar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        ListaFornecedor lista = new ListaFornecedor();
        List<Fornecedor> fornecedores = lista.busca();
        request.setAttribute("fornecedores", fornecedores);
        return "forward:FornecedorLista.jsp";
    }
}
