package poo;


import java.util.TreeMap;
import java.util.TreeSet;

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
    private TreeMap<String,Unidades> un;
    

    public Cidade(String letra, int posX, int posY) {
        this.letra = letra;
        this.posX = posX;
        this.posY = posY;
        un= new TreeMap<String,Unidades>();
        
    }

    public Cidade(String letra) {
        this.letra = letra;
        this.posX = 0;
        this.posY = 0;
        un= new TreeMap<String,Unidades>();
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

    public TreeMap<String, Unidades> getUnidades(){
        return new TreeMap<String,Unidades>(un);
    }
    public void insereUnidade(Unidades e){
        un.put(e.getLetra(), e);
    }
    public void removerUnidade(Unidades e){
        un.remove(e.getLetra());

    }
    public int numdeUnid(){
        return un.size();
    }
    public int quantidade_por_unidade(){
        int contador=0;
        for(Unidades uni : un.values()){
            contador+=uni.getConta();
        }
        return contador;
    }

    public boolean existeTropa(String letra){
       return un.containsKey(letra);
    }
    

    
   
}
