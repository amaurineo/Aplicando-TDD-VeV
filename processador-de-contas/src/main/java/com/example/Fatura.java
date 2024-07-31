package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Fatura {
    private Date data;
    private double valorTotal;
    private String nomeCliente;
    private boolean pago;
    private List<Pagamento> pagamentos;

    public Fatura(Date data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.pago = false;
        this.pagamentos = new ArrayList<>();
    }

    public Date getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}

