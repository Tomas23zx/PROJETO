package poo;

public class Terra extends Acessivel{
    public Terra(String letra) {
        super("X");
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
    public  boolean vantagem(Unidades un){
        System.out.println("Nenhuma vantagem aplicada");
        return true;
    }
}
