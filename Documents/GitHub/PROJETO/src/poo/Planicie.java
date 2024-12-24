package poo;


public class Planicie extends Acessivel {
    public Planicie(){
        super("P");

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

}
