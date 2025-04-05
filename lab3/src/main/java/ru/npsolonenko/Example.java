package ru.npsolonenko;

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
        A a = new B();
        helloA(a);
    }


}
