package ru.geekbrains;

public class Calculation {

    public static double calculatingArea (int a, int b, int c){
        int p = (a + b + c) / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

}
