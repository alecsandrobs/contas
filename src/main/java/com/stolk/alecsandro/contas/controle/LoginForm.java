package com.stolk.alecsandro.contas.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginForm implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:Login.jsp";
    }

}
