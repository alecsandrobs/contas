package com.stolk.alecsandro.contas.modelo;

import java.io.Serializable;
import java.util.Objects;

//@MappedSuperclass
public class EntidadeId implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadeId that = (EntidadeId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
