package com.stolk.alecsandro.contas.servlet.conta;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contas/cadastra")
public class Cadastrar extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String banco = req.getParameter("banco");
        String agencia = req.getParameter("agencia");
        String numero = req.getParameter("numero");

        Conta conta = new Conta(banco, agencia, numero);

        ListaConta lista = new ListaConta();
        lista.adiciona(conta);

        resp.sendRedirect("lista");

    }
}
