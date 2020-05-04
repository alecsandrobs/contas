package com.stolk.alecsandro.contas.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/obra")
public class AutorizacaoFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("####### AutorizacaoFilter #######");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String parametroAcao = request.getParameter("acao");

        HttpSession sessao = request.getSession();
        boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
        boolean ehLogin = parametroAcao.equals("Login") || parametroAcao.equals("LoginForm");
        if (!usuarioLogado && !ehLogin) {
            response.sendRedirect("obra?acao=LoginForm");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
