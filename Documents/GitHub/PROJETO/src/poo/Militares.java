


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
    private Mapa mapa;
    private static int conta;
    private int forca;
    
   
    

    public Militares(String letra,Mapa mapa ,int idCivilizacao,int vida,int forca) {
        super(letra, 0, 0, idCivilizacao,vida); 
        this.mapa=mapa;
        this.forca=forca; 
        conta++;
    }

    
    public Militares(String letra, int linha, int coluna, int idCivilizacao,int vida,int forca,Mapa mapa) {
        super(letra, linha, coluna, idCivilizacao,vida); 
        this.forca=forca; 
        this.mapa = mapa;  
        conta++;
    }

    public static int getConta(){return conta;}

    public String getCodigo(){
        return getLetra()+getConta();
    }

    public int getForca() {
        return forca;
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
        
        
    }


    public Unidades verificarInimigoAoRedorDeTodasAsUnidades(Unidades unidade, Mapa map) {
        int linhaUnidade = unidade.getLinha();
        int colunaUnidade = unidade.getColuna();
    
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
    
                int novaLinha = linhaUnidade + i;
                int novaColuna = colunaUnidade + j;
    
                if (novaLinha >= 0 && novaLinha < map.getMapa().length &&
                    novaColuna >= 0 && novaColuna < map.getMapa()[0].length) {
    
                    String codigoNaPosicao = map.getMapa()[novaLinha][novaColuna];
    
                    if (!codigoNaPosicao.equals("X")) {
                       
    
                        
                        Unidades unidadeAdjacente = map.buscarUnidadePorCodigo(codigoNaPosicao, unidade.getId());
                        

                        if (unidadeAdjacente != null) {
                            return unidadeAdjacente;  
                        }
                    }
                }
            }
        }
    
        return null; 
    }
    
    
    
    
    
    public double calcularProbabilidadeDeVitoria(Militares unidadeAdversaria) {
        // Probabilidade é baseada na força e vida das unidades
        double probabilidade = (this.forca * this.getVida()) / (double) (unidadeAdversaria.getForca() * unidadeAdversaria.getVida());
        return probabilidade;
    }
    public void atacar(Militares unidadeAdversaria) {
        double probabilidadeDeVitoria = calcularProbabilidadeDeVitoria(unidadeAdversaria);

        // Determina o dano baseado na probabilidade de vitória
        if (Math.random() < probabilidadeDeVitoria) {
            // Se a unidade ganhar, a unidade adversária perde vida
            unidadeAdversaria.setVida(unidadeAdversaria.getVida() - 10);  // Exemplo: cada ataque retira 10 de vida
            System.out.println("A unidade " + getCodigo() + " atacou com sucesso! A vida da unidade adversária agora é " + unidadeAdversaria.getVida());
        } else {
            // Caso contrário, a unidade atacante perde vida
            this.setVida(this.getVida() - 10);  // Exemplo: cada ataque retira 10 de vida
            System.out.println("A unidade " + getCodigo() + " falhou no ataque. Sua vida agora é " + this.getVida());
        }

        // Se a vida da unidade adversária ou a vida da unidade atual chegar a 0, a unidade é removida
        if (unidadeAdversaria.getVida() <= 0) {
            System.out.println("A unidade " + unidadeAdversaria.getCodigo() + " foi derrotada!");
            unidadeAdversaria.setVida(0);  // Definir vida como 0 (indicando que foi derrotada)
        }

        if (this.getVida() <= 0) {
            System.out.println("A unidade " + getCodigo() + " foi derrotada!");
            this.setVida(0);  // Definir vida como 0 (indicando que foi derrotada)
        }
    }
    
}
 

