package org.homework_01;

public class task_01 {

    public static void main(String[] args) throws InterruptedException {

        // task #1
        int count = 0;
        int rangeStart = 1;
        int rangeEnd = 2_000_000;
        int divisor = 21;

        for (int i = rangeStart; i <= rangeEnd; i++) {
            if (i % divisor == 0) {
                count++;
            }
        }
        System.out.println('\n' + "Количество чисел, делящихся на 21: " + count);
    }
}
