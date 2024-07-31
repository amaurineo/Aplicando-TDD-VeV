package sistemadeingressos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*A unica coisa mutavel em Ingresso é o seu status então estou satisfeito com essa bateira de teste*/
public class IngressoTest {
    @Test
    public void testCriarIngresso() {
        Ingresso ingresso = new Ingresso("303030", Ingresso.Tipo.VIP, Ingresso.Status.DISPONIVEL);
        assertEquals(ingresso.getId(),"303030");
        assertEquals(Ingresso.Tipo.VIP, ingresso.getTipo());
        assertEquals(Ingresso.Status.DISPONIVEL, ingresso.getStatus());
    }

    @Test
    public void testSetStatusVendido() {
        Ingresso ingresso = new Ingresso( "404040",Ingresso.Tipo.NORMAL, Ingresso.Status.DISPONIVEL);
        ingresso.setStatus(Ingresso.Status.VENDIDO);
        assertEquals(Ingresso.Status.VENDIDO, ingresso.getStatus());
    }
}
