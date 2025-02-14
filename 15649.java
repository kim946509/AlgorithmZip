import java.io.IOException;
import java.util.Scanner;

class Main {

    private static boolean[] isUsed;

    private static void pick(int k, int n, int m, int[] arr) {
        if (k == m) {
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                pick(k + 1, n, m, arr);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        final int n = sc.nextInt();
        final int m = sc.nextInt();
        isUsed = new boolean[n + 1];
        int[] arr = new int[m];
        pick(0, n, m, arr);
    }
}