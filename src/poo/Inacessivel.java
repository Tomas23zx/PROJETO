/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Inacessivel extends Terrenos {

    
    public Inacessivel(String letra) {
        super(letra);
    }

  @Override
    public String toString() {
        return "" + getLetra();
    }
}
