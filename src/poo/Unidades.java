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

   
    public Unidades(String letra, int linha, int coluna) {
        this.letra = letra;
        this.linha = linha;
        this.coluna = coluna;
    }

    
    public String getLetra() {
        return letra;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
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
   // public abstract void funcionalidade();// militar atacar,construtor construir,coluno construir cidade, --
   // public abstract void renascer();// provavemente nao será preciso

}
