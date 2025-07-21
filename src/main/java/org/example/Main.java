package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);
        String[] str_arr = new String[0];
        double one = 0, two = 0, result = 0;

        boolean flagHistory = false, flagExit = true, flagMenu = true;

        while (flagExit) {
            if (flagMenu) {
                System.out.println("1. input example:");
                System.out.println("2. Keep working it:");
                System.out.println("3. Exit:");
            }
            flagMenu = true;

            int input = scr.nextInt();
            scr.nextLine(); // очищаем буфер после nextInt()

            switch (input) {
                case 1:
                    str_arr = input_example();
                    char ch = str_arr[1].charAt(0);
                    one = Double.parseDouble(str_arr[0]);
                    two = Double.parseDouble(str_arr[2]);
                    result = solutionSwitch(ch, one, two);
                    System.out.println("Result example: " + result);
                    System.out.println();
                    flagHistory = true;
                    break;
                case 2:
                    if (flagHistory) {
                        outputMenuTwo();
                        whileCoreCase2(one, two);
                    } else {
                        System.out.println("Error");
                        flagMenu = false;
                    }
                    break;
                case 3:
                    flagExit = false;
                    break;
            }
        }
    }

    protected static String[] input_example() {
        Scanner scr = new Scanner(System.in);
        String str_input = scr.nextLine();
        return str_input.split(" ");
    }

    protected static void outputMenuTwo() {
        System.out.println("1. Сложение\n" +
                "2. Вычитание\n" +
                "3. Умножение\n" +
                "4. Деление\n" +
                "5. Возведение в степень\n" +
                "6. Сравнение\n" +
                "0. Назад");
    }

    protected static void whileCoreCase2(double one, double two) {
        int inputCase2 = -1;
        double resultCase2 = -1;

        while (inputCase2 != 0) {
            Scanner scr = new Scanner(System.in);
            inputCase2 = scr.nextInt();
            resultCase2 = switchCase2(inputCase2, one, two);
            if (inputCase2 != 0) {
                System.out.println("Result example: " + resultCase2);
            }
        }
    }

    protected static double switchCase2(int valInput, double first, double second) {
        double result = 0;
        switch (valInput) {
            case 1:
                result = solutionSwitch('+', first, second);
                break;
            case 2:
                result = solutionSwitch('-', first, second);
                break;
            case 3:
                result = solutionSwitch('*', first, second);
                break;
            case 4:
                result = solutionSwitch('/', first, second);
                break;
            case 5:
                result = solutionSwitch('^', first, second);
                break;
            case 6:
                result = solutionSwitch('?', first, second);
                break;
            case 0:
                break;
        }
        return result;
    }

    protected static double solutionSwitch(char ch, double one, double two) {
        double res = 0;
        switch (ch) {
            case '+':
                res = sum(one, two);
                break;
            case '-':
                res = subtraction(one, two);
                break;
            case '*':
                res = multiply(one, two);
                break;
            case '/':
                res = division(one, two);
                break;
            case '^':
                res = power(one, two);
                break;
            case '?':
                res = comparison(one, two);
                break;
        }
        return res;
    }

    protected static double sum(double first, double second) {
        return first + second;
    }

    protected static double subtraction(double first, double second) {
        return first - second;
    }

    protected static double multiply(double first, double second) {
        return first * second;
    }

    protected static double division(double first, double second) {
        if (second == 0) {
            System.out.println("Error 0!");
            return 0;
        }
        return first / second;
    }

    protected static double power(double first, double second) {
        return Math.pow(first, second);
    }

    protected static double comparison(double first, double second) {
        return Math.max(first, second);
    }
}
