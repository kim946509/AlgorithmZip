package programers;

import java.util.Stack;

public class CorrectBracket {
    public static void main(String[] args) {
        String brakets = ")()(";
        System.out.println(solution(brakets));
    }

    private static boolean solution(String s){

        Stack<Character> bucket= new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                bucket.push(s.charAt(i));
            }
            else{
                if(bucket.empty())
                    return false;
                else
                    bucket.pop();
            }
        }

        return bucket.empty();
    }
}
