package functionalTests;

import org.junit.Test;
import sistemadeingressos.SistemaIngresso;
import static org.junit.jupiter.api.Assertions.*;

public class ParticaoTest {

    @Test
    public void testCriarShowTeste1() {
        SistemaIngresso sistema = new SistemaIngresso();
        try {
            sistema.criarShow("show01", "2024-08-18", "Artista", 10, 100, 50, false);
            System.out.println("Show criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    @Test
    public void testCriarShowTeste2() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("2", "2024-08-19", "Artista Teste", 10, 100, 0, false);
        });
        assertEquals("Erro: preço do ingresso inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste3() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("3", "2024-08-19", "Artista Teste", 10, 100, -0.01, false);
        });
        assertEquals("Erro: preço do ingresso inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste4() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("4", "2024-08-19", "Artista Teste", 10, 0, 50, false);
        });
        assertEquals("Erro: despesas inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste5() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("5", "2024-08-19", "Artista Teste", 10, -0.01, 50, false);
        });
        assertEquals("Erro: despesas inválidas.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste6() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("6", "2024-08-19", "Artista Teste", 0, 100, 50, false);
        });
        assertEquals("Erro: cachê inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste7() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("7", "2024-08-19", "Artista Teste", -0.01, 100, 50, false);
        });
        assertEquals("Erro: cachê inválido.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste8() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("8", "2024-08-19", "Artista Teste", -0.01, 0, 0, false);
        });
        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste9() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("9", "2024-08-19", "Artista Teste", 10, -0.01, -0.01, false);
        });
        assertEquals("Erro: despesas e preço do ingresso inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarShowTeste10() {
        SistemaIngresso sistema = new SistemaIngresso();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarShow("10", "2024-08-19", "Artista Teste", 0, 0, 0, false);
        });
        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste11() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1", "2024-08-19", "Artista Teste", 10, 100, 50, false);
        try {
            sistema.criarLoteParaShow("Show1", "lote01",10 , 25, 10);
            System.out.println("Lote criado com sucesso.");
        } catch (IllegalArgumentException e) {
            fail("Não deveria lançar exceção para valores válidos.");
        }
    }

    @Test
    public void testCriarLoteParaShowTeste12() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("2", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("2", "L2", -1, 25, 10);
        });

        assertEquals("Erro: Q.Ingresso inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste13() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("3", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("3", "L3", 0, 25, 10);
        });

        assertEquals("Erro: Q.Ingresso inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste14() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("4", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("4", "L4", 10, 19, 10);
        });

        assertEquals("Erro: P.VIP inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste15() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("5", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("5", "L5", 10, 31, 10);
        });

        assertEquals("Erro: P.VIP inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste16() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("6", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("6", "L6", 10, 25, -1);
        });

        assertEquals("Erro: P.Desconto inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste17() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("7", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("7", "L7", 10, 25, 26);
        });

        assertEquals("Erro: P.Desconto inválido.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste18() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("8", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("8", "L8", -1, 19, 25);
        });

        assertEquals("Erro: Q.Ingresso e P.VIP inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste19() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("9", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("9", "L9", 0, 20, 26);
        });

        assertEquals("Erro: Q.Ingresso e P.Desconto inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste20() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("10", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("10", "L10", 10, 31, -1);
        });

        assertEquals("Erro: P.VIP e P.Desconto inválidos.", exception.getMessage());
    }

    @Test
    public void testCriarLoteParaShowTeste21() {
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("11", "2024-08-19", "Artista Teste", 10, 100, 50, false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sistema.criarLoteParaShow("11", "L11", -1, 19, 26);
        });

        assertEquals("Erro: todos os valores inválidos.", exception.getMessage());
    }
}
