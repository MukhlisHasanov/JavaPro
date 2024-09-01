package org.homework_01;

import java.util.ArrayList;

public class MyThread extends Thread {
    private final int start;
    private final int end;
    private final int sleepTime;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public MyThread(int start, int end, int sleepTime) {
        this.start = start;
        this.end = end;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("task #2 MyThread start");

        for (int i = start; i <= end; i++) {
            if (i % 21 == 0) {
                numbers.add(i);
                System.out.println(getName() + " " + i);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        count = numbers.size();

        System.out.println("Чисел, делящихся на 21 в диапазоне от " + start + " до " + end + ": " + count);
    }
}

