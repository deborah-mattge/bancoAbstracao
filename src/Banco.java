import java.util.ArrayList;

public class Banco implements  IImprimivel{
    private ArrayList<ContaBancaria> contas=new ArrayList<>();
    public boolean inserir(ContaBancaria conta){
        contas.add(conta);
        return true;
    }
    public void remover(ContaBancaria conta){
        contas.remove(conta);
    }
    public ContaBancaria procurarConta(int numero){

        for (ContaBancaria c : contas){

            if(c.getNumero()==numero){
                return c;
            }
        }
        return null;
    }



    public String mostrarDados() {
        String todosString = "";
        for (ContaBancaria c : contas){
            if(c instanceof ContaCorrente){
                todosString+= " \n"+((ContaCorrente) c).mostrarDados();
            }else if(c instanceof ContaPoupanca){
                todosString+= " \n"+((ContaPoupanca) c).mostrarDados();
            }
        }
       return todosString;
    }
}
