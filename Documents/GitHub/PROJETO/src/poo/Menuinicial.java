package poo;

import java.util.Scanner;

public class Menuinicial {


 public Menuinicial(){


 }   
/*
 * escolher qual nome de civilização quer usar
 */
 public String menCiv() {
    boolean continuar = true;
    String escolha = "";

    while (continuar) {
        System.out.println("Escolha uma civilização:");
        System.out.println("1. Bárbaros");
        System.out.println("2. Romanos");
        System.out.println("3. Persas");
        System.out.println("4. Espartanos");
        System.out.println("5. Sair");
       Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                escolha = "Bárbaros";
                System.out.println("Você escolheu Bárbaros.");
                continuar = false;
            }
            case 2 -> {
                escolha = "Romanos";
                System.out.println("Você escolheu Romanos.");
                continuar = false;
            }
            case 3 -> {
                escolha = "Persas";
                System.out.println("Você escolheu Persas.");
                continuar = false;
            }
            case 4 -> {
                escolha = "Espartanos";
                System.out.println("Você escolheu Espartanos.");
                continuar = false;
            }
            case 5 -> {
                System.out.println("Saindo do programa. Até mais!");
                escolha = "Sair";
                continuar = false;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
        System.out.println();
    }

    return escolha;
}

}
