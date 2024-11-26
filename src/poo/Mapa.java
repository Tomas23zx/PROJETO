package poo;

import java.util.Random;

public class Mapa {

    private int tamanhoX;
    private int tamanhoY;
    private String[][] mapa; // Adicionando o mapa como um atributo da classe

    public Mapa(int tamanhoX, int tamanhoY) {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.mapa = criarMapa(); // Gera o mapa ao inicializar
    }

    // Método para criar o mapa
    private String[][] criarMapa() {
        String[][] mapa = new String[tamanhoX][tamanhoY];

        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = "X"; // Inicializa como terreno acessível
            }
        }

        Random random = new Random();

        // Adiciona terrenos específicos
        Agua agua = new Agua();
        int tamanhoAgua = random.nextInt(25) + 20;
        preencherTerrenos(mapa, agua, tamanhoAgua);

        Arvore arvore = new Arvore();
        int tamanhoFloresta = random.nextInt(50) + 30;
        preencherTerrenos(mapa, arvore, tamanhoFloresta);

        Cidade city = new Cidade("C", 15, 15);
        mapa[15][15] = city.getLetra();

        Militares militar= new Militares("M",5,5,mapa);
        mapa[5][5]=militar.getLetra();

        return mapa;
    }

    // Método para preencher terrenos específicos
    private void preencherTerrenos(String[][] mapa, Terrenos tipo, int quantidade) {
        Random random = new Random();
        int posX = random.nextInt(tamanhoX);
        int posY = random.nextInt(tamanhoY);

        mapa[posX][posY] = tipo.getLetra();

        for (int i = 1; i < quantidade; i++) {
            int novaPosX = posX;
            int novaPosY = posY;

            switch (random.nextInt(4)) {
                case 0 -> novaPosX = posX - 1; // Cima
                case 1 -> novaPosX = posX + 1; // Baixo
                case 2 -> novaPosY = posY - 1; // Esquerda
                case 3 -> novaPosY = posY + 1; // Direita
            }

            if (novaPosX >= 0 && novaPosX < tamanhoX && novaPosY >= 0 && novaPosY < tamanhoY) {
                mapa[novaPosX][novaPosY] = tipo.getLetra();
                posX = novaPosX;
                posY = novaPosY;
            }
        }
    }

    // Método para obter o mapa gerado
    public String[][] getMapa() {
        return this.mapa;
    }

    // Método para imprimir o mapa
    public void imprimirMapa() {
        for (String[] linha : mapa) {
            for (String celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }

    // Método main - ponto de entrada do programa
    public static void main(String[] args) {
        // Criação de um mapa com dimensões 10x10
        Mapa mapa = new Mapa(10, 10);

        // Imprimir o mapa gerado
        mapa.imprimirMapa();
    }
}
