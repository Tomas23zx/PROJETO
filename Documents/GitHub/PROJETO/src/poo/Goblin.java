package poo;

import java.util.Random;
public class Goblin extends Unidades {
    private Mapa mapa;
    private static int conta;
    
    
   
    

    public Goblin(String letra,Mapa mapa ,int idCivilizacao,int vida) {
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
            int quantidadeParaRoubar = ouro.getQuantidade() / 3; 
    
            if (quantidadeParaRoubar > 0) {
                cidadeInimiga.consumirRecurso(new Ouro(0), quantidadeParaRoubar);
    
                if (chance == 0) {
                    System.out.println("O Goblin robou o ouro para si ahahah.");
                    
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
    
    public Cidade verificar_cidade_inimiga(Unidades unidade,Mapa map){
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
    
                    if (!codigoNaPosicao.equals(mapa.obterLetraTerra()) && !codigoNaPosicao.equals(map.obterLetraArvore()) && !codigoNaPosicao.equals(map.obterLetraAgua())  && !codigoNaPosicao.equals(map.obterLetraPlanicie()) &&  !codigoNaPosicao.startsWith("G") &&   !codigoNaPosicao.startsWith("M") &&   !codigoNaPosicao.startsWith("H") &&    !codigoNaPosicao.startsWith("E")) {
                       
    
                        
                        Cidade enimigoCidade =map.buscarCidadePorposicao(novaLinha, novaColuna, unidade.getId());
                        
    
                        if (enimigoCidade != null) {
                            return enimigoCidade;
                        }
                    }
                }
            }
        }
    
        return null; 
    }
}
