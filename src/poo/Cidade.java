package poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author joaot
 */
public class Cidade {
    private String letra;
    private int posX;
    private int posY;

    public Cidade(String letra, int posX, int posY) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
    }

    public Cidade(String letra) {
        this.letra = letra;
        this.posX = 0;
        this.posY = 0;
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

    public void setColuna(int y){this.posY=y;}
    public void setLinha(int x){this.posX=x;}

    
   
}
