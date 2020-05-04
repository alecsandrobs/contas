package com.stolk.alecsandro.contas.servlet;

import com.google.gson.Gson;
import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;
import com.thoughtworks.xstream.XStream;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/contas")
public class ContaService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Conta> contas = new ListaConta().busca();

        String accept = request.getHeader("Accept");
        accept = "application/json";

        if (accept.contains("json")) {
            String json = new Gson().toJson(contas);
            response.setContentType("application/json");
            response.getWriter().print(json);
        } else if (accept.contains("xml")) {
            XStream xStream = new XStream();
            xStream.alias("conta", Conta.class);
            String xml = xStream.toXML(contas);
            response.setContentType("application/xml");
            response.getWriter().print(xml);
        } else {
            response.setContentType("application/json");
            response.getWriter().print("{\"message\":\"Sem conteúdo\"}");
        }


    }
}
