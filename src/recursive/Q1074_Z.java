package recursive;

import java.util.Scanner;

public class Q1074_Z {

    public static int func(int n, int r, int c){
        if(n==0){
            return 0;
        }
        int half = (int)Math.pow(2,n-1);
        // 첫번째 사각형
        if(r<half &&  c<half){
            return func(n-1, r, c);
        }
        // 두번째 사각형
        else if(r<half && c >= half){
            return func(n-1, r, c-half) + half*half;
        }
        // 세번째 사각형
        else if(r >= half && c<half){
            return func(n-1,r-half,c ) + half*half*2;
        }
        // 네번째 사각형
        else {
            return func(n-1,r-half,c-half) + half*half*3;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(func(n,r,c));
    }
}
