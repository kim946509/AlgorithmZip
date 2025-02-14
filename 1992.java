import java.io.IOException;
import java.util.Scanner;

class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void press(int n, int x, int y, int[][] board) {

        // BaseCondition
        if (n == 1) {
            sb.append(board[y][x]);
            return;
        }

        if (check(n, x, y, board)) {
            sb.append(board[y][x]);
            return;
        }

        sb.append('(');
        // 왼쪽 위
        press(n / 2, x, y, board);

        // 오른쪽 위
        press(n / 2, n / 2 + x, y, board);

        // 왼쪽 아래
        press(n / 2, x, n / 2 + y, board);

        // 오른쪽 아래
        press(n / 2, n / 2 + x, n / 2 + y, board);

        sb.append(')');

    }

    public static boolean check(int n, int x, int y, int[][] board) {
        int pivot = board[y][x];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pivot != board[y + i][x + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String column = sc.next();
            for (int j = 0; j < n; j++) {
                board[i][j] = Character.getNumericValue(column.charAt(j));
            }
        }

        press(n, 0, 0, board);
        System.out.println(sb);
    }
}