package barkingDog.recursive;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q17478 {
    private static int i = 0;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void whatIs(int t) throws IOException {

        String prefix = "_".repeat(i*4);
        if(i==t){
            bw.write(prefix+"\"재귀함수가 뭔가요?\"\n");
            bw.write(prefix+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            bw.write(prefix+"라고 답변하였지.\n");
            return;
        }
        bw.write(prefix+"\"재귀함수가 뭔가요?\"\n");
        bw.write(prefix+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n"
                +prefix+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n"
                +prefix+ "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        ++i;
        whatIs(t);

        bw.write(prefix+"라고 답변하였지.\n");
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        whatIs(t);
        bw.flush();
    }
}
