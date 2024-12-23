package poo;

import java.util.ArrayList;
import java.util.Scanner;

public class Civilizacao {
    private ArrayList<Cidade> citys;
    private String nome;
    private int idCivilizacao; 

    public Civilizacao(String nome, int idCivilizacao) {
        this.nome = nome;
        this.idCivilizacao = idCivilizacao;
        citys = new ArrayList<>();
    }
//
    public String getNome() {
        return nome;
    }

    public void adicionaCidade(Cidade c) {
        
        citys.add(c);
    }

    public int getId(){
        return idCivilizacao;
    }

    public void removerCidade(Cidade c) {
        citys.remove(c);
    }
    
    public ArrayList<Cidade> getCidades(){
        return new ArrayList<Cidade>(citys);
    }
   public Cidade getCidade(int i) {
    return citys.get(i); 
}


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

    ///
    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("Civilização: " + nome + "\nCidades:\n");
        for (Cidade c : citys) {
            texto.append(c.toString()).append("\n");
        }
        return texto.toString();
    }

    public Cidade buscarCidadePorCoordenada(int x, int y) {
        for (Cidade cidade : citys) {
            if (cidade.getPosX() == x && cidade.getPosY() == y) {
                return cidade;
            }
        }
        return null;
    }
    public boolean existeCidadeNaCoordenada(int x, int y) {
        return buscarCidadePorCoordenada(x, y) != null;
    }

    public int numero_de_cidade(){
        return citys.size();
    }

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
