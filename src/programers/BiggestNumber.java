package programers;

import java.util.ArrayList;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) {
//        int[] numbers = {3,30,34,5,9};
        int[] numbers = {1000,2000,3000};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String answer = "";
//
//        Comparator<String> ncomparator = new Comparator<String>() {
//            @Override
//            public int compare(String o1,String o2 ) {
//                String s1 = o1 + o2;
//                String s2 = o2 + o1;
//                if(Integer.parseInt(s1)<Integer.parseInt(s2)){
//                    return 1;
//                }
//                else
//                    return -1;
//
//            }
//        };
//
//        ArrayList<String> number = new ArrayList<>();
//        for (Integer i : numbers) {
//            number.add(i.toString());
//        }
//        number.sort(ncomparator);
//        StringBuilder str= new StringBuilder();
//        for (String s : number) {
//            str.append(s);
//        }
//        answer=str.toString();
//        if(answer.charAt(0)=='0')
//            return "0";
//        return answer;
//
        ArrayList<String> numbersList = new ArrayList<>();
        for (Integer number : numbers) {
            numbersList.add(number.toString());
        }
        // 내림차순 정렬
        numbersList.sort((a, b) -> (b + a).compareTo(a + b));
        StringBuilder str= new StringBuilder();
        for (String s : numbersList) {
            str.append(s);
        }
        answer = str.toString();
        if(answer.charAt(0)=='0')
            return "0";
        return answer;
    }

}
