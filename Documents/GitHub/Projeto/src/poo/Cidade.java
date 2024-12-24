
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
    private ArrayList<Populacao> p;

    public Cidade(String letra, int posX, int posY, int idCivilizacao,int populacaoInicial) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        this.idCivilizacao = idCivilizacao; 
        this.populacaoInicial=populacaoInicial;
        this.un = new TreeMap<>();
        this.re = new ArrayList<>();
        this.nivel = 1;
        
        int limiteReserva=200;
        
        int randomInt = random.nextInt(1000);
        int qntComida = random.nextInt(1000);
        int qntProducao = 0;
        this.p=new ArrayList<Populacao>();
        
        re.add(new Comida(qntComida, limiteReserva, populacaoInicial));
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
                
                Recursos comida =c.findRecurso(new Comida(0,0,0));
                int qnt2=comida.getQuantidade()/2;
                c.consumirRecurso(new Comida(0,0,0),qnt2);
                
                System.out.println("Conseguiste escapar a tempo!");
                
                break;
            case 2:
                System.out.println("Perdeste esta batalha!");
                
                break;
        } 
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
        return conta * 100; 
    }
}



    
    @Override
    public String toString(){

        return "Cidades: " + getCodigo();
    }
}