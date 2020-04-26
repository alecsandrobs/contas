package com.stolk.alecsandro.contas.servlet.lancamento;

import com.stolk.alecsandro.contas.lista.ListaConta;
import com.stolk.alecsandro.contas.lista.ListaFornecedor;
import com.stolk.alecsandro.contas.lista.ListaLancamento;
import com.stolk.alecsandro.contas.modelo.Conta;
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
import static java.lang.Double.parseDouble;
import static java.lang.Long.parseLong;

@WebServlet("/lancamentos/cadastra")
public class Cadastrar extends HttpServlet {


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String dataLancamento = req.getParameter("data");
        LocalDate data = dataBr(dataLancamento);

        String fornecedorId = req.getParameter("fornecedor");
        Fornecedor fornecedor = new ListaFornecedor().busca(parseLong(fornecedorId));

        String contaId = req.getParameter("conta");
        Conta conta = new ListaConta().busca(parseLong(contaId));

        String tipoLancamento = req.getParameter("tipo");
        TipoLancamento tipo = fromValue(tipoLancamento);

        String valorLancamento = req.getParameter("valor");
        Double valor = parseDouble(valorLancamento);

        String pagamentoLancamento = req.getParameter("pagamento");
        LocalDate pagamento = pagamentoLancamento != null && !pagamentoLancamento.trim().isEmpty() ? dataBr(pagamentoLancamento) : null;

        String observacoes = req.getParameter("observacoes");

        Lancamento lancamento = new Lancamento(data, fornecedor, conta, tipo, valor, pagamento, observacoes);

        ListaLancamento lista = new ListaLancamento();
        lista.adiciona(lancamento);

        resp.sendRedirect("lista");

    }
}
