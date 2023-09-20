public class ContaCorrente extends  ContaBancaria {
    private double taxaDeOperação=3;
    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);

    }

    @Override
    public boolean sacar(double valor) {
        taxaDeOperação=valor/100*taxaDeOperação;
        if(valor<this.getSaldo()-taxaDeOperação){
            setSaldo(getSaldo()-(valor+taxaDeOperação));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean depositar(double valor) {
        taxaDeOperação=valor/100*taxaDeOperação;
            setSaldo((getSaldo()-taxaDeOperação)+valor);
            return true;

    }


    @Override
    public String mostrarDados() {
         return "numero: "+this.getNumero()+" saldo: "+this.getSaldo();
    }

}

