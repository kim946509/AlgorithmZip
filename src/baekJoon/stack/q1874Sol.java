package baekJoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class q1874Sol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int size = sc.nextInt();

        int start = 0;

        for (int i = 0; i < size; i++) {
            int value = sc.nextInt();

            if(value > start){
                for (int j = start+1; j <= value ; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                start = value;
            }
            else if(stack.peek()!=value){
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}
