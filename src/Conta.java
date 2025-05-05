public abstract class Conta implements  IConta {
    //neste ponto foi feita melhorias tirando o statis, criando uma variável de instância
    private static int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;

    //atributos
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia  = AGENCIA_PADRAO;

        this.cliente = cliente;

        this.numero = SEQUENCIAL++;

    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo = saldo - valor;
            System.out.println("Saque realizado com sucesso. Valor sacado: " + valor);
        } else {
            System.out.println("Saldo insuficiente para realizar o saque.");
        }

    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            saldo = saldo + valor;
            System.out.println("Deposito realizado com sucesso. Valor depositado " + valor);
        } else {
            System.out.println("Valor inválido para depósito");
        }
    }

    @Override
    public void transferir(double valor, IConta contadestino) {
        this.sacar(valor);
        contadestino.depositar(valor);

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

    //usado nas class filhas
    protected void imprimirInfoComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome() + " - CPF: " + cliente.getCpf()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }



}
