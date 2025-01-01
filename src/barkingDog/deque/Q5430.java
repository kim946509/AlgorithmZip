package barkingDog.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q5430 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int round=0;round<t;round++){
            String p = sc.next(); //실행 문자열
            int n = sc.nextInt(); //배열 크기

            // 배열 입력[1,2,3,4]에서 숫자만을 numbers에 넣기
            StringBuilder sb = new StringBuilder(sc.next());
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length()-1);
            Deque<Integer> numbers = new ArrayDeque<>();

            if(!sb.toString().isEmpty()) {
                String[] inputNumbers = sb.toString().split(",");
                for (String inputNumber : inputNumbers) {
                    numbers.add(Integer.parseInt(inputNumber));
                }
            }

            //실제 알고리즘 단계
            // D의 개수를 세고 D>n이면 error 출력 및 다음 케이스로 넘어감.
            int d_count = 0;
            for(int i=0;i<p.length();i++){
                if(p.charAt(i)=='D'){
                    d_count++;
                }
            }
            if(d_count>n){
                System.out.println("error");
                continue;
            }

            int p_cur = 0; //문자열 p의 인덱스 커서
            int dir = 1; //1은 오른쪽, 0은 왼쪽

            while(true){
                int r_count=0;
                while(p_cur<p.length()&&p.charAt(p_cur)=='R'){
                    r_count++;
                    p_cur++;
                }

                //덱의 진행 방향을 바꿔 뒤집는다
                if(r_count%2==1){
                    dir = (dir+1)%2; //dir이 1이면 0, 0이면 1로 바뀜
                }

                if(p_cur>=p.length()){
                    break;
                }

                if(dir==1){
                    numbers.pollFirst();
                }
                else if(dir==0){
                    numbers.pollLast();
                }
                p_cur++;
            }

            sb = new StringBuilder("[");
            if(dir==1){
                while(!numbers.isEmpty()){
                    sb.append(numbers.pollFirst()+",");
                }
            }
            else{
                while(!numbers.isEmpty()){
                    sb.append(numbers.pollLast()+",");
                }
            }
            if(sb.charAt(sb.length()-1)==',')
                sb.deleteCharAt(sb.length()-1);
            sb.append(']');
            System.out.println(sb);
        }
    }
}
