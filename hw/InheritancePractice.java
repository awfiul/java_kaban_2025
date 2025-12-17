package hw;

public class InheritancePractice {

    public static void main(String[] args) {

        ChildAccount account = new ChildAccount();
        account.printInfo();
    }
}

/*
Суперкласс
*/
class BaseAccount {

    int id;                 // default
    public String owner;    // public
    protected double sum;   // protected
    private String secret;  // private

    BaseAccount() {
        this.id = 1;
        this.owner = "Дарья";
        this.sum = 100.0;
        this.secret = "hidden";
    }

    void showId() {
        System.out.println("id = " + id);
    }

    public void showOwner() {
        System.out.println("owner = " + owner);
    }

    protected void showSum() {
        System.out.println("sum = " + sum);
    }

    private void showSecret() {
        System.out.println("secret = " + secret);
    }
}

/*
Подкласс
*/
class ChildAccount extends BaseAccount {

    public void printInfo() {

        // this — обращение к полям текущего объекта
        System.out.println("this.owner = " + this.owner);

        // super — обращение к полям и методам суперкласса
        super.showId();
        super.showOwner();
        super.showSum();

        // private-члены суперкласса недоступны
        // super.secret;        // ошибка компиляции
        // super.showSecret();  // ошибка компиляции
    }
}
