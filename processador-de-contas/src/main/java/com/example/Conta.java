package com.example;

import java.util.Date;

class Conta {
    private String codigo;
    private Date data;
    private double valorPago;
    private String tipoPagamento;

    public Conta(String codigo, Date data, double valorPago, String tipoPagamento) {
        this.codigo = codigo;
        this.data = data;
        this.valorPago = valorPago;
        this.tipoPagamento = tipoPagamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getData() {
        return data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }
}
