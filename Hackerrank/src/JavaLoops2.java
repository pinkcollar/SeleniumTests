import java.util.Scanner;

public class JavaLoops2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q > 0) {

            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int next = a;
            next =  next + ((int) Math.pow(2, 0) * b);
            System.out.print(next + " ");
            for (int i = 1; i < n; i++) {

                next = next + ((int) Math.pow(2, i) * b);
                System.out.print(next + " ");
            }

            q--;

        }
    }
}
