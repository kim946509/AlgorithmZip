package baekJoon.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//시간초과로 해결 X
public class q1874x {
    static Stack<Integer> midStack = new Stack<>(); //중간 과정 스택
    static ArrayList<Integer> result; //결과를 저장할 배열?
    static ArrayList<Character> process = new ArrayList<>(); //중간 +, -를 저장할 배열
    static ArrayList<Integer> num = new ArrayList<>(); //1..n까지 배열


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        //1..n숫자 수열 만들기
        for (int i = 0; i < size; i++) {
            num.add(i+1);
        }

        //결과로 만들어야 하는 arr 만들기
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arr.add(sc.nextInt());
        }

        if(makeArr(0,arr))
            for (int i = 0; i < process.size(); i++) {
                System.out.println(process.get(i));
            }
        else
            System.out.println("NO");
    }

    private static boolean makeArr(int index, List<Integer> arr){
        if(index==arr.size())
            return true;
        int target = arr.get(index);
        if(num.contains(target)){
            while(true){
                midStack.push(num.get(0));
                process.add('+');
                num.remove(0);
                if(midStack.contains(target)){
                    break;
                }
            }
            midStack.pop();
            process.add('-');
        }
        else if(midStack.contains(target)){
            if(midStack.pop().equals(target)){
                process.add('-');
            }
            else
                return false;
        }
        return makeArr(++index, arr);
    }
}
