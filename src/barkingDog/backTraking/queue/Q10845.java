package backTraking.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q10845 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();
        int last = -1;
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "push": {
                    int inpu_number = sc.nextInt();
                    queue.offer(inpu_number);
                    last = inpu_number;
                    break;
                }
                case "pop": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;
                }
                case "size": {
                    System.out.println(queue.size());
                    break;
                }
                case "empty": {
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                }
                case "front": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;
                }
                case "back": {
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(last);
                    }
                    break;
                }
                default: {
                    System.out.println("잘못된 명령어입니다.");
                }
            }
        }
    }
}
