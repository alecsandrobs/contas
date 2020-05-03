package com.stolk.alecsandro.contas.controle.conta;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String banco = request.getParameter("banco");
        String agencia = request.getParameter("agencia");
        String numero = request.getParameter("numero");

        String parametroId = request.getParameter("id");
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

        return "redirect:Listar";
    }
}
