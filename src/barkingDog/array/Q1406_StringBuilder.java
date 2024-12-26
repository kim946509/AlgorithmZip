package barkingDog.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1406_StringBuilder {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sentence = new StringBuilder();
        sentence.append(bufferedReader.readLine());

        //명령어 입력 횟수
        int n = Integer.parseInt(bufferedReader.readLine());
        int cur = sentence.length();
        for (int i = 0; i < n; i++) {
            String input = bufferedReader.readLine();
            String[] command = input.split(" ");
            switch (command[0]){
                case "L":{ //커서를 왼쪽으로 이동
                    cur--;
                    if(cur<0)
                        cur=0;
                    break;
                }
                case "D": { //커서를 오른쪽으로 이동
                    cur++;
                    //오른쪽 끝일 경우. 이동 X
                    if(cur>sentence.length()){
                        cur=sentence.length();
                    }
                    break;
                }
                case "B": { //커서 왼쪽에 있는 문자를 삭제

                    //맨 왼쪽이 아닐경우에만 삭제
                    if(cur>0){
                        sentence.deleteCharAt(cur-1);
                    }
                    cur--;
                    if(cur<0)
                        cur=0;
                    break;
                }
                case "P": { //이후에 입력되는 문자를  커서 왼쪽에 추가
                    sentence.insert(cur,command[1]);
                    cur++;
                    break;
                }
                default: {
                    System.out.println("입력 커맨드가 잘못되었습니다.");
                }

            }
        }
        System.out.println(sentence);
    }
}
