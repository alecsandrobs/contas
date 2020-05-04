package com.stolk.alecsandro.contas.controle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {

        HttpSession sessao = request.getSession();
//        sessao.removeAttribute("usuarioLogado");
        sessao.invalidate();

        return "redirect:obra?acao=LoginForm";
    }
}
