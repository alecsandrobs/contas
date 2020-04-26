package com.stolk.alecsandro.contas.servlet.contato;

import com.stolk.alecsandro.contas.lista.ListaContato;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contatos/remove")
public class Remover extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);

        ListaContato lista = new ListaContato();
        lista.remove(id);

        resp.sendRedirect("lista");
    }
}
