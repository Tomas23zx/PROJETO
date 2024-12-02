package poo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Cidade {
    private String letra;
    private int posX;
    private int posY;
    private TreeMap<String, Unidades> un;
     private int nivel; 

    public Cidade(String letra, int posX, int posY) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        un = new TreeMap<>();
        this.nivel=1;
    }

    public Cidade(String letra) {
        this(letra, 0, 0);
        this.nivel=1;
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
        for (Map.Entry<String, Unidades> entry : un.entrySet()) {
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

}
