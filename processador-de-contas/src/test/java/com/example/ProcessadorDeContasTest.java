package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ProcessadorDeContasTest {

    private ProcessadorDeContas processador;
    private Fatura fatura;
    private List<Conta> contas;

    @BeforeEach
    public void initializeTestEnvironment() {
        processador = new ProcessadorDeContas();
        fatura = new Fatura(getDate(2023, Calendar.FEBRUARY, 20), 1500.0, "Cliente A");
        contas = new ArrayList<>();
    }

    @Test
    public void testProcessarContasFaturaPagaCaso1() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), 500.0, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), 400.0, "BOLETO"));
        contas.add(new Conta("003", getDate(2023, Calendar.FEBRUARY, 20), 600.0, "BOLETO"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void testProcessarContasFaturaPagaCaso2() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 5), 700.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 17), 800.0, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void testProcessarContasFaturaPendenteCaso3() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 6), 700.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 17), 800.0, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura);
        assertFalse(fatura.isPago());
    }

    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
