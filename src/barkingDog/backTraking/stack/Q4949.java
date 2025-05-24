package backTraking.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String sentence = sc.nextLine();

            // 종료 조건
            if (sentence.equals(".")) {
                break;
            }

            String result = "yes"; // 결과 변수
            Deque<Character> stack = new ArrayDeque<>(100);
            for (int i = 0; i < sentence.length(); i++) {
                char c = sentence.charAt(i);
                if (c == '.') {
                    break;
                }
                if (c != '(' && c != ')' && c != '[' && c != ']') {
                    continue;
                }

                switch (c) {
                    case '(': {
                        stack.offer('(');
                        break;
                    }
                    case '[': {
                        stack.offer('[');
                        break;
                    }
                    case ')': {
                        Character sign = stack.pollLast();
                        if (sign == null || sign != '(') {
                            result = "no";
                        }
                        break;
                    }
                    case ']': {
                        Character sign = stack.pollLast();
                        if (sign == null || sign != '[') {
                            result = "no";
                        }
                        break;
                    }
                }

                if (result.equals("no")) {
                    break;
                }
            }

            if (!stack.isEmpty()) {
                result = "no";
            }

            System.out.println(result);
        }
    }
}
