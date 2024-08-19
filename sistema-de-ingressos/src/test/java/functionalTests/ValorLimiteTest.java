package functionalTests;

import org.junit.Test;
import sistemadeingressos.SistemaIngresso;

import static org.junit.jupiter.api.Assertions.*;

public class ValorLimiteTest {

    //testes de Análise de Valores Limites  para criação de show
    @Test
    public void testCriarShowValoresValidos() {
        SistemaIngresso sistema = new SistemaIngresso();

        // Teste 1
        try {
            sistema.criarShow("show01", "2024-08-18", "Artista", 0.01, 0.01, 0.01, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 13
        try {
            sistema.criarShow("show13", "2024-08-18", "Artista", 0.01, 0.01, 10.0, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 14
        try {
            sistema.criarShow("show14", "2024-08-18", "Artista", 0.01, 10.0, 0.01, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 15
        try {
            sistema.criarShow("show15", "2024-08-18", "Artista", 10.0, 0.01, 0.01, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    @Test
    public void testCriarShowValoresInvalidos() {
        SistemaIngresso sistema = new SistemaIngresso();

        // Teste 2
        try {
            sistema.criarShow("show02", "2024-08-18", "Artista", 0.01, 0.01, -0.01, false);
            fail("Deveria lançar exceção para preço do ingresso inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: preço do ingresso inválido.", e.getMessage());
        }

        // Teste 3
        try {
            sistema.criarShow("show03", "2024-08-18", "Artista", 0.01, -0.01, 0.01, false);
            fail("Deveria lançar exceção para despesas inválidas.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: despesas inválidas.", e.getMessage());
        }

        // Teste 4
        try {
            sistema.criarShow("show04", "2024-08-18", "Artista", -0.01, 0.01, 0.01, false);
            fail("Deveria lançar exceção para cachê inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: cachê inválido.", e.getMessage());
        }

        // Teste 5
        try {
            sistema.criarShow("show05", "2024-08-18", "Artista", 0.01, -0.01, -0.01, false);
            fail("Deveria lançar exceção para despesas e preço do ingresso inválidos.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: despesas e preço do ingresso inválidos.", e.getMessage());
        }

        // Teste 6
        try {
            sistema.criarShow("show06", "2024-08-18", "Artista", -0.01, 0.01, -0.01, false);
            fail("Deveria lançar exceção para cachê e preço do ingresso inválidos.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: cachê e preço do ingresso inválidos.", e.getMessage());
        }

        // Teste 7
        try {
            sistema.criarShow("show07", "2024-08-18", "Artista", -0.01, -0.01, 0.01, false);
            fail("Deveria lançar exceção para cachê e despesas inválidos.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: cachê e despesas inválidos.", e.getMessage());
        }

        // Teste 8
        try {
            sistema.criarShow("show08", "2024-08-18", "Artista", -0.01, -0.01, -0.01, false);
            fail("Deveria lançar exceção para todos os valores inválidos.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: todos os valores inválidos.", e.getMessage());
        }

        // Teste 9
        try {
            sistema.criarShow("show09", "2024-08-18", "Artista", 0.01, 0.01, 0.00, false);
            fail("Deveria lançar exceção para preço do ingresso inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: preço do ingresso inválido.", e.getMessage());
        }

        // Teste 10
        try {
            sistema.criarShow("show10", "2024-08-18", "Artista", 0.01, 0.00, 0.01, false);
            fail("Deveria lançar exceção para despesas inválidas.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: despesas inválidas.", e.getMessage());
        }

        // Teste 11
        try {
            sistema.criarShow("show11", "2024-08-18", "Artista", 0.00, 0.01, 0.01, false);
            fail("Deveria lançar exceção para cachê inválido.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: cachê inválido.", e.getMessage());
        }

        // Teste 12
        try {
            sistema.criarShow("show12", "2024-08-18", "Artista", 0.00, 0.00, 0.00, false);
            fail("Deveria lançar exceção para todos os valores inválidos.");
        } catch (IllegalArgumentException e) {
            assertEquals("Erro: todos os valores inválidos.", e.getMessage());
        }
    }

    @Test
    public void testCriarLoteValoresValidos() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1", "14/09/2025", "Zeza Pacotinho", 24000, 50000, 2000, true);

        // Teste 16
        try {
            sistema.criarLoteParaShow("Show1", "lote01",1 , 20, 0);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 17
        try {
            sistema.criarLoteParaShow("Show1", "lote01",1 , 20, 0);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 18
        try {
            sistema.criarLoteParaShow("Show1", "lote01",1 , 20, 25);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 19
        try {
            sistema.criarLoteParaShow("Show1", "lote01",10 , 25, 10);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }

        // Teste 20
        try {
            sistema.criarLoteParaShow("Show1", "lote01",1 , 25, 25);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    // Teste 21
    @Test
    public void testCriarLoteParaShowComQuantidadeIngressoInvalida() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L1", -1, 20, 0);
        });

        assertEquals("Erro: Q.Ingresso inválido.", exception.getMessage());
    }

    // Teste 22
    @Test
    public void testCriarLoteParaShowComPercentualVIPInvalido() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L2", 10, 19, 0);
        });

        assertEquals("Erro: P.VIP inválido.", exception.getMessage());
    }

    // Teste 23
    @Test
    public void testCriarLoteParaShowComPercentualDescontoInvalido() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L3", 10, 25, 26);
        });

        assertEquals("Erro: P.Desconto inválido.", exception.getMessage());
    }

    // Teste 24
    @Test
    public void testCriarLoteParaShowComQuantidadeIngressoEPercentualVIPInvalidos() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L4", -1, 19, 10);
        });

        assertEquals("Erro: Q.Ingresso e P.VIP inválidos.", exception.getMessage());
    }

    // Teste 25
    @Test
    public void testCriarLoteParaShowComPercentualVIPeDescontoInvalidos() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L5", 10, 31, 26);
        });

        assertEquals("Erro: P.VIP e P.Desconto inválidos.", exception.getMessage());
    }

    // Teste 26
    @Test
    public void testCriarLoteParaShowComTodosOsValoresInvalidos() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("1", "2024-08-19", "Artista Teste", 10000, 5000, 200, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("1", "L6", -1, 19, -1);
        });

        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }
}