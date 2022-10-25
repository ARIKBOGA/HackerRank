public class CamelCase {


    public static String camelCase(String str) {
        str = str.trim();
        str = str.replaceAll("[^\\w\\s]", " ");

        String result = "";

        String[] arr = str.split(" ");
        arr[0] = arr[0].toLowerCase();
        result += arr[0];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1).toLowerCase();
            result += arr[i];
        }
        return result;
    }

    public static int camelcase(String s) {
        return (int) s.chars()
                .filter(Character::isUpperCase)
                .count() + 1;
    }

    public static void main(String[] args) {
        System.out.println("camelCase(\"cats AND*Dogs-are Awesome\") = " + camelCase("cats AND*Dogs-are Awesome"));

        System.out.println("camelcase(\"saveChangesInTheEditor\") = " + camelcase("saveChangesInTheEditor"));
    }
}
