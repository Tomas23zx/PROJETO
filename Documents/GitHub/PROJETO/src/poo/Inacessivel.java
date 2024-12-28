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

   /*
     * criarArray cria um array de terrenos inacessiveis,para ser colocaddo incialmente no mapa de modo que fique junto
     * vantagem a unidade recebe um beneficio,neste caso nenhum
     * custo_para_mover ao mover para uma celula custa tem um certo custo de ouro,neste nao tem num porque o militar não pode se mover para la
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
        System.out.println("Nao tem custo.");
        return ;}
}
