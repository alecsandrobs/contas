package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaLancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LancamentoExcluir implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        new ListaLancamento().remove(id);

        return "redirect:LancamentoListar";
    }
}
