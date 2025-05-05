public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Flaviane Rodigues de Lima", "123.456.789-00");
        //cliente.setNome("Venilton");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.depositar(100);
        cc.transferir(50,poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}