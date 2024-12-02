package poo;

import java.util.List;
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
            System.out.println("2. Ainda não sei: ");
            System.out.println("3. Funcionalidades");
            System.out.println("4. Ver o mapa");
            System.out.println("5. Criar unidades");
            System.out.println("6. Exibir informações da cidade"); 
            System.out.println("7. Sair");
    
            int opcao = scanner.nextInt();
    
            switch (opcao) {
                case 1 -> moverUnidade(city);
                case 2 -> System.out.println("Você escolheu Atacar");
                case 3 -> {
                     List<String> letrasUnidades = city.listarLetrasUnidades();
                System.out.println("Unidades disponíveis:");
                for (int i = 0; i < letrasUnidades.size(); i++) {
                    System.out.println((i + 1) + ". " + letrasUnidades.get(i));
                }
                System.out.println("Escolha a unidade que deseja usar (digite o número correspondente):");
                String escolha = scanner.next();
                funciunalidades(escolha);

                }
                case 4 -> mapa.imprimirMapa();
                case 5 -> menuUnidades();
                case 6 -> exibirInformacoesCidade(city); 
                case 7 -> {
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
        System.out.println("2-Criar Colonos");
        System.out.println("3-Criar Construtores");
        int opcao = scanner.nextInt();
    
        if (opcao == 1) {
            Unidades novaUnidade = new Militares("M");  
            int x = city.getPosX() + 1;  
            int y = city.getPosY() + 1;
    
            city.insereUnidade(novaUnidade);  
            mapa.meterUnidade(novaUnidade, x, y);  
            System.out.println("Unidade " + novaUnidade.getCodigo() + " criada em (" + x + ", " + y + ").");
        }
        if(opcao == 2){
            Unidades novoColon= new Colono("C",mapa);
            int x = city.getPosX() + 1;  
            int y = city.getPosY() + 1;
            city.insereUnidade(novoColon);
            mapa.meterUnidade(novoColon, x, y);  
            System.out.println("Unidade " + novoColon.getCodigo() + " criada em (" + x + ", " + y + ").");
            
            
        }
        if(opcao == 3){
            Unidades novaUnidade = new Construtor("H",mapa);  
            int x = city.getPosX() + 1;  
            int y = city.getPosY() + 1;
    
            city.insereUnidade(novaUnidade);  
            mapa.meterUnidade(novaUnidade, x, y);  
            System.out.println("Unidade " + novaUnidade.getCodigo() + " criada em (" + x + ", " + y + ").");
            
            
        }
        
        
        else {
            System.out.println("Opção inválida.");
        }
    }
    

        private void exibirInformacoesCidade(Cidade city) {
            System.out.println("Informações da Cidade:");
            System.out.println("Letra identificadora: " + city.getLetra());
            System.out.println("Posição X: " + city.getPosX());
            System.out.println("Posição Y: " + city.getPosY());
            System.out.println("Número de unidades na cidade: " + city.numdeUnid());
            System.out.println("Quantidade total de tropas: " + city.quantidade_por_unidade());
        }
        

private void moverUnidade(Cidade city) {
            List<String> codigosUnidades = city.listarCodigosUnidades(); 
        
            if (codigosUnidades.isEmpty()) {
                System.out.println("Não há unidades disponíveis para mover.");
                return;
            }
        
            System.out.println("Escolha a unidade que deseja mover:");
            for (int i = 0; i < codigosUnidades.size(); i++) {
                System.out.println((i + 1) + ". " + codigosUnidades.get(i));
            }      
            int escolha = scanner.nextInt();
            if (escolha < 1 || escolha > codigosUnidades.size()) {
                System.out.println("Escolha inválida. Tente novamente.");
                return;
            }
            String codigoEscolhido = codigosUnidades.get(escolha - 1);
            Unidades unidadeEscolhida = city.getUnidades().get(codigoEscolhido);
        
            System.out.println("Escolha a direção para mover (N, S, E, O):");
            char direcao = scanner.next().toUpperCase().charAt(0); 
            mapa.moverUnidade(unidadeEscolhida, direcao);
        
            System.out.println("Unidade " + codigoEscolhido + " movida para a nova posição: (" +
                               unidadeEscolhida.getLinha() + ", " + unidadeEscolhida.getColuna() + ").");
        }
        
        
        
        
        
public void funciunalidades(String escolha) {
    System.out.println("Escolha o código da unidade que você quer usar:");

   
    for (Unidades un : city.getUnidades().values()) {
        System.out.println("Código: " + un.getCodigo() + " - Letra: " + un.getLetra());
    }
    String codigoEscolhido = scanner.next();
    codigoEscolhido = codigoEscolhido.toUpperCase();
    boolean unidadeEncontrada = false;
    try {
        
        for (Unidades un : city.getUnidades().values()) {
            if (un.getCodigo().equals(codigoEscolhido)) {
                unidadeEncontrada = true;
                System.out.println("Executando funcionalidade para a unidade: " + un.getCodigo());
                un.funcionalidade();  
                break;
            }
        }
        if (!unidadeEncontrada) {
            throw new Exception("Unidade com o código " + codigoEscolhido + " não encontrada.");
        }
    } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
    }
}


}

        
        
        


