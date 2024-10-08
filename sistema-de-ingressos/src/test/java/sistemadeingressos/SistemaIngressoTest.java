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

    @Test
    public void testCriarShows(){
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1","14/09/2025","Zeza Pacotinho",24000,50000,2000,true);
        assertTrue(sistema.getShows().containsKey("Show1"), "Houve alguma falha na criação do show");
    }

    @Test
    public void testCriarLoteParaShow(){
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1","14/09/2025","Zeza Pacotinho",24000,50000,2000,true);
        sistema.criarLoteParaShow("Show1","Lote1",5000,25,20);
        assertTrue(sistema.getShows().get("Show1").getLotes().containsKey("Lote1"));
    }

    @Test
    public void testCambistaCompraTudo(){
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1","14/09/2025","Zeza Pacotinho",24000,50000,2000,true);
        sistema.criarLoteParaShow("Show1","Lote1",5000,25,20);
        sistema.cambistaCompraTudo("Show1","Lote1");
        HashMap<String,Ingresso> ingressos = sistema.getShows().get("Show1").getLotes().get("Lote1").getIngressos();
        assertEquals(5000,countIngressosVendidos(ingressos), "Método de vender todos os ingressos do lote de um show está incorreto");
    }

    // Método auxiliar para contar ingressos Vendidos
    private int countIngressosVendidos(HashMap<String, Ingresso> ingressos) {
        return (int) ingressos.values().stream().filter(ingresso -> ingresso.getStatus() == Ingresso.Status.VENDIDO).count();
    }

    @Test
    public void testRelatorioDeShow(){
        SistemaIngresso sistema = new SistemaIngresso();
        sistema.criarShow("Show1","14/09/2025","Zeza Pacotinho", 24000,50000,2000,true);
        sistema.criarLoteParaShow("Show1","Lote1",5000,25,20);
        sistema.cambistaCompraTudo("Show1","Lote1");
        String relatorio = sistema.relatorioDeShow("Show1");
        System.out.println(relatorio);
        assertTrue(relatorio.contains("MeiaVendidos: 500"));
        assertTrue(relatorio.contains("NormalVendidos: 3250"));
        assertTrue(relatorio.contains("VipVendidos: 1250"));
        assertTrue(relatorio.contains("Receita: 9618500,00"));
        assertTrue(relatorio.contains("Status: LUCRO"),"Relatório não gerou o status esperado");
    }

}
