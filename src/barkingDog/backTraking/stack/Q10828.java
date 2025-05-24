package backTraking.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");
            switch (command[0]) {
                case "push": {
                    if (command[0] != null && !command[0].isEmpty()) {
                        stack.push(Integer.parseInt(command[1]));
                    }
                    break;
                }
                case "pop": {
                    if (!stack.isEmpty()) {
                        System.out.println(stack.pop());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
                case "size": {
                    System.out.println(stack.size());
                    break;
                }
                case "empty": {
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
                case "top": {
                    if (!stack.isEmpty()) {
                        System.out.println(stack.lastElement());
                    } else {
                        System.out.println(-1);
                    }
                    break;
                }
                default: {
                    System.out.println("존재하지 않는 명령입니다.");
                }
            }
        }

    }
}
