




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

    
    public Militares(String letra, int linha, int coluna,String [][] mapa) {
        super(letra, linha, coluna);
        this.mapa=mapa;
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
                novaColuna--;
                break;
            case 'O': 
                novaColuna++;
                break;
            default:
                System.out.println("Direção inválida! Use N, E, S ou O.");
                return;
        }

        if (novaLinha >= 0 && novaLinha < mapa.length && novaColuna >= 0 && novaColuna < mapa[0].length) {
            // Atualiza o mapa
            mapa[getLinha()][getColuna()] = " "; 
            mapa[novaLinha][novaColuna] = getLetra(); 
            
            setLinha(novaLinha);
            setColuna(novaColuna);
        } else {
            System.out.println("Movimento inválido! Fora dos limites do mapa.");
        }
    }
}
