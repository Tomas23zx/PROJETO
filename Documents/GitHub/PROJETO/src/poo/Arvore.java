package poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaot
 */
public class Arvore extends Acessivel {
    public static final String VERDE = "\033[32m";
    public static final String RESET = "\033[0m";
    public Arvore(){
        super(VERDE +"F "+RESET);
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
    public  boolean vantagem(Unidades un){
        un.setVida(un.getVida()+1);
        return true;
    }
    
}
