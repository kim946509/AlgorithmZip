package programers;

import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution20 {
    private static final String[][] precedences = {
            {"+", "-", "*"},
            {"+", "*", "-"},
            {"-", "+", "*"},
            {"-", "*", "+"},
            {"*", "+", "-"},
            {"*", "-", "+"}
    };
    private long calculate(long lhs, long rhs, String operater){
        return switch (operater) {
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private long calculate(List<String> tokens, String[] precedence){
        for (String operator : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if(tokens.get(i).equals(operator)){
                    long lhs = Long.parseLong(tokens.get(i-1));
                    long rhs = Long.parseLong(tokens.get(i+1));
                    long result = calculate(lhs, rhs, operator);
                    tokens.remove(i+1);
                    tokens.remove(i);
                    tokens.set(i-1, String.valueOf(result));
                    i--;
                }
            }
        }
        return Math.abs(Long.parseLong(tokens.get(0)));
    }

    public long solution(String expression) {
        StringTokenizer tokenizer  = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new LinkedList<>();
        while (tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for(String[] precedence : precedences){
            long result = calculate(new LinkedList<>(tokens),precedence);
            if(result > max){
                max = result;
            }
        }
        return max;
    }
}

/**
 * - +, -. *의 우선순위를 정하고 모든 경우의 수를구한다.
 * - 우선순위가 높은 연산자 부터 앞에서부터 계산을 진행한다.
 *   - 해당되는 연산자를 찾는다.
 *   - 연산자를 기준으로 왼쪽 숫자와, 오륹쪽 숫자를 찾는다.
 *   - 계산한다.
 *   - 해당숫자로 해당 부분을 교체한다.
 * - 절댓값이 가장 높은 결과를 return 한다.
 */