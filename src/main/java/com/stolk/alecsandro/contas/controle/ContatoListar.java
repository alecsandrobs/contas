package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ContatoListar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        ListaContato lista = new ListaContato();
        List<Contato> contatos = lista.busca();
        request.setAttribute("contatos", contatos);

        return "forward:ContatoLista.jsp";
    }
}
