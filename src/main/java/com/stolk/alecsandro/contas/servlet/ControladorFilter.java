package com.stolk.alecsandro.contas.servlet;

import com.stolk.alecsandro.contas.controle.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter("/obra")
public class ControladorFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("####### ControladorFilter #######");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String parametroAcao = request.getParameter("acao");

        if (parametroAcao == null) throw new RuntimeException("Ação não pode ser nula.");

        String nomeClasse = "com.stolk.alecsandro.contas.controle." + parametroAcao;
        String nome;
        try {
            Class classe = Class.forName(nomeClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executar(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }

        String[] nomes = nome.split(":");
        if (nomes[0].equalsIgnoreCase("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + nomes[1]);
            rd.forward(request, response);
        } else {
            if (nomes[1].contains("Menu")) {
                response.sendRedirect("");
            } else {
                response.sendRedirect("obra?acao=" + nomes[1]);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
