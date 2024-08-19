package functionalTests;

import org.junit.Test;
import sistemadeingressos.Show;
import sistemadeingressos.SistemaIngresso;
import static org.junit.jupiter.api.Assertions.*;

public class TabelaTest {
    @Test
    public void testCriarShowCaso1() {
        SistemaIngresso sistema = new SistemaIngresso();
        try {
            sistema.criarShow("Show1", "2024-08-20", "Artista X", 10.0, 100.0, 50.0, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    @Test
    public void testCriarShowCaso2() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show2", "2024-08-20", "Artista Y", 0.0, 100.0, 50.0, false);
        });

        assertEquals("Erro: Cachê inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso3() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show3", "2024-08-20", "Artista Z", 10.0, 0.0, 50.0, false);
        });

        assertEquals("Erro: Despesas inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso4() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show4", "2024-08-20", "Artista W", 10.0, 100.0, 0.0, false);
        });

        assertEquals("Erro: Preço do ingresso inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso5() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show5", "2024-08-20", "Artista V", 0.0, 0.0, 50.0, false);
        });

        assertEquals("Erro: Cachê e Despesas inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso6() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show6", "2024-08-20", "Artista U", 10.0, 0.0, 0.0, false);
        });

        assertEquals("Erro: Despesas e Preço inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso7() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show7", "2024-08-20", "Artista T", 0.0, 100.0, 0.0, false);
        });

        assertEquals("Erro: Cachê e Preço inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarShowCaso8() {
        SistemaIngresso sistema = new SistemaIngresso();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("Show8", "2024-08-20", "Artista S", 0.0, 0.0, 0.0, false);
        });

        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso9() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show9", "2024-08-19", "Artista Teste", 10, 100, 50, false);
        try {
            sistema.criarLoteParaShow("Show9", "Lote1", 10, 25, 10);
            System.out.println("Lote criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    @Test
    public void testCriarLoteCaso10() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show10", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show10", "Lote2", 0, 25, 10);
        });

        assertEquals("Erro: Quantidade de ingressos inválida.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso11() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show11", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show11", "Lote3", 10, 19, 10);
        });

        assertEquals("Erro: Porcentagem VIP inválida.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso12() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show12", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show12", "Lote4", 10, 25, -1);
        });

        assertEquals("Erro: Porcentagem de desconto inválida.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso13() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show13", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show13", "Lote5", 0, 19, 10);
        });

        assertEquals("Erro: Quantidade de ingressos e porcentagem VIP inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso14() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show14", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show14", "Lote6", 10, 19, -1);
        });

        assertEquals("Erro: Porcentagem VIP e porcentagem de desconto inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso15() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show15", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show15", "Lote7", 0, 25, 26);
        });

        assertEquals("Erro: Quantidade de ingressos e porcentagem de desconto inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarLoteCaso16() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show16", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("Show16", "Lote8", 0, 19, 26);
        });

        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }
}
