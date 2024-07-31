package sistemadeingressos;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/*A unica coisa mutavel em Ingresso é o seu status então estou satisfeito com essa bateira de teste*/
public class IngressoTest {
    @Test
    public void testCriarIngresso() {
        Ingresso ingresso = new Ingresso("303030", Ingresso.Tipo.VIP, Ingresso.Status.DISPONIVEL);
        assertEquals(ingresso.getId(),"303030","Leitura do ID está incorreta");
        assertEquals(Ingresso.Tipo.VIP, ingresso.getTipo(),"Leitura do Tipo está incorreta");
        assertEquals(Ingresso.Status.DISPONIVEL, ingresso.getStatus(),"Leitura do Status está incorreta");
    }

    @Test
    public void testSetStatusVendido() {
        Ingresso ingresso = new Ingresso( "404040",Ingresso.Tipo.NORMAL, Ingresso.Status.DISPONIVEL);
        ingresso.setStatus(Ingresso.Status.VENDIDO);
        assertEquals(Ingresso.Status.VENDIDO, ingresso.getStatus(),"Mudança do Status está incorreta");
    }
}
