package com.stolk.alecsandro.contas.recurso;

import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("lancamentos")
@Produces(APPLICATION_XML)
@Consumes(APPLICATION_XML)
public class LancamentoResource {

    private URI getUri(Long... id) {
        final String RESOURCE = "lancamentos";
        if (id.length > 0) {
            return URI.create(String.format("/%s/%s", RESOURCE, id[0]));
        } else {
            return URI.create(String.format("/%s", RESOURCE));
        }
    }

    @GET()
    public List<Lancamento> get() {
        return new ListaLancamento().busca();
    }

    @GET
    @Path("{id}")
    public Lancamento getById(@PathParam("id") Long id) {
        Lancamento lancamento = new ListaLancamento().busca(id);
        return lancamento;
    }

    @POST
    public Response post(Lancamento lancamento) {
        new ListaLancamento().adiciona(lancamento);
        return Response.created(getUri(lancamento.getId())).build();
    }

    @PUT
    public Response put(Lancamento lancamento) {
        new ListaLancamento().edita(lancamento);
        return Response.ok(getUri(lancamento.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        new ListaLancamento().remove(id);
        return Response.noContent().build();
    }
}
