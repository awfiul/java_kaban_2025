package hw;

public class AccessModifiersPractice {

    public static void main(String[] args) {

        BasePerson person = new BasePerson();

        // public — доступен отовсюду
        person.publicName = "Дарья";
        person.showPublic();

        // default (без спецификатора) — доступен внутри пакета hw
        person.defaultAge = 20;
        person.showDefault();

        // protected — доступен внутри пакета hw
        person.protectedCity = "Москва";
        person.showProtected();

        // private — НЕДОСТУПЕН извне класса
        // person.privateSecret = "секрет";     // ошибка компиляции
        // person.showPrivate();                // ошибка компиляции
    }
}

/*
Класс с полями и методами,
объявленными с разными спецификаторами доступа.
*/
class BasePerson {

    // public — доступен везде
    public String publicName;

    // default (package-private) — доступен только внутри пакета
    int defaultAge;

    // protected — доступен в пакете и в подклассах
    protected String protectedCity;

    // private — доступен только внутри этого класса
    private String privateSecret = "hidden";

    public void showPublic() {
        System.out.println("publicName = " + publicName);
    }

    void showDefault() {
        System.out.println("defaultAge = " + defaultAge);
    }

    protected void showProtected() {
        System.out.println("protectedCity = " + protectedCity);
    }

    private void showPrivate() {
        System.out.println("privateSecret = " + privateSecret);
    }
}

/*
Подкласс демонстрирует доступ к protected-членам.
*/
class Student extends BasePerson {

    public void printData() {

        // public — доступен
        publicName = "Дарья";

        // default — доступен, так как тот же пакет
        defaultAge = 21;

        // protected — доступен в подклассе
        protectedCity = "Санкт-Петербург";

        // private — недоступен даже в подклассе
        // privateSecret = "x";   // ошибка компиляции
    }
}
