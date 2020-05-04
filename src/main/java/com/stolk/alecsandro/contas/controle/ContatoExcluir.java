package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaContato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContatoExcluir implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaContato lista = new ListaContato();
        lista.remove(id);
        return "redirect:ContatoListar";
    }
}
