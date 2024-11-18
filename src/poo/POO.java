/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;
import java.util.Scanner;

public class POO{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Mover uma unidade");
            System.out.println("2. Atacar com uma unidade");
            System.out.println("3. Construir ou melhorar um edifício na cidade");
            System.out.println("4. Ver o mapa");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu mover uma unidade.");
                    break;

                case 2:
                    System.out.println("Você escolheu atacar com uma unidade.");
                   
                    break;

                case 3:
                    System.out.println("Você escolheu construir ou melhorar um edifício na cidade.");
                    break;

                case 4:
                    Mapa matrizTerrenos = new Mapa(50, 50); 
                    Terrenos[][] matriz = matrizTerrenos.criarMatriz();
                       matrizTerrenos.imprimirMatriz(matriz);       

                    
                    break;

                case 5:
                    System.out.println("Saindo do programa. Até mais!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); 
        }

        scanner.close();
    }
}


