


package poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DOIT
 */
public class Militares extends Unidades {
    private String [][] mapa;
    private static int conta;

    
    public Militares(String letra) {
        super(letra, 0, 0);
        conta++; 
        
    }

    
    public Militares(String letra, int linha, int coluna) {
        super(letra, linha, coluna); 
        this.mapa = mapa;
        conta++;
    }

    public static int getConta(){return conta;}

    public String getCodigo(){
        return getLetra()+getConta();
    }

    
    
    @Override
    public void mover(char direcao) {
        int novaLinha = getLinha(); 
        int novaColuna = getColuna(); 
    
        switch (direcao) {
            case 'N': 
                novaLinha--; 
                break;
            case 'S': 
                novaLinha++;
                break;
            case 'E': 
                novaColuna++; 
                break;
            case 'O': 
                novaColuna--; 
                break;
            default:
                System.out.println("Direção inválida! Use N, E, S ou O.");
                return; 
        }
    
        setLinha(novaLinha); 
        setColuna(novaColuna); 
    }
    @Override
    public void funcionalidade(){
        
    }
    
}
