/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
import java.util.Random;

public class Mapa {

    private int tamanhoX;
    private int tamanhoY;
    private Cidade cidade;

    public Mapa(int tamanhoX, int tamanhoY) {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
    }

    public Terrenos[][] criarMatriz() {
        Terrenos[][] matriz = new Terrenos[tamanhoX][tamanhoY];

        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                matriz[i][j] = new Acessivel("X");
            }
        }

        Random random = new Random();

        Agua agua = new Agua();
        int tamanhoAgua = random.nextInt(25) + 20; 
        char[] arrayAgua = agua.criarArray(tamanhoAgua);
        preencherTerrenos(matriz, new Agua(), arrayAgua);

        Arvore arvore = new Arvore();
        int tamanhoFloresta = random.nextInt(50) + 30; 
        char[] arrayFloresta = arvore.criarArray(tamanhoFloresta); 
        preencherTerrenos(matriz, new Arvore(), arrayFloresta);
        
       
        
        

        return matriz;
    }

    private void preencherTerrenos(Terrenos[][] matriz, Terrenos tipo, char[] array) {
        Random random = new Random();

        
        int posX = random.nextInt(tamanhoX);
        int posY = random.nextInt(tamanhoY);

        matriz[posX][posY] = tipo;

        
        for (int i = 1; i < array.length; i++) {
            int novaPosX = posX;
            int novaPosY = posY;

            
            switch (random.nextInt(4)) {
                case 0: 
                    novaPosX = posX - 1;
                    break;
                case 1: 
                    novaPosX = posX + 1;
                    break;
                case 2: 
                    novaPosY = posY - 1;
                    break;
                case 3: 
                    novaPosY = posY + 1;
                    break;
            }

            
            if (novaPosX >= 0 && novaPosX < tamanhoX && novaPosY >= 0 && novaPosY < tamanhoY
                    && matriz[novaPosX][novaPosY] instanceof Acessivel) {
                matriz[novaPosX][novaPosY] = tipo;
                posX = novaPosX; 
                posY = novaPosY;
            }
        }
    }

    public void imprimirMatriz(Terrenos[][] matriz) {
        for (Terrenos[] linha : matriz) {
            for (Terrenos terreno : linha) {
                System.out.print(terreno.getLetra() + " "); 
            }
            System.out.println();
        }
    }
   
}

