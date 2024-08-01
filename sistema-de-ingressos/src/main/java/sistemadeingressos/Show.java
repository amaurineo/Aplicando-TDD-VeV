package sistemadeingressos;

import java.util.HashMap;

public class Show {
    private final String id;
    private final String data;
    private final String nomeArtista;
    private HashMap<String, LoteIngresso> lotes;
    private final double cache;
    private final double despesas;
    private final double precoIngresso;
    private final boolean diaEspecial;

    public Show(String id, String data, String nomeArtista, double cache, double despesas, double precoIngresso, boolean diaEspecial) {
        this.id = id;
        this.data = data;
        this.nomeArtista = nomeArtista;
        this.cache = cache;
        this.despesas = despesas;
        this.precoIngresso = precoIngresso;
        this.diaEspecial = diaEspecial;
        this.lotes = new HashMap<String, LoteIngresso>();
    }

    public void adicionarLote(LoteIngresso lote) {
        this.lotes.put(lote.getId(), lote);
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getNomeArtista() {
        return nomeArtista;
    }

    public HashMap<String, LoteIngresso> getLotes() {
        return lotes;
    }

    public double getCache() {
        return cache;
    }

    public double getDespesas() {
        return despesas;
    }

    public double getPrecoIngresso() {
        return precoIngresso;
    }

    public boolean isDiaEspecial() {
        return diaEspecial;
    }
}
