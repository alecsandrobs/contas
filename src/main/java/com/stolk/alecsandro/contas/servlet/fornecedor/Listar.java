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
import java.util.List;

@WebServlet("/fornecedores/lista")
public class Listar extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListaFornecedor lista = new ListaFornecedor();
        List<Fornecedor> fornecedores = lista.busca();
        req.setAttribute("fornecedores", fornecedores);
        RequestDispatcher rd = req.getRequestDispatcher("/fornecedor/lista.jsp");
        rd.forward(req, resp);
    }
}
