package poo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POO {
    public static void main(String[] args) {
        Menuinicial men = new Menuinicial();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo! Quantas civilizações deseja jogar? (mínimo 2, máximo 4): ");
        int numeroCivilizacoes;
        while (true) {
            try {
                numeroCivilizacoes = Integer.parseInt(scanner.nextLine());
                if (numeroCivilizacoes >= 2 && numeroCivilizacoes <= 4) {
                    break;
                } else {
                    System.out.println("Por favor, insira um número entre 2 e 4:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número:");
            }
        }

        List<Civilizacao> civilizacoes = new ArrayList<>();
        Mapa mapa = new Mapa(25, 25);

       
        for (int i = 1; i <= numeroCivilizacoes; i++) {
            System.out.println("Insira o nome da civilização " + i + ":");
            String nome = men.menCiv();
            Civilizacao civilizacao = new Civilizacao(nome, i);
            civilizacoes.add(civilizacao);

            
            int posX = 5 + (i * 5);  
            int posY = 5 + (i * 5);
            mapa.meterCidade(civilizacao, posX, posY);
            mapa.adiciona_Civ(civilizacao);
        }

        String[][] matriz = mapa.getMapa();
        Menu menu = new Menu(matriz, mapa, civilizacoes.get(0));

        int turnoAtual = 0;
        boolean continuarJogo = true;

        while (continuarJogo) {
            Civilizacao civilizacaoAtual = civilizacoes.get(turnoAtual);
            System.out.println("É o turno de: " + civilizacaoAtual.getNome());

            for (Cidade cidade : civilizacaoAtual.getCidades()) {
                if (cidade != null) {
                    Recursos producao = cidade.findRecurso(new Producao(0));
                    if (producao != null) {
                        producao.setQuantidade(10);  
                        System.out.println("A produção da cidade " + cidade.getCodigo() + " foi ajustada para 10.");
                    }
                }
            }

        
            menu.Interface(civilizacaoAtual);
            menu.menus(civilizacaoAtual, mapa);

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
