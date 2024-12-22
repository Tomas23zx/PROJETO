/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Construtor extends Unidades {
    private Mapa mapa;
    private static int conta;
    private Cidade city;

    
    public Construtor(String letra,Mapa mapa,int idCivilizacao,int vida) {
        super(letra, 0, 0,idCivilizacao,vida);
        this.mapa=mapa;
        conta++; 
        
    }
//
    
    public Construtor(String letra, int linha, int coluna,Mapa mapa,int idCivilizacao,int vida) {
        super(letra, linha, coluna,idCivilizacao,vida); 
        this.mapa = mapa;
        conta++;
    }
      public static int getConta(){return conta;}

     @Override
    public String getCodigo(){
        return getLetra()+getConta();
    }
    
     
    @Override
    public void mover(char direcao, Mapa map) {
        int novaLinha = getLinha();
        int novaColuna = getColuna();

        switch (direcao) {
            case 'N' -> novaLinha--;
            case 'S' -> novaLinha++;
            case 'E' -> novaColuna++;
            case 'O' -> novaColuna--;
            default -> {
                System.out.println("Direção inválida! Use N, E, S ou O.");
                return;
            }
        }

        map.moverUnidade(this, novaLinha, novaColuna);
    }
@Override
public void funcionalidade(Civilizacao civi) {
    /*
            
        
        if (this.city != null) {
            
            if (this.getLinha() == city.getPosX() && this.getColuna() == city.getPosY()) {
               
                city.upgrade();

                
                mapa.meterCidade(getLinha(), getColuna());

                System.out.println("Cidade " + city.getLetra() + " foi upada!");
            } else {
                System.out.println("O construtor não está na cidade, não pode upar.");
            }
        } else {
            System.out.println("Cidade não definida para o construtor.");
        }
*/
    }
    
    
}
