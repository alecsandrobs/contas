package com.stolk.alecsandro.contas.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LancamentoNovo implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:LancamentoCadastra.jsp";
    }
}
