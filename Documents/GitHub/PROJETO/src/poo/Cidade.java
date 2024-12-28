
package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
//
public class Cidade {
    Random random = new Random();
    private String letra;
    private int posX;
    private int posY;
    private TreeMap<String, Unidades> un;
    private ArrayList<Recursos> re;
    private ArrayList<String> ligacoes;
    private int idCivilizacao; 
    private int populacaoInicial;
    private int reserva;
    private int consumoTotalPopulacao;
    private ArrayList<Populacao> p;
    private int comida_consumida;
    private int comida_produzida;
    private int ouro_produzido;
    private int valor_produzido_reserva;
    private int valor_consumido_reserva;
    private int defesa;

    private static final String NEGRITO = "\033[1m";
    private static final String RESET = "\033[0m"; 
    public Cidade(String letra, int posX, int posY, int idCivilizacao,int populacaoInicial) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        this.ligacoes = new ArrayList<>();
        this.idCivilizacao = idCivilizacao; 
        this.populacaoInicial=populacaoInicial;
        this.un = new TreeMap<>();
        this.re = new ArrayList<>();
        this.reserva=0;
        this.comida_consumida=0;
        this.comida_produzida=0;
        this.ouro_produzido=0;
        this.valor_consumido_reserva=0;
        this.valor_produzido_reserva=0;
        this.consumoTotalPopulacao=0;
        this.defesa=0;
        
       
        
        int randomInt = random.nextInt(1000);
        int qntComida = random.nextInt(1000);
        int qntProducao = 0;
        this.p=new ArrayList<Populacao>();
        
        re.add(new Comida(qntComida,populacaoInicial));
        re.add(new Producao(qntProducao));
        re.add(new Ouro(randomInt));
    }

    public Cidade(String letra, int idCivilizacao,int populacaoInicial) {
        this(letra, 0, 0, idCivilizacao,populacaoInicial);
    }
    /*
    *  retorna todas as ligações entre cidades num array
    */
    public ArrayList<String> getLigacoes() {
        return ligacoes;
    }
     /*
    *  retorna todas a letra da cidade com a respetiva cor
    */
    public String getLetra() {
        return NEGRITO + letra + RESET;
    }

      /*
    *  adiciona uma ligação
    */
    public void addLigacao(String codigo){
        ligacoes.add(codigo);
    }
      /*
    *  retorna o valor de reserva
    */
   
    public int getReserva(){
        return reserva;
    }
      /*
    *  permite mudar o valor da reserva
    */
    public void setReserva(int x){
        this.reserva=x;
    }
     /*
    *  retorna  o valor da posição X
    */
    
    public int getPosX() {
        return posX;
    }
     /*
    *  retorna  o valor da posição Y
    */

    public int getPosY() {
        return posY;
    }
     /*
    *  permite mudar o valor da posicao Y
    */

    public void setColuna(int y) {
        this.posY = y;
    }
     /*
    *  permite mudar o valor da posicao x
    */

    public void setLinha(int x) {
        this.posX = x;
    }
     /*
    *  retorn o valor da populacao
    */
    public int getPopulacao(){
        return populacaoInicial;
    }
     /*
    *  muda o valor da populacao
    */
    public void  setPopulacao(int x){
        this.populacaoInicial=x;
    }
     /*
    *  retorna uma copia do treeMap de unidades
    */
    public TreeMap<String, Unidades> getUnidades() {
        return new TreeMap<>(un);
    }
     /*
    *  insere unidades no treemap
    */

    public void insereUnidade(Unidades e) {
        un.put(e.getCodigo(), e);
    }
     /*
    *  remove unidades no treemap
    */

    public void removerUnidade(Unidades e) {
        un.remove(e.getCodigo());
    }
     /*
    *  retorna o tamanhanho do treemap de unidades
    */

    public int numdeUnid() {
        if(un!=null){
            return un.size();
        }
        return 0;
    }
     /*
    * retorna o numero de defesa da cidade
    */
    public int getDefesa(){
        return defesa;
    }
     /*
    * mudar o valor da defesa
    */
    
    public void setDefesa(int x){
        this.defesa=defesa;
    }
     /*
    * calcula o valor da defesa apartir de um random
    */
    public void CalcularDefesa() {
        Random rand = new Random();
        int x = rand.nextInt(50);
        defesa = x; 
    }

 /*
    * retorna o codigo
    */

    public String getCodigo() {
        
        return  getLetra() + idCivilizacao;
    }
     /*
    * retorna o id
    */
