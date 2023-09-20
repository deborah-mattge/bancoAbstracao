public class ContaPoupanca extends ContaBancaria {
    private double limite;
    public ContaPoupanca(int numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite=limite;

    }

    @Override
    public boolean sacar(double valor) {
        if(this.limite+this.getSaldo()>valor){
            this.setSaldo(this.getSaldo()-valor);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean depositar(double valor) {
        this.setSaldo(this.getSaldo()+valor);
        return true;

    }
    @Override
    public String mostrarDados() {
        return "numero: "+this.getNumero()+" saldo: "+this.getSaldo();
    }
}
