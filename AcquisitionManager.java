import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AcquisitionManager {
    private List<Acquisition> acquisitions;
    private Operator currentOperator;

    public AcquisitionManager() {
        acquisitions = new ArrayList<>();
    }

    public void initializeData() {
        acquisitions.add(new Acquisition("Laptop", 1500.0, 10));
        acquisitions.add(new Acquisition("Mouse", 25.0, 50));
        currentOperator = new Operator("John Doe", "JD");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Listar Aquisições");
            System.out.println("2. Adicionar Aquisição");
            System.out.println("3. Alterar Operador");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (choice) {
                case 1:
                    listAcquisitions();
                    break;
                case 2:
                    addAcquisition(scanner);
                    break;
                case 3:
                    changeOperator(scanner);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    private void listAcquisitions() {
        System.out.println("Aquisições:");
        for (Acquisition acq : acquisitions) {
            System.out.println(acq);
        }
    }

    private void addAcquisition(Scanner scanner) {
        System.out.print("Item: ");
        String item = scanner.nextLine();
        System.out.print("Preço: ");
        double price = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        acquisitions.add(new Acquisition(item, price, quantity));
    }

    private void changeOperator(Scanner scanner) {
        System.out.print("Nome do Operador: ");
        String name = scanner.nextLine();
        System.out.print("Iniciais: ");
        String initials = scanner.nextLine();
        currentOperator.setName(name);
        currentOperator.setInitials(initials);
    }
}
