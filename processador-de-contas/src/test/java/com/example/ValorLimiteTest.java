package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ValorLimiteTest {

    private ProcessadorDeContas processador;
    private Fatura fatura1;
    private Fatura fatura2;
    private List<Conta> contas;

    @BeforeEach
    public void initializeTestEnvironment() {
        processador = new ProcessadorDeContas();
        fatura1 = new Fatura(getDate(2023, Calendar.FEBRUARY, 20), 1500.0, "Carimbo Miguel Porfírio");
        fatura2 = new Fatura(getDate(2023, Calendar.FEBRUARY, 20), 6000.0, "Carimbo Miguel Porfírio");
        contas = new ArrayList<>();
    }

    @Test
    public void TC1() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 0.01, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 1499.99, "BOLETO"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC2() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 0.02, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 1499.98, "BOLETO"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC3() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 50, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 1450, "BOLETO"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC4() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 17), getDate(2023, Calendar.FEBRUARY, 17), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 17), getDate(2023, Calendar.FEBRUARY, 17), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC5() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 19), getDate(2023, Calendar.FEBRUARY, 19), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC6() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC7() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 21), getDate(2023, Calendar.FEBRUARY, 21), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 21), getDate(2023, Calendar.FEBRUARY, 21), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertFalse(fatura1.isPago());
    }

    @Test
    public void TC8() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 22), getDate(2023, Calendar.FEBRUARY, 22), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 22), getDate(2023, Calendar.FEBRUARY, 22),1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertFalse(fatura1.isPago());
    }

    @Test
    public void TC9() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 24), getDate(2023, Calendar.FEBRUARY, 24), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 24), getDate(2023, Calendar.FEBRUARY, 24), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertFalse(fatura1.isPago());
    }

    @Test
    public void TC10() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));

        processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
    }

    @Test
    public void TC11() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));

        double soma = processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
        assertEquals(1500.00, soma);
    }

    @Test
    public void TC12() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 21), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));

        double soma = processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
        assertEquals(1550.00, soma);
    }

    @Test
    public void TC13() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 20), 500, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));

        double soma = processador.processar(contas, fatura1);
        assertTrue(fatura1.isPago());
        assertEquals(1550.00, soma);
    }

    @Test
    public void TC14() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 4999.99, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000.01, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC15() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 5000, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC16() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 5000, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000.01, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC17() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 5000, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1050, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC18() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 17), 4999.99, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());

    }

    @Test
    public void TC18_erro() {
        // Observa-se erro no processamento do acréscimo de 10% no boleto
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 18), 4999.99, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());
    }

    @Test
    public void TC19() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 17), 4999.98, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());

    }

    @Test
    public void TC20() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 18), getDate(2023, Calendar.FEBRUARY, 17), 4950.99, "BOLETO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());

    }


    @Test
    public void TC21() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 1), getDate(2023, Calendar.FEBRUARY, 1), 1000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 5000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC22() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 4), getDate(2023, Calendar.FEBRUARY, 1), 1000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 5000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC23() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 4), getDate(2023, Calendar.FEBRUARY, 1), 5000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 500, "TRANSFERENCIA_BANCARIA"));
        contas.add(new Conta("003", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 500, "BOLETO"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());   
    }

    @Test
    public void TC24() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 5), getDate(2023, Calendar.FEBRUARY, 1), 5000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertTrue(fatura2.isPago());

    }

    @Test
    public void TC25() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 6), getDate(2023, Calendar.FEBRUARY, 1), 5000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());

    }

    @Test
    public void TC26() {
        contas.add(new Conta("001", getDate(2023, Calendar.FEBRUARY, 10), getDate(2023, Calendar.FEBRUARY, 1), 5000.0, "CARTAO_CREDITO"));
        contas.add(new Conta("002", getDate(2023, Calendar.FEBRUARY, 20), getDate(2023, Calendar.FEBRUARY, 20), 1000, "TRANSFERENCIA_BANCARIA"));
        
        processador.processar(contas, fatura2);
        assertFalse(fatura2.isPago());

    }
       

    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}