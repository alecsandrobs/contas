package com.stolk.alecsandro.contas.recurso;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.modelo.Conta;
import com.stolk.alecsandro.contas.modelo.Contato;
import com.stolk.alecsandro.contas.modelo.Fornecedor;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_XML;

@Path("fornecedores")
@Produces(APPLICATION_XML)
@Consumes(APPLICATION_XML)
public class FornecedorResource {

    private URI getUri(Long... id) {
        final String RESOURCE = "fornecedores";
        if (id.length > 0) {
            return URI.create(String.format("/%s/%s", RESOURCE, id[0]));
        } else {
            return URI.create(String.format("/%s", RESOURCE));
        }
    }

    @GET()
    public List<Fornecedor> get() {
        return new ListaFornecedor().busca();
    }

    @GET
    @Path("{id}")
    public Fornecedor getById(@PathParam("id") Long id) {
        Fornecedor fornecedor = new ListaFornecedor().busca(id);
        return fornecedor;
    }

    @POST
    public Response post(Fornecedor fornecedor) {
        new ListaFornecedor().adiciona(fornecedor);
        return Response.created(getUri(fornecedor.getId())).build();
    }

    @PUT
    public Response put(Fornecedor fornecedor) {
        new ListaFornecedor().edita(fornecedor);
        return Response.ok(getUri(fornecedor.getId())).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        new ListaFornecedor().remove(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("{fornecedorId}/contas/{id}")
    public Response putConta(Conta conta, @PathParam("fornecedorId") Long fornecedorId, @PathParam("id") Long id) {
        Fornecedor fornecedor = new ListaFornecedor().busca(fornecedorId);
        fornecedor.removeConta(id);
        fornecedor.adicionaConta(conta);
        return Response.ok().build();
    }

    @PUT
    @Path("{fornecedorId}/contatos/{id}")
    public Response putContato(Contato contato, @PathParam("{fornecedorId}") Long fornecedorId, @PathParam("id") Long id) {
        Fornecedor fornecedor = new ListaFornecedor().busca(fornecedorId);
        fornecedor.removeContato(id);
        fornecedor.adicionaContato(contato);
        return Response.ok().build();
    }

    @DELETE
    @Path("{fornecedorId}/contas/{id}")
    public Response deleteConta(@PathParam("fornecedorId") Long fornecedorId, @PathParam("id") Long id) {
        Fornecedor fornecedor = new ListaFornecedor().busca(fornecedorId);
        fornecedor.removeConta(id);
        return Response.ok().build();
    }

    @DELETE
    @Path("{fornecedorId}/contatos/{id}")
    public Response deleteContato(@PathParam("fornecedorId") Long fornecedorId, @PathParam("id") Long id) {
        Fornecedor fornecedor = new ListaFornecedor().busca(fornecedorId);
        fornecedor.removeContato(id);
        return Response.ok().build();
    }
}
