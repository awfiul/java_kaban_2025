package hw;

public class EnumPractice {

    public static void main(String[] args) {

        OrderStatus status = OrderStatus.NEW;

        System.out.println("Статус: " + status);
        System.out.println("Описание: " + status.getDescription());

        if (status.isFinal()) {
            System.out.println("Заказ завершен");
        } else {
            System.out.println("Заказ еще в процессе");
        }
    }
}
