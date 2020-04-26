package com.stolk.alecsandro.contas.servlet.contato;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contatos/lista")
public class Listar extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListaContato lista = new ListaContato();
        List<Contato> contatos = lista.busca();
        req.setAttribute("contatos", contatos);
        RequestDispatcher rd = req.getRequestDispatcher("/contato/lista.jsp");
        rd.forward(req, resp);
    }
}
