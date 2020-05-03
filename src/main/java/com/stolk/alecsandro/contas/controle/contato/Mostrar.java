package com.stolk.alecsandro.contas.controle.contato;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mostrar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaContato lista = new ListaContato();
        Contato contato = lista.busca(id);
        request.setAttribute("contato", contato);
        return "forward:edita.jsp";
    }
}
