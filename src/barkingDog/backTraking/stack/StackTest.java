package backTraking.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class StackTest {
    static int N = 100_000_000;

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        // Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack = new LinkedList<>();

        int count = 0;

        while (count++ < N) {
            stack.addLast(1);
        }

        while (count++ < N) {
            stack.pollLast();
        }

        long end = System.currentTimeMillis();

        // System.out.println("===== ArrayDeque =====");
        System.out.println("===== LinkedList =====");
        System.out.println("걸린 시간 : " + (end - start) + "ms");
    }
}