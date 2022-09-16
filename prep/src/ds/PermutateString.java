package ds;

public class PermutateString {

    public static void main(String[] args) {
        String str = "abc";
        String offset = "";
        permute(str, offset);
    }

    private static void permute(String str, String offset) {
        if (str.isEmpty()) {
            System.out.println(offset + "");
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String left = str.substring(0, i);
                String right = str.substring(i + 1);
                String rest = left + right;
                permute(rest, offset + ch);
            }
        }
    }
}
