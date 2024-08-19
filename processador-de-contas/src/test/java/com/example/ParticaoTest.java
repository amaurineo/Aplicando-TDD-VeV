package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ParticaoTest {
    private ProcessadorDeContas processador;
    private Fatura fatura;
    private List<Conta> contas;

    @BeforeEach
    public void initializeTestEnvironment() {
        processador = new ProcessadorDeContas();
        fatura = new Fatura(getDate(2023, Calendar.FEBRUARY, 20), 1500.0, "Carimbo Miguel Porfírio");
        contas = new ArrayList<>();
    }

    @Test
    public void TC1() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 400, "BOLETO"));
        contas.add(new Conta("003", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 600, "BOLETO"));

        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void TC2() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 5), getDate(2023, Calendar.FEBRUARY, 19), 700, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 17), getDate(2023, Calendar.FEBRUARY, 19), 800, "TRANSFERENCIA_BANCARIA"));


        processador.processar(contas, fatura);
        assertTrue(fatura.isPago());
    }

    @Test
    public void TC3() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 6), getDate(2023, Calendar.FEBRUARY, 19), 700, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 17), getDate(2023, Calendar.FEBRUARY, 19), 800, "TRANSFERENCIA_BANCARIA"));


        processador.processar(contas, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void TC4() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 0, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 6000, "BOLETO"));

        processador.processar(contas, fatura);
        assertFalse(fatura.isPago());
    }

    @Test
    public void TC5() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 22), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 19), 1000, "BOLETO"));

        double soma = processador.processar(contas, fatura);
        assertEquals(1550,soma);
        assertTrue(fatura.isPago());
    }


    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
