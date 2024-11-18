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
        int numero_de_aguas=random.nextInt(tamanhoX);
        for(int i=0;i<=numero_de_aguas;i++){
            int posX = random.nextInt(tamanhoX);
        int posY = random.nextInt(tamanhoY);
        matriz[posX][posY] = new Agua();
        }
        

        return matriz;
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