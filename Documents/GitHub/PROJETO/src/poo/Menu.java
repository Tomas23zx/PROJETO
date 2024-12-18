package poo;

import java.util.ArrayList;
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
                    System.out.println("Voce escolheu Bárbaros.");
                    continuar = false;
                }
                case 2 -> {
                    System.out.println("Voce escolheu Romanos.");
                    continuar = false;
                }
                case 3 -> {
                    System.out.println("Voce escolheu Persas.");
                    continuar = false;
                }
                case 4 -> {
                    System.out.println("Voce escolheu Espartanos.");
                    continuar = false;
                }
                case 5 -> {
                    System.out.println("Saindo do programa. Ate mais!");
                    continuar = false;
                }
                default -> System.out.println("Opção invalida. Tente novamente.");
            }
            System.out.println();
        }
    }
    public void menus(Civilizacao civi,Mapa map) {
        boolean continuar = true;
    
        while (continuar) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Mover uma unidade");
            System.out.println("2. Produzir ");
            System.out.println("3. Funcionalidades");
            System.out.println("4. Ver o mapa");
            System.out.println("5. Criar unidades");
            System.out.println("6. Atacar uma cidade");
            System.out.println("7. Exibir informacoes da cidade");
            System.out.println("8. Exibir informacoes da civilizacao");
            System.out.println("9. Sair");
    
            int opcao = scanner.nextInt();
            //Atualizar recuros
            
            switch (opcao) {
                case 1 -> menuMover(civi);
                case 2 -> escolherProducao( civi,map) ;
                case 3 -> menuFunciunalidades(civi);
                case 4 -> mapa.imprimirMapa();
                case 5 -> menuUnidades(civi);
                case 6 -> Atacar();
                case 7 -> exibircidade(civi);
                case 8 -> {
                    System.out.println("Informacoes da Civilizacao:");
                    System.out.println(civi.toString()); 
                }
                case 9 -> {
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
public void Interface() {
        int comidaInicial = 50;
        int comidaMax = 150;
        int populacao = 0;
        int gemas = 0;
        int tesouros = 0;
        int dia = 0;
        int energia = 0;

        System.out.println("Total das civilizacoes: ");
        System.out.println("    Comida: " + comidaInicial + " / " + comidaMax);
        System.out.println("    Populacao: " + populacao);
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
    
       
        int linhaAnterior = unidadeEscolhida.getLinha();
        int colunaAnterior = unidadeEscolhida.getColuna();
        unidadeEscolhida.mover(direcao, mapa);
    
      
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
        
        
        //Atualizar Comida
        int somaousub1 = random.nextInt(2);
        int qntC=comida.getQuantidade();
        int novacomida = random.nextInt(50);
        if(somaousub1==1){
            comida.adicionar(novacomida);
        }
        else{ if(comida.getQuantidade()>50){
            comida.consumir(novacomida);
        }}
        
        
        //Atualizar Producao
        int somaousub2 = random.nextInt(2);
        int qntP=producao.getQuantidade();
        int novaproducao = random.nextInt(50);
        if(somaousub2==1){
            producao.adicionar(novaproducao);
        }
        else {
            if(producao.getQuantidade()>50){
                producao.consumir(novaproducao);
            }
        }
        
    }
}

public Cidade selecionarCidade(Civilizacao civi){
    Scanner scanner = new Scanner(System.in);

    System.out.println("===== Selecionar Cidade =====");
    System.out.println("Civilizacao: " + civi.getNome());
    System.out.println("Cidades disponiveis:");

    
    ArrayList<Cidade> cidades = civi.getCidades();
    for (int i = 0; i < cidades.size(); i++) {
        System.out.println(i + " - " + cidades.get(i).getCodigo() + "(" + cidades.get(i).getPosX() + "," + cidades.get(i).getPosY() + ")" );
    }

    if (cidades.isEmpty()) {
        System.out.println("Nenhuma cidade disponivel.");
        return null;
    }

    
    System.out.print("Escolha o indice da cidade : ");
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
    System.out.println("Voce escolheu a cidade: " + cidadeEscolhida.getCodigo());
      return cidadeEscolhida;
  }
  public void menuUnidades(Civilizacao civi) {
    
    Cidade cidadeEscolhida = selecionarCidade(civi);  
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
            System.out.println("Tipo de unidade invalido!");
            return;
        }
    }

    
    
    

    
    int posX = cidadeEscolhida.getPosX();
    int posY = cidadeEscolhida.getPosY();
    cidadeEscolhida.insereUnidade(unidadeCriada);
    mapa.meterUnidade(unidadeCriada, posX+1,posY+1);
    System.out.println("Unidade criada e posicionada no mapa na cidade " + cidadeEscolhida.getCodigo());
}

