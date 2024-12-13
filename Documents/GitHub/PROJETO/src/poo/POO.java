package poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POO {
    public static void main(String[] args) {
        
        Civilizacao civi1 = new Civilizacao("Espartanos", 1);
        Civilizacao civi2 = new Civilizacao("Romanos", 2);
       

//
       
        Mapa mapa = new Mapa(25, 25);
        mapa.meterCidade(civi1, 15, 15);
        mapa.meterCidade(civi2, 10, 10); 

       
        List<Civilizacao> civilizacoes = new ArrayList<>();
        civilizacoes.add(civi1);
        civilizacoes.add(civi2);

    
        String[][] matriz = mapa.getMapa();
        Menu menu = new Menu(matriz, mapa, civi1);
        Scanner scanner = new Scanner(System.in);

        int turnoAtual = 0;
        boolean continuarJogo = true;

        
        while (continuarJogo) {
            Civilizacao civilizacaoAtual = civilizacoes.get(turnoAtual);
            System.out.println("É o turno de: " + civilizacaoAtual.getNome());

           
            menu.Interface();
            menu.menus(civilizacaoAtual,mapa);

            
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
