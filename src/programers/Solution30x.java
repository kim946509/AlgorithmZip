package programers;

import java.util.HashSet;
import java.util.Set;

public class Solution30x {
//        Solution2
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0;i<query.length;i++){
            query[i] = query[i].replaceAll("and ", "");
            String[] split = query[i].split(" ");
            Set<Integer> satisfyingLanguage = new HashSet<>();
            Set<Integer> satisfyingJob = new HashSet<>();
            Set<Integer> satisfyingCareer = new HashSet<>();
            Set<Integer> satisfyingFood = new HashSet<>();
            Set<Integer> satisfyingScore = new HashSet<>();

            for(int j = 0; j<info.length;j++){
                String[] splitInfo = info[j].split(" ");
                if(split[0].equals("-")||split[0].equals(splitInfo[0])){
                    satisfyingLanguage.add(j);
                }
                if(split[1].equals("-")||split[1].equals(splitInfo[1])){
                    satisfyingJob.add(j);
                }
                if(split[2].equals("-")||split[2].equals(splitInfo[2])){
                    satisfyingCareer.add(j);
                }
                if(split[3].equals("-")||split[3].equals(splitInfo[3])){
                    satisfyingFood.add(j);
                }
                if(split[4].equals("-")||Integer.parseInt(split[4])<=Integer.parseInt(splitInfo[4])){
                    satisfyingScore.add(j);
                }
            }
            satisfyingLanguage.retainAll(satisfyingJob);
            satisfyingLanguage.retainAll(satisfyingCareer);
            satisfyingLanguage.retainAll(satisfyingFood);
            satisfyingLanguage.retainAll(satisfyingScore);
            int count = satisfyingLanguage.size();
            answer[i]=count;
            System.out.println("count = " + count);
        }
        return answer;
    }


}
/**
 * 1. query를 순회하며 조건을 분리한다.
 * 2. 각각의 조건(언어, 직군, 경력, 소울푸드, 점수)에 맞는 사람들의 index를 Set에 저장한다.
 * 3. 각각의 조건에 맞는 사람들의 index를 교집합하여 결과를 반환한다.
 시간복잡도 \
 query의 길이 m X info의 길이 n X 5(조건의 수) = 5mn

 시간 초과 발생
 */
