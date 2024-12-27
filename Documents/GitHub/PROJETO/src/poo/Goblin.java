package poo;

import java.util.Random;
public class Goblin extends Unidades {
    private Mapa mapa;
    private static int conta;
    
    
   
    

    public Goblin(String letra,Mapa mapa ,int idCivilizacao,int vida,int forca) {
        super(letra, 0, 0, idCivilizacao,vida); 
        this.mapa=mapa;
        
        conta++;
    }

    
    public Goblin(String letra, int linha, int coluna, int idCivilizacao,int vida,int forca,Mapa mapa) {
        super(letra, linha, coluna, idCivilizacao,vida); 
        this.mapa = mapa;  
        conta++;
    }

    public static int getConta(){return conta;}

    public String getCodigo(){
        return getLetra()+getConta();
    }

   

    @Override
    public void mover(char direcao, Mapa map,Unidades escolhida,String codigo,Cidade cidadeEscolhida) {
        int novaLinha = getLinha();
        int novaColuna = getColuna();

        switch (direcao) {
            case 'N' -> novaLinha--;
            case 'S' -> novaLinha++;
            case 'E' -> novaColuna++;
            case 'O' -> novaColuna--;
            default -> {
                System.out.println("Direcao invalida! Use N, E, S ou O.");
                return;
            }
        }

        map.moverUnidade(escolhida, novaLinha, novaColuna,codigo, cidadeEscolhida);
    }

    @Override
    public void funcionalidade(Civilizacao civi,Mapa map) {

        
        
    }
    public void roubar(Cidade cidadeOrigem, Cidade cidadeInimiga) {
        Random random = new Random();
        int chance = random.nextInt(2);
        Recursos ouro = cidadeInimiga.findRecurso(new Ouro(0)); 
    
        if (ouro != null) {
            int quantidadeParaRoubar = ouro.getQuantidade() / 2; 
    
            if (quantidadeParaRoubar > 0) {
                cidadeInimiga.consumirRecurso(new Ouro(0), quantidadeParaRoubar);
    
                if (chance == 0) {
                    
                    System.out.println("O Goblin roubou " + quantidadeParaRoubar + " unidades de ouro da cidade inimiga " +
                            cidadeInimiga.getCodigo() + " sem revelar sua origem!");
                } else {
                    
                    System.out.println("O Goblin roubou " + quantidadeParaRoubar + " unidades de ouro da cidade inimiga " +
                            cidadeInimiga.getCodigo() + " e revelou sua origem: Cidade de ID " + cidadeOrigem.getCodigo());
                            cidadeOrigem.adicionarRecurso(new Ouro(0), quantidadeParaRoubar);
                }
            } else {
                System.out.println("A cidade inimiga " + cidadeInimiga.getCodigo() + " não possui ouro suficiente para ser roubado.");
            }
        } else {
            System.out.println("A cidade inimiga " + cidadeInimiga.getCodigo() + " não possui ouro!");
        }
    }
    

}
