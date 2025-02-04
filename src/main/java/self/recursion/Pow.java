package self.recursion;

public class Pow {
    private static int pow(int base,int exponent) {
        if(exponent == 1) return base;
        return base * pow(base, exponent-1);
    }

    public static void main(String[] args) {
        int base = 2;
        int exponent = 10;
        System.out.println(pow(2, 10));
    }
}
