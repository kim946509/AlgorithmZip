package programers;

import java.util.*;

public class Solution29 {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerList = new ArrayList<>();

        // 각 주문의 메뉴를 정렬
        String[] sortedOrders = new String[orders.length];
        for(int i = 0; i < orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            sortedOrders[i] = new String(chars);
        }

        for(int courseSize : course) {
            Map<String, Integer> combinationCountMap = new HashMap<>();
            int maxCount = 0;

            // 각 주문별로 조합 생성 및 등장 횟수 계산
            for(String order : sortedOrders) {
                List<String> combinations = new ArrayList<>();
                getAllCombination(order, new StringBuilder(), 0, courseSize, combinations);

                for(String comb : combinations) {
                    if(combinationCountMap.containsKey(comb)){
                        combinationCountMap.put(comb, combinationCountMap.get(comb) + 1);
                    }
                    else
                        combinationCountMap.put(comb, 1);

                    maxCount = Math.max(maxCount, combinationCountMap.get(comb));
                }
            }

            // 최대 등장 횟수가 2 이상이고 maxCount(가장 많은 주문)와 같은 조합을 선택
            List<String> courceList = new ArrayList<>();
            Set<String> combinations = combinationCountMap.keySet();
            for(String comb : combinations){
                if(combinationCountMap.get(comb) == maxCount && maxCount >= 2){
                    courceList.add(comb);
                }
            }
            answerList.addAll(courceList);
        }

        // 결과를 사전순으로 정렬
        Collections.sort(answerList);

        // 리스트를 배열로 변환하여 반환
        String[] answer = new String[answerList.size()];
        answerList.toArray(answer);
        return answer;
    }

    // 모든 조합 생성. 백트래킹을 이용하여 조합 생성
    private void getAllCombination(String order, StringBuilder comb, int start, int r, List<String> combinations) {
        if(comb.length() == r) {
            combinations.add(comb.toString());
            return;
        }

        for(int i = start; i < order.length(); i++) {
            comb.append(order.charAt(i));
            getAllCombination(order, comb, i + 1, r, combinations);
            comb.deleteCharAt(comb.length() - 1);
        }
    }
}
