package self.recursion;

public class ReverseString {
    private static String reverseString(String s) {
        int len = s.length();
        String lastChar = s.substring(len-1);
        String remainString = s.substring(0, len-1);
        if(len == 1) {
            return s;
        }
        return lastChar + reverseString(remainString);
    }

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(reverseString(s));
    }
}
