package barkingDog.bfs;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        int[][] board = new int[width][height];
        int[][] visit = new int[width][height];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=sc.nextInt();
            }
        }

        //우,상,좌,하 이동을 위한 변수
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        // bfs를 위한 Queue
        Queue<Point> queue = new ArrayDeque<>();

        //한점씩 방문
        for(int y=0;y<board.length;y++) {
            for (int x = 0; x < board[y].length; x++) {
                if(board[y][x]==0 || visit[y][x]==1){
                    continue;
                }
                visit[y][x]=1;
                int count=1;
                queue.add(new Point(x,y));
                while(!queue.isEmpty()){
                    Point p = queue.poll();
                    for(int i=0;i<4;i++){
                       Point nextP = new Point(p.x+dx[i],p.y+dy[i]);

                       // board 범위를 벗어났을 경우 continue;
                       if(nextP.x<0 || nextP.x>=width || nextP.y<0 || nextP.y>=height){
                           continue;
                       }
                       // 만약 막힌 곳이거나 이미 방문했을경우 continue;
                       if(board[nextP.y][nextP.x]==0 || visit[nextP.y][nextP.x]==1){
                           continue;
                       }

                       count++;

                    }
                }
            }
        }
    }
}
