package hw;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationsPractice {

    public static void main(String[] args) {

        ChildTask task = new ChildTask();
        task.execute();

        LegacyService service = new LegacyService();
        service.oldMethod();
    }
}
