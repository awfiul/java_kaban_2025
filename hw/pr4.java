package hw;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ActionInfo {
    int priority();
}
