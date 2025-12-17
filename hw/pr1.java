package hw;

class ParentTask {
    void execute() {
        System.out.println("Выполнение задачи родителем");
    }
}

class ChildTask extends ParentTask {

    @Override
    void execute() {
        System.out.println("Выполнение задачи потомком");
    }
}
