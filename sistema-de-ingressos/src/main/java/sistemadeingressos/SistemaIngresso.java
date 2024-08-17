package sistemadeingressos;

import java.util.HashMap;

public class SistemaIngresso {
    private HashMap<String,Show> shows;


    public SistemaIngresso() {
        this.shows = new HashMap<String, Show>();
    }

    public void criarShow(String id, String data, String nomeArtista, double cache, double despesas, double precoIngresso, boolean diaEspecial){
        Show show = new Show(id,data,nomeArtista,cache,despesas,precoIngresso,diaEspecial);
        this.shows.put(id,show);
    }

    public void criarLoteParaShow(String showID, String loteID, int quantDeIngresso, int perCentVIP, int perCentDesconto) {
        LoteIngresso lote1 = new LoteIngresso(loteID,quantDeIngresso,perCentVIP,perCentDesconto);
        this.shows.get(showID).adicionarLote(lote1);
    }

    public void cambistaCompraTudo(String showID, String loteID) {
        this.shows.get(showID).getLotes().get(loteID).vendeLoteTodo();
    }

    public String relatorioDeShow(String showID) {
        return this.shows.get(showID).gerarRelatorio();
    }

    public HashMap<String, Show> getShows() {
        return shows;
    }
}