public void menuFunciunalidades(Civilizacao civi){
    Cidade cidadeEscolhida=selecionarCidade(civi);
    Unidades un=selecionarUnidade( cidadeEscolhida);
    un.funcionalidade(civi);
    if(un instanceof Colono){
        cidadeEscolhida.removerUnidade(un);
    }

}

public void escolherProducao(Civilizacao civi, Mapa mapa) {
    
    Cidade cidadeEscolhida = selecionarCidade(civi);
    if (cidadeEscolhida == null) {
        System.out.println("Nenhuma cidade selecionada.");
        return;
    }

    int populacaoDisponivel = cidadeEscolhida.getPopulacao();
    if (populacaoDisponivel <= 0) {
        System.out.println("A cidade não possui população disponível.");
        return;
    }

    System.out.println("Cidade selecionada: " + cidadeEscolhida.getCodigo());
    System.out.println("População disponível para alocação: " + populacaoDisponivel);

    int cidadeX = cidadeEscolhida.getPosX();
    int cidadeY = cidadeEscolhida.getPosY();

    
    List<int[]> posicoesDisponiveis = new ArrayList<>();
    int raio = populacaoDisponivel+1;

    for (int i = Math.max(0, cidadeX - raio); i <= Math.min(mapa.getMapa().length - 1, cidadeX + raio); i++) {
        for (int j = Math.max(0, cidadeY - raio); j <= Math.min(mapa.getMapa()[0].length - 1, cidadeY + raio); j++) {
            int distancia = Math.abs(i - cidadeX) + Math.abs(j - cidadeY);
            if (distancia <= raio && mapa.getMapa()[i][j].equals("X")) { 
                posicoesDisponiveis.add(new int[]{i, j});
            }
        }
    }

    if (posicoesDisponiveis.isEmpty()) {
        System.out.println("Nenhuma posição disponível para alocar a população.");
        return;
    }

   
    int numCidadaosAlocar;
    do {
        System.out.println("Quantos cidadãos deseja alocar? (Máximo: " + populacaoDisponivel + ")");
        numCidadaosAlocar = scanner.nextInt();
        if (numCidadaosAlocar < 1 || numCidadaosAlocar > populacaoDisponivel) {
            System.out.println("Número inválido. Tente novamente.");
        }
    } while (numCidadaosAlocar < 1 || numCidadaosAlocar > populacaoDisponivel);

  
    System.out.println("Posições disponíveis para alocação (dentro do raio de " + raio + "):");
    for (int i = 0; i < posicoesDisponiveis.size(); i++) {
        int[] posicao = posicoesDisponiveis.get(i);
        System.out.println(i + ". (" + posicao[0] + ", " + posicao[1] + ")");
    }

  
    List<int[]> posicoesAlocadas = new ArrayList<>();
    while (posicoesAlocadas.size() < numCidadaosAlocar) {
        System.out.println("Selecione uma posição para alocar um cidadão (Digite o índice):");
        int opcaoPosicao = scanner.nextInt();

        if (opcaoPosicao < 0 || opcaoPosicao >= posicoesDisponiveis.size()) {
            System.out.println("Opção inválida. Tente novamente.");
            continue;
        }

        int[] posicaoSelecionada = posicoesDisponiveis.get(opcaoPosicao);
        if (posicoesAlocadas.contains(posicaoSelecionada)) {
            System.out.println("Essa posição já está alocada. Escolha outra.");
            continue;
        }

        posicoesAlocadas.add(posicaoSelecionada);
        System.out.println("Cidadão alocado na posição: (" + posicaoSelecionada[0] + ", " + posicaoSelecionada[1] + ")");
    }


    for (int[] posicao : posicoesAlocadas) {
        int linha = posicao[0];
        int coluna = posicao[1];
        String tipoTerreno = mapa.getMapa()[linha][coluna];

        
        int comida = 0, ouro = 0, producao = 0;
        switch (tipoTerreno) {
            case "~": // Exemplo: Terreno fértil para comida
                comida = 5;
                break;
            case "X": // Exemplo: Montanha para ouro
                ouro = 10;
                break;
            case "F": // Exemplo: Floresta para produção
                producao = 3;
                break;
        }

        
        if (comida > 0) {
            cidadeEscolhida.adicionarRecurso(new Comida(0, 0, 0), comida);
        }
        if (ouro > 0) {
            cidadeEscolhida.adicionarRecurso(new Ouro(0), ouro);
        }
        if (producao > 0) {
            cidadeEscolhida.adicionarRecurso(new Producao(0), producao);
        }
    }

    System.out.println("Alocação concluída. Recursos totais da cidade foram atualizados:");
    cidadeEscolhida.getRecursos(); 
}









}