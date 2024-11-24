public abstract class Recursos{
    private int comida;
    private int producao;
    private int ouro;

    public Recursos(int comidaInicial, int producaoInicial, int ouroInicial) {
        this.comida = comidaInicial;
        this.producao = producaoInicial;
        this.ouro = ouroInicial;
    }

    public void addComida(int pomba){
        comida += pomba;
    }
}
