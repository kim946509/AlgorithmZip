package programers;

import java.util.ArrayList;
import java.util.Comparator;

public class H_index {

    public static void main(String[] args) {
        int[] citiations = {1, 11, 111, 1111};
        System.out.println(solution(citiations));
    }

    public static int solution(int[] citations){
        int answer = 0;
        ArrayList<Integer> listCitations = new ArrayList<>();
        for (int citation : citations) {
            listCitations.add(citation);
        }
        listCitations.sort(Comparator.naturalOrder());
        int start = 0;
        int end = listCitations.size()-1;
        int middle = (start+end-1)/2;

        answer = find(listCitations, start, end, middle, answer);
        return answer;
    }

    public static int find(ArrayList<Integer> listCitations, int start, int end, int middle, int answer){

        if(start>end)
            return answer;

        int n = listCitations.size();
        middle = (start+end)/2;
        int value = listCitations.get(middle);


        if(n-middle == value){
            answer = value;
            return answer;
        }

        //오른쪽 검사
        else if(n-middle > value){
            start= middle+1;
            answer = find(listCitations, start, end, middle, answer);
        }

        //왼쪽 검사
        else if(n-middle < value){
            end = middle-1;
            if(answer < n-middle)
                answer = n-middle;
            answer = find(listCitations, start, end, middle,answer);
        }

        return answer;
    }
}
