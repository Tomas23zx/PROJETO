package poo;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String[][] matriz; 
    private Unidades un;
    private Civilizacao civi;
    private Mapa mapa; 

    
    public Menu(String[][] matriz, Mapa mapa,Civilizacao civi) {
        if (matriz == null) {
            throw new IllegalArgumentException("A matriz do mapa não pode ser nula.");
        }
        this.matriz = matriz;
        this.mapa = mapa;
        this.civi=civi;
    }

public void menCiv() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma civilização:");
            System.out.println("1. Bárbaros");
            System.out.println("2. Romanos");
            System.out.println("3. Persas");
            System.out.println("4. Espartanos");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("Você escolheu Bárbaros.");
                    continuar = false;
                }
                case 2 -> {
                    System.out.println("Você escolheu Romanos.");
                    continuar = false;
                }
                case 3 -> {
                    System.out.println("Você escolheu Persas.");
                    continuar = false;
                }
                case 4 -> {
                    System.out.println("Você escolheu Espartanos.");
                    continuar = false;
                }
                case 5 -> {
                    System.out.println("Saindo do programa. Até mais!");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
    }
    public void menus(Civilizacao civi) {
        boolean continuar = true;
    
        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Mover uma unidade");
            System.out.println("2. Ainda não sei: ");
            System.out.println("3. Funcionalidades");
            System.out.println("4. Ver o mapa");
            System.out.println("5. Criar unidades");
            System.out.println("6. Exibir informações da cidade");
            System.out.println("7. Exibir informações da civilização");
            System.out.println("8. Sair");
    
            int opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1 -> System.out.println("Você escolheu Mover uma unidade");
                case 2 -> System.out.println("Você escolheu Ainda não sei");
                case 3 -> System.out.println("Você escolheu Funcionalidades");
                case 4 -> mapa.imprimirMapa();
                case 5 -> System.out.println("Você escolheu Criar unidades");
                case 6 -> System.out.println("Você escolheu Exibir informações da cidade");
                case 7 -> {
                    System.out.println("Informações da Civilização:");
                    System.out.println(civi.toString()); 
                }
                case 8 -> {
                    System.out.println("Saindo do programa. Até mais!");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
    }
    
    

public void Interface() {
        int comidaInicial = 50;
        int comidaMax = 150;
        int populacao = 0;
        int gemas = 0;
        int tesouros = 0;
        int dia = 0;
        int energia = 0;

        System.out.println("Total das civilizações: ");
        System.out.println("    Comida: " + comidaInicial + " / " + comidaMax);
        System.out.println("    População: " + populacao);
        System.out.println("    Gemas: " + gemas);
        System.out.println("    Tesouro: " + tesouros + " (cada 5 gemas 1 tesouro)");

        System.out.println("                               N");
        System.out.println("                             //\\");
        System.out.println("                            E< >W");
        System.out.println("                             \\//");
        System.out.println("                               S");

        System.out.println("DIA " + dia + " (turno)");
        System.out.print("Energia: [");
        for (int i = 0; i < energia; i++) {
            System.out.print("/");
        }
        for (int i = energia; i < 5; i++) {
            System.out.print("\\");
        }
        System.out.println("]");
    }




}