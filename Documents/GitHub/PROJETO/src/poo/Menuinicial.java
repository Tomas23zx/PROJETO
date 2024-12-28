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
        
        System.out.println("   Escolha uma civilizacao:");
        System.out.println("    1. Barbaros");
        System.out.println("    2. Romanos");
        System.out.println("    3. Persas");
        System.out.println("    4. Espartanos");
        System.out.println("    5. Customizado");
        System.out.print("->");
       Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1 -> {
                escolha = "Barbaros";
                System.out.println("");
                System.out.println("Escolheste Barbaros.");
                continuar = false;
            }
            case 2 -> {
                escolha = "Romanos";
                System.out.println("");
                System.out.println("Escolheste Romanos.");
                continuar = false;
            }
            case 3 -> {
                escolha = "Persas";
                System.out.println("");
                System.out.println("Escolheste Persas.");
                continuar = false;
            }
            case 4 -> {
                escolha = "Espartanos";
                System.out.println("");
                System.out.println("Escolheste Espartanos.");
                continuar = false;
            }
            case 5 -> {
                System.out.println("");
                System.out.println("Da o nome a tua civilizacao:");
                System.out.print("->");
                escolha = scanner.next();
                continuar = false;
            }
            default -> System.out.println("Opcao invalida. Tente novamente.");
        }
        System.out.println();
    }

    return escolha;
}

}
