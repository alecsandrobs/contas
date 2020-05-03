package com.stolk.alecsandro.contas.controle.contato;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Editar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String documento = request.getParameter("documento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");

        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Contato contato = new Contato();
        contato.setId(id);
        contato.setNome(nome);
        contato.setDocumento(documento);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        ListaContato lista = new ListaContato();
        contato = lista.busca(id);
        contato.setNome(nome);
        contato.setDocumento(documento);
        contato.setTelefone(telefone);
        contato.setEmail(email);

        return "redirect:Listar";
    }
}
