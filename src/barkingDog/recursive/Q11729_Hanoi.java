package recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q11729_Hanoi {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void func(int a, int b, int n) throws IOException {
        if(n==1){
            bw.write(a+" "+ b + "\n" );
//            System.out.println(a+" "+ b);
            return;
        }
        func(a, 6-a-b, n-1);
        bw.write(a+" "+ b + "\n" );
        func(6-a-b,b,n-1);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println((int)(Math.pow(2,n)-1));
        func(1,3,n);
        bw.flush();
    }
}
