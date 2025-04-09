package ru.npsolonenko;

import java.util.ArrayList;

public class Example {



    static class A {

       public void hello() {
            System.out.println("A");
        }
    }

    static class B extends A{

       public void hello() {
            System.out.println("B");
       }
    }

    public static void helloA(A a) {
        System.out.println("A");
        a.hello();
    }

    public static void helloA(B a) {
        System.out.println("B");
        a.hello();
    }

    public static void main(String[] args) {
        ArrayList<Runnable> array = new ArrayList<>();
        //f = x -> x * x
        array.add(() -> {
            System.out.println("LAMDA");
        });
        array.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("ANNONIMUS HAHAHHHAHA");
            }
        });



    }


}
