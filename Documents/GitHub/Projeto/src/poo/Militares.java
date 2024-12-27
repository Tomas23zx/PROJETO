


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
    public void setForca(int x){
        this.forca=x;
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
    
                    if (!codigoNaPosicao.equals(mapa.obterLetraTerra()) && !codigoNaPosicao.equals(map.obterLetraArvore()) && !codigoNaPosicao.equals(map.obterLetraAgua()) && !codigoNaPosicao.startsWith("C") && !codigoNaPosicao.equals(map.obterLetraPlanicie()) ) {
                       
    
                        
                        Unidades unidadeAdjacente = map.buscarUnidadePorCodigo(novaLinha,novaColuna,unidade.getId());
                        

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
     
        double probabilidade = (this.forca * this.getVida()) / (double) (unidadeAdversaria.getForca() * unidadeAdversaria.getVida());
        return probabilidade;
    }

    public void atacar(Unidades unidadeAdversaria) {
        double probabilidadeDeVitoria;
    
        if (this instanceof Militares) {
            
            if (unidadeAdversaria instanceof Militares) {
                probabilidadeDeVitoria = calcularProbabilidadeDeVitoria((Militares) unidadeAdversaria);
            } else {
                
                probabilidadeDeVitoria = 0.8; 
            }
    
            
            if (Math.random() < probabilidadeDeVitoria) {
                
                int dano = (unidadeAdversaria instanceof Militares) ? 10 : 20; 
    
                unidadeAdversaria.setVida(unidadeAdversaria.getVida() - dano);
                System.out.println("A unidade " + getCodigo() + " atacou com sucesso! A vida da unidade adversária agora é " + unidadeAdversaria.getVida());
            } else {
             
                this.setVida(this.getVida() - 10);
                System.out.println("A unidade " + getCodigo() + " falhou no ataque. Sua vida agora é " + this.getVida());
            }
    
           
            if (unidadeAdversaria.getVida() <= 0) {
                System.out.println("A unidade " + unidadeAdversaria.getCodigo() + " foi derrotada!");
                unidadeAdversaria.setVida(0);
            }
    
            
            if (this.getVida() <= 0) {
                System.out.println("A unidade " + getCodigo() + " foi derrotada!");
                this.setVida(0); 
            }
        } else {
            System.out.println("Apenas unidades militares podem calcular probabilidade de vitória!");
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

                if (!codigoNaPosicao.equals(mapa.obterLetraTerra()) && !codigoNaPosicao.equals(map.obterLetraArvore()) && !codigoNaPosicao.equals(map.obterLetraAgua())  && !codigoNaPosicao.equals(map.obterLetraPlanicie()) &&  !codigoNaPosicao.startsWith("M") ) {
                   

                    
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
 
public boolean atacar_cidade(Cidade cidade_inimiga,Cidade cidade_origem) {
    
    if (cidade_inimiga == null) {
        System.out.println("Nenhuma cidade inimiga para atacar.");
        return false;
    }

    double fatorDeReducao = 0.5;
    double probabilidadeDeVitoria = (this.forca * this.getVida()) / (double) (cidade_inimiga.getDefesa() * cidade_inimiga.getPopulacao());
    probabilidadeDeVitoria *= fatorDeReducao;
    
    if (Math.random() < probabilidadeDeVitoria) {
        
        System.out.println("A unidade " + getCodigo() + " venceu o ataque! A cidade " + cidade_inimiga.getCodigo() + " foi destruída.");
        mapa.remover_do_mapa(cidade_inimiga.getPosX(), cidade_inimiga.getPosY());
        mapa.removerCidades(conta);
        mapa.removerCidadeDaposicao(cidade_inimiga.getPosX(), cidade_inimiga.getPosY());
        return true;
    } else {
        
        double sorte = Math.random();
        if (sorte < 0.5) {
           
            int recursosRoubados = cidade_inimiga.getReserva() / 2; 
            cidade_inimiga.setReserva(cidade_inimiga.getReserva() - recursosRoubados);
            cidade_origem.setReserva(cidade_origem.getReserva()+recursosRoubados);
            System.out.println("O ataque falhou, mas a unidade " + getCodigo() + " conseguiu roubar " + recursosRoubados + " recursos da cidade " + cidade_inimiga.getCodigo() + ".");
            return false;
        } else {
            
            this.setVida(this.getVida() - 20);
            System.out.println("O ataque falhou. A unidade " + getCodigo() + " perdeu 20 de vida e agora tem " + this.getVida() + " de vida.");
            return false;
        }

        
        
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
    
    
    

}
 

