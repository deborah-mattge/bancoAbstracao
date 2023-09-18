public class ContaCorrente extends  ContaBancaria implements IImprimivel{
    private double taxaDeOperação=3;
    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);

    }

    @Override
    public boolean sacar(double valor) {
        if(valor+taxaDeOperação>=this.getSaldo()){
            setSaldo(getSaldo()-(valor+taxaDeOperação));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
            setSaldo((getSaldo()-taxaDeOperação)+valor);
            return true;

    }


    @Override
    public String mostrarDados() {
         return "numero: "+this.getNumero()+" saldo: "+this.getSaldo();
    }

}

