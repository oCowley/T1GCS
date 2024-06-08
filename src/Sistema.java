import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    private List<Departamento> departamentos;
    private List<Funcionario> funcionarios;
    private List<Pedido> pedidos;
    private Funcionario usuarioAtual;

    public Sistema() {
        departamentos = new ArrayList<>();
        funcionarios = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public void inicializarDados() {

        departamentos.add(new Departamento("Financeiro", 5000.0));
        departamentos.add(new Departamento("RH", 3000.0));
        departamentos.add(new Departamento("Engenharia", 10000.0));
        departamentos.add(new Departamento("Manutenção", 4000.0));
        departamentos.add(new Departamento("Marketing", 6000.0));


        funcionarios.add(new Funcionario(1, "Alice", Funcionario.TipoFuncionario.EMPREGADO, departamentos.get(0)));
        funcionarios.add(new Funcionario(2, "Bob", Funcionario.TipoFuncionario.EMPREGADO, departamentos.get(1)));
        funcionarios.add(new Funcionario(3, "Charlie", Funcionario.TipoFuncionario.EMPREGADO, departamentos.get(2)));
        funcionarios.add(new Funcionario(4, "David", Funcionario.TipoFuncionario.EMPREGADO, departamentos.get(3)));
        funcionarios.add(new Funcionario(5, "Eve", Funcionario.TipoFuncionario.EMPREGADO, departamentos.get(4)));
        funcionarios.add(new Funcionario(6, "Frank", Funcionario.TipoFuncionario.ADMINISTRADOR, departamentos.get(0)));
        funcionarios.add(new Funcionario(7, "Grace", Funcionario.TipoFuncionario.ADMINISTRADOR, departamentos.get(1)));
       
        usuarioAtual = funcionarios.get(5);
    }

    public void executar() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n1. Listar Pedidos");
            System.out.println("2. Registrar Pedido");
            System.out.println("3. Alterar Usuário");
            System.out.println("4. Avaliar Pedidos (Admin)");
            System.out.println("5. Estatísticas (Admin)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    listarPedidos();
                    break;
                case 2:
                    registrarPedido(scanner);
                    break;
                case 3:
                    alterarUsuario(scanner);
                    break;
                case 4:
                    if (usuarioAtual.getTipo() == Funcionario.TipoFuncionario.ADMINISTRADOR) {
                        avaliarPedidos(scanner);
                    } else {
                        System.out.println("Apenas administradores podem avaliar pedidos.");
                    }
                    break;
                case 5:
                    if (usuarioAtual.getTipo() == Funcionario.TipoFuncionario.ADMINISTRADOR) {
                        exibirEstatisticas();
                    } else {
                        System.out.println("Apenas administradores podem ver estatísticas.");
                    }
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private void listarPedidos() {
        System.out.println("\nPedidos de Aquisição:");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.getId() + " - " + pedido.getSolicitante().getNome() + " - " + pedido.getStatus());
        }
    }

    private void registrarPedido(Scanner scanner) {
        Pedido pedido = new Pedido(pedidos.size() + 1, usuarioAtual);
        boolean adicionarItens = true;

        while (adicionarItens) {
            System.out.print("Descrição do Item: ");
            String descricao = scanner.nextLine();
            System.out.print("Valor Unitário: ");
            double valorUnitario = scanner.nextDouble();
            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine(); 

            pedido.adicionarItem(new Item(descricao, valorUnitario, quantidade));

            System.out.print("Deseja adicionar outro item? (s/n): ");
            adicionarItens = scanner.nextLine().equalsIgnoreCase("s");
        }

        if (pedido.podeSerAprovado()) {
            pedidos.add(pedido);
            System.out.println("Pedido registrado com sucesso!");
        } else {
            System.out.println("Valor total do pedido excede o limite do departamento.");
        }
    }

    private void alterarUsuario(Scanner scanner) {
        System.out.print("ID do novo usuário: ");
        int idUsuario = scanner.nextInt();
        scanner.nextLine(); 
        usuarioAtual = funcionarios.stream()
                           .filter(func -> func.getId() == idUsuario)
                           .findFirst()
                           .orElse(null);

        if (usuarioAtual != null) {
            System.out.println("Usuário alterado para: " + usuarioAtual.getNome());
        } else {
            System.out.println("Usuário não encontrado

}