public int getId(){
    return idCivilizacao;
}

 /*
    * retorna o o numero de unidades por unidade
    */
    public int quantidade_por_unidade() {
        int contador = 0;
        for (Unidades uni : un.values()) {
            contador += uni.getConta();
        }
        return contador;
    }
 /*
    * verifica se uma determinada tropa existe no treemap apartir  da letra(ex:M1)
    */
    public boolean existeTropa(String letra) {
        return un.containsKey(letra);
    }
 /*
    * retorna uma copia das chaves do treemap de unidades
    */   
    
    public List<String> listarCodigosUnidades() {
        return new ArrayList<>(un.keySet());
    }
 /*
    * retorna uma copia ordenada do treemap de unidades
    */ 

    public TreeMap<String, Unidades> unidadesOrdenadas() {
        return new TreeMap<>(un);
    }
    /*
    * retorna a unidade pelo seu codigo
    */ 

    public Unidades buscarUnidadePorCodigo(String codigo) {
        return un.getOrDefault(codigo, null);
    }
    
 /*
    * aparece as informações do treemap de unidades como seu codigo e posicoes
    */ 

    public void listarDetalhesUnidades() {
        for (var entry : un.entrySet()) {
            System.out.println("Código: " + entry.getKey() + " - Unidade: " + entry.getValue().getLetra() +
                    " (Posição: " + entry.getValue().getLinha() + ", " + entry.getValue().getColuna() + ")");
        }
    }
    /*
    * retorna o primeiro codigo
    */ 

    public String unidadeComCodigoMin() {
        return un.firstKey();
    }
    /*
    * retorna o ultimo codigo
    */ 

    public String unidadeComCodigoMax() {
        return un.lastKey();
    }
    /*
    * cria uma lista com as letras de cada unidade no treemap
    */ 

    public List<String> listarLetrasUnidades() {
        List<String> letras = new ArrayList<>();
        for (Unidades unidade : un.values()) {
            letras.add(unidade.getLetra());
        }
        return letras;
    }
/*
    * da print dos valores dos recursso do array
    */ 
    public Recursos getRecursos() {
        for (Recursos r : re) {
            System.out.println(r);
        }
        return null; 
    }
    /*
    * procura um determinado tipo de recurso
    */ 
    
    public Recursos findRecurso(Recursos recurso) {
        for (Recursos r : re) {
            if(r.getClass().equals(recurso.getClass())){
                return r;
                        }
        }
        return null; 
    }
    /*
    * adiciona recursos
    */ 
    
    public void adicionarRecurso(Recursos recurso, int quantidade) {
    Recursos r = findRecurso(recurso);
        if (r != null) {
            r.adicionar(quantidade); 
        } else {
            System.out.println("Recurso não encontrado!");
        }
    }
    /*
    * tira uma certa quantidade de um tipo de recurso
    */ 
    

    public void consumirRecurso(Recursos recurso, int quantidade) {
        Recursos r = findRecurso(recurso); 
        if (r != null) {
            r.consumir(quantidade); 
        } else {
            System.out.println("Recurso não encontrado ou insuficiente!");
        }
    }
    /*
    * atualiza os valores do recurso
    */ 
    

    public void atualizarRecursos() {
        for (Recursos recurso : re) {
            recurso.atualizar();
        }
    }
    /*
    * adiciona pessoas
    */ 
    
    public void meterPessoas(Populacao po)
    {
        p.add(po);

    }
      /*
    * remove pessoas
    */

    public void removerPessoas(int pox)
    {
        p.remove(pox);

    }
  /*
    * retorna uma copia do array de populacoes
    */
    
    public List<Populacao> getPopulacoes() {
        return new ArrayList<>(this.p);
    }
    /*
    * procura unidade no treemap a partir da sua posicao no mapa
    */
    

    public Unidades buscarUnidadePorPosicao(int posX, int posY) {
        for (Unidades unidade : un.values()) {
            if (unidade.getLinha() == posX && unidade.getColuna() == posY) {
                return unidade;  
            }
        }
        return null;  
    }
    
    /*
    * remove unidade no treemap a partir da sua posicao no mapa
    */

    public Unidades removerUnidadePorPosicao(int posX, int posY) {
        for (var entry : un.entrySet()) {
            Unidades unidade = entry.getValue();  
            if (unidade.getLinha() == posX && unidade.getColuna() == posY) {
                un.remove(entry.getKey());
                return unidade;  
            }
        }
        return null;  
    }
    
    /*
    * retorna o tanho da populaçao
    */
public int tamanho_da_populacao(){
    return p.size();
}
/*
    * calcula um valor fixo de acordo com o tamanho dos militares,por explo se tiver apenas duas tropas de militares vai me retornar 20,que depois ira mais a frente pagar 20 de ouro
    */

public int manutencao_das_unidades() {
    int conta = 0;
    if (un.size() == 0) {
        return conta;
    } else {
        for (Unidades unidade : un.values()) {
            if (unidade instanceof Militares) { 
                conta++;
            }
        }
        return conta * 10; 
    }
}

/*
    * cada pessoa na cidade consumo 5 de comida
    */

public void Populacao_consumir() {
    Recursos comida = findRecurso(new Comida(0, 0));
    
    if (comida != null) {
        
        consumoTotalPopulacao = populacaoInicial * 5;

        
        if (comida.getQuantidade() >= consumoTotalPopulacao) {
            
            consumirRecurso(new Comida(0,0), consumoTotalPopulacao);
            System.out.println("População consumiu " + consumoTotalPopulacao + " unidades de comida.");
        } else {
            System.out.println("Recursos de comida insuficientes! Apenas " + comida.getQuantidade() + " disponíveis.");
        }
    } else {
        System.out.println("Recurso de comida nao encontrado!");
    }
}
/*
    * retorna o consumo total
    */

