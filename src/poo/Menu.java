package poo;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String[][] matriz; 
    private Unidades un;
    private Cidade city;
    private Mapa mapa; 

    
    public Menu(String[][] matriz, Mapa mapa,Cidade city) {
        if (matriz == null) {
            throw new IllegalArgumentException("A matriz do mapa não pode ser nula.");
        }
        this.matriz = matriz;
        this.mapa = mapa;
        this.city=city;
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

    public void menus(Cidade city) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Mover uma unidade");
            System.out.println("2. Atacar com uma unidade");
            System.out.println("3. Construir ou melhorar um edifício na cidade");
            System.out.println("4. Ver o mapa");
            System.out.println("5.Criar unidades");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    un.mover('O');
                    mapa.meterUnidade(un, un.getLinha(), un.getColuna());
                }
                case 2 ->  System.out.println("Você escolheu Atacar");
                case 3 -> System.out.println("Você escolheu construir ou melhorar um edifício na cidade.");
                case 4 -> mapa.imprimirMapa(); 
                case 5 -> menuUnidades();
                case 6 -> {
                    System.out.println("Saindo do programa. Até mais!");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
    }

    public void Interface() {
        int comida = 0;
        int comidaMax = 0;
        int populacao = 0;
        int gemas = 0;
        int tesouros = 0;
        int dia = 0;
        int energia = 0;

        System.out.println("Comida: " + comida + " / " + comidaMax);
        System.out.println("População: " + populacao);
        System.out.println("Gemas: " + gemas);
        System.out.println("Tesouro: " + tesouros + " (cada 5 gemas 1 tesouro)");

        System.out.println("   N");
        System.out.println("  //\\");
        System.out.println(" E< >W");
        System.out.println(" \\//");
        System.out.println("  S");

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

    public void menuUnidades() {
        System.out.println("1-Criar militares");
        int opcao = scanner.nextInt();
    
        un = new Militares("M");  
        int x = city.getPosX();
        int y = city.getPosY();
    
        
         
            switch (opcao) {
                case 1 -> mapa.meterUnidade(un, x+1, y+1);  
            }
       
    
        }
}
