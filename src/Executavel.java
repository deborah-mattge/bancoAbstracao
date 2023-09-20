
import java.util.Scanner;

public class Executavel {
    static Banco banco = new Banco();
    static Scanner sc = new Scanner(System.in);
    static Relatorio relatorio =new Relatorio();
    public static void main(String[] args) {
        int opcao=0;
        do {
            System.out.println("""
                    MENU 
                    1- Criar conta
                    2- Selecionar conta
                    3- Remover conta
                    4- Gerar relatório
                    5- Finalizar
                    """);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                   selecionarConta();
                    break;
                case 3:
                   removerConta();
                    break;
                case 4:
                    gerarRelatorio();
                    break;
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("O numero escolhido é inválido!");
                    break;
            }
        } while (opcao!=5);
    }

    public static void criarConta() {
        int escolhaConta = 1;
        do {
            boolean retornoInserir = false;
            System.out.println("""
                    Qual conta deseja criar?
                    1- Conta Poupança
                    2- Conta Corrente 
                    3- Voltar
                    """);
            escolhaConta = sc.nextInt();


            switch (escolhaConta) {
                case 1,2:
                    System.out.println("Informe o numero da conta: ");
                    int numero = sc.nextInt();
                    if (escolhaConta==1){
                        System.out.println("Informe o limite: ");
                        double limite = sc.nextDouble();
                        ContaBancaria contaPoupanca = new ContaPoupanca(numero, 0, limite);
                        retornoInserir = banco.inserir(contaPoupanca);
                    } else {
                        ContaBancaria contaCorrente = new ContaCorrente(numero, 0);
                        retornoInserir = banco.inserir(contaCorrente);
                    }
                    break;
                case 3:
                    return;

                default:
                    System.out.println("O numero escolhido é inválido!");
                    break;
            }
            if (retornoInserir) {
                System.out.println("A conta foi inserida com sucesso!");
            }
        } while (escolhaConta != 3);


    }
    public static void selecionarConta(){
        int escolhaConta=1;
        System.out.println("Informe o numero da conta: ");
        int numero =sc.nextInt();
        do{
            ContaBancaria contaEncontrada =banco.procurarConta(numero);
            if(contaEncontrada!=null){
                System.out.println("""
                        1- Depositar
                        2- Sacar
                        3- Transferir 
                        4- Gerar Relatório 
                        5- Voltar 
                        """);
                escolhaConta=sc.nextInt();
                switch (escolhaConta){
                    case 1,2,3:
                        System.out.println("Informe o valor para a operação: ");
                        double valor=sc.nextDouble();
                        if (valor >0) {


                            if (escolhaConta == 1) {
                                contaEncontrada.depositar(valor);

                            } else if (escolhaConta == 2) {
                                contaEncontrada.sacar(valor);
                            } else {
                                System.out.println("Informe o numero da conta que deseja transferir: ");
                                int numeroTransferir = sc.nextInt();
                                ContaBancaria contaTranferir = banco.procurarConta(numeroTransferir);
                                System.out.println(contaTranferir);
                                contaEncontrada.transferir(contaTranferir, valor);
                            }
                        }else{
                            System.out.println("O valor precisa ser maior que zero");
                        }
                        break;
                    case 4:
                        System.out.println(relatorio.gerarRelatorio(contaEncontrada));
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("O numero escolhido é inválido!");
                        break;
                }
            }else{
                System.out.println("A conta é inexistente");
            }

        }while (escolhaConta!=5);
    }
    public static void removerConta(){
        System.out.println("Informe o numero da conta que deseja excluir: ");
        int numero =sc.nextInt();
        ContaBancaria contaEncontrada= banco.procurarConta(numero);
        if(contaEncontrada!= null){
            banco.remover(contaEncontrada);
            System.out.println("Conta removida com sucesso!");
        }else{
            System.out.println("Conta não encontrada");
        }
    }
    public static void gerarRelatorio(){
        System.out.println( relatorio.gerarRelatorio(banco));

    }

}
