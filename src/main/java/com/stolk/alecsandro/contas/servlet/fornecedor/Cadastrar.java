package com.stolk.alecsandro.contas.servlet.fornecedor;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fornecedores/cadastra")
public class Cadastrar extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String documento = req.getParameter("documento");

        Fornecedor fornecedor = new Fornecedor(nome, documento, null, null);

        ListaFornecedor lista = new ListaFornecedor();
        lista.adiciona(fornecedor);

        resp.sendRedirect("lista");

    }
}
