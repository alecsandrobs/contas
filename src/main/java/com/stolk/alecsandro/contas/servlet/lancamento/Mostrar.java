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

@WebServlet("/lancamentos/mostra")
public class Mostrar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaLancamento lista = new ListaLancamento();
        Lancamento lancamento = lista.busca(id);
        req.setAttribute("lancamento", lancamento);
        RequestDispatcher rd = req.getRequestDispatcher("/lancamento/edita.jsp");
        rd.forward(req, resp);
    }
}
