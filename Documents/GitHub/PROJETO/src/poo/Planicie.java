package poo;


public class Planicie extends Acessivel {
    private static final String CASTANHO = "\033[33m";
    private static final String RESET = "\033[0m";
    public Planicie(){
        super(CASTANHO+"P "+RESET);


    }
     /*
     * criarArray cria um array de terrenos de planicies,para ser colocaddo incialmente no mapa de modo que fique junto
     * vantagem a unidade recebe um beneficio,os Militares ganham o dobro da força
     * custo_para_mover ao mover para uma celula custa tem um certo custo de ouro,neste caso 1
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
    @Override
    public  boolean vantagem(Unidades un){
        if(un instanceof  Militares)
        {
            ((Militares) un).setForca(((Militares) un).getForca() + ((Militares) un).getForca());
            System.out.println("A sua forca e: "+ ((Militares) un).getForca());
        }
        return true;
    }

    public  void custo_para_mover(Cidade cidade){
        Recursos ouro = cidade.findRecurso(new Ouro(0));
        if (ouro != null) {
            cidade.consumirRecurso(new Ouro(0), 1);
            System.out.println("Cidade " + cidade.getCodigo() + ",consumio "+ 1 +" para mover.");
    }
    else{
        return ;
    }

}
}
