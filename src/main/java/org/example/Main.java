package org.example;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scr = new Scanner(System.in);

        String name = scr.nextLine();

        String[] str = name.split(" ");

        int val = pars(str[1]);

        if(val > 9 && val < 10000){
            int sum = curs(val);
            String world = toWord(sum);
            print(str[0] , world);

        }else{
            System.out.println("error");
        }


    }

    protected static int pars(String val){
        return Integer.parseInt(val);
    }

    protected static int curs(int val){
        if(val == 0){
            return 0;
        }else{
            int dig = val % 10;
            val /= 10;
            return dig + curs(val);
        }
    }


    protected static String toWord(int num) {
        switch(num) {
            case 0: return "ноль";
            case 1: return "один";
            case 2: return "два";
            case 3: return "три";
            case 4: return "четыре";
            case 5: return "пять";
            case 6: return "шесть";
            case 7: return "семь";
            case 8: return "восемь";
            case 9: return "девять";
            case 10: return "десять";
            default: return "неизвестно";
        }
    }

    protected static void print(String name , String digit){
        System.out.println("Hello " + name + "!" + " sum digit = " + digit);
    }

}