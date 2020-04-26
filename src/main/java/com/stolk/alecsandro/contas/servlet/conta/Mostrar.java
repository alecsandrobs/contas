package com.stolk.alecsandro.contas.servlet.conta;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contas/mostra")
public class Mostrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaConta lista = new ListaConta();
        Conta conta = lista.busca(id);
        req.setAttribute("conta", conta);
        RequestDispatcher rd = req.getRequestDispatcher("/conta/edita.jsp");
        rd.forward(req, resp);
    }
}
