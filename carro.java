import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class carro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Cria um scanner para entrada de dados

        System.out.print("Quantidade de carros a cadastrar: ");
        int quantidadeCarros = scanner.nextInt();  // Solicita a quantidade de carros a cadastrar
        scanner.nextLine();  // Limpa o buffer

        List<String> infosCarros = new ArrayList<>();  // Cria uma lista para armazenar informações dos carros

        int totalImposto = 0;  // Inicializa o total de imposto a zero

        for (int i = 1; i <= quantidadeCarros; i++) {  // Loop para cadastrar os carros
            System.out.println("Cadastro do Carro #" + i);

            System.out.print("Ano atual: ");
            int anoAtual = scanner.nextInt();  // Solicita o ano atual do carro

            System.out.print("Modelo: ");
            String modelo = scanner.next();  // Solicita o modelo do carro

            System.out.print("Placa: ");
            String placa = scanner.next();  // Solicita a placa do carro

            System.out.print("Ano de fabricação: ");
            int anoFabricacao = scanner.nextInt();  // Solicita o ano de fabricação do carro

            int imposto = calcularImposto(anoAtual, anoFabricacao);  // Calcula o imposto do carro

            totalImposto += imposto;  // Atualiza o total de impostos

            // Adiciona as informações do carro à lista
            infosCarros.add("Imposto a ser pago para o carro " + placa + ": R$ " + imposto + " | Modelo: " + modelo);
        }

        scanner.close();  // Fecha o scanner após a entrada de dados

        for (String info : infosCarros) {  // Loop para exibir as informações de cada carro
            System.out.println(info);
        }

        System.out.println("Total de imposto de todos os carros: R$ " + totalImposto);  // Exibe o total de impostos dos carros
    }

    // Método para calcular o imposto com base no ano atual e de fabricação
    private static int calcularImposto(int anoAtual, int anoFabricacao) {
        int anosDeUso = anoAtual - anoFabricacao + 1;  // Calcula os anos de uso do carro
        int imposto;

        if (anosDeUso <= 10) {  // Verifica se o carro tem até 10 anos de uso
            imposto = 500 - (anosDeUso - 1) * 100;  // Calcula o imposto com base nos anos de uso
            imposto = Math.max(imposto, 100);  // Garante que o imposto não seja menor que 100
        } else {
            imposto = 0;  // Define o imposto como zero para carros com mais de 10 anos de uso
        }

        return imposto;  // Retorna o valor do imposto calculado
    }
}
