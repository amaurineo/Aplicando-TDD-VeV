package sistemadeingressos;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class ShowTest {
    public void testCriarShow() {
        Show show = new Show("Show1","09/09/99","Route 99", 9999,99999,99.99,false);
        assertEquals(show.getId(),"Show1","Leitura do ID está incorreta");
        assertEquals(show.getData(),"09/09/99","Leitura da data está incorreta");
        assertEquals(show.getNomeArtista(),"Route 99","Leitura do Nome do artista está incorreta");
        assertEquals(show.getCache(),9999,"Leitura do cachê está incorreta");
        assertEquals(show.getDespesas(),99999,"Leitura das despesas está incorreta");
        assertEquals(show.getPrecoIngresso(),99.99,"Leitura do preço do ingresso está incorreta");
        assertEquals(show.isDiaEspecial(),false,"Leitura do diaEspecial está incorreta");
    }
}
