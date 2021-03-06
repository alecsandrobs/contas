package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LancamentoListar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        ListaLancamento lista = new ListaLancamento();
        List<Lancamento> lancamentos = lista.busca();
        request.setAttribute("lancamentos", lancamentos);
        return "forward:LancamentoLista.jsp";
    }
}
