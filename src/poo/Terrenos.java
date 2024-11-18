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

   
    public Terrenos(String letra) {
        this.letra = letra;
    }

    
    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    
    public abstract String toString();
}
