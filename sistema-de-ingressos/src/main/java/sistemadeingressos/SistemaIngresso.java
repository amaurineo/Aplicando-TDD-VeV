package sistemadeingressos;

import java.util.HashMap;

public class SistemaIngresso {
    private HashMap<String,Show> shows;


    public SistemaIngresso() {
        this.shows = new HashMap<String, Show>();
    }

    public void criarShow(String id, String data, String nomeArtista, double cache, double despesas, double precoIngresso, boolean diaEspecial) {
        if (cache <= 0) {
            if (despesas <= 0 && precoIngresso <= 0) {
                throw new IllegalArgumentException("Erro: todos os valores inválidos.");
            } else if (despesas <= 0) {
                throw new IllegalArgumentException("Erro: cachê e despesas inválidos.");
            } else if (precoIngresso <= 0) {
                throw new IllegalArgumentException("Erro: cachê e preço do ingresso inválidos.");
            } else {
                throw new IllegalArgumentException("Erro: cachê inválido.");
            }
        } else if (despesas <= 0) {
            if (precoIngresso <= 0) {
                throw new IllegalArgumentException("Erro: despesas e preço do ingresso inválidos.");
            } else {
                throw new IllegalArgumentException("Erro: despesas inválidas.");
            }
        } else if (precoIngresso <= 0) {
            throw new IllegalArgumentException("Erro: preço do ingresso inválido.");
        } else {
            Show show = new Show(id, data, nomeArtista, cache, despesas, precoIngresso, diaEspecial);
            this.shows.put(id, show);
        }
    }

    public void criarLoteParaShow(String showID, String loteID, int quantDeIngresso, int perCentVIP, int perCentDesconto) {
        if (quantDeIngresso <= 0) {
            if (perCentVIP < 20 || perCentVIP > 30) {
                if (perCentDesconto < 0 || perCentDesconto > 25) {
                    throw new IllegalArgumentException("Erro: todos os valores inválidos.");
                } else {
                    throw new IllegalArgumentException("Erro: Q.Ingresso e P.VIP inválidos.");
                }
            } else if (perCentDesconto < 0 || perCentDesconto > 25) {
                throw new IllegalArgumentException("Erro: Q.Ingresso e P.Desconto inválidos.");
            } else {
                throw new IllegalArgumentException("Erro: Q.Ingresso inválido.");
            }
        } else if (perCentVIP < 20 || perCentVIP > 30) {
            if (perCentDesconto < 0 || perCentDesconto > 25) {
                throw new IllegalArgumentException("Erro: P.VIP e P.Desconto inválidos.");
            } else {
                throw new IllegalArgumentException("Erro: P.VIP inválido.");
            }
        } else if (perCentDesconto < 0 || perCentDesconto > 25) {
            throw new IllegalArgumentException("Erro: P.Desconto inválido.");
        } else {
            LoteIngresso lote1 = new LoteIngresso(loteID, quantDeIngresso, perCentVIP, perCentDesconto);
            this.shows.get(showID).adicionarLote(lote1);
        }
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
