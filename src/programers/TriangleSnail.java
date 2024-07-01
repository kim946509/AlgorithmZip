package programers;

/**
 * 재귀함수를 이용해서 풀어보자
 * 높이가 n인 삼각형의 바깥쪽을 채운다음 n-3인 삼각형의 바깥쪽을 채우기 반복
 *
 * 1. 배열의 높이를 매개변수로 받아야함.
 * 2. 배열의 현재 커서를 저장해야함.
 *
 * 과정
 * 1. 1씩 증가 폭이 증가하는 반복문 생성. 해당 커서에 숫자 저장
 * 2. 증가폭이 n-1이라면 그때부터는 1씩 증가해서 n번 반복.
 * 3. n번 반복 이후에는 다시 n부터 3까지 감소폭이 1씩 감소. 해당 커서에 숫자저장
 * 4. 바깥쪽은 다 채웠으므로 n-2높이의 1~3번 반복.
 */

public class TriangleSnail {

    public static void main(String[] args) {
        int n = 5;
        int[] solution = solution(n);
        for (int i : solution) {
            System.out.print(" "+ i);
        }

    }

    public static int[] solution(int n) {
        int [][] triangle = new int[n][n];
        int num=1;
        int x=0;
        int y=0;

        while(true){

            //아래로 이동
            while(true){
                triangle[y][x]=num;
                num++;
                if(y+1==n || triangle[y+1][x]!=0) break;
                y++;
            }
            if(x+1 == n || triangle[y][x+1]!=0) break;
            x++;
            //오른쪽으로 이동
            while(true){
                triangle[y][x]=num;
                num++;
                if(x+1==n || triangle[y][x+1]!=0) break;
                x++;
            }
            if(triangle[y-1][x-1]!=0) break;
            x-=1;
            y-=1;
            while (true){
                triangle[y][x]=num;
                num++;
                if(triangle[y-1][x-1]!=0) break;
                x-=1;
                y-=1;
            }
            if (y+1==n || triangle[y+1][x]!=0) break;
            y++;
        }
        int[] answer = new int[num-1];
        int index = 0;
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        return answer;
    }
}

