package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ContaListar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        ListaConta lista = new ListaConta();
        List<Conta> contas = lista.busca();
        request.setAttribute("contas", contas);
        return "forward:ContaLista.jsp";
    }
}
