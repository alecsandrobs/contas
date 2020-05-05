package com.stolk.alecsandro.contas.recurso;

import com.stolk.alecsandro.contas.lista.ListaContato;
import com.stolk.alecsandro.contas.modelo.Contato;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("contatos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ContatoResource {

    private URI getUri(Long... id) {
        final String RESOURCE = "contatos";
        if (id.length > 0) {
            return URI.create(String.format("/%s/%s", RESOURCE, id[0]));
        } else {
            return URI.create(String.format("/%s", RESOURCE));
        }
    }

    @GET()
    public Response get() {
        List<Contato> contatos = new ListaContato().busca();
        return Response.ok(contatos).build();
    }

    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") Long id) {
        Contato contato = new ListaContato().busca(id);
        return Response.ok(contato).build();
    }

    @POST
    public Response post(Contato contato) {
        new ListaContato().adiciona(contato);
        return Response.created(getUri(contato.getId())).build();
    }

    @PUT
    public Response put(Contato contato) {
        new ListaContato().edita(contato);
        return Response.ok(getUri(contato.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        new ListaContato().remove(id);
        return Response.noContent().build();
    }
}
