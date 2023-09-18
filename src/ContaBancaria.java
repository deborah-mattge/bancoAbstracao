public abstract class ContaBancaria {
    private int numero;
    private double saldo;
    public ContaBancaria(int numero, double saldo){
        this.numero=numero;
        this.saldo=saldo;
    }
    public abstract boolean sacar(double valor);
    public abstract boolean depositar(double valor);

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public  boolean transferir(ContaBancaria conta, double valor){
        this.sacar(valor);
        conta.depositar(valor);
        return true;
    }

}
