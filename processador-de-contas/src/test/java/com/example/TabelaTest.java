package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TabelaTest {

    private ProcessadorDeContas processador;
    private Fatura fatura;
    private List<Conta> contas;

    @BeforeEach
    public void initializeTestEnvironment() {
        processador = new ProcessadorDeContas();
        fatura = new Fatura(getDate(2023, Calendar.FEBRUARY, 20), 1000.0, "Carimbo Miguel Porfírio");
        contas = new ArrayList<>();
    }
    

    @Test
    public void TR1() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 600, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void TR2() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 50, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 600, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura);
        assertFalse(fatura.isPago());
    }


    @Test
    public void TR3() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 18), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 18), 500, "BOLETO"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }


    @Test
    public void TR4() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 21), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 18), 500, "BOLETO"));

        double soma = processador.processar(contas, fatura);
        assertEquals(1050, soma);
        assertTrue(fatura.isPago());
    }


    @Test
    public void TR5() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 4), getDate(2023, Calendar.FEBRUARY, 18), 1000, "CARTAO_CREDITO"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void TR5_2() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 7), getDate(2023, Calendar.FEBRUARY, 18), 1000, "CARTAO_CREDITO"));

        processador.processar(contas, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void TR6() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
