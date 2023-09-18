public class Main {
    public static void main(String[] args) {
        ContaBancaria contaCorrente = new ContaCorrente(1, 0);
        ContaBancaria contaPoupanca = new ContaPoupanca(2, 0, 1000);
        Relatorio relatorio =new Relatorio();
        System.out.println(contaCorrente.depositar(100));
        System.out.println(contaPoupanca.depositar(100));
        System.out.println("conta corrente: " + contaCorrente.getSaldo());
        System.out.println("conta poupanca: " + contaPoupanca.getSaldo());
        System.out.println( contaCorrente.sacar(10));
        System.out.println(contaPoupanca.sacar(110));
        System.out.println("conta corrente: " + contaCorrente.getSaldo());
        System.out.println("conta poupanca: " + contaPoupanca.getSaldo());
        System.out.println(relatorio.gerarRelatorio(contaCorrente));
        System.out.println(relatorio.gerarRelatorio(contaPoupanca));
    }
}
