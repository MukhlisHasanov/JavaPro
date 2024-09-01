package org.homework_01;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        MyThread thread1 = new MyThread(1, 1_000_000, 1);
        MyThread thread2 = new MyThread(1_000_001, 2_000_000, 2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        try {
            thread1.join();
            thread2.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int answerTask2 = thread2.getCount() + thread1.getCount();
        System.out.println("Ответ на задачу №2: " + answerTask2);
    }
}
