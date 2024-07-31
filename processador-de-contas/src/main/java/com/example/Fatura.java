package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class Fatura {
    private Date data;
    private double valorTotal;
    private String nomeCliente;
    private boolean paga;
    private List<Pagamento> pagamentos;

    public Fatura(Date data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.paga = false;
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

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public void adicionarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }
}

