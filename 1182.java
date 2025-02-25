import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

class Main {

    static int count = 0;
    static int[] isUsed;
    static int n;
    static int s;

    private static void sequence(int arr[], int cur) {
        if (cur == n) {
            return;
        }

        isUsed[cur] = 1;
        for (int k = cur; k < n; k++) {
            int sum = 0;
            // 전체 부분수열 합을 구함
            for (int j = 0; j < n; j++) {
                if (isUsed[j] == 1) {
                    sum += arr[j];
                }
            }

            // 부분수열 합이 s와 일치할 경우 count추가
            if (sum == s) {
                if (!Arrays.stream(isUsed).allMatch(x -> x == 0)) {
                    count++;
                }
            }
            sequence(arr, cur + 1);
            isUsed[cur] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        isUsed = new int[n];
        sequence(arr, 0);
        System.out.println(count);
    }
}