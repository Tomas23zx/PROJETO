package poo;

public class Comida extends Recursos {
   
    private int populacao;

    public Comida(int quantidadeInicial,  int populacaoInicial) {
        super(quantidadeInicial);
    
        this.populacao = populacaoInicial;
    }


//
    public int getPopulacao() {
        return populacao;
    }

    @Override
    public void adicionar(int quantidade) {
        setQuantidade(getQuantidade() + quantidade);
    }

    @Override
    public void consumir(int quantidade) {
        if (getQuantidade() >= quantidade) {
            setQuantidade(getQuantidade() - quantidade);
        } else {
            System.out.println("Comida insuficiente!");
        }
    }

    @Override
    public void atualizar() { //ainda falta
       
}
    @Override
    public String toString(){
          return "Quantidade de comida: "+getQuantidade()+ "\n" + "Populacao:" + getPopulacao()+ "\n";
      }
}