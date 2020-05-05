package com.stolk.alecsandro.contas.modelo;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "lancamentos")
public class Lancamento extends EntidadeId {

    private LocalDate data;
    private Fornecedor fornecedor;
    private Conta conta;
    private TipoLancamento tipo;
    private Double valor;
    private LocalDate pagamento;
    private String observacoes;

    public Lancamento() {
    }

    public Lancamento(LocalDate data, Fornecedor fornecedor, Conta conta, TipoLancamento tipo, Double valor, LocalDate pagamento, String observacoes) {
        this.data = data;
        this.fornecedor = fornecedor;
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
        this.pagamento = pagamento;
        this.observacoes = observacoes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getPagamento() {
        return pagamento;
    }

    public void setPagamento(LocalDate pagamento) {
        this.pagamento = pagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public enum TipoLancamento {
        PAGAMENTO("PAGAMENTO", "Pagamento"),
        RECEBIMENTO("RECEBIMENTO", "Recebimento");

        private String tipo;
        private String valor;

        TipoLancamento(String tipo, String valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        public static TipoLancamento fromValue(String valor) {
            for (TipoLancamento tipo : TipoLancamento.values()) {
                if (tipo.valor.equalsIgnoreCase(valor)) {
                    return tipo;
                }
            }
            return null;
        }

        public String getTipo() {
            return tipo;
        }

        public String getValor() {
            return valor;
        }

        public String toXml() {
            return new XStream().toXML(this);
        }

        public String toJson() {
            return new Gson().toJson(this);
        }
    }
}
