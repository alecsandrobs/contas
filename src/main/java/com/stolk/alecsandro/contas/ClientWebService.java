package com.stolk.alecsandro.contas;

import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ClientWebService {

    public static void main(String[] args) throws IOException {
        String conteudo = Request.Post("http://localhost:8080/contas/contas")
                .addHeader("Accept", "application/json")
                .execute()
                .returnContent()
                .asString();

        System.out.println(conteudo);
    }
}
