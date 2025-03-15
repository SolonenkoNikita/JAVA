package ru.npsolonenko;


import java.util.Map;

public class TheFourth {

    //Не получится, так как создаются копии
    public static void swap(int a, int b) {
        int c = a;
        a = b;
        b = c;
    }

    //Не получится, так как создаются копии
    public static void swap(Integer a, Integer b) {
        Integer c = a;
        a = b;
        b = c;
    }

    static class IntHolder {

        int value;

        public IntHolder(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "IntHolder{" +
                    "value=" + value +
                    '}';
        }
    }

    public static void swap(IntHolder a, IntHolder b) {
        int c = a.value;
        a.value = b.value;
        b.value = c;
    }



    public static void main(String[] args) {
        int a = 100;
        int b = 1000;
        System.out.println("Was here: a = " + a + " b = " + b);
        swap(a, b);
        System.out.println("a = " + a + " b = " + b);

        Integer a1 = 100;
        Integer b1 = 1000;
        System.out.println("Was here: a = " + a1 + " b = " + b1);
        swap(a1, b1);
        System.out.println("a = " + a1 + " b = " + b1);

        IntHolder a2 = new IntHolder(5);
        IntHolder b2 = new IntHolder(6);
        swap(a2, b2);

        System.out.println(a2);
        System.out.println(b2);

    }
}