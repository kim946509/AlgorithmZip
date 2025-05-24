package backTraking.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Q1406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> sentence = new LinkedList<>();
        String input = sc.next();

        for (int i = 0; i < input.length(); i++) {
            sentence.add(input.charAt(i));
        }

        // 명령어 입력 횟수
        int n = sc.nextInt();

        // 명령어 초기 커서 위치
        int cur = sentence.size() - 1;
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            switch (command) {
                case "L": { // 커서를 왼쪽으로 이동
                    cur--;
                    // 맨 왼쪽일 경우 이동 X
                    if (cur < 0) {
                        cur = 0;
                    }
                    break;
                }
                case "D": { // 커서를 오른쪽으로 이동
                    cur++;
                    // 오른쪽 끝일 경우. 이동 X
                    if (cur >= sentence.size()) {
                        cur = sentence.size() - 1;
                    }
                    break;
                }
                case "B": { // 커서 왼쪽에 있는 문자를 삭제
                    // 맨 왼쪽이 아닐경우에만 삭제
                    if (cur > 0) {
                        sentence.remove(cur);
                    }
                    break;
                }
                case "P": { // 이후에 입력되는 문자를 커서 왼쪽에 추가
                    char c = sc.next().charAt(0);
                    int inputIdx = cur - 1;
                    if (inputIdx < 0) {
                        inputIdx = 0;
                    }
                    sentence.add(inputIdx, c);

                    cur++;
                    break;
                }
                default: {
                    System.out.println("입력 커맨드가 잘못되었습니다.");
                }
            }

            // for(int j=0;j<sentence.size();j++){
            // System.out.print(sentence.get(j)+" ");
            // }
            // System.out.println();
        }
        for (int j = 0; j < sentence.size(); j++) {
            System.out.print(sentence.get(j) + " ");
        }
        System.out.println();
    }

}
