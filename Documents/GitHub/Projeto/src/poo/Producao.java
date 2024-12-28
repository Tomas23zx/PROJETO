package poo;

public class Producao extends Recursos {

    public Producao(int quantidadeInicial) {
        super(quantidadeInicial);
    }
    /*
     * aumenta a quantidade de produção
     */

    @Override
    public void adicionar(int quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }
     /*
     * diminui a quantidade de produção
     */

    @Override
    public void consumir(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
        } else {
            System.out.println("Produção insuficiente!");
        }
    }
//
    @Override
    public void atualizar() {
        // A produção não utilizada em cada turno é perdida
        setQuantidade(0);
    }
    /*
     * toString
     */
    @Override
    public String toString(){
          return "Quantidade de producao: "+getQuantidade();
      }
}