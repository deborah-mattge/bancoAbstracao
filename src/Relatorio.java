public class Relatorio {
    public String gerarRelatorio(ContaBancaria conta){
        if(conta instanceof ContaCorrente){
            return ((ContaCorrente)conta).mostrarDados();
        }
        if(conta instanceof ContaPoupanca){
            return ((ContaPoupanca)conta).mostrarDados();
        }
        return null;
    }
}
