package com.stolk.alecsandro.contas.controle.contato;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Cadastrar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        Contato contato = new Contato(nome, documento, telefone, email);
        new ListaContato().adiciona(contato);
        return "redirect:Listar";
    }
}
