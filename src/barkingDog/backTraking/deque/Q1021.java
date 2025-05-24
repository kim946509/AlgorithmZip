package backTraking.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int loop = sc.nextInt();
        int[] drawNumbers = new int[loop];
        for (int i = 0; i < loop; i++) {
            drawNumbers[i] = sc.nextInt();
        }

        // 1..N을 저장할 수열
        List<Integer> sequence = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            sequence.add(i);
        }

        // 횟수를 저장할 변수
        int count = 0;

        // 뽑기 진행
        for (int drawNumber : drawNumbers) {
            while (true) {
                if (sequence.get(0).equals(drawNumber)) {
                    sequence.remove(0);
                    break;
                }

                // 해당 숫자가 존재하는 인덱스
                int index = sequence.indexOf(drawNumber);

                if (sequence.size() / 2 >= index) {
                    // 왼쪽으로 이동(첫번째 숫자가 마지막으로 이동함)
                    int removeNumber = sequence.remove(0);
                    sequence.add(removeNumber);
                } else if (sequence.size() / 2 < index) {
                    // 오른쪽으로 이동(마지막 숫자가 첫번째로 오게됨)
                    int removeNumber = sequence.remove(sequence.size() - 1);
                    sequence.add(0, removeNumber);
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
