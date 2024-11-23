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

    public String getLetra() {
        return letra;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
   
}
