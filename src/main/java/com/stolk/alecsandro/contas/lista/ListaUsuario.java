package com.stolk.alecsandro.contas.lista;

import com.stolk.alecsandro.contas.modelo.Usuario;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

public class ListaUsuario {

    private static AtomicLong contador = new AtomicLong(1L);
    public static List<Usuario> usuarios = new ArrayList<>();

    static {
        adiciona(new Usuario("teste", "1234567"));
        adiciona(new Usuario("admin", "nimda"));
    }

    public static void adiciona(Usuario usuario) {
        usuario.setId(contador.getAndIncrement());
        usuarios.add(usuario);
    }

    public List<Usuario> busca() {
        return usuarios;
    }

    public Usuario busca(Long id) {
        for (Usuario usuario : usuarios) {
            if (id.equals(usuario.getId())) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario busca(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.ehIgual(login, senha)) {
                return usuario;
            }
        }
        return null;
    }

    public void edita(Usuario usuario) {
        remove(usuario.getId());
        adiciona(usuario);
    }

    public void remove(Long id) {
        usuarios.removeIf(usuario -> id.equals(usuario.getId()));

        /*Iterator<Usuario> iterator = usuarios.iterator();
        while (iterator.hasNext()) {
            Usuario usuario = iterator.next();
            if (id.equals(usuario.getId())) {
                iterator.remove();
            }
        }*/
    }
}
