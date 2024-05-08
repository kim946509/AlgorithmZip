package programers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Clothes {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        solution(clothes);
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String,Integer> category = new HashMap<String,Integer>();
        for (int i = 0; i < clothes.length; i++) {
            if(category.containsKey(clothes[i][1])){
                category.put(clothes[i][1], category.get(clothes[i][1])+1);
            }
            else
                category.put(clothes[i][1],1);
        }
        int n = category.size();
        ArrayList<String> arr = new ArrayList<>();//고른 카테고리를 저장할 배열
        String[] categories = category.keySet().toArray(new String[0]);

        for (int r = 1; r < n; r++) {
            ArrayList<String> combinationArray = combination(arr, categories, 0, n, r);
            System.out.println(combinationArray);
        }

        return answer;
    }
    // 백트래킹 사용
    // 사용 예시 : combination(arr, visited, 0, n, r)
    static ArrayList<String> combination(ArrayList<String> arr, String[] categories, int start, int n, int r) {
        if(r == 0) {
            return arr;
        }

        for(int i=start; i<n; i++) {
            arr.add(categories[i]);
            combination(arr,categories, i + 1, n, r - 1);
            arr.remove(categories[i]);
        }
        return arr;
    }
}
