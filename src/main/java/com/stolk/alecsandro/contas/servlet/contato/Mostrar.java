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

@WebServlet("/contatos/mostra")
public class Mostrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaContato lista = new ListaContato();
        Contato contato = lista.busca(id);
        req.setAttribute("contato", contato);
        RequestDispatcher rd = req.getRequestDispatcher("/contato/edita.jsp");
        rd.forward(req, resp);
    }
}
