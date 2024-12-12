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
    ///
    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("Civilização: " + nome + "\nCidades:\n");
        for (Cidade c : citys) {
            texto.append(c.toString()).append("\n");
        }
        return texto.toString();
    }
}
