package poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaot
 */
public abstract class Terrenos {
    private String letra;
    private int tamanho;

    // Construtor principal
    public Terrenos(String letra, int tamanho) {
        this.letra = letra;
        this.tamanho = tamanho;
    }

  //  
    public Terrenos(String letra) {
        this(letra, 0); 
    }

    // Getters e Setters
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }


    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    


    public abstract char[] criarArray(int tamanho);
    //public abstract void permiteandar();
    public abstract boolean vantagem(Unidades un);
    public abstract void custo_para_mover(Cidade cidade);

}
