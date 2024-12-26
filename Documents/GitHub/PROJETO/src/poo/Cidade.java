
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
    private int nivel;
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

    public Cidade(String letra, int posX, int posY, int idCivilizacao,int populacaoInicial) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        this.idCivilizacao = idCivilizacao; 
        this.populacaoInicial=populacaoInicial;
        this.un = new TreeMap<>();
        this.re = new ArrayList<>();
        this.nivel = 1;
        this.reserva=0;
        this.comida_consumida=0;
        this.comida_produzida=0;
        this.ouro_produzido=0;
        this.valor_consumido_reserva=0;
        this.valor_produzido_reserva=0;
        this.consumoTotalPopulacao=0;
        
       
        
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

    public String getLetra() {
        return letra;
    }
    
    public void Atacar(Cidade c){
        int probGanhar = random.nextInt(3);
        System.out.println(" ");
        switch(probGanhar){
            case 0: 
                System.out.println("Ganhaste esta batalha!");
                
                break;
            case 1:
                Recursos o =c.findRecurso(new Ouro(0));
                int qnt=o.getQuantidade()/2;
                c.consumirRecurso(new Ouro(0),qnt);
                
                Recursos producao =c.findRecurso(new Producao(0));
                int qnt1=producao.getQuantidade()/2;
                c.consumirRecurso(new Producao(0),qnt1);
                
                Recursos comida =c.findRecurso(new Comida(0,0));
                int qnt2=comida.getQuantidade()/2;
                c.consumirRecurso(new Comida(0,0),qnt2);
                
                System.out.println("Conseguiste escapar a tempo!");
                
                break;
            case 2:
                System.out.println("Perdeste esta batalha!");
                
                break;
        } 
    }
    public int getReserva(){
        return reserva;
    }
    public void setReserva(int x){
        this.reserva=x;
    }
    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setColuna(int y) {
        this.posY = y;
    }

    public void setLinha(int x) {
        this.posX = x;
    }
    public int getPopulacao(){
        return populacaoInicial;
    }
    public void  setPopulacao(int x){
        this.populacaoInicial=x;
    }
    public TreeMap<String, Unidades> getUnidades() {
        return new TreeMap<>(un);
    }

    public void insereUnidade(Unidades e) {
        un.put(e.getCodigo(), e);
    }

    public void removerUnidade(Unidades e) {
        un.remove(e.getCodigo());
    }

    public int numdeUnid() {
        return un.size();
    }

    public String getCodigo() {
        
        return  getLetra() + idCivilizacao;
    }
public int getId(){
    return idCivilizacao;
}
    public int quantidade_por_unidade() {
        int contador = 0;
        for (Unidades uni : un.values()) {
            contador += uni.getConta();
        }
        return contador;
    }

    public boolean existeTropa(String letra) {
        return un.containsKey(letra);
    }

    public List<String> listarCodigosUnidades() {
        return new ArrayList<>(un.keySet());
    }

    public TreeMap<String, Unidades> unidadesOrdenadas() {
        return new TreeMap<>(un);
    }

    public Unidades buscarUnidadePorCodigo(String codigo) {
        return un.getOrDefault(codigo, null);
    }

    public void listarDetalhesUnidades() {
        for (var entry : un.entrySet()) {
            System.out.println("Código: " + entry.getKey() + " - Unidade: " + entry.getValue().getLetra() +
                    " (Posição: " + entry.getValue().getLinha() + ", " + entry.getValue().getColuna() + ")");
        }
    }

    public String unidadeComCodigoMin() {
        return un.firstKey();
    }

    public String unidadeComCodigoMax() {
        return un.lastKey();
    }

    public List<String> listarLetrasUnidades() {
        List<String> letras = new ArrayList<>();
        for (Unidades unidade : un.values()) {
            letras.add(unidade.getLetra());
        }
        return letras;
    }

    public void upgrade() {
        this.nivel++;
        System.out.println("A cidade " + letra + " foi atualizada para o nível " + nivel);
    }

    public Recursos getRecursos() {
        for (Recursos r : re) {
            System.out.println(r);
        }
        return null; 
    }
    
    public Recursos findRecurso(Recursos recurso) {
        for (Recursos r : re) {
            if(r.getClass().equals(recurso.getClass())){
                return r;
                        }
        }
        return null; 
    }
    
    public void adicionarRecurso(Recursos recurso, int quantidade) {
    Recursos r = findRecurso(recurso);
        if (r != null) {
            r.adicionar(quantidade); 
        } else {
            System.out.println("Recurso não encontrado!");
        }
    }

    public void consumirRecurso(Recursos recurso, int quantidade) {
        Recursos r = findRecurso(recurso); 
        if (r != null) {
            r.consumir(quantidade); 
        } else {
            System.out.println("Recurso não encontrado ou insuficiente!");
        }
    }

    public void atualizarRecursos() {
        for (Recursos recurso : re) {
            recurso.atualizar();
        }
    }

    public void meterPessoas(Populacao po)
    {
        p.add(po);

    }

    public void removerPessoas(int pox)
    {
        p.remove(pox);

    }

    
    public List<Populacao> getPopulacoes() {
        return new ArrayList<>(this.p);
    }
    

    public Unidades buscarUnidadePorPosicao(int posX, int posY) {
        for (Unidades unidade : un.values()) {
            if (unidade.getLinha() == posX && unidade.getColuna() == posY) {
                return unidade;  
            }
        }
        return null;  
    }
    


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
    

public int tamanho_da_populacao(){
    return p.size();
}

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

public int getConsumoTotalPopulacao() {
    return consumoTotalPopulacao;
}
public void setConsumoTotalPopulacao(int x){
    this.consumoTotalPopulacao=x;
}




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


public void consumir_pessoas() {
    

    
        System.out.print(this.getCodigo() + " (" + this.getPosX() + "," + this.getPosY() + ") ");
        this.Populacao_consumir(); 
        comida_consumida += this.getConsumoTotalPopulacao();
        this.setConsumoTotalPopulacao(0); 
        System.out.println("Comida total consumida pela cidade: " + comida_consumida + " unidades.");
        valor_consumido_reserva=comida_consumida;
       
    

    comida_consumida=0;

}




public void meter_reserva() {
    
    int novaReserva = this.getReserva() +(valor_produzido_reserva-valor_consumido_reserva) ;
    this.setReserva(novaReserva);

    if (novaReserva >= 0) {
        System.out.print(this.getCodigo() + " (" + this.getPosX() + "," + this.getPosY() + ") ");
        System.out.println("Reserva atualizada para a cidade: " + novaReserva + " unidades.");
        System.out.println("Diferenca entre produzido e consumido"+ (valor_produzido_reserva-valor_consumido_reserva));
    } else {
        System.out.println("O valor da reserva ficara a 0");
        this.setReserva(0);

    }
    valor_produzido_reserva=0;
    valor_consumido_reserva=0;
}



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






    
    @Override
    public String toString(){

        return "Cidades: " + getCodigo();
    }
}