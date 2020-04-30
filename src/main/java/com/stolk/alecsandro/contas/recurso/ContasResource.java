package com.stolk.alecsandro.contas.recurso;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.modelo.Conta;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("contas")
@Produces({APPLICATION_XML, APPLICATION_JSON})
@Consumes({APPLICATION_XML, APPLICATION_JSON})
public class ContasResource {

    private URI getUri(Long... id) {
        final String RESOURCE = "contas";
        if (id.length > 0) {
            return URI.create(String.format("/%s/%s", RESOURCE, id[0]));
        } else {
            return URI.create(String.format("/%s", RESOURCE));
        }
    }

    @GET()
    public List<Conta> get() {
        return new ListaConta().busca();
    }

    @GET
    @Path("{id}")
    public Conta getById(@PathParam("id") Long id) {
        Conta conta = new ListaConta().busca(id);
        return conta;
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
