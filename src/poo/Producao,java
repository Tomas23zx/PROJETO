package poo;

public class Producao extends Recursos {

    public Producao(int quantidadeInicial) {
        super(quantidadeInicial);
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
            System.out.println("Produção insuficiente!");
        }
    }

    @Override
    public void atualizar() {
        // A produção não utilizada em cada turno é perdida
        setQuantidade(0);
    }
}