package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContatoMostrar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaContato lista = new ListaContato();
        Contato contato = lista.busca(id);
        request.setAttribute("contato", contato);
        return "forward:ContatoEdita.jsp";
    }
}
