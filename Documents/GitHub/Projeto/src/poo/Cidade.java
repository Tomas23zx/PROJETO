
package poo;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import poo.Recursos;
//
public class Cidade {
    private String letra;
    private int posX;
    private int posY;
    private TreeMap<String, Unidades> un;
    private ArrayList<Recursos> re;
    private int nivel;
    private int idCivilizacao; 

    public Cidade(String letra, int posX, int posY, int idCivilizacao) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        this.idCivilizacao = idCivilizacao; 
        this.un = new TreeMap<>();
        this.re = new ArrayList<>();
        this.nivel = 1;
        int limiteReserva=200;
        Random random = new Random();
        int randomInt = random.nextInt(1000);
        int qntComida = random.nextInt(1000);
        int qntProducao = random.nextInt(1000);
        int populacaoInicial = random.nextInt(1000);
        // Inicializa os recursos.
        re.add(new Comida(qntComida, limiteReserva, populacaoInicial));
        re.add(new Producao(qntProducao));
        re.add(new Ouro(randomInt));
    }

    public Cidade(String letra, int idCivilizacao) {
        this(letra, 0, 0, idCivilizacao);
    }

    public String getLetra() {
        return letra;
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
    
    @Override
    public String toString(){

        return "Cidades: " + getCodigo();
    }
}