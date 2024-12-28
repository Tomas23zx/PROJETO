package poo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ramnu
 */
public class Estrutura {
    public static final String VERMELHO = "\033[31m";
    public static final String RESET = "\033[0m";
    private String letra;
    private int linha;
    private int coluna;
    private int idCivilizacao;
    private String tipo;
    
    public Estrutura(String letra,int idCivilizacao) {  
        this.letra = letra;
        this.linha = 0;
        this.coluna = 0;
        this.idCivilizacao=idCivilizacao;
   
    }
    public Estrutura(String letra,int idCivilizacao,String tipo) {  
        this.letra = letra;
        this.linha = 0;
        this.coluna = 0;
        this.idCivilizacao=idCivilizacao;
        this.tipo=tipo;
    }
      /*
     * retorna a letra da estrutura
    */
    public String getLetra() {
        return VERMELHO +letra + "" + RESET ;
    }
     /*
     * mete mais ouro ou comida nas cidades
    */
    public void funcionalidade(Civilizacao civi){
        if(tipo!=null){
        
            switch(tipo){
                case "ouro" ->{

                   civi.atualizarRecurssos(new Ouro(0), civi);

                }
                case "comida" ->{

                    civi.atualizarRecurssos(new Comida(0,0), civi);

                }
            }
        }
    
    }
     /*
     * Geters seters
    */
    public int getId(){
        return idCivilizacao;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public String getCodigo(){
        return getLetra();
    }
    

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

}

