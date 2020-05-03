package com.stolk.alecsandro.contas.controle.lancamento;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mostrar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaLancamento lista = new ListaLancamento();
        Lancamento lancamento = lista.busca(id);
        request.setAttribute("lancamento", lancamento);
        return "forward:edita.jsp";
    }
}
