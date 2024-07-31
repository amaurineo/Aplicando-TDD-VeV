package sistemadeingressos;

import java.util.HashMap;
import java.util.UUID;

public class LoteIngresso {
    private final String id;
    private final int quantDeIngressos;
    private HashMap<String, Ingresso> ingressos;
    private final int perCentVIP;
    private final int perCentDesconto;

    public LoteIngresso(String id, int quantDeIngressos, int perCentVIP, int perCentDesconto) {
        this.id = id;
        this.quantDeIngressos = quantDeIngressos;
        this.perCentVIP = perCentVIP;
        this.perCentDesconto = perCentDesconto;
        this.ingressos = new HashMap<String, Ingresso>();
        populaIngressos();
    }

    private void populaIngressos() {
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

    public void vendeLoteTodo() {
        for (Ingresso ingresso : ingressos.values()) {
            ingresso.setStatus(Ingresso.Status.VENDIDO);
        }
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
