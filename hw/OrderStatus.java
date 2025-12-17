package hw;

/*
Перечисление с инициализацией элементов.
Каждый элемент хранит дополнительное состояние.
*/
public enum OrderStatus {

    NEW("Создан", false),
    IN_PROGRESS("В работе", false),
    DONE("Завершен", true),
    CANCELED("Отменен", true);

    private final String description;
    private final boolean finished;

    // Конструктор enum всегда private (неявно)
    OrderStatus(String description, boolean finished) {
        this.description = description;
        this.finished = finished;
    }

    public String getDescription() {
        return description;
    }

    public boolean isFinal() {
        return finished;
    }
}
