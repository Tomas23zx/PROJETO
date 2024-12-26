package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Mapa {
    private int tamanhoX;
    private int tamanhoY;
    private ArrayList<Unidades>un;
    private ArrayList<Estrutura>es;
    private ArrayList<Cidade>city;
    private String[][] estadoAnterior;
    private ArrayList<Terrenos> ter;
    public static final String VERMELHO = "\033[31m";
    public static final String RESET = "\033[0m";
    
    private String[][] mapa;

    public Mapa(int tamanhoX, int tamanhoY) {
        if (tamanhoX <= 0 || tamanhoY <= 0) {
            throw new IllegalArgumentException("As dimensões da matriz devem ser maiores que zero.");
        }
        this.tamanhoX = tamanhoX;
        this.tamanhoY = tamanhoY;
        this.un=new ArrayList<Unidades>();
        this.city=new ArrayList<Cidade>();
        this.ter=new ArrayList<Terrenos>();
        this.es=new ArrayList<Estrutura>();
        this.mapa = criarMapa();
        this.estadoAnterior = copiarMapa(mapa);
    }
//
    private String[][] criarMapa() {
        String[][] mapa = new String[tamanhoX][tamanhoY];
        Terrenos ass=new Acessivel("X");
        for (int i = 0; i < tamanhoX; i++) {
            
            for (int j = 0; j < tamanhoY; j++) {
                mapa[i][j] = ass.getLetra();
            }
        }

        Random random = new Random();
        Terrenos agua = new Agua();
        ter.add(agua);
        int tamanhoAgua = random.nextInt(50) + 30;
        preencherTerrenos(mapa, agua, tamanhoAgua);

        Terrenos arvore = new Arvore();
        ter.add(arvore);
        int tamanhoFloresta = random.nextInt(50) + 30;
        preencherTerrenos(mapa, arvore, tamanhoFloresta);

        Terrenos pl=new Planicie();
        ter.add(pl);
        int tamanhoPlanicie = random.nextInt(70) + 30;
        preencherTerrenos(mapa, pl, tamanhoPlanicie);
        
    
        

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
    private String[][] copiarMapa(String[][] mapa) {
        String[][] copia = new String[tamanhoX][tamanhoY];
        for (int i = 0; i < tamanhoX; i++) {
            System.arraycopy(mapa[i], 0, copia[i], 0, tamanhoY);
        }
        return copia;
    }

    public String[][] getMapa() {
        return this.mapa;
    }

    public void imprimirMapa() {
        for (String[] linha : mapa) {
            for (String celula : linha) {
                if(celula == "E"){
                System.out.print(VERMELHO + celula + " " + RESET);
                }
                else{
                System.out.print(celula + " ");}
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
    public void meterEstrutura(Estrutura en, int x, int y) {
        en.setColuna(y);
        en.setLinha(x);
        mapa[x][y] = en.getCodigo();
        es.add(en);
        
        System.out.println("Estrutura adicionada: " + en.getCodigo());
    }
    
    public void meterCidade(Civilizacao civi, int x, int y) {
        if (!podeConstruirCidade(civi,x, y)) {
            System.out.println("Não é possível construir uma cidade aqui. Existe outra cidade próxima.");
            return;
        }

        Cidade citys = new Cidade("C", x, y, civi.getId(),4);
        civi.adicionaCidade(citys);
        mapa[x][y] = citys.getCodigo();
        city.add(citys);
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
                        if (cidade.getLetra().equals(cidade.getLetra())) {
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

    public void adicionarTerrenos(Terrenos cas){
        ter.add(cas);
    }

    public void removerTerrenos(int capa){
        ter.remove(capa);
    }
    public void removerUnidadePorPosicao(int x, int y) {
       
        for (int i = 0; i < un.size(); i++) {
            Unidades unidade = un.get(i);
            if (unidade.getLinha() == x && unidade.getColuna() == y) {
              
                un.remove(i);
                
                return; 
            }
        }
        System.out.println("Nenhuma unidade encontrada na posição (" + x + ", " + y + ").");
    }

    public void adicionaCidadees(Cidade citys){
        city.add(citys);
    }
    public void removerCidades(int poxi)
    {
        city.remove(poxi);

    }
    
    public ArrayList<Cidade> getCidades() {
        return city; 
    }

    public Unidades getUnidades(int i) {
        return  un.get(i);
    }
    
    public void moverUnidade(Unidades en, int novaLinha, int novaColuna,String codigo) {
        int linhaAtual = en.getLinha();
        int colunaAtual = en.getColuna();

        

        if (novaLinha < 0) novaLinha = tamanhoX - 1;
        if (novaLinha >= tamanhoX) novaLinha = 0;
        if (novaColuna < 0) novaColuna = tamanhoY - 1;
        if (novaColuna >= tamanhoY) novaColuna = 0;

        String letraDestino = mapa[novaLinha][novaColuna];
    
            if (buscarUnidades(novaLinha,novaColuna)!=null) {
                System.out.println("Não é possível mover para a posição (" + novaLinha + ", " + novaColuna + "). Já está ocupada por uma tropa.");
                return;
            }

        

         for (Cidade cidade : city) {
        if (cidade.getCodigo().equals(letraDestino)) {
            System.out.println("Não é possível mover para a posição (" + novaLinha + ", " + novaColuna + "). Já está ocupada por uma cidade.");
            return;
        }
    }
        
        
        if (mapa[novaLinha][novaColuna] == obterLetraAgua()) {
            Terrenos agua = obterAgua();
            boolean x = agua.vantagem(en);
            System.out.println("Nao pode mover para aqui");
            
            
            return;
        }
        if (mapa[novaLinha][novaColuna]==obterLetraArvore()) {
            Terrenos arvore=obterArvore();
            boolean x= arvore.vantagem(en);
            System.out.println("A sua vida, e agora: "+en.getVida());
            mapa[linhaAtual][colunaAtual] = estadoAnterior[linhaAtual][colunaAtual];
            en.setLinha(novaLinha);
            en.setColuna(novaColuna);
            mapa[novaLinha][novaColuna] = codigo;


            return;
            
        }
        if(mapa[novaLinha][novaColuna]==obterLetraPlanicie()){
            Terrenos pl=obterPlanicie();
            boolean x = pl.vantagem(en);
            mapa[linhaAtual][colunaAtual] = estadoAnterior[linhaAtual][colunaAtual];
            en.setLinha(novaLinha);
            en.setColuna(novaColuna);
            mapa[novaLinha][novaColuna] = codigo;


            return;

        }
        else{

        
        mapa[linhaAtual][colunaAtual] = estadoAnterior[linhaAtual][colunaAtual];
        en.setLinha(novaLinha);
        en.setColuna(novaColuna);

        mapa[novaLinha][novaColuna] = codigo;
        }
    }
    
    public int obterUnidadePorPosicao(int x, int y, List<Unidades> unidades) {
        
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
    
    public Unidades buscarUnidadePorCodigo(int x,int y, int idCivilizacao) {
        for (Unidades unidade : un) {
           
            if (unidade.getLinha()==x && unidade.getColuna()==y && unidade.getId()!= idCivilizacao) {
                return unidade;
            }
            System.out.println(""+unidade.getId());
        }
        System.out.println(""+idCivilizacao);
        return null;  
    }

    public Unidades buscarUnidades(int x,int y) {
        for (Unidades unidade : un) {
           
            if (unidade.getLinha()==x && unidade.getColuna()==y ) {
                return unidade;
            }
            System.out.println(""+unidade.getId());
        }
       
        return null;  
    }

    public Cidade buscarCidadePorposicao(int x,int y,int idCivilizacao){

        for(Cidade cit:city){
            if(cit.getPosX()==x && cit.getPosY()==y && cit.getId()!=idCivilizacao){
                return cit;
            }
        }
        return null;
    }
    
    
    public void remover_do_mapa(int x,int y){
        mapa[x][y]=estadoAnterior[x][y];
    }

    public String[] obterLetrasDosTerrenos() {
        String[] letrasTerrenos = new String[ter.size()];
    
        for (int i = 0; i < ter.size(); i++) {
            letrasTerrenos[i] = ter.get(i).getLetra();
        }
    
        return letrasTerrenos;
    }

    public String obterLetraAgua() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Agua) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Agua nao encontrado no array.");
    }

    public Terrenos obterAgua() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Agua) {
                return (Agua) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Agua nao encontrado no array.");
    }
    public String obterLetraArvore() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Arvore) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Arvore nao encontrado no array.");
    }
    public Terrenos obterArvore() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Arvore) {
                return (Arvore) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Arvore nao encontrado no array.");
    }
    public String obterLetraAcessivel() {
        for (Terrenos terreno : ter) {
            if (terreno != null && terreno.getClass() == Acessivel.class) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Acessivel nao encontrado no array.");
    }
    public String obterLetraPlanicie() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Planicie) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Planicie nao encontrado no array.");
    }
    public Terrenos obterPlanicie() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Planicie) {
                return (Planicie) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Planicie nao encontrado no array.");
    }
    
    
    
}
