package com.stolk.alecsandro.contas.servlet.contato;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contatos/cadastra")
public class Cadastrar extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String documento = req.getParameter("documento");
        String telefone = req.getParameter("telefone");
        String email = req.getParameter("email");

        Contato contato = new Contato(nome, documento, telefone, email);

        ListaContato lista = new ListaContato();
        lista.adiciona(contato);

        resp.sendRedirect("lista");

    }
}
