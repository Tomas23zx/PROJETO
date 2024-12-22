package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POO {
    public static void main(String[] args) {
        Menuinicial men= new Menuinicial();
        String x = men.menCiv();
        Civilizacao civi1 = new Civilizacao(x, 1);
        String y = men.menCiv();
        Civilizacao civi2 = new Civilizacao(y, 2);
       

       
        Mapa mapa = new Mapa(25, 25);
        mapa.meterCidade(civi1, 15, 15);
        //mapa.meterCidade(civi2, 10, 10); 

       
        List<Civilizacao> civilizacoes = new ArrayList<>();
        civilizacoes.add(civi1);
        civilizacoes.add(civi2);

    
        String[][] matriz = mapa.getMapa();
        Menu menu = new Menu(matriz, mapa, civi1);
        Scanner scanner = new Scanner(System.in);

        int turnoAtual = 0;
        boolean continuarJogo = true;

        Controlarturnos controla = new Controlarturnos();

        while (continuarJogo) {
            Civilizacao civilizacaoAtual = civilizacoes.get(turnoAtual);
            System.out.println("É o turno de: " + civilizacaoAtual.getNome());

           
            menu.Interface(civilizacaoAtual);
            menu.menus(civilizacaoAtual,mapa, controla);

            Vitoria.verificarCondicoesDeVitoria(mapa, civilizacaoAtual.getId());;

            
            System.out.println("Deseja continuar o jogo? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("n")) {
                System.out.println("Saindo do jogo. Até a próxima!");
                continuarJogo = false;
            } else {
               
                turnoAtual = (turnoAtual + 1) % civilizacoes.size();
            }
        }

        scanner.close();
    }
}
