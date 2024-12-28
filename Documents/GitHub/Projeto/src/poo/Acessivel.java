/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Acessivel extends Terrenos {
//
    
    public Acessivel(String letra) {
        super(letra);
    }


    /*
     * criarArray cria um array de terrenos acessiveis,para ser colocaddo incialmente no mapa de modo que fique junto
     * vantagem a unidade recebe um beneficio
     * custo_para_mover ao mover para uma celula custa tem um certo custo de ouro
     */

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
        return true;
    }
    public  void custo_para_mover(Cidade cidade){
        return ;}
}
