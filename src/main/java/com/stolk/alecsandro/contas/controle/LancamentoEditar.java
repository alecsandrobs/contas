package com.stolk.alecsandro.contas.controle;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Fornecedor;
import com.stolk.alecsandro.contas.modelo.Lancamento;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

import static com.stolk.alecsandro.contas.modelo.Lancamento.TipoLancamento.fromValue;
import static com.stolk.alecsandro.contas.util.Util.dataBr;
import static com.stolk.alecsandro.contas.util.Util.dataEn;
import static java.lang.Double.parseDouble;

public class LancamentoEditar implements Acao {
    public String executar(HttpServletRequest request, HttpServletResponse response) {
        String dataLanamento = request.getParameter("data");
        LocalDate data = dataLanamento.contains("-") ? dataEn(dataLanamento) : dataBr(dataLanamento);

        String fornecedorId = request.getParameter("fornecedor");
        Fornecedor fornecedor = new ListaFornecedor().busca(Long.parseLong(fornecedorId));

        String tipoLancamento = request.getParameter("tipo");
        Lancamento.TipoLancamento tipo = fromValue(tipoLancamento);

        String valorLancamento = request.getParameter("valor");
        Double valor = parseDouble(valorLancamento);

        String pagamentoLancamento = request.getParameter("pagamento");
        LocalDate pagamento = pagamentoLancamento != null && !pagamentoLancamento.trim().isEmpty() ? pagamentoLancamento.contains("-") ? dataEn(pagamentoLancamento) : dataBr(pagamentoLancamento) : null;

        String observacoes = request.getParameter("observacoes");

        String parametroId = request.getParameter("id");
        Long id = Long.parseLong(parametroId);

        Lancamento lancamento = new Lancamento();
        lancamento.setId(id);
        lancamento.setData(data);
        lancamento.setFornecedor(fornecedor);
        lancamento.setTipo(tipo);
        lancamento.setValor(valor);
        lancamento.setPagamento(pagamento);
        lancamento.setObservacoes(observacoes);

        ListaLancamento lista = new ListaLancamento();
        lancamento = lista.busca(id);
        lancamento.setData(data);
        lancamento.setFornecedor(fornecedor);
        lancamento.setTipo(tipo);
        lancamento.setValor(valor);
        lancamento.setPagamento(pagamento);
        lancamento.setObservacoes(observacoes);

        return "redirect:LancamentoListar";
    }
}
