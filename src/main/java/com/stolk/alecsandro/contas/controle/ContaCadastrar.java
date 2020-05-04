package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContaCadastrar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String banco = request.getParameter("banco");
        String agencia = request.getParameter("agencia");
        String numero = request.getParameter("numero");
        Conta conta = new Conta(banco, agencia, numero);

        new ListaConta().adiciona(conta);

        return "redirect:ContaListar";
    }
}
