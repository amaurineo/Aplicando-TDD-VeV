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

}
