package poo;

public class POO {
    public static void main(String[] args) {
        int comidaInicial = 100;
        int limiteReserva = 200;
        int populacaoInicial = 1;
        int producaoInicial = 50;
        int ouroInicial = 100;

        Cidade city = new Cidade("C", 15, 15, comidaInicial, limiteReserva, populacaoInicial, producaoInicial, ouroInicial);
        city.adicionarRecurso(new Comida(0, limiteReserva, populacaoInicial), 50);
        city.consumirRecurso(new Producao(0), 30);
        city.atualizarRecursos();

        Mapa mapa = new Mapa(25, 25, city);

        String[][] matriz = mapa.getMapa();

        // Menu de interação
        Menu menu = new Menu(matriz, mapa, city);

        boolean isFirstTime = true;

        if (isFirstTime) {
            menu.menCiv();
            isFirstTime = false;
        }

        menu.Interface();
        menu.menus(city);
    }
}
