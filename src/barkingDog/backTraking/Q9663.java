package barkingDog.backTraking;

import java.io.IOException;
import java.util.Scanner;

public class Q9663 {

    // 놓을수있는자리 0, 놓을 수 없는 자리는 1
    private static int[][] board;
    private static int count = 0;

    private static void nQeen(int row, int qeenCount) {

        if (row == board.length) {

            // n개의 모든 퀸을 놓는것이 성공하였을때

            count++;

            return;
        }

        for (int j = 0; j < board[row].length; j++) {
            // 놓을 수 있는 자리인지 확인
            if (check(row, j)) {
                board[row][j] = 1;
                nQeen(row + 1, qeenCount + 1);
                board[row][j] = 0;
            }
        }

    }

    private static boolean check(int row, int column) {

        int i = 1;
        row--; // 해당 행 위부터 검사
        while (row >= 0) {
            // 좌상
            if (column - i >= 0 && board[row][column - i] == 1) {
                return false;
            }

            // 상
            if (board[row][column] == 1) {
                return false;
            }

            // 우상
            if (column + i < board[row].length && board[row][column + i] == 1) {
                return false;
            }
            row--;
            i++;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        board = new int[n][n];
        nQeen(0, 0);
        System.out.println(count);
    }
}