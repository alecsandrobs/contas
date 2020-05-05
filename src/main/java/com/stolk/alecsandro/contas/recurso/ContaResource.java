package com.stolk.alecsandro.contas.recurso;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("contas")
@Produces({APPLICATION_JSON})
@Consumes({APPLICATION_JSON})
public class ContaResource {

    private URI getUri(Long... id) {
        final String RESOURCE = "contas";
        if (id.length > 0) {
            return URI.create(String.format("/%s/%s", RESOURCE, id[0]));
        } else {
            return URI.create(String.format("/%s", RESOURCE));
        }
    }

    @GET()
    public Response get() {
        List<Conta> contas = new ListaConta().busca();
        return Response.ok(contas).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Conta conta = new ListaConta().busca(id);
        return Response.ok(conta).build();
    }

    @POST
    public Response post(Conta conta) {
        new ListaConta().adiciona(conta);
        return Response.created(getUri(conta.getId())).build();
    }

    @PUT
    public Response put(Conta conta) {
        new ListaConta().edita(conta);
        return Response.ok(getUri(conta.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        new ListaConta().remove(id);
        return Response.noContent().build();
    }
}
