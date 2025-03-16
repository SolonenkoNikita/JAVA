package ru.npsolonenko;

public class Greeter implements Runnable {
    int n;
    String target;

    public Greeter(int n, String target) {
        this.n = n;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; ++i)
            System.out.println("Hello, " + target);
    }

    public static void main(String[] args) {

        Runnable greeter1 = new Greeter(10, "Nikita");
        Runnable greeter2 = new Greeter(10, "Diman");

        Thread thread1 = new Thread(greeter1);
        Thread thread2 = new Thread(greeter2);

        thread1.start();
        thread2.start();
    }
}
