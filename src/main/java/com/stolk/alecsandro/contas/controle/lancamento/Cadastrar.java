package com.stolk.alecsandro.contas.controle.lancamento;

import com.stolk.alecsandro.contas.controle.Acao;
import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Conta;
import com.stolk.alecsandro.contas.modelo.Fornecedor;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import static com.stolk.alecsandro.contas.modelo.Lancamento.TipoLancamento.fromValue;
import static com.stolk.alecsandro.contas.util.Util.dataBr;
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

public class Cadastrar implements Acao {

    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String dataLancamento = request.getParameter("data");
        LocalDate data = dataBr(dataLancamento);

        String fornecedorId = request.getParameter("fornecedor");
        Fornecedor fornecedor = new ListaFornecedor().busca(parseLong(fornecedorId));

        String contaId = request.getParameter("conta");
        Conta conta = new ListaConta().busca(parseLong(contaId));

        String tipoLancamento = request.getParameter("tipo");
        Lancamento.TipoLancamento tipo = fromValue(tipoLancamento);

        String valorLancamento = request.getParameter("valor");
        Double valor = parseDouble(valorLancamento);

        String pagamentoLancamento = request.getParameter("pagamento");
        LocalDate pagamento = pagamentoLancamento != null && !pagamentoLancamento.trim().isEmpty() ? dataBr(pagamentoLancamento) : null;

        String observacoes = request.getParameter("observacoes");

        Lancamento lancamento = new Lancamento(data, fornecedor, conta, tipo, valor, pagamento, observacoes);

        new ListaLancamento().adiciona(lancamento);

        return "redirect:Listar";
    }
}
