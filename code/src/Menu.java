import java.util.Scanner;
import java.util.ArrayList;

public class Menu {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int menuChoice = 0;

        while (menuChoice != 4) {

            System.out.println("[1] Login\n[2] Cadastro\n[3] Transferência\n[4] Sair");
            menuChoice = read.nextInt();
            read.nextLine();

            switch (menuChoice) {
                case 1:
                    realizarLogin(read);
                    break;

                case 2:
                    cadastrar(read);
                    break;

                case 3:
                    FuncoesBanco.deposito(read, listaContas);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    menuChoice = 4;
                    read.close();
                    break;

                default:
                    System.out.println("Opção invalida! Tente novamente.");
                    break;
            }
        }
    }

    private static ArrayList<Contas> listaContas = new ArrayList<>();

    private static int idContas = 1;
    private static double saldoMenu;
    private static double valorBoleto;

    public static void cadastrar(Scanner scanner) {
        System.out.println("Documento:");
        String docMenu = scanner.nextLine();

        System.out.println("Nome:");
        String nomeMenu = scanner.nextLine();

        System.out.println("Telefone:");
        String teleMenu = scanner.nextLine();

        System.out.println("E-mail:");
        String emailManu = scanner.nextLine();

        boolean senhaOk = false;

        while (!senhaOk) {
            System.out.println("Senha:");
            String senhaMenu = scanner.nextLine();
            System.out.println("Confirme sua senha:");
            String confirmeSenha = scanner.nextLine();

            if (senhaMenu.equals(confirmeSenha)) {
                senhaOk = true;
                Contas novaConta = new Contas(idContas++, docMenu, nomeMenu, teleMenu, emailManu, emailManu, saldoMenu,
                        valorBoleto);
                listaContas.add(novaConta);
                System.out.println("Conta criada com sucesso!");
            } else {
                System.out.println("Senhas não conferem! Tente novamente.");
            }
        }
    }

    public static void realizarLogin(Scanner scanner) {
        System.out.println("Documento:");
        String documento = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        for (Contas conta : listaContas) {
            if (conta.getDocumento().equals(documento) && conta.getSenha().equals(senha)) {
                System.out.println("Bem vindo, " + conta.getNome() + "!");
                int secondMenu = 0;

                while (secondMenu != 5) {
                    System.out.println(
                            "[1] Consultar saldo\n[2] Creditar conta\n[3] Consultar boleto\n[4] Pagar boleto\n[5] Sair");
                    secondMenu = scanner.nextInt();

                    switch (secondMenu) {
                        case 1:
                            FuncoesBanco.consultarSaldo(conta);
                            break;

                        case 2:
                            FuncoesBanco.creditarConta(scanner, conta);
                            break;

                        case 3:
                            FuncoesBanco.linhaDigitavel(scanner, conta);
                            break;

                        case 4:
                            FuncoesBanco.pagarBoleto(scanner, conta);
                            break;

                        case 5:
                            System.out.println("Saindo...");
                            secondMenu = 5;
                            break;
                            
                        default:
                            System.out.println("Opção invalida! Tente novamente.");
                            break;
                    }
                }
                break;
            } else {
                System.out.println("Documento ou senha incorretos! Tente novamente.");
            }
        }
    }
}