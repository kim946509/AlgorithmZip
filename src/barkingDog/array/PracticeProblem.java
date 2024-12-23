package barkingDog.array;

import java.util.Arrays;

public class PracticeProblem {

    public static void main(String[] args) {
        int[] arr = {4,13,63,87};
        System.out.println(func2Sol(arr));
    }

    /**
     * 내가 생각한 솔루션
     * 시간복잡도 : O(nlogn)
     */
    public static int func2(int[] arr){
        Arrays.sort(arr);
        int leftCur = 0;
        int rightCur = arr.length-1;

        while(leftCur < rightCur){
            int sumValue = arr[leftCur] + arr[rightCur];
            if(sumValue == 100){
                return 1;
            }
            else if( sumValue>100 ){
                rightCur--;
            }
            else if( sumValue<100){
                leftCur++;
            }
        }
        return 0;
    }

    public static int func2Sol(int[] arr){
        Boolean[] isPresent = new Boolean[101];
        Arrays.fill(isPresent, false);
        for(int i = 0 ; i<arr.length;i++){
            int num = arr[i];
            if(isPresent[100-num]){
                return 1;
            }
            isPresent[num]=true;
        }
        return 0;
    }
}
