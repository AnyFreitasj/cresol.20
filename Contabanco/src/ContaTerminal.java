import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        String agencia;
        int numero;
        String nomeCliente;
        double saldo;
        try (Scanner scanner = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println("===================================");
            System.out.println("======= Abertura de Conta =========");
            System.out.println("===================================");
            System.out.println("Por favor, digite o número da Agência:");
            agencia = scanner.nextLine();
            System.out.println("Por favor, digite o número da Conta:");
            numero = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Por favor, digite o seu Nome:");
            nomeCliente = scanner.nextLine();
            // Definindo o saldo inicial
            saldo = 2456.90;
            System.out.println("Saldo Inicial da sua conta: R$ " + saldo);
            boolean continuar = true;
            while (continuar) {
                System.out.println("===================================");
                System.out.println("======= Menu de Operações =========");
                System.out.println("===================================");
                System.out.println("Escolha a operação desejada:");
                System.out.println("1. Depósito");
                System.out.println("2. Saque");
                System.out.println("3. Sair");
                int escolha = scanner.nextInt();
                
                switch (escolha) {
                    case 1 -> {
                        System.out.println("Por favor, digite o valor que deseja depositar:");
                        double deposito = scanner.nextDouble();
                        saldo += deposito;
                        System.out.printf("Depósito realizado com sucesso. Saldo atual: R$ %.2f%n", saldo);
                    }
                    case 2 -> {
                        System.out.println("Por favor, digite o valor que deseja sacar:");
                        double saque = scanner.nextDouble();
                        if (saque > saldo) {
                            System.out.println("Saldo insuficiente para realizar o saque.");
                        } else {
                            saldo -= saque;
                            System.out.printf("Saque realizado com sucesso. Saldo atual: R$ %.2f%n", saldo);
                        }
                    }
                    case 3 -> {
                        continuar = false;
                        System.out.println("Operações finalizadas. Obrigado por usar nossos serviços.");
                    }
                    default -> System.out.println("Opção inválida. Por favor, escolha uma operação válida.");
                }
            }
        }

        System.out.println("===================================");
        System.out.println("======= Resumo da Conta ===========");
        System.out.println("===================================");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("Agência: " + agencia);
        System.out.println("Conta: " + numero);
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
        System.out.println("===================================");
    }
}
