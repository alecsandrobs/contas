package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaUsuario;
import com.stolk.alecsandro.contas.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("Logando " + login);

        ListaUsuario lista = new ListaUsuario();
        Usuario usuario = lista.busca(login, senha);

        if (usuario != null) {
            System.out.println("Usuario existe");

            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuarioLogado", usuario);

//            return "redirect:obra?acao=Menu";
            return "redirect:Menu";
        } else {
            return "redirect:obra?acao=LoginForm";
        }

    }
}
