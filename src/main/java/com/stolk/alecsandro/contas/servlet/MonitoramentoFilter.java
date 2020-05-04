package com.stolk.alecsandro.contas.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/obra")
public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("####### MonitoramentoFilter #######");

        long antes = System.currentTimeMillis();
        String acao = request.getParameter("acao");

        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println(String.format("Tempo de execução da ação %s: %d", acao, (depois - antes)));
    }

    @Override
    public void destroy() {

    }
}
