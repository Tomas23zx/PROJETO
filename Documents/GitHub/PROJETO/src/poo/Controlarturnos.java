package poo;

public class Controlarturnos {
    private int dia;
    private int energia;
    private static final int ENERGIA_MAXIMA = 5;

    public Controlarturnos() {
        this.dia = 1; // Começa no primeiro dia
        this.energia = ENERGIA_MAXIMA; // Energia inicial
    }

    // Método para avançar um dia
    public void avancarDia() {
        dia++;
        energia = ENERGIA_MAXIMA; // Restaura energia ao máximo a cada novo dia
        System.out.println("Dia avançado para: " + dia);
        System.out.println("Energia restaurada para: " + energia);
    }

    // Método para gastar energia
    public boolean gastarEnergia(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade de energia inválida.");
            return false;
        }

        if (energia >= quantidade) {
            energia -= quantidade;
            System.out.println("Energia gasta: " + quantidade + ". Energia restante: " + energia);
            return true;
        } else {
            System.out.println("Energia insuficiente. Energia atual: " + energia);
            return false;
        }
    }

    // Método para exibir status atual
    public void exibirStatus() {
        System.out.println("===== Status do Jogo =====");
        System.out.println("Dia atual: " + dia);
        System.out.print("Energia: [");
        for (int i = 0; i < energia; i++) {
            System.out.print("/");
        }
        for (int i = energia; i < ENERGIA_MAXIMA; i++) {
            System.out.print("\\");
        }
        System.out.println("]");
    }

    // Métodos para obter o dia e a energia
    public int getDia() {
        return dia;
    }

    public int getEnergia() {
        return energia;
    }
}
