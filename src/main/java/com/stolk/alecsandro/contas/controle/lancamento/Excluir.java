package com.stolk.alecsandro.contas.controle.lancamento;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaLancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Excluir implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        ListaLancamento lista = new ListaLancamento();
        lista.remove(id);

        return "redirect:Listar";
    }
}
