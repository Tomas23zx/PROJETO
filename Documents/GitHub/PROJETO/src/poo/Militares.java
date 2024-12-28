


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
    //Getrs setters

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
                System.out.println("Direcao invalida! Use N, E, S ou O.");
                return;
            }
        }

        map.moverUnidade(this, novaLinha, novaColuna,codigo, cidadeEscolhida);
    }
    /*
     * a funcao de cada(não foi preciso)
    */
    @Override
    public void funcionalidade(Civilizacao civi,Mapa map) {
        
        
    }

    /*
     * verifica se existe inimigos ao redor desta unidade
     */
    public Unidades verificarInimigoAoRedorDeTodasAsUnidades( Mapa map) {
        int linhaUnidade = this.getLinha();
        int colunaUnidade = this.getColuna();
    
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
    
                int novaLinha = linhaUnidade + i;
                int novaColuna = colunaUnidade + j;
    
                if (novaLinha >= 0 && novaLinha < map.getMapa().length &&
                    novaColuna >= 0 && novaColuna < map.getMapa()[0].length) {
    
                    String codigoNaPosicao = map.getMapa()[novaLinha][novaColuna];
    
                    if (!codigoNaPosicao.equals(mapa.obterLetraTerra()) && !codigoNaPosicao.equals(map.obterLetraArvore()) && !codigoNaPosicao.equals(map.obterLetraAgua()) && !codigoNaPosicao.startsWith("C") && !codigoNaPosicao.equals(map.obterLetraPlanicie()) ) {
                       
    
                        
                        Unidades unidadeAdjacente = map.buscarUnidadePorCodigo(novaLinha,novaColuna,this.getId());
                        

                        if (unidadeAdjacente != null) {
                            return unidadeAdjacente;  
                        }
                    }
                }
            }
        }
    
        return null; 
    }
    
    
    /*
     * calcula a probabilidade de vitoria entre esta unidade e o inimigo apratir da força e da vida
     */
    
    
    public double calcularProbabilidadeDeVitoria(Militares unidadeAdversaria) {
     
        double probabilidade = (this.forca * this.getVida()) / (double) (unidadeAdversaria.getForca() * unidadeAdversaria.getVida());
        return probabilidade;
    }
/*
 * ataca a unidadeAdversaria detectada ao redor desta unidade atraves de probabilidades,esta podera falhar e perder vida ou ganhar 
 */
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
    
                unidadeAdversaria.Perder_Vida(dano);
                System.out.println("A unidade " + getCodigo() + " atacou com sucesso! A vida da unidade adversária agora é " + unidadeAdversaria.getVida());
            } else {
             
                this.Perder_Vida(10);
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
/*
 * verifica se existe cidade inimiga ao rodor do militar escolhido
 */
public Cidade verificar_cidade_inimiga(Mapa map){
    int linhaUnidade = this.getLinha();
    int colunaUnidade = this.getColuna();

    for (int i = -1; i <= 1; i++) {
        for (int j = -1; j <= 1; j++) {
            if (i == 0 && j == 0) continue;

            int novaLinha = linhaUnidade + i;
            int novaColuna = colunaUnidade + j;

            if (novaLinha >= 0 && novaLinha < map.getMapa().length &&
                novaColuna >= 0 && novaColuna < map.getMapa()[0].length) {

                String codigoNaPosicao = map.getMapa()[novaLinha][novaColuna];

                if (!codigoNaPosicao.equals(mapa.obterLetraTerra()) && !codigoNaPosicao.equals(map.obterLetraArvore()) && !codigoNaPosicao.equals(map.obterLetraAgua())  && !codigoNaPosicao.equals(map.obterLetraPlanicie()) &&  !codigoNaPosicao.startsWith("M") ) {
                   

                    
                    Cidade enimigoCidade =map.buscarCidadePorposicao(novaLinha, novaColuna, this.getId());
                    

                    if (enimigoCidade != null) {
                        return enimigoCidade;
                    }
                }
            }
        }
    }

    return null; 
}
 /*
 * ataca a cidade_inimiga detectada ao redor desta unidade atraves de probabilidades,esta podera falhar e perder vida ou ganhar e destruir a cidade
 */
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
       
        return true;
    } else {
        
        double sorte = Math.random();
        if (sorte < 0.5) {
            System.out.println("Falhou o ataque,nao aconteceu nada!");
            return false;
        } else {
            
            this.Perder_Vida(20);
            System.out.println("O ataque falhou. A unidade " + getCodigo() + " perdeu 20 de vida e agora tem " + this.getVida() + " de vida.");
            return false;
        }

        
        
    }
        
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
 

