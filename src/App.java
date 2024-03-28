import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o seu nome: ");
        String nome = ler.nextLine();

        System.out.println("Digite seu CPF: ");
        String cpf = ler.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setCpf(cpf);

        Conta corrente = new ContaCorrente(cliente, cliente);
        Conta poupanca = new ContaPoupanca(cliente, cliente);

        System.out.println("\n");
        System.out.println("--- Contas criadas ---\n");
        corrente.imprimirExtrato();
        System.out.println("\n");
        poupanca.imprimirExtrato();

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nEscolha uma opção: ");
            System.out.println("1 - Sacar");
            System.out.println("2 - Transferir para Conta Poupanca");
            System.out.println("3 - Transferir para Conta Corrente");
            System.out.println("4 - Depositar");
            System.out.println("5 - Mostrar Extrato");
            System.out.println("6 - Sair");

            int opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor para sacar: ");
                    double valorSaque = ler.nextDouble();
                    corrente.sacar(valorSaque);
                    break;
                case 2:
                    System.out.println("Digite o valor para transferir para a Conta Poupanca: ");
                    double valorTransferenciaPoupanca = ler.nextDouble();
                    corrente.transferir(valorTransferenciaPoupanca, poupanca);
                    break;
                case 3:
                    System.out.println("Digite o valor para transferir para a Conta Corrente: ");
                    double valorTransferenciaCorrente = ler.nextDouble();
                    poupanca.transferir(valorTransferenciaCorrente, corrente);
                    break;
                case 4:
                    System.out.println("Digite o valor para depositar: ");
                    double valorDeposito = ler.nextDouble();
                    corrente.depositar(valorDeposito);
                    break;
                case 5:
                    corrente.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor escolha uma opcao valida ");
                    break;
            }

        }

        ler.close();

    }
}
