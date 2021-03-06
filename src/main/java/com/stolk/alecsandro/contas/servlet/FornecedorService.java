package com.stolk.alecsandro.contas.servlet;

import com.google.gson.Gson;
import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Conta;
import com.stolk.alecsandro.contas.modelo.Contato;
import com.stolk.alecsandro.contas.modelo.Fornecedor;
import com.thoughtworks.xstream.XStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/fornecedores")
public class FornecedorService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Fornecedor> fornecedores = new ListaFornecedor().busca();

        String accept = request.getHeader("Accept");
        accept = "application/json";

        if (accept.contains("json")) {
            String json = new Gson().toJson(fornecedores);
            response.setContentType("application/json");
            response.getWriter().print(json);
        } else if (accept.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("conta", Conta.class);
            String xml = xStream.toXML(fornecedores);
            response.setContentType("application/xml");
            response.getWriter().print(xml);
        } else {
            response.setContentType("application/json");
            response.getWriter().print("{\"message\":\"Sem conteúdo\"}");
        }


    }
}
