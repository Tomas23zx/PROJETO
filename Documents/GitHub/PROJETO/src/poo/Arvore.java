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
    public Arvore(){
        super("F");

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
    public  void custo_para_mover(Cidade cidade){
        Recursos ouro = cidade.findRecurso(new Ouro(0));
        if (ouro != null) {
            cidade.consumirRecurso(new Ouro(0), 10);
            System.out.println("Cidade " + cidade.getCodigo() + ",consumio "+ 10 +" para mover.");
    }
    else{
        return ;
    }
    
}
}
