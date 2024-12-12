package poo;

import java.util.Scanner;
import java.util.ArrayList;

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
                case 1 -> menuMover(civi);
                case 2 -> System.out.println("Você escolheu Ainda não sei");
                case 3 -> System.out.println("Você escolheu Funcionalidades");
                case 4 -> mapa.imprimirMapa();
                case 5 -> menuUnidades(civi);
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


public void menuMover(Civilizacao civi){
    
    
}

  public void menuUnidades(Civilizacao civi) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("===== Menu de Unidades =====");
    System.out.println("Civilização: " + civi.getNome());
    System.out.println("Cidades disponíveis:");

    
    ArrayList<Cidade> cidades = civi.getCidades();
    for (int i = 0; i < cidades.size(); i++) {
        System.out.println(i + " - " + cidades.get(i).getCodigo());
    }

    if (cidades.isEmpty()) {
        System.out.println("Nenhuma cidade disponível.");
        return;
    }

    
    System.out.print("Escolha o índice da cidade onde deseja criar unidades: ");
    int indiceCidade;
    try {
        indiceCidade = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Entrada inválida! Por favor, insira um número.");
        return;
    }

    if (indiceCidade < 0 || indiceCidade >= cidades.size()) {
        System.out.println("Índice inválido.");
        return;
    }

    Cidade cidadeEscolhida = cidades.get(indiceCidade);
    System.out.println("Você escolheu a cidade: " + cidadeEscolhida.getCodigo());

  
    System.out.println("Escolha uma unidade para criar:");
    System.out.println("1. Militar");
    System.out.println("2. Construtor");
    System.out.println("3. Colono");
    int tipoUnidade = scanner.nextInt();

    Unidades unidadeCriada;
    switch (tipoUnidade) {
        case 1 -> unidadeCriada = new Militares("M");
        case 2 -> unidadeCriada = new Construtor("H",mapa);
        case 3 -> unidadeCriada = new Colono("E",mapa);
        default -> {
            System.out.println("Tipo de unidade inválido!");
            return;
        }
    }

    
    cidadeEscolhida.insereUnidade(unidadeCriada);
    Recursos ouro= new Ouro(1);
    Recursos ouro1= new Ouro(2);
    cidadeEscolhida.adicionarRecurso(ouro,ouro.getQuantidade());
    cidadeEscolhida.adicionarRecurso(ouro1,ouro1.getQuantidade());
    System.out.println(cidadeEscolhida.getRecurso(ouro));
    

    
    int posX = cidadeEscolhida.getPosX();
    int posY = cidadeEscolhida.getPosY();

    mapa.meterUnidade(unidadeCriada, posX+1, posY+1);
    System.out.println("Unidade criada e posicionada no mapa na cidade " + cidadeEscolhida.getCodigo());
}


}