package com.stolk.alecsandro.contas.servlet;

import com.stolk.alecsandro.contas.controle.Acao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/obra")
public class Servico extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response, Class classe) throws ServletException, IOException, IllegalAccessException, InstantiationException {
        System.out.println("####### ENTROU #######");

        String[] parametros = request.getParameter("acao").split("-");
        String modelo = parametros[0];
        String parametroAcao = parametros[1];

        HttpSession sessao = request.getSession();
        boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
        boolean ehLogin = parametroAcao.equals("Login") || parametroAcao.equals("LoginForm");
        if (!usuarioLogado && !ehLogin) {
            response.sendRedirect("login?acao=LoginForm");
            return;
        }

        if (parametroAcao == null) throw new RuntimeException("Ação não pode ser nula.");

        System.out.println("Classe: " + classe.getName());
        System.out.println("Package: " + classe.getPackage());

        Acao acao = (Acao) classe.newInstance();
        String nome = acao.executar(request, response);

        String[] nomes = nome.split(":");
        if (nomes[0].equalsIgnoreCase("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + modelo + "/" + nomes[1]);
            rd.forward(request, response);
        } else {
            response.sendRedirect(modelo + "?acao=" + nomes[1]);
        }

    }
}
