package com.stolk.alecsandro.contas.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/obra")
public class MonitoramentoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long antes = System.currentTimeMillis();

        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();
        System.out.println(String.format("Tempo de execução: %d", depois - antes));
    }

    @Override
    public void destroy() {

    }
}
