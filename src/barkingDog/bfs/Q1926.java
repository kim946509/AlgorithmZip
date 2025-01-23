package barkingDog.bfs;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q1926 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int height = sc.nextInt();
       int width = sc.nextInt();
       int[][] board = new int[height][width];
       for(int i=0;i< board.length;i++){
           for(int j=0;j<board[i].length;j++){
               board[i][j]=sc.nextInt();
           }
       }
       int[] dx = {1,0,-1,0};
       int[] dy = {0,1,0,-1};
       int maxSize = 0;
       int count = 0;
       Queue<Point> queue = new ArrayDeque<>();
       int[][] isVisit = new int[height][width];
       for(int i=0;i<height;i++) {
           for(int j=0;j<width;j++) {
               if(isVisit[i][j]==1 || board[i][j]==0)
                   continue;
               count++;
               queue.add(new Point(j,i));
               isVisit[i][j]=1;
               int size = 1;
               while (!queue.isEmpty()) {
                   Point p = queue.poll();
                   for (int dir = 0; dir < 4; dir++) {
                       int nx = p.x + dx[dir];
                       int ny = p.y + dy[dir];
                       if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                           continue;
                       }
                       if (isVisit[ny][nx] == 1 || board[ny][nx] == 0) {
                           continue;
                       }
                       queue.add(new Point(nx, ny));
                       isVisit[ny][nx] = 1;
                       size++;
                   }
               }
               if(maxSize<size){
                   maxSize=size;
               }
           }
       }
       System.out.println(count);
       System.out.println(maxSize);

    }
}
