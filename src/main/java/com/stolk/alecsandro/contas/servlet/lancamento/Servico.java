package com.stolk.alecsandro.contas.servlet.lancamento;

import com.stolk.alecsandro.contas.controle.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lancamentos")
public class Servico extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String parametroAcao = request.getParameter("acao");
        if (parametroAcao == null) throw new RuntimeException("Ação não pode ser nula.");

        String nomeClasse = "com.stolk.alecsandro.contas.controle.lancamento." + parametroAcao;
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
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/lancamento/" + nomes[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect("lancamentos?acao=" + nomes[1]);
        }
    }
}
