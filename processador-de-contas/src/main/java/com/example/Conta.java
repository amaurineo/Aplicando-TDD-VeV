package com.example;

import java.util.Date;

class Conta {
    private String codigo;
    private Date data;
    private Date data_paga;
    private double valorPago;
    private String tipoPagamento;

    public Conta(String codigo, Date data, Date data_paga, double valorPago, String tipoPagamento) {
        this.codigo = codigo;
        this.data = data;
        this.data_paga = data_paga;
        this.valorPago = valorPago;
        this.tipoPagamento = tipoPagamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getData() {
        return data;
    }

    public Date getDataPaga() {
        return data_paga;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
}
