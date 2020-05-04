package com.stolk.alecsandro.contas.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContaNova implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:ContaCadastra.jsp";
    }
}
