package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LancamentoMostrar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaLancamento lista = new ListaLancamento();
        Lancamento lancamento = lista.busca(id);
        request.setAttribute("lancamento", lancamento);
        return "forward:LancamentoEdita.jsp";
    }
}
