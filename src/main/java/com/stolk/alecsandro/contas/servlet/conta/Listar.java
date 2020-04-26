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
import java.util.List;

@WebServlet("/contas/lista")
public class Listar extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListaConta lista = new ListaConta();
        List<Conta> contas = lista.busca();
        req.setAttribute("contas", contas);
        RequestDispatcher rd = req.getRequestDispatcher("/conta/lista.jsp");
        rd.forward(req, resp);
    }
}
