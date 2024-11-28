package poo;

public class Ouro extends Recursos {

    public Ouro(int quantidadeInicial) {
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
            System.out.println("Ouro insuficiente!");
        }
    }

    @Override
    public void atualizar() {
        //ouro não precisa atualizar por turno
    }
}