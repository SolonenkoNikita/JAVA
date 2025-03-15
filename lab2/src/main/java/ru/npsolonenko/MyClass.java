package ru.npsolonenko;

class MyClass {
    private int value;

    public MyClass(int initialValue) {
        this.value = initialValue;
    }

    public MyClass increment() {
        ++this.value;
        return this;
    }

    public MyClass postIncrement() {
        MyClass temp = new MyClass(this.value);
        ++this.value;
        return temp;
    }

    public int getValue() {
        return this.value;
    }

    public static void main(String[] args) {
        MyClass obj = new MyClass(5);

        MyClass oldValue = obj.postIncrement();
        System.out.println("Old value: " + oldValue.getValue()); // 5
        System.out.println("New value: " + obj.getValue()); // 6


        MyClass newObj = obj.increment();
        System.out.println("New value after prefix increment: " + newObj.getValue()); // 7
    }
}

