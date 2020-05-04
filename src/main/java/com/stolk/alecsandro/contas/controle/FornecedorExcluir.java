package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FornecedorExcluir implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        ListaFornecedor lista = new ListaFornecedor();
        lista.remove(id);

        return "redirect:FornecedorListar";
    }
}
