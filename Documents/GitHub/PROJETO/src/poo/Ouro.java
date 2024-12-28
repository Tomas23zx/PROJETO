package poo;

public class Ouro extends Recursos {

    public Ouro(int quantidadeInicial) {
        super(quantidadeInicial);
    }
    /*
     * aumenta a quantidade de ouro
     */

    @Override
    public void adicionar(int quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }
    /*
     * diminui a quantidade de ouro
     */

    @Override
    public void consumir(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
        } else {
            System.out.println("Ouro insuficiente!");
        }
    }
//
    @Override
    public void atualizar() {
        //ouro não precisa atualizar por turno
    }
    /*
     * toString
     */
    
    @Override
      public String toString(){
          return "Quantidade de ouro: "+getQuantidade();
      }
}