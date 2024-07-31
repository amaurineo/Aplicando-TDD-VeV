package com.example;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProcessadorDeContas {

    public void processar(List<Conta> contas, Fatura fatura) {
        double somaPagamentos = 0;
        
        // A data da fatura já está ajustada para meia-noite na criação da fatura

        for (Conta conta : contas) {
            double valorPago = conta.getValorPago();
            Date dataConta = ajustarDataParaMeiaNoite(conta.getData());
            String tipoPagamento = conta.getTipoPagamento();

            boolean incluirPagamento = false;

            if (tipoPagamento.equals("BOLETO")) {
                if (valorPago >= 0.01 && valorPago <= 5000.00) {
                    incluirPagamento = true;
                    if (dataConta.after(fatura.getData())) {
                        valorPago *= 1.10; // Acrescenta 10% no valor do pagamento por atraso
                    }
                }
            } else if (tipoPagamento.equals("CARTAO_CREDITO")) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(dataConta);
                cal.add(Calendar.DAY_OF_MONTH, 15);
                
                if (true) {
                    incluirPagamento = true;
                }
            } else if (tipoPagamento.equals("TRANSFERENCIA_BANCARIA")) {
                if (true) {
                    incluirPagamento = true;
                }
            }

            if (incluirPagamento) {
                Pagamento pagamento = new Pagamento(valorPago, dataConta, tipoPagamento);
                fatura.adicionarPagamento(pagamento);
                somaPagamentos += valorPago;
            }
        }

        fatura.setPago(somaPagamentos >= fatura.getValorTotal());
    }

    private Date ajustarDataParaMeiaNoite(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }


}
