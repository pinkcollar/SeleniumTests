public class Fib {

    public static int fib(int n){
        if(n < 2) return 1;
        return fib(n-1) + fib(n-2);
    }

    public static void main(String args[]){
        int n = 5;
        int k = 1;
        while ( k <= n) {
            System.out.print(fib(k) + " ");
            k++;
        }
    }
}
