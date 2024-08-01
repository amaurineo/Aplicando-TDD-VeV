package sistemadeingressos;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class SistemaIngressoTest {
    @Test
    public void testCriarSistema() {
        SistemaIngresso sistema = new SistemaIngresso();
        assertTrue(sistema.getShows().isEmpty(), "Não podem existir shows na hora em que o sistema é criado!");
    }
}
