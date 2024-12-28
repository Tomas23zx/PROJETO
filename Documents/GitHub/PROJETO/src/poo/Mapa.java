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
    private ArrayList<Civilizacao> civa;
    private static final String VERMELHO = "\033[31m";
    private static final String AZUL = "\033[34m";
    private static final String RESET = "\033[0m";
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
        this.civa=new ArrayList<Civilizacao>();
        this.es=new ArrayList<Estrutura>();
        this.mapa = criarMapa();
        this.estadoAnterior = copiarMapa(mapa);
        
    }
/*
 * esta função preenche o mapa incialmente com a terra para ter mais terra no mapa, e depois chama um função de apoio para preencher o resto do mapa
 * de modo que fiquem todas juntas
 */
    private String[][] criarMapa() {
        String[][] mapa = new String[tamanhoX][tamanhoY];
        Terrenos ass=new Terra("X");
        ter.add(ass);
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
    /*
     * esta função preenche o mapa com os tipos de terrenos que existem, de acordo com a quantidade desejada
     */

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
    /*
     * esta função é privada pois e um metodo de apoio,em que copia este mapa de modo que depois do movimento da unidade,mete a celula que tava inicialmente
     */
    
    private String[][] copiarMapa(String[][] mapa) {
        String[][] copia = new String[tamanhoX][tamanhoY];
        for (int i = 0; i < tamanhoX; i++) {
            System.arraycopy(mapa[i], 0, copia[i], 0, tamanhoY);
        }
        return copia;
    }
//get
    public String[][] getMapa() {
        return this.mapa;
    }
    /*
     * esta função imprime o mapa,com o devido espaçamento
     */

    public void imprimirMapa() {
        System.out.println("");
        for (String[] linha : mapa) {
            for (String celula : linha) {
                
                    if(celula.length()==2){
                        System.out.print(celula + " ");

                    }
                    else if(celula.length()==1){
                        System.out.print(celula + "  ");
                    }
                    
                    else{
                        System.out.print(celula + " ");
                    }
                
            }
            System.out.println();
        }
    }
    /*
     * mete o codigo da unidade no mapa e coloca no array, de todas as unidades do jogo(un)
     */

    public void meterUnidade(Unidades en, int x, int y) {
        en.setColuna(y);
        en.setLinha(x);
        mapa[x][y] = en.getCodigo();
        un.add(en);
        
        System.out.println("Unidade adicionada: " + en.getCodigo());
    }
    /*
     * mete o codigo da estrutura no mapa e coloca no array, de todas as estruturas do jogo
     */
    public void meterEstrutura(Estrutura en, int x, int y) {
        en.setColuna(y);
        en.setLinha(x);
        mapa[x][y] = en.getCodigo();
        es.add(en);
        
        System.out.println("Estrutura adicionada: " + en.getCodigo());
    }
    /*
     * mete o codigo da cidade no mapa e coloca no array, de todas as cidades do jogo,verificando se pode construir naquele local
     */
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
    /*
     * boolean que verifica se pode construir nas posições adjacentes,ou com a distância de duas células
     */
    public boolean podeConstruirCidade(Civilizacao civi, int x, int y) {

        
        if (x == 0 && y == 0) {
            return false;
        }
    
        
        int[][] direcoes = {
            {-2, -2}, {-2, -1}, {-2, 0}, {-2, 1}, {-2, 2},  
            {-1, -2}, {-1, -1}, {-1, 0}, {-1, 1}, {-1, 2},  
            {0, -2}, {0, -1},          {0, 1}, {0, 2},     
            {1, -2}, {1, -1}, {1, 0}, {1, 1}, {1, 2},     
            {2, -2}, {2, -1}, {2, 0}, {2, 1}, {2, 2}     
        };
    
       
        for (int[] dir : direcoes) {
            int novoX = x + dir[0];
            int novoY = y + dir[1];
    
            
            if (novoX >= 0 && novoX < tamanhoX && novoY >= 0 && novoY < tamanhoY) {
                for (Cidade cidade : city) {
                    
                    if (cidade.getPosX() == novoX && cidade.getPosY() == novoY) {
                        return false;
                    }
                }
            }
        }
    
      
        return true;
    }
    //metodos de inserir e remover dos arrays
    
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
    /*
     * remove do array a unidade que ta naquele posição,independentemente da civilização,pois o mapa é criado uma vez
     */
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
    /*
     * remove do array a cidade que ta naquele posição,independentemente da civilização,pois o mapa é criado uma vez
     */
    public void removerCidadeDaposicao(int x,int y){
        for (int i = 0; i < city.size(); i++) {
            Cidade cit = city.get(i);
            if (cit.getPosX() == x && cit.getPosY() == y) {
              
                city.remove(i);
                
                return; 
            }
        }
        System.out.println("Nenhuma unidade encontrada na posição (" + x + ", " + y + ").");
    }
    //adiciona e remover do array
    public void adicionaCidadees(Cidade citys){
        city.add(citys);
    }
    public void removerCidades(int poxi)
    {
        city.remove(poxi);

    }
    public void  adiciona_Civ(Civilizacao cava){
        civa.add(cava);
    }
    public void remover_civ(int x){
        civa.remove(x);

    }
    /*
     * procura no array de todas as civilizacoes do jogo, a civilização com aquele id
     */
    public Civilizacao buscarcivilizacao_por_id(int id) {
        for (Civilizacao c : civa) {  
            if (c.getId() == id) {    
                return c;  
            }
        }
        return null;  
    }
    
    //metodos para retornar objetos do array
    
    public ArrayList<Cidade> getCidades() {
        return city; 
    }
    public Civilizacao getCivi(int x){
        return civa.get(x);
    }
    public Unidades getUnidades(int i) {
        return  un.get(i);
    }
    public void meter_estrutura_no_array(Estrutura e){
        es.add(e);
    }
    /*
     * realiza verificações se a unidade pode se remover para aquela posição,e realiza os tais custos de movimento
     */
    public void moverUnidade(Unidades en, int novaLinha, int novaColuna,String codigo,Cidade cidades) {
        int linhaAtual = en.getLinha();
        int colunaAtual = en.getColuna();

        

        if (novaLinha < 0) novaLinha = tamanhoX - 1;
        if (novaLinha >= tamanhoX) novaLinha = 0;
        if (novaColuna < 0) novaColuna = tamanhoY - 1;
        if (novaColuna >= tamanhoY) novaColuna = 0;

        String letraDestino = mapa[novaLinha][novaColuna];
    
            if (buscarUnidades(novaLinha,novaColuna)!=null || buscar_estrutura_letra(letraDestino)) {
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
            arvore.custo_para_mover(cidades);


            return;
            
        }
        if(mapa[novaLinha][novaColuna]==obterLetraPlanicie()){
            Terrenos pl=obterPlanicie();
            boolean x = pl.vantagem(en);
            mapa[linhaAtual][colunaAtual] = estadoAnterior[linhaAtual][colunaAtual];
            en.setLinha(novaLinha);
            en.setColuna(novaColuna);
            mapa[novaLinha][novaColuna] = codigo;
            pl.custo_para_mover(cidades);


            return;

        }
        else{

        Terrenos terra=obterTerra();
        boolean x= terra.vantagem(en);
        terra.custo_para_mover(cidades);
        mapa[linhaAtual][colunaAtual] = estadoAnterior[linhaAtual][colunaAtual];
        en.setLinha(novaLinha);
        en.setColuna(novaColuna);

        mapa[novaLinha][novaColuna] = codigo;
        }
    }
    /*
     * retorna o id da unidade que esta naquela posição
     */
    
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
    /*
     * retorna a unidade que esta naquela posição em que o id é diferente
     */
    public Unidades buscarUnidadePorCodigo(int x,int y, int idCivilizacao) {
        for (Unidades unidade : un) {
           
            if (unidade.getLinha()==x && unidade.getColuna()==y && unidade.getId()!= idCivilizacao) {
                return unidade;
            }
           
        }
        
        return null;  
    }
    /*
    * retorna unidade que esta apenas naquela posição,um pouco diferente do de cima
    */
    public Unidades buscarUnidades(int x,int y) {
        for (Unidades unidade : un) {
           
            if (unidade.getLinha()==x && unidade.getColuna()==y ) {
                return unidade;
            }
            
        }
       
        return null;  
    }
    /*
    * retorna cidade que esta apenas naquela posição,em que o id é diferente
    */

    public Cidade buscarCidadePorposicao(int x,int y,int idCivilizacao){

        for(Cidade cit:city){
            if(cit.getPosX()==x && cit.getPosY()==y && cit.getId()!=idCivilizacao){
                return cit;
            }
        }
        return null;
    }
    /*
    * remover qualquer String do mapa
    */
    
    public void remover_do_mapa(int x,int y){
        mapa[x][y]=estadoAnterior[x][y];
    }
    /*
    * remover qualquer String do mapa
    */
    public String[] obterLetrasDosTerrenos() {
        String[] letrasTerrenos = new String[ter.size()];
    
        for (int i = 0; i < ter.size(); i++) {
            letrasTerrenos[i] = ter.get(i).getLetra();
        }
    
        return letrasTerrenos;
    }
    /*
     * obtem a letra conrrespondente a agua,apartir do array
     */

    public String obterLetraAgua() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Agua) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Agua nao encontrado no array.");
    }
    /*
     * obter o terreno que conrresponde a agua
     */

    public Terrenos obterAgua() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Agua) {
                return (Agua) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Agua nao encontrado no array.");
    }
    /*
     * obtem a letra conrrespondente a Arvore,apartir do array
     */
    public String obterLetraArvore() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Arvore) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Arvore nao encontrado no array.");
    }
     /*
     * obter o terreno que conrresponde a Arvore
     */
    public Terrenos obterArvore() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Arvore) {
                return (Arvore) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Arvore nao encontrado no array.");
    }
    /*
     * obtem a letra conrrespondente a Terra,apartir do array
     */
    public String obterLetraTerra() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Terra) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Terra nao encontrado no array.");
    }
    /*
     * obtem a letra conrrespondente a Planicie,apartir do array
     */
    public String obterLetraPlanicie() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Planicie) {
                return terreno.getLetra();
            }
        }
        throw new IllegalStateException("Terreno do tipo Planicie nao encontrado no array.");
    }
     /*
     * obter o terreno que conrresponde a Planicie
     */
    public Terrenos obterPlanicie() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Planicie) {
                return (Planicie) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Planicie nao encontrado no array.");
    }
     /*
     * obter o terreno que conrresponde a Terra
     */
    public Terrenos obterTerra() {
        for (Terrenos terreno : ter) {
            if (terreno instanceof Terra) {
                return (Terra) terreno;
            }
        }
        throw new IllegalStateException("Terreno do tipo Planicie nao encontrado no array.");
    }
    /*
     * obtem a letra conrrespondente a estrutura,apartir do array
     */
    public boolean buscar_estrutura_letra(String letra){
        for(Estrutura est: es){
            if(est.getLetra().equals(letra)){
                return true;
            }
        }
        return false;
    }
    
}
