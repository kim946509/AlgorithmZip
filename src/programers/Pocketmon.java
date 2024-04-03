package programers;

import java.util.HashSet;

public class Pocketmon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> buckets = new HashSet<>();
        for(int num : nums){
            buckets.add(num);
        }
        return Math.min(buckets.size(), nums.length / 2);
    }
}
