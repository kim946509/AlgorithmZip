package programers;

import java.util.ArrayList;
import java.util.Comparator;

public class KthNumber {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {new int[]{2, 5, 3},new int[]{4,4,1},new int[]{1,7,3}};
        int[] solution = solution(array, commands);
        for (int i : solution) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] array, int[][] commands){
        ArrayList<Integer> answerList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i : array) {
            arrayList.add(i);
        }
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1]-1;
            int cur = commands[i][2]-1;
            ArrayList<Integer> subList = new ArrayList<>();
            for (int j = start; j < end+1 ; j++) {
                subList.add(arrayList.get(j));
            }
            subList.sort(Comparator.naturalOrder());
            answerList.add(subList.get(cur));
        }
        int[] answerA = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answerA[i]=answerList.get(i);
        }
        return answerA;
    }
}
