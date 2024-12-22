/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo;

/**
 *
 * @author joaot
 */
public class Colono extends Unidades {
    private Mapa mapa;
    private Civilizacao civi;
    
    private static int conta;
//
    
    public Colono(String letra,Mapa mapa,int idCivilizacao,int vida) {
        super(letra, 0, 0,idCivilizacao,vida);
        this.mapa=mapa;
        conta++; 
        
    }

    
    public Colono(String letra, int linha, int coluna,Mapa mapa,int idCivilizacao,int vida) {
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
    public  void funcionalidade(Civilizacao civi)
    {
        mapa.meterCidade(civi,getLinha(),getColuna());
        
        
    }
    
}
