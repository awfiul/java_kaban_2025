package hw;

@ActionInfo(priority = 3)
class TaskProcessor {

    void process() {
        Class<?> clazz = this.getClass();
        ActionInfo info = clazz.getAnnotation(ActionInfo.class);
        System.out.println("priority = " + info.priority());
    }
}
