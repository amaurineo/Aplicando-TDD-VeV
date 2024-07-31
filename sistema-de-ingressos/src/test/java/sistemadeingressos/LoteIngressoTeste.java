package sistemadeingressos;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
/*
Pelo que Li na proposta temos uma porcentagem de tipo de ingressos VIP por lote que é customizavel,

LoteIngresso
    id: Identificador único do lote.
    QuantDeIngressos: inteiro.
    ingressos: Conjunto de ingressos no lote. (20~30% vip, 10% meia)
    perCentVIP: inteiro.
    desconto: Desconto aplicável ao lote. (max 25%)

*/
public class LoteIngressoTeste {
    @Test
    public void testCriarLoteIngresso() {
        LoteIngresso lote = new LoteIngresso("L1", 500, 20, 0);
        assertEquals(lote.getId(),"L1", "Leitura do ID está incorreta");
        assertEquals(lote.getQuantDeIngressos(),500,"Leitura da Quantidade de Ingressos está incorreta");
        assertEquals(lote.getPerCentDesconto(),0,"Leitura da Porcentagem de Desconto  está incorreta");
        assertEquals(lote.getPerCentVIP(),20,"Leitura da Porcentagem de ingressos VIP  está incorreta");
    }

    @Test
    public void testPopulaIngressos() {
        LoteIngresso lote2 = new LoteIngresso("L2", 100, 20, 15); // 100 ingressos, 20% VIP
        HashMap<String, Ingresso> ingressos = lote2.getIngressos();
        assertEquals(20, countIngressosByType(ingressos, Ingresso.Tipo.VIP), "Quantidade de ingressos VIP está incorreta");
        assertEquals(10, countIngressosByType(ingressos, Ingresso.Tipo.MEIA_ENTRADA), "Quantidade de ingressos MEIA_ENTRADA está incorreta");
        assertEquals(70, countIngressosByType(ingressos, Ingresso.Tipo.NORMAL), "Quantidade de ingressos NORMAL está incorreta");
    }

    // Método auxiliar para contar ingressos por tipo
    private int countIngressosByType(HashMap<String, Ingresso> ingressos, Ingresso.Tipo tipo) {
        return (int) ingressos.values().stream().filter(ingresso -> ingresso.getTipo() == tipo).count();
    }

    @Test
    public void testVendeLoteTodo(){
        LoteIngresso lote3 = new LoteIngresso("L3",100,30,25);
        lote3.vendeLoteTodo();
        HashMap<String, Ingresso> ingressos = lote3.getIngressos();
        assertEquals(100,countIngressosVendidos(ingressos), "Método de vender todos os ingressos do lote está incorreto");
    }

    // Método auxiliar para contar ingressos Vendidos
    private int countIngressosVendidos(HashMap<String, Ingresso> ingressos) {
        return (int) ingressos.values().stream().filter(ingresso -> ingresso.getStatus() == Ingresso.Status.VENDIDO).count();
    }
}
