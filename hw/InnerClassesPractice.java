package hw;

public class InnerClassesPractice {

    public static void main(String[] args) {

        Container container = new Container();

        // Доступ к public inner-классу извне
        Container.PublicInner pub = container.new PublicInner();
        pub.print();

        // Доступ к default inner-классу (тот же пакет)
        Container.PackageInner pack = container.new PackageInner();
        pack.print();

        // Доступ к protected inner-классу (тот же пакет)
        Container.ProtectedInner prot = container.new ProtectedInner();
        prot.print();

        // Private inner-класс недоступен извне
        // Container.PrivateInner priv = container.new PrivateInner(); // ошибка
    }
}

/*
Внешний класс
*/
class Container {

    private String secret = "секретное поле";
    protected int value = 42;

    // =========================
    // Практика #1
    // Спецификаторы доступа
    // =========================

    // public — доступен отовсюду
    public class PublicInner {
        public void print() {
            System.out.println("PublicInner, secret = " + secret);
        }
    }

    // default — доступен только внутри пакета
    class PackageInner {
        public void print() {
            System.out.println("PackageInner, value = " + value);
        }
    }

    // protected — доступен в пакете и в подклассах
    protected class ProtectedInner {
        public void print() {
            System.out.println("ProtectedInner, secret = " + secret);
        }
    }

    // private — доступен только внутри внешнего класса
    private class PrivateInner {
        private String data = "inner data";

        private void show() {
            System.out.println(data);
        }
    }

    // =========================
    // Практика #3
    // Доступ внешнего класса
    // =========================

    public void usePrivateInner() {
        PrivateInner inner = new PrivateInner();
        System.out.println(inner.data);
        inner.show();
    }
}
