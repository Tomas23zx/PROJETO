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
     /*
     * criarArray cria um array de terrenos Arvores,para ser colocaddo incialmente no mapa de modo que fique junto
     * vantagem a unidade recebe um beneficio,neste caso ganho 1 de vida
     * custo_para_mover ao mover para uma celula custa tem um certo custo de ouro,neste caso per 2 de ouro
     */
   
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
        un.Ganhar_vida(1);
        return true;
    }
    public  void custo_para_mover(Cidade cidade){
        Recursos ouro = cidade.findRecurso(new Ouro(0));
        if (ouro != null) {
            cidade.consumirRecurso(new Ouro(0), 2);
            System.out.println("Cidade " + cidade.getCodigo() + ",consumio "+ 2 +" para mover.");
    }
    else{
        return ;
    }

}
    
}
