package barkingDog.recursive;

import java.util.Scanner;

public class Q1629 {
    public static Long calcurate(Long a, Long b, Long c) {
        if (b == 1) {
            return a % c;
        }
        Long val = calcurate(a, b / 2, c);
        val = val * val % c;
        if (b % 2 == 0) {
            return val % c;
        }
        return val * a % c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        System.out.println(calcurate(a, b, c));
    }
}
