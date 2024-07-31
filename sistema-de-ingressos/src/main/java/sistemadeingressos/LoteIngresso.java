package sistemadeingressos;

import java.util.HashMap;

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
