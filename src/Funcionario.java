public class Funcionario {
    public enum TipoFuncionario {
        EMPREGADO, ADMINISTRADOR
    }

    private int id;
    private String nome;
    private TipoFuncionario tipo;
    private Departamento departamento;

    public Funcionario(int id, String nome, TipoFuncionario tipo, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoFuncionario getTipo() {
        return tipo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
}
