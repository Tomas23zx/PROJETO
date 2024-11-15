/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Mapa {
    private int tamanhoX;
    private int tamanhoY;

    // Construtor padrão
    public Mapa() {
        this.tamanhoX = 0; // Inicializar com valores padrão
        this.tamanhoY = 0;
    }

    // Construtor com parâmetros
    public Mapa(int tamanhoX, int tamanhoY) {
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
    }

    // Getters e Setters
    public int getTamanhoX() {
        return tamanhoX;
    }

    public void setTamanhoX(int tamanhoX) {
        this.tamanhoX = tamanhoX;
    }

    public int getTamanhoY() {
        return tamanhoY;
    }

    public void setTamanhoY(int tamanhoY) {
        this.tamanhoY = tamanhoY;
    }

    // Método para criar a matriz
    public char[][] criarMatriz() {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }

        char[][] matriz = new char[tamanhoX][tamanhoY];

        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                matriz[i][j] = 'X';
            }
        }
        return matriz;
    }

    // Método para imprimir a matriz
    public void imprimirMatriz(char[][] matriz) {
        for (char[] linha : matriz) {
            for (char elemento : linha) {
                System.out.print(elemento + " ");
            }
            System.out.println(); // Nova linha após cada linha da matriz
        }
    }
}