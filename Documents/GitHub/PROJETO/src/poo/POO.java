package poo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class POO {
    public static void main(String[] args) {
        Menuinicial men = new Menuinicial();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao jogo! Quantas civilizaçoes deseja jogar? (mínimo 2, máximo 3): ");
        int numeroCivilizacoes;
        while (true) {
            try {
                numeroCivilizacoes = Integer.parseInt(scanner.nextLine());
                if (numeroCivilizacoes >= 2 && numeroCivilizacoes <= 3) {
                    break;
                } else {
                    System.out.println("Entrada invalida. Por favor, insira um numero entre 2 e 3:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Por favor, insira um numero:");
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
            // Seleciona a civilização atual
            Civilizacao civilizacaoAtual = civilizacoes.get(turnoAtual);
            System.out.println("É o turno de: " + civilizacaoAtual.getNome());
        
            // Ajusta a produção das cidades da civilização atual
            for (Cidade cidade : civilizacaoAtual.getCidades()) {
                if (cidade != null) {
                    Recursos producao = cidade.findRecurso(new Producao(0));
                    if (producao != null) {
                        producao.setQuantidade(10);
                        System.out.println("A produção da cidade " + cidade.getCodigo() + " foi ajustada para 10.");
                    }
                }
            }
        
            // Mostra a interface e menus para o jogador atual
            menu.Interface(civilizacaoAtual);
            menu.menus(civilizacaoAtual, mapa);
        
            // Troca de jogador
            int conta = 0;
            System.out.println(" ");
            System.out.println("Mudar de Player");
            for (Civilizacao c : civilizacoes) {
                conta++;
                System.out.println(conta + ". Player" + conta);
            }
            System.out.print("->");
        
            int resposta = scanner.nextInt();
            System.out.println(" ");
            switch (resposta) {
                case 1 -> turnoAtual = 0;
                case 2 -> turnoAtual = 1;
                case 3 -> {
                    if (civilizacoes.size() > 2) turnoAtual = 2;
                }
                case 4 -> {
                    if (civilizacoes.size() > 2) turnoAtual = 3;
                }
            }
        
            
            for (Civilizacao c : civilizacoes) {
                if (menu.condicoesdevitoria(c)==0) {
                    continuarJogo = false; 
                    System.out.println("A civilização " + c.getNome() + " venceu o jogo!");
                    break;
                }
                if(menu.condicoesdevitoria(c)==1){
                    
                    if(civilizacoes.size()==2){
                        continuarJogo = false; 
                        for (Civilizacao outraCivilizacao : civilizacoes) {
                            if (!outraCivilizacao.equals(c)) {
                                System.out.println("A civilização " + outraCivilizacao.getNome() + " venceu o jogo!");
                                break;
                            }
                        }
                    }
                    else{
                        System.out.println("A civilizacao " + c.getNome() + " foi eliminada!");
                        civilizacoes.remove(c);
                    }
                    break; 
                }
                if(menu.condicoesdevitoria(c)==2){
                    
                }

            }
        }
        

        scanner.close();
    }
}

