package programers;

public class NumsAndWords {

    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder alpha = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (alpha.capacity()!=0) {
                for (int j = 0; j < nums.length; j++) {
                    if (alpha.toString().equals(nums[j])) {
                        answer.append(j);
                        alpha.delete(0,alpha.length());
                    }
                }
            }
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                answer.append(s.charAt(i));
            } else {
                alpha.append(s.charAt(i));
            }
        }
        if (!alpha.isEmpty()) {
            for (int j = 0; j < nums.length; j++) {
                if (alpha.toString().equals(nums[j])) {
                    answer.append(j);
                    alpha.delete(0,alpha.length());
                }
            }
        }
        return Integer.parseInt(answer.toString());
    }
}
