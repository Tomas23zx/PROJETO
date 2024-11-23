/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poo;


public class POO {
    public static void main(String[] args) {
        Mapa matrizTerrenos = new Mapa(25, 25);  
        Terrenos[][] matriz = matrizTerrenos.criarMatriz();  
        

        Menu menu = new Menu(matriz, matrizTerrenos);  

        boolean isFirstTime = true; 

        
        if (isFirstTime) {
            menu.menCiv();  
            isFirstTime = false;  
        }
        menu.Interface();
        menu.menus();  
    }
}





