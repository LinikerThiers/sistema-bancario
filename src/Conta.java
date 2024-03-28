public abstract class Conta implements IConta {
    
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Cliente cpf;

    public Conta(Cliente cliente, Cliente cpf) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.cpf = cpf;
    }

    @Override
    public void sacar (double valor) {

        if(saldo < valor) {
            System.out.println("Nao foi possivel realizar o saque. Saldo abaixo do valor de saque.");
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar (double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir (double valor, IConta contaDestino) {

        if (saldo >= valor) {
            sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferencia da conta corrente para a poupanca");

        } else {
            System.out.println("Saldo insuficiente para realizar a transferencia");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInformacoesConta() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("CPF Titular: %s", this.cpf.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }

}
