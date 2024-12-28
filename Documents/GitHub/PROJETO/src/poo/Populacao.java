package poo;

public class Populacao {
private int posX;
private int posY;
private Mapa map;
private int comidaTotalProduzida;
private int totaldeOuroProduzido;


public Populacao(int posX,int posY,Mapa map)
{
    this.posX=posX;
    this.posY=posY;
    this.map=map;
    this.comidaTotalProduzida = 0;
    this.totaldeOuroProduzido=0;
}
//Getrs setrs
public int getPox(){return posX;}
public int getPoy(){return posY;}
public void setPox(int x){this.posX=x;}
public void setPoy(int y){this.posY=y;}

/*
 * recebe a letra atribuida e produz de acordo com essa letra do mapa produzindo ou ouro ou comida,para isso recebe o mapa para obter essas letras 
 */

public void letraAtribuida(Cidade city, String letra, Mapa map) {
    if (letra.equalsIgnoreCase(map.obterLetraTerra())) {
        Recursos recurso = new Comida(0,0);
        city.adicionarRecurso(recurso, 100);
        this.comidaTotalProduzida += 100; 
        Recursos recursos = new Ouro(0);
        city.adicionarRecurso(recursos, 50);
        this.totaldeOuroProduzido+=50;
    }
    if (letra.equalsIgnoreCase(map.obterLetraAgua())) {
        Recursos recurso = new Ouro(0);
        city.adicionarRecurso(recurso, 100);
        this.totaldeOuroProduzido+=100;
    }
    if (letra.equalsIgnoreCase(map.obterLetraArvore())) {
        Recursos recurso = new Comida(0,  0);
        city.adicionarRecurso(recurso, 100);
        this.comidaTotalProduzida += 100; 
    }
    if (letra.equalsIgnoreCase(map.obterLetraPlanicie())) {
        Recursos recurso = new Comida(0,  0);
        city.adicionarRecurso(recurso, 100);
        this.comidaTotalProduzida += 100;
    }
}
//Getrs setrs

public int getComidaTotalProduzida() {
    return comidaTotalProduzida;
}
public void setComidaTotalProduzida(int x){
    this.comidaTotalProduzida=x;
}

public int getOuroproduzido(){
    return totaldeOuroProduzido;
}

public void setOuroproduzido(int x){
    this.totaldeOuroProduzido=x;
}

}