public int getConsumoTotalPopulacao() {
    return consumoTotalPopulacao;
}
    /*
    * muda o valor
    */
public void setConsumoTotalPopulacao(int x){
    this.consumoTotalPopulacao=x;
}


/*
    *a cada pessoa alocada no array e  no mapa ira prodizir de acordo com a letra no mapa
    */

public void produzir(Mapa mapa) {
    if (this.getPopulacoes().isEmpty()) {
        System.out.println("A cidade " + this.getCodigo() + " nao tem populacao alocada.");
        return; 
    }

    String[][] mapaArray = mapa.getMapa(); 
    

    for (Populacao populacao : this.getPopulacoes()) {
        int posX = populacao.getPox();
        int posY = populacao.getPoy();

       
        if (posX >= 0 && posX < mapaArray.length && posY >= 0 && posY < mapaArray[0].length) {
            String letraMapa = mapaArray[posX][posY];

           
            populacao.letraAtribuida(this, letraMapa, mapa);

            
            comida_produzida += populacao.getComidaTotalProduzida();
            ouro_produzido+= populacao.getOuroproduzido();
            
        } else {
            System.out.println("Posicao fora dos limites do mapa: (" + posX + ", " + posY + ")");
        }
        populacao.setComidaTotalProduzida(0);
        populacao.setOuroproduzido(0);
        
    }
    System.out.print(this.getCodigo() + " (" + this.getPosX() + "," + this.getPosY() + ") ");
    System.out.println("A quantidade de comida produzida foi: " + comida_produzida);
    System.out.println("A quantidade de ouro produzida foi: " + ouro_produzido);
    valor_produzido_reserva=comida_produzida;
    comida_produzida=0;
    ouro_produzido=0;
}
    /*
    *as pessoas comem comida e guarda uma copia na variavel globas valor_consumido_reserva, e reinicia a a variavel comida_consumida
    */

public void consumir_pessoas() {
    

    
        System.out.print(this.getCodigo() + " (" + this.getPosX() + "," + this.getPosY() + ") ");
        this.Populacao_consumir(); 
        comida_consumida += this.getConsumoTotalPopulacao();
        this.setConsumoTotalPopulacao(0); 
        System.out.println("Comida total consumida pela cidade: " + comida_consumida + " unidades.");
        valor_consumido_reserva=comida_consumida;
       
    

    comida_consumida=0;

}

    /*
    *Calcula o valor da reserva, muda seu valor,caso seja 0 mantem
    */


public void meter_reserva() {
    
    int novaReserva = this.getReserva() +(valor_produzido_reserva-valor_consumido_reserva) ;
    this.setReserva(novaReserva);

    if (novaReserva >= 0) {
        System.out.print(this.getCodigo() + " (" + this.getPosX() + "," + this.getPosY() + ") ");
        System.out.println("Reserva atualizada para a cidade: " + novaReserva + " unidades.");
        System.out.println("Diferenca entre produzido e consumido: "+ (valor_produzido_reserva-valor_consumido_reserva));
    } else {
        System.out.println("O valor da reserva ficara a 0");
        this.setReserva(0);

    }
    valor_produzido_reserva=0;
    valor_consumido_reserva=0;
}

     /*
    *faz o aumento da população  ao ultrapassar certo limite coloca o resto que sobrou na reserva e aumenta a população em um
    */

public void aumentar_populacao() {    
    int limiteSuperior =500;   
    if (reserva > limiteSuperior) {     
        int excedente = reserva - limiteSuperior;
        populacaoInicial += 1;

        reserva = excedente;

        System.out.println("A populacao foi aumentada para " + populacaoInicial +
                           " e a nova reserva e " + reserva);
    } else {
       
    }
}
    /*
    *remove todas as unidades da cidade
    */

public void removerTodasUnidades() {
    if (un.isEmpty()) {
        System.out.println("Não há unidades para remover.");
    } else {
        int quantidadeRemovida = un.size();
        un.clear(); 
        System.out.println("Todas as " + quantidadeRemovida + " unidades foram removidas da cidade " + getCodigo() + ".");
    }
}
    /*
    *remove uma pessoa aleatoria do array ou da populacao inicial,qquandoa reserva é 0
    */
public void remover_pessoa_aleatoria() {
    if (p.isEmpty()) {
        System.out.println("Não há pessoas para remover.");
        return;
    }
    int indiceAleatorio = random.nextInt(p.size()); 
    Populacao pessoaRemovida = p.remove(indiceAleatorio); 
    System.out.println("Uma pessoa foi removida aleatoriamente:");
}



    /*
    *verifica a reserva se for 0 e nao houver pessoas alocadas tira da populacao se ouver tira do array
    */

public void verifica_reserva() {
    if (getReserva() == 0) {
        if (p.isEmpty()|| p.size()==0) {
            setPopulacao(getPopulacao() - 1);
            System.out.println("População total da cidade foi reduzida para: " + getPopulacao());
        } else {
            remover_pessoa_aleatoria(); 
        }
    }
}

/*
 * toString
 */

    
    @Override
    public String toString(){

        return "Cidades: " + getCodigo();
    }
}