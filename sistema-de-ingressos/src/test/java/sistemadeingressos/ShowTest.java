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
        Show show = new Show("show3", "11/11/99", "Route 101", 100000, 100000, 100, true);
        assertEquals(115000.0, show.getDespesas(), 0.0001, "Despesas não aumentaram corretamente para o dia especial");
    }

    @Test
    public void testGerarRelatorioLucro() {
        Show show = new Show("Show3", "11/11/99", "Route 101", 5000, 10000, 150.00, false);
        LoteIngresso lote1 = new LoteIngresso("L1", 100, 20, 10);

        show.adicionarLote(lote1);

        lote1.vendeLoteTodo();

        String relatorio = show.gerarRelatorio();

        System.out.println(relatorio);

        assertTrue(relatorio.contains("MeiaVendidos: 10"));
        assertTrue(relatorio.contains("NormalVendidos: 70"));
        assertTrue(relatorio.contains("VipVendidos: 20"));
        assertTrue(relatorio.contains("Receita: 600,00"));
        assertTrue(relatorio.contains("Status: LUCRO"),"Relatório não gerou o status esperado");
    }

    @Test
    public void testGerarRelatorioEstavel() {
        Show show = new Show("Show4", "12/12/99", "Route 102", 1500, 10000, 100, false);
        LoteIngresso lote1 = new LoteIngresso("L1", 100, 20, 0);

        show.adicionarLote(lote1);

        lote1.vendeLoteTodo();

        String relatorio = show.gerarRelatorio();

        System.out.println(relatorio);

        assertTrue(relatorio.contains("MeiaVendidos: 10"));
        assertTrue(relatorio.contains("NormalVendidos: 70"));
        assertTrue(relatorio.contains("VipVendidos: 20"));
        assertTrue(relatorio.contains("Receita: 0,00"));
        assertTrue(relatorio.contains("Status: ESTÁVEL"), "Relatório não gerou o status esperado");
    }

    @Test
    public void testGerarRelatorioPrejuizo() {
        Show show = new Show("Show5", "13/13/99", "Route 103", 100000, 200000, 100, false);
        LoteIngresso lote1 = new LoteIngresso("L1", 10, 0, 0);

        show.adicionarLote(lote1);

        lote1.vendeLoteTodo();

        String relatorio = show.gerarRelatorio();

        System.out.println(relatorio);

        assertTrue(relatorio.contains("MeiaVendidos: 1"));
        assertTrue(relatorio.contains("NormalVendidos: 9"));
        assertTrue(relatorio.contains("VipVendidos: 0"));
        assertTrue(relatorio.contains("Receita: -299050,00"));
        assertTrue(relatorio.contains("Status: PREJUÍZO"), "Relatório não gerou o status esperado");
    }



}
