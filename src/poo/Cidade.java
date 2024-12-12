
package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
//
public class Cidade {
    private String letra;
    private int posX;
    private int posY;
    private TreeMap<String, Unidades> un;
    private ArrayList<Recursos> re;
    private int nivel;
    private int idCivilizacao; 

    public Cidade(String letra, int posX, int posY, int idCivilizacao, int comidaInicial, int limiteReserva, int populacaoInicial, int producaoInicial, int ouroInicial) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        this.idCivilizacao = idCivilizacao; 
        this.un = new TreeMap<>();
        this.re = new ArrayList<>();
        this.nivel = 1;

        // Inicializa os recursos.
        re.add(new Comida(comidaInicial, limiteReserva, populacaoInicial));
        re.add(new Producao(producaoInicial));
        re.add(new Ouro(ouroInicial));
    }

    public Cidade(String letra, int posX, int posY, int idCivilizacao) {
        this(letra, posX, posY, idCivilizacao, 100, 200, 1, 50, 100); 
    }

    public Cidade(String letra, int idCivilizacao) {
        this(letra, 0, 0, idCivilizacao, 100, 200, 1, 50, 100);
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

    public Recursos getRecurso(Recursos recurso) {
        for (Recursos r : re) {
            if (r.getClass().equals(recurso.getClass())) {
                return r;
            }
        }
        return null; 
    }

    public void adicionarRecurso(Recursos recurso, int quantidade) {
    Recursos r = getRecurso(recurso);
        if (r != null) {
            r.adicionar(quantidade); 
        } else {
            System.out.println("Recurso não encontrado!");
        }
    }

    public void consumirRecurso(Recursos recurso, int quantidade) {
        Recursos r = getRecurso(recurso); 
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

    public String toString(){

        return "Cidades: " + getCodigo();
    }
}
