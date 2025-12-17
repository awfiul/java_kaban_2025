package hw;

import java.util.StringJoiner;

public class Practice2_StringJoiner {

    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(", ");
        joiner.add("Java");
        joiner.add("Spring");
        joiner.add("Hibernate");
        System.out.println(joiner);

        StringJoiner joinerWithBrackets =
                new StringJoiner(" -> ", "{", "}");
        joinerWithBrackets.add("Дарья");
        joinerWithBrackets.add("Backend");
        joinerWithBrackets.add("Developer");
        System.out.println(joinerWithBrackets);
    }
}
