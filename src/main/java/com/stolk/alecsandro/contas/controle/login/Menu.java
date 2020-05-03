package com.stolk.alecsandro.contas.controle.login;

import com.stolk.alecsandro.contas.controle.Acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Menu implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:index.jsp";
    }
}
