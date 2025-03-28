import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        int width = sc.nextInt();
        int stickerCount = sc.nextInt();
        int count = 0;
        int[][] board = new int[height][width];
        List<int[][]> stickers = new ArrayList<>();
        for (int i = 0; i < stickerCount; i++) {
            int stickerHeight = sc.nextInt();
            int stickerWidth = sc.nextInt();
            int[][] sticker = new int[stickerHeight][stickerWidth];
            for (int y = 0; y < stickerHeight; y++) {
                for (int x = 0; x < stickerWidth; x++) {
                    sticker[y][x] = sc.nextInt();
                }
            }
            stickers.add(sticker);
        }

        // 모든 스티커 순회
        for (int[][] sticker : stickers) {
            boolean isPut = false;
            for (int r = 0; r < 4; r++) {
                if (isPut)
                    break;

                int stickerWidth = sticker[0].length;
                int stickerHeight = sticker.length;

                // 1. 모든 시작점 순회
                for (int y = 0; y <= height - stickerHeight; y++) {
                    for (int x = 0; x <= width - stickerWidth; x++) {
                        if (pastable(x, y, board, sticker)) {
                            isPut = true;
                            break;
                        }
                    }
                    if (isPut) {
                        break;
                    }
                }
                sticker = turnSticker(sticker);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1)
                    count++;
            }
        }
        System.out.println(count);
    }

    public static int[][] turnSticker(int[][] sticker) {
        int height = sticker.length;
        int width = sticker[0].length;

        int[][] newSticker = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newSticker[i][j] = sticker[height - 1 - j][i];
            }
        }
        return newSticker;
    }

    public static boolean pastable(int x, int y, int[][] board, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1 && board[y + i][x + j] == 1) {
                    return false;
                }
            }
        }

        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (sticker[i][j] == 1) {
                    board[y + i][x + j] = sticker[i][j];
                }
            }
        }

        return true;
    }
}