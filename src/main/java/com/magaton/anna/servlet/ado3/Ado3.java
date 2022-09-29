
/*Crie um programa que permita ao usuário especificar quantos jogos deseja fazer
e quantos números em cada jodo da Loto Fácil(1 a 25). Podendo escolher entre 15 
a 19 números por jogo. Imprima os jogos gerados para o usuário. Implemente uma 
função que faça sorteio de 15 números e ao final informe quantos pontos o 
usuário fez em cada jogo. Discente: Anna Paula Frassom da Silva Magaton - TADS - 
Turma A - 2* semestre.*/
package com.magaton.anna.servlet.ado3;

import java.util.Random;
import java.util.Scanner;

public class Ado3 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Quantos jogos deseja realizar?: ");
        int nJogos = teclado.nextInt();
        int nNumeros;
        boolean nValido;

        do {
            System.out.println("Quantos números (15 a 19) deseja inserir em cada jogo?: ");
            nNumeros = teclado.nextInt();
            nValido = nNumeros >= 15 && nNumeros <= 19;
            if (!nValido) {
                System.out.println("Erro: Quantidade de números deve ser entre 15 e 19");
            }
        } while (!nValido);

        int jogos[][] = new int[nJogos][nNumeros];

        for (int i = 0; i < nJogos; i++) {
            for (int j = 0; j < nNumeros; j++) {
                System.out.printf("Digite o número %d/%d do jogo %d - entre 1 e 25: \n", j + 1, nNumeros, i + 1);
                jogos[i][j] = teclado.nextInt();

                if (jogos[i][j] < 1 || jogos[i][j] > 25) {
                    System.out.println("Erro: Número informado deve estar entre 15 e 25");
                    j--;
                }
            }
        }

        for (int i = 0; i < nJogos; i++) {
            System.out.printf("JOGO %s \n", i + 1);
            for (int j = 0; j < nNumeros; j++) {
                System.out.printf(jogos[i][j] + ", ");
            }
            System.out.printf("\n");
        }

        calcularAcertos(nJogos, nNumeros, jogos);

    }

    public static void calcularAcertos(int nJogos, int nNumeros, int[][] jogos) {
        Random sorteador = new Random();
        System.out.print("Números sorteados :");

        int sorteio[] = new int[15];
        for (int i = 0; i < sorteio.length; i++) {
            sorteio[i] = sorteador.nextInt(24) + 1;
            System.out.printf("%d, ", sorteio[i]);
        }
        System.out.printf("\n");

        for (int i = 0; i < nJogos; i++) {
            int totAcertos = 0;
            for (int a = 0; a < sorteio.length; a++) {
                for (int j = 0; j < nNumeros; j++) {
                    if (jogos[i][j] == sorteio[a]) {
                        totAcertos++;
                    }
                }
            }
            System.out.printf("JOGO %d teve %d pontos\n", i + 1, totAcertos);
        }
    }
}
