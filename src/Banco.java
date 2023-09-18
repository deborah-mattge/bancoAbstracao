import java.util.ArrayList;

public class Banco implements  IImprimivel{
    private ArrayList<ContaBancaria> contas=new ArrayList<>();
    public void inserir(ContaBancaria conta){
        contas.add(conta);
    }
    public void remover(ContaBancaria conta){
        contas.remove(conta);
    }
    public ContaBancaria procurarConta(int numero){
        for (ContaBancaria c : contas){
            if(c.getNumero()==numero){
                return c;
            }else {
                return null;
            }
        }
        return null;
    }



    public String mostrarDados() {
       return c.
    }
}
