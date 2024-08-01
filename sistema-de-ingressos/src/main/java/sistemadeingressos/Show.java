package sistemadeingressos;

import java.util.HashMap;

public class Show {
    private final String id;
    private final String data;
    private final String nomeArtista;
    private HashMap<String, LoteIngresso> lotes;
    private final double cache;
    private double despesas;
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
        if (diaEspecial) {
            this.despesas *= 1.15;
            this.despesas = Math.round(this.despesas * 100.0) / 100.0;
        }
    }

    public void adicionarLote(LoteIngresso lote) {
        this.lotes.put(lote.getId(), lote);
    }

    public String gerarRelatorio() {
        int meiaVendidos = 0;
        int normalVendidos = 0;
        int vipVendidos = 0;
        double receita = 0.0;

        for (LoteIngresso lote : lotes.values()) {
            for (Ingresso ingresso : lote.getIngressos().values()) {
                if (ingresso.getStatus() == Ingresso.Status.VENDIDO) {
                    double precoFinal = precoIngresso;
                    if (ingresso.getTipo() == Ingresso.Tipo.VIP) {
                        precoFinal *= 2;
                        precoFinal *= (1 - (lote.getPerCentDesconto() / 100.0));
                        vipVendidos++;
                    } else if (ingresso.getTipo() == Ingresso.Tipo.MEIA_ENTRADA) {
                        precoFinal *= 0.5;
                        meiaVendidos++;
                    } else {
                        precoFinal *= (1 - (lote.getPerCentDesconto() / 100.0));
                        normalVendidos++;
                    }
                    receita += precoFinal;
                }
            }
        }

        double receitaLiquida = receita - despesas - cache;
        String status;
        if (receitaLiquida > 0) {
            status = "LUCRO";
        } else if (receitaLiquida == 0) {
            status = "ESTÁVEL";
        } else {
            status = "PREJUÍZO";
        }

        return String.format("MeiaVendidos: %d\nNormalVendidos: %d\nVipVendidos: %d\nReceita: %.2f\nStatus: %s",
                meiaVendidos, normalVendidos, vipVendidos, receitaLiquida, status);
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
