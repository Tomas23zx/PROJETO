package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Civilizacao {
    private ArrayList<Cidade> citys;
    private String nome;
    private int idCivilizacao; 
    private ArrayList<Estrutura>estt;

    public Civilizacao(String nome, int idCivilizacao) {
        this.nome = nome;
        this.idCivilizacao = idCivilizacao;
        this.estt=new ArrayList<Estrutura>();
        citys = new ArrayList<>();
    }
//GETRS SETRS
    public String getNome() {
        return nome;
    }
    public void adicionaEstrutura(Estrutura est){
        estt.add(est);
    }
    public void adicionaCidade(Cidade c) {
        
        citys.add(c);
    }
    public ArrayList<Estrutura> getEstruturas(){
        return estt;
    }
    public int getId(){
        return idCivilizacao;
    }
    /*
     * remove uma cidade do array de cidades da civilização
    */
    public void removerCidade(Cidade c) {
        citys.remove(c);
    }
    /*
     * retorna uma copia do array de cidades
    */
    
    public ArrayList<Cidade> getCidades(){
        return new ArrayList<Cidade>(citys);
    }
     /*
     *vai biscar a cidade ao array com aquele indice
    */
   public Cidade getCidade(int i) {
    return citys.get(i); 
}
    /*
     * soma todos os recurssos das cidades,se receber o ouro forma o tesouro da civilização
    */

public int Total_Recurssos(Recursos tipoRecurso, Civilizacao civ) { 
    int totalRecursos = 0;
    for (Cidade cidade : civ.getCidades()) {
        Recursos recurso = cidade.findRecurso(tipoRecurso);
        if (recurso != null) {
            totalRecursos += recurso.getQuantidade();
        }
    }
    return totalRecursos;
}
/*
     * adiciona 5 a todas as cidades da civilização
    */
public void atualizarRecurssos(Recursos tipoRecurso, Civilizacao civ) { 
    
    for (Cidade cidade : civ.getCidades()) {
        
            cidade.findRecurso(tipoRecurso).adicionar(5);
        
    }
}
/*
     * toString
    */
    
    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("Civilização: " + nome + "\nCidades:\n");
        for (Cidade c : citys) { 
        texto.append(c.toString()) 
             .append(" (PosX: ").append(c.getPosX())
             .append(", PosY: ").append(c.getPosY())
             .append(")\n"); 
    }
        return texto.toString();
    }
    /*
     * retorna a cidade que esta naquela posição
    */

    public Cidade buscarCidadePorCoordenada(int x, int y) {
        for (Cidade cidade : citys) {
            if (cidade.getPosX() == x && cidade.getPosY() == y) {
                return cidade;
            }
        }
        return null;
    }
    /*
     * verifica se esxiste uma cidade naquela posição
    */
    public boolean existeCidadeNaCoordenada(int x, int y) {
        return buscarCidadePorCoordenada(x, y) != null;
    }
    /*
     * retorna o tamanho do array de cidades
    */

    public int numero_de_cidade(){
        return citys.size();
    }
/*
     * pede ao utilizador para escolher uma cidade
    */
    public void escolherCidades() {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.println("Escolha duas cidades da lista abaixo:");
        for (int i = 0; i < citys.size(); i++) {
            System.out.println(i + ": " + citys.get(i).getCodigo()+" ( " +citys.get(i).getPosX()+" ,"+citys.get(i).getPosY() + ")" );
        }

        
        System.out.print("Escolha o número da primeira cidade: ");
        int indiceCidade1 = scanner.nextInt();
        Cidade cidade1 = citys.get(indiceCidade1);

        
        System.out.print("Escolha o número da segunda cidade: ");
        int indiceCidade2 = scanner.nextInt();
        Cidade cidade2 = citys.get(indiceCidade2);

        
        System.out.println("Voce escolheu as cidades:");
        System.out.println("Cidade 1: " + cidade1.getCodigo() + " Posicao: (" + cidade1.getPosX() + " ,"+cidade1.getPosY()+" )" );
        System.out.println("Cidade 2: " + cidade2.getCodigo() + " Posicao: (" + cidade2.getPosX() + ", "+cidade2.getPosY()+" )" );
    }

   
}
