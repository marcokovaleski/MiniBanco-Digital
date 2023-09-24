import java.util.ArrayList;
import java.util.Scanner;

public class FuncoesBanco {
    public static void consultarSaldo(Contas conta) {
        double salario = conta.getSaldo();
        String salarioFormatado = String.format("%.2f", salario);
        System.out.println("Saldo: R$" + salarioFormatado);
    }

    public static void creditarConta(Scanner scanner, Contas conta) {
        System.out.println("Valor a creditar:");
        double saldoCreditado = scanner.nextDouble();
        double saldoConta = conta.getSaldo();
        saldoCreditado += saldoConta;

        conta.setSaldo(saldoCreditado);
        System.out.println("Saldo creditado com sucesso!");
    }

    public static void linhaDigitavel(Scanner scanner, Contas conta) {
        System.out.println("Informe a linha digitável do boleto:");
        String linhaDigitavel = scanner.next();

        if (linhaDigitavel.length() >= 47 && linhaDigitavel.length() <= 48) {
            String dezUltimos = linhaDigitavel.substring(linhaDigitavel.length() - 10);

            try {
                double dezUltimosDouble = Double.parseDouble(dezUltimos);
                double valorBoleto = dezUltimosDouble / 100;
                conta.setValorBoleto(valorBoleto);
                String valorBoletoFormatado = String.format("%.2f", valorBoleto);
                System.out.println("Valor do boleto: R$" + valorBoletoFormatado);
            } catch (NumberFormatException e) {
                System.out.println("Boleto inválido!");
            }
        } else {
            System.out.println("Linha digitável inválida! Deve conter 47 ou 48 caracteres.");
        }
    }

    public static void pagarBoleto(Scanner scanner, Contas conta) {
        double saldoConta = conta.getSaldo();
        double valorBoleto = conta.getValorBoleto();

        if (valorBoleto > 0) {
            if (saldoConta >= valorBoleto) {
                saldoConta -= valorBoleto;
                System.out.println("Operção realizada com sucesso!");
                conta.setSaldo(saldoConta);
            } else {
                System.out.println("Saldo insuficiente!");
            }
        } else {
            System.out.println(("Nenhum boleto consultado!"));
        }

        conta.setValorBoleto(0);
    }

    public static void deposito(Scanner scanner, ArrayList<Contas> listaContas) {
        double valorDeposito;

        System.out.println("Digite o ID da conta que deseja realizar a transferência:");
        int idTransferencia = scanner.nextInt();

        Contas contaDeposito = null;

        for (Contas conta : listaContas) {
            if (conta.getId() == idTransferencia) {
                contaDeposito = conta;
                break;
            }
        }

        if (contaDeposito != null) {
            System.out.println("Digite o valor a ser depositado:");
            valorDeposito = scanner.nextDouble();

            double saldoConta = contaDeposito.getSaldo();
            saldoConta += valorDeposito;
            contaDeposito.setSaldo(saldoConta);

            System.out.println("Transferência realizada com sucesso!/n Saldo atual: R$" + saldoConta);
        } else {
            System.out.println("Conta com ID " + idTransferencia + " não encontrada!");
        }
    }
}