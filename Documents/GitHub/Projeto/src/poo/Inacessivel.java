/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Inacessivel extends Terrenos {

    
    public Inacessivel(String letra) {
        super(letra);
    }

   //

    @Override
    public char[] criarArray(int tamanho) {
        char[] array = new char[tamanho];
        char letraChar = getLetra().charAt(0); 
        for (int i = 0; i < tamanho; i++) {
            array[i] = letraChar; 
        }
        return array;
    }
}
