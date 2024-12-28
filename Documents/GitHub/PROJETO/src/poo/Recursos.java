package poo;

public abstract class Recursos {
    private int quantidade;

    public Recursos(int quantidadeInicial) {
        this.quantidade = quantidadeInicial;
    }
//Getrs seters
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /*
     * funcoes explicadas nas subclasses
     */

    public abstract void adicionar(int quantidade);

    public abstract void consumir(int quantidade);

    public abstract void atualizar();
    
    
  //
}