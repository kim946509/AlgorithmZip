package programers;

public class Main {

    public static void main(String[] args) {

        Solution23 solution23 = new Solution23();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution23.solution(array,commands));

    }
}

