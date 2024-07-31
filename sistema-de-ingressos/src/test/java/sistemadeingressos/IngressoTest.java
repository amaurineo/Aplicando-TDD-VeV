package sistemadeingressos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IngressoTest {
    @Test
    public void testCriacaoIngresso() {
        // Este é um teste simples para criar um ingresso
        Ingresso ingresso = new Ingresso("Evento Teste", 50.0);
        assertEquals("Evento Teste", ingresso.getNomeEvento());
        assertEquals(50.0, ingresso.getPreco(), 0.01);
    }
}
