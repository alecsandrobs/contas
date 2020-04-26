package com.stolk.alecsandro.contas.servlet.lancamento;

import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/lancamentos/lista")
public class Listar extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ListaLancamento lista = new ListaLancamento();
        List<Lancamento> lancamentos = lista.busca();
        req.setAttribute("lancamentos", lancamentos);
        RequestDispatcher rd = req.getRequestDispatcher("/lancamento/lista.jsp");
        rd.forward(req, resp);
    }
}