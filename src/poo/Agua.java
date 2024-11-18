/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Agua extends Inacessivel {

    public Agua() {
        super("~"); 
    }

    @Override
    public String toString() {
        return "" + getLetra();
    }
}