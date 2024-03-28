public class ContaCorrente extends Conta {
    
    public ContaCorrente(Cliente cliente, Cliente cpf){
        super(cliente, cpf);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("--- Extrato Conta Corrente ---");
        super.imprimirInformacoesConta();
    }

}
