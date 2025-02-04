package self.recursion;

public class SumNaturalNum {
    private static int naturalSum(int n) {
        if( n==1 ) return 1;
        return n + naturalSum(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(naturalSum(n));
    }
}
