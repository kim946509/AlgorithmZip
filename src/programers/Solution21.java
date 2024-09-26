package programers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution21 {
    public int solution(String numbers) {
        List<String> numbersList = new ArrayList<>(List.of(numbers.split("")));
        List<String> pickedNumber = new ArrayList<>();
        Set<List<String>> allCombinationNumbers = new HashSet<>();
        pickedNumber(numbersList, pickedNumber, allCombinationNumbers);
        for (List<String> allCombinationNumber : allCombinationNumbers) {
            System.out.println("allCombinationNumber = " + allCombinationNumber);
        }

        Set<Integer> primeNumbers = new HashSet<>();
        for(List<String> allCombinationNumber : allCombinationNumbers){
            StringBuilder sb = new StringBuilder();
            for(String number : allCombinationNumber){
                sb.append(number);
            }
            int number = Integer.parseInt(sb.toString());
            if(isPrimeNumber(number)){
                primeNumbers.add(number);
            }
        }
        return primeNumbers.size();
    }

    // 모든 경우의 숫자 조합을 재귀함수를 통해 구한다.
    private void pickedNumber(List<String> numbers, List<String> pickedNumber, Set<List<String>> pickedNumbers){
        List<String> remainNumbers = new ArrayList<>(numbers);
        if(numbers.isEmpty()){
            return;
        }
        for (String number : numbers) {
            pickedNumber.add(number);
            remainNumbers.remove(number);
            pickedNumbers.add(new ArrayList<>(pickedNumber));
            pickedNumber(remainNumbers, pickedNumber, pickedNumbers);
            pickedNumber.remove(number);
            remainNumbers.add(number);
        }
    }

    // 해당 숫자가 소수인지 확인한다.
    private boolean isPrimeNumber(int number){
        if(number == 0 || number == 1){
            return false;
        }
        for(int i = 2; i <= number/2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}

/**
 * - 모든 경우의 숫자 조합을 재귀함수를 통해 구한다.
 * - 해당 숫자가 소수인지 확인한다.
 * - 소수라면 answer를 증가시킨다.
 */