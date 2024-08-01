package sistemadeingressos;

import org.junit.Assert;
import org.junit.Test;

public class SistemaIngressoTest {
    @Test
    public void testCriarSistema() {
        SistemaIngresso sistema = new SistemaIngresso();
        AssertTrue(sistema.getShows.isempty, "Não podem existir shows na hora em que o sistema é criado!");
    }
}
