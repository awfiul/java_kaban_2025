package hw;

public class Practice2_StringConversions {

    public static void main(String[] args) {

        // String -> StringBuilder
        String text = "Java";
        StringBuilder builder = new StringBuilder(text);

        // String -> StringBuffer
        StringBuffer buffer = new StringBuffer(text);

        // StringBuilder -> String
        String fromBuilder = builder.toString();

        // StringBuffer -> String
        String fromBuffer = buffer.toString();

        // StringBuilder -> StringBuffer
        StringBuffer bufferFromBuilder =
                new StringBuffer(builder.toString());

        // StringBuffer -> StringBuilder
        StringBuilder builderFromBuffer =
                new StringBuilder(buffer.toString());

        System.out.println(fromBuilder);
        System.out.println(fromBuffer);
        System.out.println(bufferFromBuilder);
        System.out.println(builderFromBuffer);
    }
}
