package poo;

import java.util.Random;

public class Mapa {
    private int tamanhoX;
    private int tamanhoY;
    private Cidade city;
    private String[][] mapa;

    public Mapa(int tamanhoX, int tamanhoY,Cidade city) {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.city=city;
        this.mapa = criarMapa();
    }

    private String[][] criarMapa() {
        String[][] mapa = new String[tamanhoX][tamanhoY];

        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = "X";
            }
        }

        Random random = new Random();
        Terrenos agua = new Agua();
        int tamanhoAgua = random.nextInt(25) + 20;
        preencherTerrenos(mapa, agua, tamanhoAgua);

        Terrenos arvore = new Arvore();
        int tamanhoFloresta = random.nextInt(50) + 30;
        preencherTerrenos(mapa, arvore, tamanhoFloresta);

        Cidade city = new Cidade("C", 15, 15);
        mapa[15][15] = city.getLetra(); 
    
        

        return mapa;
    }

    private void preencherTerrenos(String[][] mapa, Terrenos tipo, int quantidade) {
        Random random = new Random();
        int posX = random.nextInt(tamanhoX);
        int posY = random.nextInt(tamanhoY);
        mapa[posX][posY] = tipo.getLetra();

        for (int i = 1; i < quantidade; i++) {
            int novaPosX = posX;
            int novaPosY = posY;

            switch (random.nextInt(4)) {
                case 0 -> novaPosX = posX - 1;
                case 1 -> novaPosX = posX + 1;
                case 2 -> novaPosY = posY - 1;
                case 3 -> novaPosY = posY + 1;
            }

            if (novaPosX >= 0 && novaPosX < tamanhoX && novaPosY >= 0 && novaPosY < tamanhoY) {
                mapa[novaPosX][novaPosY] = tipo.getLetra();
                posX = novaPosX;
                posY = novaPosY;
            }
        }
    }

    public String[][] getMapa() {
        return this.mapa;
    }

    public void imprimirMapa() {
        for (String[] linha : mapa) {
            for (String celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }

    public void meterUnidade(Unidades un, int x, int y) {
        un.setColuna(y);
        un.setLinha(x);
        mapa[x][y] = un.getCodigo();
    }

    public void meterCidade(Cidade city, int x, int y) {
        city.setColuna(y);
        city.setLinha(x);
        mapa[x][y] = city.getLetra();
        
    }

    public int retornarPosi(){
        return city.getPosX();
        
    }
    public void moverUnidade(Unidades un, char direcao) {
        int linhaAtual = un.getLinha();
        int colunaAtual = un.getColuna();
    
        
        mapa[linhaAtual][colunaAtual] = "X";
    
        
        int novaLinha = linhaAtual;
        int novaColuna = colunaAtual;
    
        switch (direcao) {
            case 'N' -> novaLinha--;
            case 'S' -> novaLinha++;
            case 'E' -> novaColuna++;
            case 'O' -> novaColuna--;
            default -> {
                System.out.println("Direção inválida! Use N, S, E ou O.");
                return;
            }
        }
    
        
        if (novaLinha < 0) novaLinha = tamanhoX - 1;
        if (novaLinha >= tamanhoX) novaLinha = 0;
        if (novaColuna < 0) novaColuna = tamanhoY - 1;
        if (novaColuna >= tamanhoY) novaColuna = 0;
    
        
        un.setLinha(novaLinha);
        un.setColuna(novaColuna);
    
        
        mapa[novaLinha][novaColuna] = un.getCodigo();
    }
    
    
    
}
