package poo;

public class Populacao {
private int posX;
private int posY;


public Populacao(int posX,int posY)
{
    this.posX=posX;
    this.posY=posY;
}
public int getPox(){return posX;}
public int getPoy(){return posY;}
public void setPox(int x){this.posX=x;}
public void setPoy(int y){this.posY=y;}


public void letraAtribuida(Cidade city,String letra){
    if(letra.equalsIgnoreCase("X"))
    {
        Recursos recurso = new Ouro(0);
        city.adicionarRecurso(recurso, 5);
    }
    if(letra.equalsIgnoreCase("~"))
    {
        Recursos recurso = new Comida(0,0,0);
        city.adicionarRecurso(recurso, 5);

    }
    if(letra.equalsIgnoreCase("F"))
    {
        Recursos recurso = new Comida(0,0,0);
        city.adicionarRecurso(recurso, 5);
    }

}



}
