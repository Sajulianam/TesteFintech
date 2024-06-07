import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private String nome;
    private double rendaAnual;
    private String numeroConta;

    public Cliente(String nome, double rendaAnual, String numeroConta) {
        this.nome = nome;
        this.rendaAnual = rendaAnual;
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public double getRendaAnual() {
        return rendaAnual;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String toString() {
        return "Nome: " + nome + ", Número da Conta: " + numeroConta + ", Renda Anual: " + rendaAnual + (rendaAnual > 400000 ? " *" : "");
    }
}

public class Fintech {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int numeroConta = 1001; // Número inicial da conta bancária

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Ver Clientes");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarCliente(scanner);
                    break;
                case 2:
                    verClientes();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a renda anual do cliente: ");
        double rendaAnual = scanner.nextDouble();
        scanner.nextLine(); // Limpa o buffer do scanner

        String numeroConta = "CB" + numeroConta; // Gera o número da conta bancária
        clientes.add(new Cliente(nome, rendaAnual, numeroConta));

        System.out.println("Cliente cadastrado com sucesso! Número da conta: " + numeroConta);

        numeroConta++; // Incrementa o número da conta para o próximo cliente
    }

    private static void verClientes() {
        System.out.println("\nClientes Cadastrados:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }
}
