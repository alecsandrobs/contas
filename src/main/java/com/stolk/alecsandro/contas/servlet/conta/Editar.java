package com.stolk.alecsandro.contas.servlet.conta;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contas/edita")
public class Editar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String banco = req.getParameter("banco");
        String agencia = req.getParameter("agencia");
        String numero = req.getParameter("numero");

        String parametroId = req.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Conta conta = new Conta();
        conta.setId(id);
        conta.setBanco(banco);
        conta.setAgencia(agencia);
        conta.setNumero(numero);

        ListaConta lista = new ListaConta();
        conta = lista.busca(id);
        conta.setBanco(banco);
        conta.setAgencia(agencia);
        conta.setNumero(numero);

        resp.sendRedirect("lista");
    }
}
