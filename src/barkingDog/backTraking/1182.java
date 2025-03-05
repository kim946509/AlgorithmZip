package barkingDog.backTraking;

import java.io.IOException;
import java.util.Scanner;

class Main {

    static int count = 0;
    static int n;
    static int s;

    private static void sequence(int arr[], int cur, int sum) {
        if (cur == n) {
            if (sum == s) {
                count++;
            }
            return;
        }

        sequence(arr, cur + 1, sum);
        sequence(arr, cur + 1, sum + arr[cur]);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sequence(arr, 0, 0);
        if (s == 0) {
            count--;
        }
        System.out.println(count);
    }
}