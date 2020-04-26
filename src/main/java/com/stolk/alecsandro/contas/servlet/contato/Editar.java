package com.stolk.alecsandro.contas.servlet.contato;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contatos/edita")
public class Editar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String documento = req.getParameter("documento");
        String telefone = req.getParameter("telefone");
        String email = req.getParameter("email");

        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setDocumento(documento);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        ListaContato lista = new ListaContato();
        contato = lista.busca(id);
        contato.setNome(nome);
        contato.setDocumento(documento);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        resp.sendRedirect("lista");
    }
}
