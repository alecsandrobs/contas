package com.stolk.alecsandro.contas.controle.fornecedor;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Novo implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        return "forward:cadastra.jsp";
    }
}
