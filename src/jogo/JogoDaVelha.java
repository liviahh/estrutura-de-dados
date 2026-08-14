package jogo;

import java.util.Scanner;

public class JogoDaVelha {

    private char[][] tabuleiro;
    private Scanner sc;

    public JogoDaVelha() {
        
        tabuleiro = new char[3][3];
        sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                tabuleiro[i][j] = ' ';
            }
        }
    }

    public void iniciar() {
        char jogador = 'X';

        while (true) {
            mostrarTabuleiro();

            System.out.println("\nJogador " + jogador);

            System.out.print("Linha: ");
            int linha = sc.nextInt();

            System.out.print("Coluna: ");
            int coluna = sc.nextInt();

            if (!jogar(linha, coluna, jogador)) {
                System.out.println("Posição inválida!");
                continue;
            }

            if (verificarVitoria(jogador)) {

                mostrarTabuleiro();
                System.out.println("\nJogador " + jogador + " venceu!");
                break;
            }

            if (empate()) {

                mostrarTabuleiro();
                System.out.println("\nEmpate!");
                break;
            }
            jogador = (jogador == 'X') ? 'O' : 'X';
        }
    }

    private void mostrarTabuleiro() {
        System.out.println();
        System.out.println("     0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j] + " ");
                if (j < 2)
                    System.out.print("|");
            }
            System.out.println();
            if (i < 2)
                System.out.println("   ---+---+---");
        }
        System.out.println();
    }

    private boolean jogar(int linha, int coluna, char jogador) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2)
            return false;

        if (tabuleiro[linha][coluna] != ' ')
            return false;

        tabuleiro[linha][coluna] = jogador;
        return true;
    }

    private boolean verificarVitoria(char jogador) {
        for (int i = 0; i < 3; i++) {

            if (tabuleiro[i][0] == jogador &&
                    tabuleiro[i][1] == jogador &&
                    tabuleiro[i][2] == jogador)
                return true;

            if (tabuleiro[0][i] == jogador &&
                    tabuleiro[1][i] == jogador &&
                    tabuleiro[2][i] == jogador)
                return true;
        }

        if (tabuleiro[0][0] == jogador &&
                tabuleiro[1][1] == jogador &&
                tabuleiro[2][2] == jogador)
            return true;

        if (tabuleiro[0][2] == jogador &&
                tabuleiro[1][1] == jogador &&
                tabuleiro[2][0] == jogador)
            return true;
        return false;
    }

    private boolean empate() {
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (tabuleiro[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}