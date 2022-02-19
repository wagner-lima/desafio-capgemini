package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Débora se inscreveu em uma rede social para se manter em contato com seus amigos.
A página de cadastro exigia o preenchimento dos campos de nome e senha, porém a senha precisa ser forte.
O site considera uma senha forte quando ela satisfaz os seguintes critérios:
Possui no mínimo 6 caracteres.
Contém no mínimo 1 digito.
Contém no mínimo 1 letra em minúsculo.
Contém no mínimo 1 letra em maiúsculo.
Contém no mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+
 */


public class question02 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("------------- REGRAS DE SENHA -----------");
        System.out.println("Possuir 6 ou mais caracteres.");
        System.out.println("Possuir 1 ou mais dígitos.");
        System.out.println("Possuir, no mínimo, 1 letra minúscula.");
        System.out.println("Possuir, no mínimo, 1 letra maiúscula.");
        System.out.println("Possuir, no mínimo, 1 caractere especial.");
        System.out.println("-----------------------------------------");
        System.out.println("Crie sua senha:");

        String password = in.nextLine();

        passwordStrength(password);
    }

    public static void passwordStrength(String password) {
        // Sets minimum password length
        int passwordLength = 6;
        // Initializing variables
        int upperCase = 0, lowerCase = 0, specialChars = 0, digits = 0;
        char ch;
        // Set special characters
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));

        // Checking if password meets minimum length
        if (password.length() < passwordLength) {
            int missingChars = passwordLength - password.length();
            System.out.println("Adicione mais " + missingChars + " caracteres.");
            return;
        } else {
            for (int i = 0; i < password.length(); i++) {
                ch = password.charAt(i);
                if (Character.isUpperCase(ch))
                    upperCase++;
                else if (Character.isLowerCase(ch))
                    lowerCase++;
                else if (Character.isDigit(ch))
                    digits++;
                else if (set.contains(ch))
                    specialChars++;
            }
        }

        // Checking password strength and if meet requirements
        if (upperCase != 0 && lowerCase != 0 && digits != 0 && specialChars != 0) {
            // Sets minimum length to be considered as strong password
            int minimumStrongPassword = 8;

            if (password.length() >= minimumStrongPassword) {
                System.out.println("\nForça da Senha: Forte.");
            } else {
                System.out.println("\nForça da Senha: Médio.");
            }

            System.out.println("\n--- A senha contém ---");
            System.out.println("Letras Maiúsculas: " + upperCase);
            System.out.println("Letras Minúsculas: " + lowerCase);
            System.out.println("Dígitos: " + digits);
            System.out.println("Caracteres especiais: " + specialChars);
        } else {
            if (upperCase == 0)
                System.out.println("\nA senha deve conter pelo menos um caractere maiúsculo.");
            if (lowerCase == 0)
                System.out.println("\nA senha deve conter pelo menos um caractere minúsculo.");
            if (digits == 0)
                System.out.println("\nA senha deve conter pelo menos um dígito.");
            if (specialChars == 0)
                System.out.println("\nA senha deve conter pelo menos um caractere especial.");
        }
    }
}