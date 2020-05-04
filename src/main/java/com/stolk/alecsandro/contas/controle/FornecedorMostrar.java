package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FornecedorMostrar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaFornecedor lista = new ListaFornecedor();
        Fornecedor fornecedor = lista.busca(id);
        request.setAttribute("fornecedor", fornecedor);
        return "forward:FornecedorEdita.jsp";
    }
}
