package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContaMostrar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaConta lista = new ListaConta();
        Conta conta = lista.busca(id);
        request.setAttribute("conta", conta);
        return "forward:ContaEdita.jsp";
    }
}
