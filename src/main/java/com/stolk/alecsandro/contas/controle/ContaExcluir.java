package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaConta;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContaExcluir implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);
        ListaConta lista = new ListaConta();
        lista.remove(id);
        return "redirect:ContaListar";
    }
}
