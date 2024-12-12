package poo;

public class Comida extends Recursos {
    private int reserva;
    private int limiteSuperiorReserva;
    private int populacao;

    public Comida(int quantidadeInicial, int limiteSuperiorReserva, int populacaoInicial) {
        super(quantidadeInicial);
        this.reserva = 0;
        this.limiteSuperiorReserva = limiteSuperiorReserva;
        this.populacao = populacaoInicial;
    }

    public int getReserva() {
        return reserva;
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
          return "Quantidade de comida: "+getQuantidade()+ "\n" + "Populacao:" + getPopulacao()+ "\n" + "Reserva:" + getReserva();
      }
}