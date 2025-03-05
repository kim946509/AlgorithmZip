import java.io.IOException;
import java.util.Scanner;

class Main {

    static boolean isUsed[];
    static int n;
    static int m;

    private static void sequence(int cur, int count) {
        if (count == m) {
            // for (int i = 1; i <= n; i++) {
            // System.out.print(isUsed[i] + " ");
            // }
            // System.out.println();
            for (int i = 1; i <= n; i++) {

                if (isUsed[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = cur; i <= n; i++) {
            isUsed[i] = true;
            sequence(i + 1, count + 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        isUsed = new boolean[n + 1];
        sequence(1, 0);
    }
}