package sistemadeingressos;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

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
    public void CriarLoteIngresso() {
        LoteIngresso lote = new LoteIngresso("L1", 500, 0, 20);
        assertEquals(lote.getId(),"L1");
        assertEquals(lote.getQuantDeIngressos(),500);
        assertEquals(lote.getPerCentDesconto(),0);
        assertEquals(lote.getPerCentVIP(),20);
    }

}
