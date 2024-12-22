package poo;

public class Vitoria {

    private Mapa mapa;
    private Civilizacao civi;
    private Terrenos terre;

    public Vitoria(Mapa mapa, Civilizacao civi, Terrenos terre) {
        this.mapa = mapa;
        this.civi = civi;
        this.terre = terre;
    }

    // Verifica se existem cidades de outros jogadores no mapa
    public static boolean vitoriaEliminar(Mapa mapa, int idCivilizacao) {
        String[][] grid = mapa.getMapa();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String celula = grid[i][j];
                if (celula.startsWith("C")) {
                    int idCidade = Integer.parseInt(celula.substring(1)); // Obtém o ID após o 'C'
                    if (idCidade != idCivilizacao) {
                        return false; // Existe uma cidade que não pertence à civilização especificada
                    }
                }
            }
        }
        return true; // Todas as cidades restantes pertencem ao jogador
    }

    // Método para verificar as condições de vitória no final de cada turno
    public static void verificarCondicoesDeVitoria(Mapa mapa, int idCivilizacao) {
    if (vitoriaEliminar(mapa, idCivilizacao)) {
        System.out.println("Jogador " + idCivilizacao + " venceu por eliminação do adversário!");
    }
    }
}
