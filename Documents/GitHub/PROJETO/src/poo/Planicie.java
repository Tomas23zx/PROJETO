package poo;


public class Planicie extends Acessivel {
    public static final String CASTANHO = "\033[33m";
    public static final String RESET = "\033[0m";
    public Planicie(){
        super(CASTANHO+"P "+RESET);


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
