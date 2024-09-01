package de.ait.shop42.product.service;

public class Main {
    public static void main(String[] args) {
        int a=10;
        double g = 3.33333333;
        String str = "Jack";

        System.out.println(str + " get " + a + " apples");
        String format = String.format("%s get %d apples", str, a);
        System.out.println(format);
        System.out.printf("%s get %d %napples %8.2f",str,a, g);



    }
}
