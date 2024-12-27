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
    public void mover(char direcao, Mapa map,Unidades escolhida,String codigo) {
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

        map.moverUnidade(escolhida, novaLinha, novaColuna,codigo);
    }

@Override
public void funcionalidade(Civilizacao civi,Mapa map) {


}
   

    @Override
    public void morrer(Cidade city, Mapa map) {
        if (this.getVida() == 0) {
            
            map.remover_do_mapa(getLinha(), getColuna());  
    
            
            for (Cidade c : map.getCidades()) {
                
                Unidades unidadeRemovida = c.removerUnidadePorPosicao(getLinha(), getColuna());
                if (unidadeRemovida != null) {
                    
                    System.out.println("A unidade " + unidadeRemovida.getCodigo() + " foi removida da cidade " + c.getCodigo());
                    break; 
                }
            }
    
            
            map.removerUnidadePorPosicao(getLinha(), getColuna());  
            System.out.println("A unidade " + this.getCodigo() + " foi removida do mapa.");
        }
    }
    
    
}
