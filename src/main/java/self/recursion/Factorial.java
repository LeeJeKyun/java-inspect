package self.recursion;

public class Factorial {
    private static int factorial(int n) {
        if(n==0) {
            return 1;
        }
        return n*factorial(n-1);
    }

    public static void main(String[] args) {
        int n = 5;
        int result = factorial(5);
        System.out.println("result = " + result);
    }
}
