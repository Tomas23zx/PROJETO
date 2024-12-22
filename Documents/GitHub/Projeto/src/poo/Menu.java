package poo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String[][] matriz; 
    private Unidades un;
    private Civilizacao civi;
    private Mapa mapa; 

    
    public Menu(String[][] matriz, Mapa mapa,Civilizacao civi) {
        if (matriz == null) {
            throw new IllegalArgumentException("A matriz do mapa nao pode ser nula.");
        }
        this.matriz = matriz;
        this.mapa = mapa;
        this.civi=civi;
    }
//
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
    public void menus(Civilizacao civi,Mapa map) {
        boolean continuar = true;
    
        while (continuar) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Mover uma unidade");
            System.out.println("2. Alocar ");
            System.out.println("3. Funcionalidades");
            System.out.println("4. Ver o mapa");
            System.out.println("5. Criar unidades");
            System.out.println("6. Atacar uma cidade");
            System.out.println("7. Exibir informacoes da cidade");
            System.out.println("8. Exibir informacoes da civilizacao");
            System.out.println("9.Produzir");
            System.out.println("10.Atacar");
            System.out.println("11. Sair");
    
            int opcao = scanner.nextInt();
            
            
            switch (opcao) {
               
                case 1 -> menuMover(civi);
                case 2 -> alocarPopulacao(civi) ;
                case 3 -> menuFunciunalidades(civi,map);
                case 4 -> mapa.imprimirMapa();
                case 5 -> menuUnidades(civi,map);
                case 6 -> Atacar();
                case 7 -> exibircidade(civi);
                case 8 -> {
                    System.out.println("Informacoes da Civilizacao:");
                    System.out.println(civi.toString()); 
                }
                case 9 -> {
                    manutecao( civi,map);
                }
                case 10 ->{
                    atacares(civi,map);

                }
                case 11 ->{
                    System.out.println("Saindo do programa. Ate mais!");
                    continuar = false;
                }
                default -> System.out.println("Opcao invalida. Tente novamente.");
            }
            atualizarCidades(civi);
            System.out.println();
        }
    }
    
    
public void Atacar(){
        Cidade c = selecionarCidade(civi);
        Cidade atacada = selecionarCidade(civi);
        c.Atacar(atacada);
        exibircidade(civi);
}
public void atacares(Civilizacao civi, Mapa map) {
    // Seleciona uma cidade da civilização
    Cidade cityCidade = selecionarCidade(civi);
    if (cityCidade == null) {
        System.out.println("Cidade não encontrada ou opção inválida.");
        return;
    }
    
    // Seleciona uma unidade da cidade escolhida
    Unidades un = selecionarUnidade(cityCidade);
    if (un == null) {
        System.out.println("Unidade não encontrada ou opção inválida.");
        return;
    }
    
    // Verifica se a unidade selecionada é do tipo Militar
    if (un instanceof Militares) {
        Militares unidadeMilitar = (Militares) un;  // Faz o casting para Militares
        
        // Verifica se há unidades inimigas ao redor da unidade selecionada
        Unidades unidadesAoRedor = unidadeMilitar.verificarInimigoAoRedorDeTodasAsUnidades(unidadeMilitar,map);
        
        if (unidadesAoRedor != null) {
            System.out.println("Unidades inimigas detectadas ao redor.");
            System.out.println("Unidade inimiga encontrada: " + unidadesAoRedor.getCodigo());
            // Chama a funcionalidade da unidade (no caso, ataque)
            unidadeMilitar.funcionalidade(civi);
        } else {
            System.out.println("Nenhuma unidade inimiga detectada ao redor.");
        }
    } else {
        System.out.println("A unidade selecionada não é militar.");
    }
}



