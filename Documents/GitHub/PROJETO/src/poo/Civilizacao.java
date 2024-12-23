package poo;

import java.util.ArrayList;

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

   
}
