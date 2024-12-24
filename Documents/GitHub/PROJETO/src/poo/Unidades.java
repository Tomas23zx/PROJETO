/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DOIT
 */
package poo;

public abstract class Unidades {
    private String letra;
    private int linha;
    private int coluna;
    private static int conta;
    private int idCivilizacao;
    private int vida;
//
   
    public Unidades(String letra,int idCivilizacao,int vida) {  
        this.letra = letra;
        this.linha = 0;
        this.coluna = 0;
        this.idCivilizacao=idCivilizacao;
        this.vida=vida;

        conta=1;
    }

    public Unidades(String letra, int linha, int coluna,int idCivilizacao,int vida) {
        this.letra = letra;
        this.linha = linha;
        this.coluna = coluna;
        this.idCivilizacao=idCivilizacao;
        this.vida=vida;
        conta++;
    }

    public static int getConta(){return conta;}

   

    
    public String getLetra() {
        return letra;
    }
    public int getVida() {
        return vida;
    }
   public void setVida(int x){
    this.vida=x;
   }
    public int getId(){
        return idCivilizacao;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getCodigo(){
        return getLetra()+getConta();
    }
    

    
    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    
    public abstract  void mover(char direcao, Mapa mapa,Unidades escolhida,String codigo);
    public abstract void morrer(Cidade city,Mapa map);
    //public abstract void perderVida(); // ainda ns como vai ficar
   // public abstract void recuperarVida();// ainda ns tbm
    public abstract void funcionalidade(Civilizacao civi,Mapa map);// militar atacar,construtor construir,coluno construir cidade, --
   // public abstract void renascer();// provavemente nao será preciso

}
