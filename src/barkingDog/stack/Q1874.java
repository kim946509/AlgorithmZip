package barkingDog.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Q1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //리스트 초기화. 1..n까지
        List<Integer> numbers = new LinkedList<>();
        int numbers_cur = 0;
        for(int i=1;i<=n;i++){
            numbers.add(i);
        }

        //결과로 필요한 수열 입력
        List<Integer> sequence = new ArrayList<>();

        for( int i=0;i<n;i++){
            sequence.add(sc.nextInt());
        }

        //결과 커맨드를 저장할 변수
        List<Character> commands = new ArrayList<>();

        //스택에 저장할 변수
        Stack<Integer> stack = new Stack<>();

        boolean is_sucess=true;
        for(int i=0;i<sequence.size();i++){
            if(numbers.contains(sequence.get(i))){
                while(true) {
                    stack.add(numbers.get(0));
                    commands.add('+');
                    int remove = numbers.remove(0);
                    if(remove==sequence.get(i)){
                        break;
                    }
                }
            }

            if(!stack.peek().equals(sequence.get(i))){
                System.out.println("NO");
                is_sucess=false;
                break;
            }

            stack.pop();
            commands.add('-');
        }

        if(is_sucess){
            for(int i=0;i<commands.size();i++){
                System.out.println(commands.get(i));
            }
        }
//        while(!sequence.isEmpty()){
//            //필요한 숫자가 배열안에 있을 경우
//            if(numbers.contains(sequence.get(0))){
//                //해당 numbers에 숫자가 stack에 옮겨질때까지
//                while(sequence.get(0)!=numbers.get(numbers_cur)){
//                    stack.push(numbers_cur++);
//                    commands.add('+');
//                }
//                stack.push(numbers_cur++);
//                commands.add('+');
//
//            }
//
//            //스택에 존재하지만 마지막 수가 아닐경우
//            if(stack.peek()!=sequence.get(0)){
//                System.out.println("NO");
//                break;
//            }
//
//            //스택에 존재하는데 마지막 수일 경우
//            stack.pop();
//            commands.add('-');
//            sequence.remove(0);
//        }
//
//        //수열이 비어있을경우에, 즉 수열이 모두 완성되었을 경우
//        if(sequence.isEmpty()){
//            for(int i=0;i<commands.size();i++){
//                System.out.println(commands.get(i));
//            }
//        }
    }
}
