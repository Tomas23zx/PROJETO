package poo;

public class POO {
    public static void main(String[] args) {
        Mapa mapa = new Mapa(25, 25); // Cria o mapa
        String[][] matriz = mapa.getMapa(); // Obtém a matriz do mapa

        Menu menu = new Menu(matriz, mapa); // Passa a matriz e o mapa para o menu

        boolean isFirstTime = true;

        if (isFirstTime) {
            menu.menCiv(); // Exibe menu de civilizações
            isFirstTime = false;
        }

        menu.Interface();
        menu.menus();
    }
}
