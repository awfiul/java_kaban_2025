package hw;

/*
Суперкласс
*/
class User {

    protected String name;
    protected int age;

    public User(String name) {
        this.name = name;
        this.age = 0;
        System.out.println("Конструктор User(String)");
    }

    public void printInfo() {
        System.out.println("User: " + name + ", age = " + age);
    }
}

/*
Подкласс
*/
class AdvancedUser extends User {

    public AdvancedUser(String name, int age) {
        // 1. Вызов конструктора суперкласса
        super(name);
        this.age = age;
        System.out.println("Конструктор AdvancedUser");
    }

    @Override
    public void printInfo() {
        // 2. Доступ к полю суперкласса
        System.out.println("Имя (super.name): " + super.name);

        // 3. Вызов метода суперкласса
        super.printInfo();
    }
}
