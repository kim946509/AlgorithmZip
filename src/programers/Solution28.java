package programers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution28 {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> numberList = new ArrayList<>();
        for(int number : numbers){
            numberList.add(String.valueOf(number));
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int index = 0;
                while(index>=s1.length() || index>=s2.length()){
                    if(s1.charAt(index)!=s2.charAt(index))
                        return (s2.charAt(index)) - (s1.charAt(index));
                    index++;
                }
                if(s1.length()>s2.length()){
                    if((s1.charAt(s1.length()-1))>(s1.charAt(s1.length()-2))){
                        return -1;
                    }
                    else
                        return 1;
                }
                else {
                    if ((s2.charAt(s2.length() - 1)) > (s2.charAt(s2.length() - 2))) {
                        return -1;
                    } else
                        return 1;
                }
            }
        };
        numberList.sort(comp);

        return answer;
    }
}

/**
 - 정렬방법
 - 맨 앞자리의 대 소 비교
 - 만약 앞자리가 같다면
 - 뒤에 자리 대소 비교 반복
 - 뒤에 자리가 한쪽만 있다면?
 - 뒤에 자리가 있는수의 숫자가 바로 앞의자리 숫자보다 클경우 해당 숫자가 큼.

 1. int[] 배열을 String[] 배열로 바꾼다.
 2.해당 정렬 방법을 통해 문자열을 정렬하고 전부 StringBuilder로 이어서 return 함.
 */