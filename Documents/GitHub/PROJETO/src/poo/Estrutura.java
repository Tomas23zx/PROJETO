package poo;

import static poo.Unidades.getConta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ramnu
 */
public class Estrutura {
    private String letra;
    private int linha;
    private int coluna;
    private int idCivilizacao;
    
    public Estrutura(String letra,int idCivilizacao) {  
        this.letra = letra;
        this.linha = 0;
        this.coluna = 0;
        this.idCivilizacao=idCivilizacao;
    }
    public String getLetra() {
        return letra;
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
        return getLetra();
    }
    

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

}

