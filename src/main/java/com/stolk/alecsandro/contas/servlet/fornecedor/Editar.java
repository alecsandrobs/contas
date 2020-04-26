package com.stolk.alecsandro.contas.servlet.fornecedor;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fornecedores/edita")
public class Editar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nome = req.getParameter("nome");
        String documento = req.getParameter("documento");

        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setId(id);
        fornecedor.setNome(nome);
        fornecedor.setDocumento(documento);

        ListaFornecedor lista = new ListaFornecedor();
        fornecedor = lista.busca(id);
        fornecedor.setNome(nome);
        fornecedor.setDocumento(documento);

        resp.sendRedirect("lista");
    }
}
