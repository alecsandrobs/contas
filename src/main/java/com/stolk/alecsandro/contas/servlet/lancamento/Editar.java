package com.stolk.alecsandro.contas.servlet.lancamento;

import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Fornecedor;
import com.stolk.alecsandro.contas.modelo.Lancamento;
import com.stolk.alecsandro.contas.modelo.Lancamento.TipoLancamento;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

import static com.stolk.alecsandro.contas.modelo.Lancamento.TipoLancamento.fromValue;
import static com.stolk.alecsandro.contas.modelo.Lancamento.TipoLancamento.valueOf;
import static com.stolk.alecsandro.contas.util.Util.dataBr;
import static com.stolk.alecsandro.contas.util.Util.dataEn;
import static java.lang.Double.parseDouble;

@WebServlet("/lancamentos/edita")
public class Editar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dataLanamento = req.getParameter("data");
        LocalDate data = dataLanamento.contains("-") ? dataEn(dataLanamento) : dataBr(dataLanamento);

        String fornecedorId = req.getParameter("fornecedor");
        Fornecedor fornecedor = new ListaFornecedor().busca(Long.parseLong(fornecedorId));

        String tipoLancamento = req.getParameter("tipo");
        TipoLancamento tipo = fromValue(tipoLancamento);

        String valorLancamento = req.getParameter("valor");
        Double valor = parseDouble(valorLancamento);

        String pagamentoLancamento = req.getParameter("pagamento");
        LocalDate pagamento = pagamentoLancamento != null && !pagamentoLancamento.trim().isEmpty() ? pagamentoLancamento.contains("-") ? dataEn(pagamentoLancamento) : dataBr(pagamentoLancamento) : null;

        String observacoes = req.getParameter("observacoes");

        String parametroId = req.getParameter("id");
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

        resp.sendRedirect("lista");
    }
}
