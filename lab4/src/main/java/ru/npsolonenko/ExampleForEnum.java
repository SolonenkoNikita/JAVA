package ru.npsolonenko;

import java.util.EnumSet;

public class ExampleForEnum {

    interface AI {
        default int p() {
            System.out.println("A");
            return 0;
        }
    }

    interface BI {
        default void p() {
            System.out.println("B");
        };
    }

    class C implements AI, BI {

        

    }



    public abstract class A {

        abstract void p();
    }

    public abstract class B extends A {

    }

}
