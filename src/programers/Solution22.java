package programers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution22 {
    public int solution(String[] users_id, String[] banned_ids) {
        int answer = 0;
        List<Set<String>> satisfyingSetList = new ArrayList<>();
        for(int i=0;i<banned_ids.length;i++){
            Set<String> satisfyingSet = getSatisfyingSet(users_id, banned_ids[i]);
            satisfyingSetList.add(satisfyingSet);
        }
        for (Set<String> strings : satisfyingSetList) {
            System.out.println(strings);
        }

        Set<Set<String>> pickedUserId = new HashSet<>();
        pickedUserId(satisfyingSetList, new HashSet<>(), 0, pickedUserId);
        for(Set<String> set : pickedUserId){
            System.out.println("set = " + set);
        }
        return pickedUserId.size();
    }

    //모든 경우의 수를 구하는 함수. 재귀함수를 통해 구현.
    private void pickedUserId(List<Set<String>> satisfyingSetList, Set<String> pickedUserId, int index, Set<Set<String>> pickedUserIdSet){
        if(index == satisfyingSetList.size()){
            if(pickedUserId.size() == satisfyingSetList.size()) {
                pickedUserIdSet.add(new HashSet<>(pickedUserId));
            }
            return;
        }
        // 현재 banned_id에 해당하는 만족하는 사용자 아이디를 하나씩 선택
        Set<String> satisfyingSet = satisfyingSetList.get(index);
        for (String userId : satisfyingSet) {
            // 이미 선택된 아이디라면 패스 (중복되지 않도록)
            if (pickedUserId.contains(userId)) {
                continue;
            }

            pickedUserId.add(userId); // 아이디를 선택
            pickedUserId(satisfyingSetList, pickedUserId, index + 1, pickedUserIdSet); // 다음 단계로 진행
            pickedUserId.remove(userId); // 백트래킹: 선택한 아이디를 제거
        }
    }

    private Set<String> getSatisfyingSet(String[] users_id, String banned_id){
        Set<String> satisfyingSet=new HashSet<>();
        boolean check;

        for(String user : users_id){
            check=true;

            //길이가 다르면 무조건 불만족함.
            if(user.length()!=banned_id.length())
                continue;

            //길이가 같은 경우 한글자 씩 검사
            for (int i = 0; i < banned_id.length(); i++) {
                // *일경우 무조건 통과
                if(banned_id.charAt(i)!='*'&&banned_id.charAt(i)!=user.charAt(i)) {
                    check=false;
                    break;
                }
            }

            //만족할 경우 set에 추가
            if(check)
                satisfyingSet.add(user);
        }
        return satisfyingSet;
    }
}
