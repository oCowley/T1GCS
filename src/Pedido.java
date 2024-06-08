import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    public enum Status {
        ABERTO, APROVADO, REPROVADO
    }

    private int id;
    private Funcionario solicitante;
    private Date dataPedido;
    private Date dataConclusao;
    private Status status;
    private List<Item> itens;
    private double valorTotal;

    public Pedido(int id, Funcionario solicitante) {
        this.id = id;
        this.solicitante = solicitante;
        this.dataPedido = new Date();
        this.status = Status.ABERTO;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getId() {
        return id;
    }

    public Funcionario getSolicitante() {
        return solicitante;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(Date dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        valorTotal += item.getTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public boolean podeSerAprovado() {
        return valorTotal <= solicitante.getDepartamento().getValorMaximoPorPedido();
    }
}