public void Interface(Civilizacao civi) {
    int comidaMax = 150;
    int populacao = 0;
    int gemas = 0;
    int tesouros = 0;
    int dia = 0;
    int energia = 3; 

    Recursos tipoComida = new Comida(0, 0, 0); 
    Recursos tipoOuro = new Ouro(0);           
    
    int totalComida = civi.Total_Recurssos(tipoComida, civi);
    int totalOuro = civi.Total_Recurssos(tipoOuro, civi);

    
    System.out.println("Total das civilizacoes: ");
    System.out.println("    Comida: " + totalComida + " / " + comidaMax);
    System.out.println("    Populacao: " + populacao);
    System.out.println("    Ouro " + totalOuro);
    System.out.println("    Tesouro: " + tesouros + " (cada 5 gemas 1 tesouro)");
    
   
    System.out.println("                               N");
    System.out.println("                              /|\\");
    System.out.println("                             / | \\");
    System.out.println("                            /  |  \\");
    System.out.println("                           W---+---E");
    System.out.println("                            \\  |  /");
    System.out.println("                             \\ | /");
    System.out.println("                               \\|/");
    System.out.println("                                S");

    
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


    public void menuMover(Civilizacao civi) {

        Cidade cidadeEscolhida = selecionarCidade(civi);
        if (cidadeEscolhida == null) {
            System.out.println("Operação cancelada. Nenhuma cidade foi selecionada.");
            return;
        }
    
        Unidades unidadeEscolhida = selecionarUnidade(cidadeEscolhida);
        if (unidadeEscolhida == null) {
            System.out.println("Operação cancelada ou unidade não encontrada.");
            return;
        }
    
        System.out.print("Digite a direção para mover a unidade (N, S, E, O): ");
        char direcao = scanner.next().toUpperCase().charAt(0);
    
        System.out.print("Digite o número de casas que deseja mover: ");
        int numCasas;
        try {
            numCasas = scanner.nextInt();
            if (numCasas <= 0) {
                System.out.println("O número de casas deve ser maior que zero.");
                return;
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de digitar um número inteiro.");
            scanner.next(); 
            return;
        }
    
        int linhaAnterior = unidadeEscolhida.getLinha();
        int colunaAnterior = unidadeEscolhida.getColuna();
    
        for (int i = 0; i < numCasas; i++) {
            unidadeEscolhida.mover(direcao, mapa);
        }
    
        int novaLinha = unidadeEscolhida.getLinha();
        int novaColuna = unidadeEscolhida.getColuna();
    
        if (novaLinha != linhaAnterior || novaColuna != colunaAnterior) {
            System.out.println("Unidade movida com sucesso para a posição: (" + novaLinha + ", " + novaColuna + ").");
            mapa.moverUnidade(unidadeEscolhida, novaLinha, novaColuna);
        } else {
            System.out.println("Movimento inválido. A unidade permaneceu na posição original.");
        }
    }
    
    
    private Unidades selecionarUnidade(Cidade cidade) {
        System.out.println("Unidades disponíveis na cidade:");
        cidade.listarDetalhesUnidades(); 
    
        System.out.print("Digite o código da unidade que deseja selecionar: ");
        String codigoUnidade = scanner.next();
    
        Unidades unidadeEscolhida = cidade.buscarUnidadePorCodigo(codigoUnidade);
        if (unidadeEscolhida == null) {
            System.out.println("Unidade com o código especificado não foi encontrada na cidade.");
            return null;
        }
    
        return unidadeEscolhida;
    }
    
  public void exibircidade(Civilizacao civi){
    Cidade c = selecionarCidade(civi);
    c.getRecursos();
    
  }
  
public void atualizarCidades(Civilizacao civi){
ArrayList<Cidade> cidades = civi.getCidades();
    for (int i = 0; i < cidades.size(); i++) {
        Recursos ouro = cidades.get(i).findRecurso(new Ouro(0));
        Recursos comida = cidades.get(i).findRecurso(new Comida(0,0,0));
        Recursos producao = cidades.get(i).findRecurso(new Producao(0));
        Random random = new Random();
        
        //Atualizar Ouro
        int somaousub = random.nextInt(2);
        int qnt=ouro.getQuantidade();
        int novoouro = random.nextInt(50);
        if(somaousub==1){
            ouro.adicionar(novoouro);
        }
        else{ if(ouro.getQuantidade()>50){
            ouro.consumir(novoouro);
        }}
        
        
        
        int somaousub1 = random.nextInt(2);
        int qntC=comida.getQuantidade();
        int novacomida = random.nextInt(50);
        if(somaousub1==1){
            comida.adicionar(novacomida);
        }
        else{ if(comida.getQuantidade()>50){
            comida.consumir(novacomida);
        }}
        
        
       
        
        
    }
}

public Cidade selecionarCidade(Civilizacao civi) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("===== Selecionar Cidade =====");
    System.out.println("Civilizacao: " + civi.getNome());
    System.out.println("Cidades disponiveis:");

    ArrayList<Cidade> cidades = civi.getCidades();
    for (int i = 0; i < cidades.size(); i++) {
        Cidade cidade = cidades.get(i);
        System.out.print(i + " - " + cidade.getCodigo() + " (" + cidade.getPosX() + "," + cidade.getPosY() + ") ");
        
        // Acessar e exibir os recursos da cidade
        Recursos producao = cidade.findRecurso(new Producao(0));
        Recursos comida = cidade.findRecurso(new Comida(0, 0, 0));
        Recursos ouro = cidade.findRecurso(new Ouro(0));

        // Exibindo os pontos de produção, comida e ouro
        if (producao != null) {
            System.out.print("Produção: " + producao.getQuantidade() + " ");
        }
        if (comida != null) {
            System.out.print("Comida: " + comida.getQuantidade() + " ");
        }
        if (ouro != null) {
            System.out.print("Ouro: " + ouro.getQuantidade() + " ");
        }
        System.out.println();  // Nova linha para separar as cidades
    }

    if (cidades.isEmpty()) {
        System.out.println("Nenhuma cidade disponivel.");
        return null;
    }

    // Entrada para selecionar a cidade
    System.out.print("Escolha o indice da cidade: ");
    int indiceCidade;
    try {
        indiceCidade = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Entrada invalida! Por favor, insira um numero.");
        return null;
    }

    if (indiceCidade < 0 || indiceCidade >= cidades.size()) {
        System.out.println("Indice invalido.");
        return null;
    }

    Cidade cidadeEscolhida = cidades.get(indiceCidade);
    System.out.println("Você escolheu a cidade: " + cidadeEscolhida.getCodigo());
    return cidadeEscolhida;
}

public void menuUnidades(Civilizacao civi,Mapa mapa) {
    // Selecionar a cidade escolhida pelo jogador
    Cidade cidadeEscolhida = selecionarCidade(civi);  
    if (cidadeEscolhida == null) {
        return;  // Se a cidade for null (não há cidades disponíveis), termina o método
    }

    System.out.println("Escolha uma unidade para criar:");
    System.out.println("1. Militar");
    System.out.println("2. Construtor");
    System.out.println("3. Colono");
    int tipoUnidade = scanner.nextInt();

    Unidades unidadeCriada;

    
    Recursos producao = cidadeEscolhida.findRecurso(new Producao(0));

    
    if (producao != null && producao.getQuantidade() >= 5) {
        
        cidadeEscolhida.consumirRecurso(new Producao(0), 5);
        System.out.println("5 pontos de produção foram retirados.");

        
        switch (tipoUnidade) {
            case 1:
            Random random = new Random();
            int numeroAleatorio = random.nextInt(41);  
            
            
            unidadeCriada = new Militares("M",mapa, civi.getId(),100, numeroAleatorio);
                break;
            case 2:
                unidadeCriada = new Construtor("H", mapa,civi.getId(),100);
                break;
            case 3:
                unidadeCriada = new Colono("E", mapa,civi.getId(),100);
                break;
            default:
                System.out.println("Tipo de unidade inválido!");
                return;
        }

        
        int posX = cidadeEscolhida.getPosX();
        int posY = cidadeEscolhida.getPosY();

        // Inserindo a unidade na cidade e no mapa
        cidadeEscolhida.insereUnidade(unidadeCriada);
        //mapa.adicionarUnidades(unidadeCriada);
        mapa.meterUnidade(unidadeCriada, posX + 1, posY + 1);
        System.out.println(""+mapa.getUnidades(0).getCodigo());
        ;

        // Informando que a unidade foi criada e posicionada
        System.out.println("Unidade criada e posicionada no mapa na cidade " + cidadeEscolhida.getCodigo());
    } else {
        // Caso não haja produção suficiente
        System.out.println("Não há produção suficiente para criar a unidade. Produção necessária: 5 pontos.");
    }
}


public void menuFunciunalidades(Civilizacao civi,Mapa map){
    Cidade cidadeEscolhida=selecionarCidade(civi);
    Unidades un=selecionarUnidade( cidadeEscolhida);
    un.funcionalidade(civi);
    if(un instanceof Colono && map.podeConstruirCidade(civi,un.getLinha(),un.getColuna())){
        cidadeEscolhida.removerUnidade(un);
    }

}



public void alocarPopulacao(Civilizacao civi) {
    Scanner scanner = new Scanner(System.in);
    Cidade cidadescolhida = selecionarCidade(civi);
    List<int[]> posicoesAlocadas = new ArrayList<>();
    int cidadeX = cidadescolhida.getPosX();
    int cidadeY = cidadescolhida.getPosY();
    int populacaoInicial = cidadescolhida.getPopulacao();
    int raio = populacaoInicial + 1;
    List<int[]> posicoesDisponiveis = new ArrayList<>();

    // Determinar as posições disponíveis no raio da cidade
    for (int i = Math.max(0, cidadeX - raio); i <= Math.min(mapa.getMapa().length - 1, cidadeX + raio); i++) {
        for (int j = Math.max(0, cidadeY - raio); j <= Math.min(mapa.getMapa()[0].length - 1, cidadeY + raio); j++) {
            int distancia = Math.abs(i - cidadeX) + Math.abs(j - cidadeY);
            if (distancia <= raio) { 
                posicoesDisponiveis.add(new int[]{i, j});
            }
        }
    }

    System.out.println("Posições disponíveis para alocar população:");
    for (int i = 0; i < posicoesDisponiveis.size(); i++) {
        int[] pos = posicoesDisponiveis.get(i);
        System.out.println(i + ": (" + pos[0] + ", " + pos[1] + ")");
    }

    // Perguntar ao utilizador quantas pessoas ele quer alocar
    int pessoasParaAlocar;
    do {
        System.out.print("Digite o número de pessoas que deseja alocar (máximo " + populacaoInicial + "): ");
        pessoasParaAlocar = scanner.nextInt();
        if (pessoasParaAlocar > populacaoInicial || pessoasParaAlocar < 1) {
            System.out.println("Número inválido. Tente novamente.");
        }
    } while (pessoasParaAlocar > populacaoInicial || pessoasParaAlocar < 1);

    // Perguntar ao utilizador onde ele quer alocar as pessoas
    for (int i = 0; i < pessoasParaAlocar; i++) {
        int posicaoEscolhida;
        do {
            System.out.print("Escolha o índice da posição para alocar a pessoa " + (i + 1) + ": ");
            posicaoEscolhida = scanner.nextInt();
            if (posicaoEscolhida < 0 || posicaoEscolhida >= posicoesDisponiveis.size()) {
                System.out.println("Índice inválido. Tente novamente.");
            }
        } while (posicaoEscolhida < 0 || posicaoEscolhida >= posicoesDisponiveis.size());

        // Alocar a pessoa na posição escolhida
        int[] posicao = posicoesDisponiveis.get(posicaoEscolhida);
        int posX = posicao[0];
        int posY = posicao[1];

        Populacao novaPopulacao = new Populacao(posX, posY);
        cidadescolhida.meterPessoas(novaPopulacao);
        posicoesAlocadas.add(posicao);

        System.out.println("Pessoa alocada na posição: (" + posX + ", " + posY + ")");
    }

    System.out.println("Alocação concluída. Total de pessoas alocadas: " + posicoesAlocadas.size());
}

public void manutencaoPopulacao(Cidade cidade, Mapa mapa) {
    
    if (cidade.getPopulacoes().isEmpty()) {
        System.out.println("A cidade " + cidade.getCodigo() + " não tem população alocada.");
        return; 
    }

    String[][] mapaArray = mapa.getMapa(); 

    for (Populacao populacao : cidade.getPopulacoes()) {
        int posX = populacao.getPox();
        int posY = populacao.getPoy();

       
        if (posX >= 0 && posX < mapaArray.length && posY >= 0 && posY < mapaArray[0].length) {
            
            String letraMapa = mapaArray[posX][posY];

            
            populacao.letraAtribuida(cidade, letraMapa);
        } else {
            System.out.println("Posição fora dos limites do mapa: (" + posX + ", " + posY + ")");
        }
    }
}



public void manutecao(Civilizacao civi,Mapa mapa){
    Cidade city = selecionarCidade(civi);
    manutencaoPopulacao(city,mapa);
}



}