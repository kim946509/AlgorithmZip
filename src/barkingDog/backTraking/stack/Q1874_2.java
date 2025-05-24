package backTraking.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q1874_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 리스트 초기화. 1..n까지
        Queue<Integer> before = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            before.add(i);
        }
        int number = 1;

        // 결과로 필요한 수열 입력
        Queue<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            sequence.add(sc.nextInt());
        }

        // 결과 커맨드를 저장할 변수
        List<Character> commands = new ArrayList<>();

        // 스택에 저장할 변수
        java.util.Stack<Integer> stack = new Stack<>();

        while (!sequence.isEmpty()) {
            // 필요한 숫자까지 stack에 넣음.
            if (sequence.peek() >= number) {
                while (number <= sequence.peek()) {
                    stack.push(number);
                    commands.add('+');
                    number++;
                }
            }

            // 스택에 뽑은 숫자와 수열에 뽑은 숫자가 다를 경우 NO출력함.
            if (!stack.pop().equals(sequence.poll())) {
                System.out.println("NO");
                return;
            }
            commands.add('-');
        }

        for (int i = 0; i < commands.size(); i++) {
            System.out.println(commands.get(i));
        }

    }
}
