package com.bingo;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        System.out.println("BINGO");

        String[][] bingo;
        bingo = new String[5][5];

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {
                int aux;
                boolean duplicado;
                do {
                    aux = (int) (Math.random() * 100);
                    duplicado = false;

                    for (int f = 0; f < bingo.length; f++) {
                        for (int m = 0; m < bingo.length; m++) {

                            if (bingo[f][m] != null && bingo[f][m].equals(String.valueOf(aux))) {
                                duplicado = true;
                            }
                        }
                    }

                } while (duplicado);

                bingo[i][j] = String.valueOf(aux);
            }
        }

        for (int i = 0; i < bingo.length; i++) {
            for (int j = 0; j < bingo.length; j++) {
                System.out.print(bingo[i][j] + "\t");
            }
            System.out.println();
        }

        while (true) {

            try {
                System.out.println("Ingrese fila: ");
                int fila = sc.nextInt();

                System.out.println("Ingrese columna: ");
                int columna = sc.nextInt();

                bingo[fila][columna] = "X";

                for (int i = 0; i < bingo.length; i++) {
                    for (int j = 0; j < bingo.length; j++) {
                        System.out.print(bingo[i][j] + "\t");
                    }
                    System.out.println();
                }

            } catch (InputMismatchException e) {
                System.out.println("¡Error! Debe ingresar únicamente números enteros.");
                sc.next();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("¡Error! La fila y la columna deben estar entre 0 y 4.");
            }
        }
    }
}
