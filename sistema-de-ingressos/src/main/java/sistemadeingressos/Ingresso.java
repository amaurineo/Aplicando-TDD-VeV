package sistemadeingressos;

public class Ingresso {


    public enum Tipo { VIP, MEIA_ENTRADA, NORMAL }
    public enum Status { VENDIDO, DISPONIVEL }

    private final String id;
    private final Tipo tipo;
    private Status status;

    public Ingresso(String id, Tipo tipo, Status status){
        this.id=id;
        this.tipo = tipo;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }


}
