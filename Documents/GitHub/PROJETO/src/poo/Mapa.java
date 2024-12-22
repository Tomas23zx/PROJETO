package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Mapa {
    private int tamanhoX;
    private int tamanhoY;
    private ArrayList<Unidades>un;
    
    
    private String[][] mapa;

    public Mapa(int tamanhoX, int tamanhoY) {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.un=new ArrayList<Unidades>();
       
        this.mapa = criarMapa();
    }
//
    private String[][] criarMapa() {
        String[][] mapa = new String[tamanhoX][tamanhoY];

        for (int i = 0; i < tamanhoX; i++) {
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = "X";
            }
        }

        Random random = new Random();
        Terrenos agua = new Agua();
        int tamanhoAgua = random.nextInt(25) + 20;
        preencherTerrenos(mapa, agua, tamanhoAgua);

        Terrenos arvore = new Arvore();
        int tamanhoFloresta = random.nextInt(50) + 30;
        preencherTerrenos(mapa, arvore, tamanhoFloresta);

        
    
        

        return mapa;
    }

    private void preencherTerrenos(String[][] mapa, Terrenos tipo, int quantidade) {
        Random random = new Random();
        int posX = random.nextInt(tamanhoX);
        int posY = random.nextInt(tamanhoY);
        mapa[posX][posY] = tipo.getLetra();

        for (int i = 1; i < quantidade; i++) {
            int novaPosX = posX;
            int novaPosY = posY;

            switch (random.nextInt(4)) {
                case 0 -> novaPosX = posX - 1;
                case 1 -> novaPosX = posX + 1;
                case 2 -> novaPosY = posY - 1;
                case 3 -> novaPosY = posY + 1;
            }

            if (novaPosX >= 0 && novaPosX < tamanhoX && novaPosY >= 0 && novaPosY < tamanhoY) {
                mapa[novaPosX][novaPosY] = tipo.getLetra();
                posX = novaPosX;
                posY = novaPosY;
            }
        }
    }

    public String[][] getMapa() {
        return this.mapa;
    }

    public void imprimirMapa() {
        for (String[] linha : mapa) {
            for (String celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
    }

    public void meterUnidade(Unidades en, int x, int y) {
        en.setColuna(y);
        en.setLinha(x);
        mapa[x][y] = en.getCodigo();
        un.add(en);
        
        System.out.println("Unidade adicionada: " + en.getCodigo());
    }

    public void meterCidade(Civilizacao civi, int x, int y) {
        if (!podeConstruirCidade(civi,x, y)) {
            System.out.println("Não é possível construir uma cidade aqui. Existe outra cidade próxima.");
            return;
        }

        Cidade citys = new Cidade("C", x, y, civi.getId(),4);
        civi.adicionaCidade(citys);
        mapa[x][y] = citys.getCodigo();
    }

    public boolean podeConstruirCidade(Civilizacao civi, int x, int y) {
        int[][] direcoes = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},          {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };
    
        for (int[] dir : direcoes) {
            int novoX = x + dir[0];
            int novoY = y + dir[1];
    
            if (novoX >= 0 && novoX < tamanhoX && novoY >= 0 && novoY < tamanhoY) {
                for (Cidade cidade : civi.getCidades()) {
                    if (cidade.getPosX() == novoX && cidade.getPosY() == novoY) {
                        if ("C".equals(cidade.getLetra())) {
                            return false;
                        }
                    }
                }
            }
        }
    
        return true;
    }

    public void adicionarUnidades(Unidades e){
        un.add(e);
    }
    public void removerPessoas(int pox)
    {
        un.remove(pox);

    }

    public Unidades getUnidades(int i) {
        return  un.get(i);
    }
    
    public void moverUnidade(Unidades un, int novaLinha, int novaColuna) {
        int linhaAtual = un.getLinha();
        int colunaAtual = un.getColuna();

        mapa[linhaAtual][colunaAtual] = "X";

        if (novaLinha < 0) novaLinha = tamanhoX - 1;
        if (novaLinha >= tamanhoX) novaLinha = 0;
        if (novaColuna < 0) novaColuna = tamanhoY - 1;
        if (novaColuna >= tamanhoY) novaColuna = 0;

        un.setLinha(novaLinha);
        un.setColuna(novaColuna);

        mapa[novaLinha][novaColuna] = un.getCodigo();
    }
    
    public int obterUnidadePorPosicao(int x, int y, List<Unidades> unidades) {
        // Verifica se as posições fornecidas estão dentro dos limites do mapa
        if (x < 0 || x >= tamanhoX || y < 0 || y >= tamanhoY) {
            throw new IllegalArgumentException("As posições fornecidas estão fora dos limites do mapa.");
        }

        
        String codigo = mapa[x][y];

       
        for (Unidades unidade : unidades) {
            if (unidade.getCodigo().equals(codigo)) {
                return unidade.getId();
            }
        }

       
        return 0;
    }
    
    public Unidades buscarUnidadePorCodigo(String codigo, int idCivilizacao) {
        for (Unidades unidade : un) {
            System.out.println("un:"+unidade.getCodigo());
            System.out.println("c:"+codigo);
            if (unidade.getCodigo().equals(codigo)) {
                return unidade;
            }
        }
        return null;  // Return null if no enemy unit is found
    }
    
    
    
    
}
