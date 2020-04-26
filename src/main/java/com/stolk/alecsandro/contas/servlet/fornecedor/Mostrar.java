package com.stolk.alecsandro.contas.servlet.fornecedor;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/fornecedores/mostra")
public class Mostrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaFornecedor lista = new ListaFornecedor();
        Fornecedor fornecedor = lista.busca(id);
        req.setAttribute("fornecedor", fornecedor);
        RequestDispatcher rd = req.getRequestDispatcher("/fornecedor/edita.jsp");
        rd.forward(req, resp);
    }
}
