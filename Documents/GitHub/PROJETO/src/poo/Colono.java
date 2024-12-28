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
    /*
     * retorna a conta(valor estatico,faz aoarecer exmplo H1,H2)
    */
      public static int getConta(){return conta;}
/*
     * retorna a conta(valor estatico,faz aoarecer exmplo H1,H2)
    */
     @Override
    public String getCodigo(){
        return getLetra()+getConta();
    }
   /*
     * recebe a direçao,o mapa,a unidade escolhida no menu,o codigo dessa,e a cidade,e move para N norte,S Sul ...,
     * depois chama o mapa para verificar se pode ser deslocado para la, e os custos dos terrenos
    */ 
     
    @Override
    public void mover(char direcao, Mapa map,String codigo,Cidade cidadeEscolhida) {
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

        map.moverUnidade(this, novaLinha, novaColuna,codigo,cidadeEscolhida);
    }
    /*
     * a funcao de cada
    */
     @Override
    public  void funcionalidade(Civilizacao civi,Mapa map)
    {
        mapa.meterCidade(civi,getLinha(),getColuna());
        
    }
     /*
     * se a sua vida for 0,e removido do mapa e do tremap da cidade,e do array de unidades do mapa
    */
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
     /*
     * diminui a vida
    */
    @Override
    public void Perder_Vida(int x){
        setVida(getVida()-x);
    }
     /*
     * ganha vida
    */
    @Override
    public void Ganhar_vida(int x){
        setVida(getVida()+x);
    }
}
