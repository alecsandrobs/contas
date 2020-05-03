package com.stolk.alecsandro.contas.controle.fornecedor;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Excluir implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        ListaFornecedor lista = new ListaFornecedor();
        lista.remove(id);

        return "redirect:Listar";
    }
}
