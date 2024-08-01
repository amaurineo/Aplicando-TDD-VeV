package sistemadeingressos;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class ShowTest {
    @Test
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

    @Test
    public void testAdicionarLote() {
        Show show = new Show("Show2", "10/09/99", "Route 99", 9999, 99999, 99.99, false);
        LoteIngresso lote = new LoteIngresso("L1", 100, 30, 25);
        show.adicionarLote(lote);
        HashMap<String, LoteIngresso> lotes = show.getLotes();
        assertEquals(1, lotes.size(), "O lote não foi adicionado corretamente");
        assertTrue(lotes.containsKey("L1"), "O lote com ID L1 não foi encontrado");
    }

    @Test
    public void testDiaEspecialAumentaDespesas() {
        Show show = new Show("Show3", "11/10/99", "Route 100", 10000, 100000, 100.00, true);
        assertEquals(115000, show.getDespesas(), "Despesas não aumentaram corretamente para o dia especial");
    }




}
