package hw;

class A {
    int value = 10;

    void show() {
        System.out.println("A.show(), value = " + value);
    }
}

class B extends A {
    // ничего не объявлено
}

class C extends B {

    void show() {
        int local = super.value;
        System.out.println("C.show(), super.value = " + local);
        super.show();
    }
}
