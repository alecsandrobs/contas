package com.stolk.alecsandro.contas.controle.conta;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Nova implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:cadastra.jsp";
    }
}
