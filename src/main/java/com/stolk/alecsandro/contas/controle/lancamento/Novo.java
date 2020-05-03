package com.stolk.alecsandro.contas.controle.lancamento;

import com.stolk.alecsandro.contas.controle.Acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Novo implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:cadastra.jsp";
    }
}
