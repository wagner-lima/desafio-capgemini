package main.question01;

import java.util.Scanner;

/*
Escreva um algoritmo que mostre na tela uma escada de tamanho n
utilizando o caractere * e espaços. A base e altura da escada devem
ser iguais ao valor de n. A última linha não deve conter nenhum espaço.
 */

public class question01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Digite o tamanho da escada:");
        int size = in.nextInt();

        // Checks if input number is valid
        if (size <= 1) {
            do {
                System.out.println("Número inválido. Digite outro!");
                size = in.nextInt();
            } while (size <= 1);
            createStairs(size);
        }
        else {
            createStairs(size);
        }
    }

    // Creates stairs
    public static void createStairs(int n) {
        int space = n - 1;
        int star = 1;

        System.out.println();

        while (space >= 0) {
            System.out.print(" ".repeat(space));
            System.out.println("*".repeat(star));
            space -= 1;
            star += 1;
        }
    }
}