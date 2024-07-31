package sistemadeingressos;

import java.util.HashMap;
import java.util.UUID;

public class LoteIngresso {
    private final String id;
    private final int quantDeIngressos;
    private HashMap ingressos;
    private final int perCentVIP;
    private final int perCentDesconto;

    public LoteIngresso(String id, int quantDeIngressos, int perCentVIP, int perCentDesconto) {
        this.id = id;
        this.quantDeIngressos = quantDeIngressos;
        this.perCentVIP = perCentVIP;
        this.perCentDesconto = perCentDesconto;
        this.ingressos = new HashMap<>();
        populaIngressos();
    }

    public void populaIngressos() {
        int numVIP = (int) Math.round(this.quantDeIngressos * (this.perCentVIP / 100.0));
        int numMeia = (int) Math.round(this.quantDeIngressos * 0.10);
        int numNormal = this.quantDeIngressos - numVIP - numMeia;

        for (int i = 0; i < numVIP; i++) {
            String id = UUID.randomUUID().toString();
            Ingresso ingresso = new Ingresso(id, Ingresso.Tipo.VIP, Ingresso.Status.DISPONIVEL);
            ingressos.put(id, ingresso);
        }

        for (int i = 0; i < numMeia; i++) {
            String id = UUID.randomUUID().toString();
            Ingresso ingresso = new Ingresso(id, Ingresso.Tipo.MEIA_ENTRADA, Ingresso.Status.DISPONIVEL);
            ingressos.put(id, ingresso);
        }

        for (int i = 0; i < numNormal; i++) {
            String id = UUID.randomUUID().toString();
            Ingresso ingresso = new Ingresso(id, Ingresso.Tipo.NORMAL, Ingresso.Status.DISPONIVEL);
            ingressos.put(id, ingresso);
        }
    }

    // Método auxiliar para contar ingressos por tipo
    public int countIngressosByType(HashMap<String, Ingresso> ingressos, Ingresso.Tipo tipo) {
        return (int) ingressos.values().stream().filter(ingresso -> ingresso.getTipo() == tipo).count();
    }

    public String getId() {
        return id;
    }

    public int getQuantDeIngressos() {
        return this.quantDeIngressos;
    }

    public HashMap getIngressos() {
        return ingressos;
    }

    public int getPerCentVIP() {
        return perCentVIP;
    }

    public int getPerCentDesconto() {
        return perCentDesconto;
    }
}
