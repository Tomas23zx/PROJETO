package poo;

public class Populacao {
private int posX;
private int posY;
private Mapa map;


public Populacao(int posX,int posY,Mapa map)
{
    this.posX=posX;
    this.posY=posY;
    this.map=map;
}
public int getPox(){return posX;}
public int getPoy(){return posY;}
public void setPox(int x){this.posX=x;}
public void setPoy(int y){this.posY=y;}


public void letraAtribuida(Cidade city,String letra,Mapa map){
    if(letra.equalsIgnoreCase("X"))
    {
        Recursos recurso = new Comida(0,0,0);
        city.adicionarRecurso(recurso, 4000000);
    }
    if(letra.equalsIgnoreCase(map.obterLetraAgua()))
    {
        Recursos recurso = new Ouro(0);
        city.adicionarRecurso(recurso, 5);

    }
    if(letra.equalsIgnoreCase(map.obterLetraArvore()))
    {
        Recursos recurso = new Comida(0,0,0);
        city.adicionarRecurso(recurso, 5);
    }
    if(letra.equalsIgnoreCase(map.obterLetraPlanicie()))
    {
        Recursos recurso = new Comida(0,0,0);
        city.adicionarRecurso(recurso, 5);
    }

}



}
