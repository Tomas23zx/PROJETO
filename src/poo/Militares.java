


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
        conta=1; 
        
    }

    
    public Militares(String letra, int linha, int coluna) {
        super(letra, linha, coluna); 
        this.mapa = mapa;
        conta++;
    }

    public static int getConta(){return conta;}

    
    
    @Override
    public void mover(char direcao) {
        int novaLinha = getLinha(); // Supondo que existam métodos getLinha() e getColuna()
        int novaColuna = getColuna(); // para obter as posições atuais.
    
        switch (direcao) {
            case 'N': 
                novaLinha--; // Movendo para o norte.
                break;
            case 'S': 
                novaLinha++; // Movendo para o sul.
                break;
            case 'E': 
                novaColuna++; // Movendo para o leste.
                break;
            case 'O': 
                novaColuna--; // Movendo para o oeste.
                break;
            default:
                System.out.println("Direção inválida! Use N, E, S ou O.");
                return; // Sai do método se a direção for inválida.
        }
    
        setLinha(novaLinha); // Atualiza a nova linha.
        setColuna(novaColuna); // Atualiza a nova coluna.
    }
    
}
