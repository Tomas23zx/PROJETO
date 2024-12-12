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
//
   
    public Unidades(String letra) {  
        this.letra = letra;
        this.linha = 0;
        this.coluna = 0;
        conta=1;
    }

    public Unidades(String letra, int linha, int coluna) {
        this.letra = letra;
        this.linha = linha;
        this.coluna = coluna;
        conta++;
    }

    public static int getConta(){return conta;}

   

    
    public String getLetra() {
        return letra;
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

    
    public abstract void mover(char direcao);
    //public abstract void perderVida(); // ainda ns como vai ficar
   // public abstract void recuperarVida();// ainda ns tbm
    public abstract void funcionalidade(Civilizacao civi);// militar atacar,construtor construir,coluno construir cidade, --
   // public abstract void renascer();// provavemente nao será preciso

}
