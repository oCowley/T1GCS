public class Departamento {
    private String nome;
    private double valorMaximoPorPedido;

    public Departamento(String nome, double valorMaximoPorPedido) {
        this.nome = nome;
        this.valorMaximoPorPedido = valorMaximoPorPedido;
    }

    public String getNome() {
        return nome;
    }

    public double getValorMaximoPorPedido() {
        return valorMaximoPorPedido;
    }
}
