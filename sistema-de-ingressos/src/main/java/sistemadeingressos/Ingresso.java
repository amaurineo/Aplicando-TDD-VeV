package sistemadeingressos;

public class Ingresso {
    private String nomeEvento;
    private double preco;

    public Ingresso(String nomeEvento, double preco) {
        this.nomeEvento = nomeEvento;
        this.preco = preco;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public double getPreco() {
        return preco;
    }
}
