package poo;

public class Comida extends Recursos {
   
    private int populacao;

    public Comida(int quantidadeInicial,  int populacaoInicial) {
        super(quantidadeInicial);
    
        this.populacao = populacaoInicial;
    }
 /*
     * retorna a populacao
    */

//
    public int getPopulacao() {
        return populacao;
    }
     /*
     * adiciona comida
    */
    @Override
    public void adicionar(int quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }
     /*
     * consome comida
    */

    @Override
    public void consumir(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
        } else {
            System.out.println("Comida insuficiente!");
        }
    }

    @Override
    public void atualizar() { //nao atualiza
       

}
 /*
     * toString
    */
    @Override
    public String toString(){
          return "Quantidade de comida: "+getQuantidade()+ "\n";
      }
}