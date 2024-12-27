/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Agua extends Inacessivel {
    //
        public static final String AZUL = "\033[34m";
        public static final String RESET = "\033[0m";
        public Agua() {
            super(AZUL+"~ "+RESET); 
        }
    
        @Override
        public char[] criarArray(int tamanho) {
            char[] array = new char[tamanho];
            char letraChar = getLetra().charAt(0); 
            for (int i = 0; i < tamanho; i++) {
                array[i] = letraChar; 
            }
            return array;
        }
        public  boolean  vantagem(Unidades un){
            return true;
    
        }
        
    }