package barkingDog.bfs;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q10026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            String line = sc.next();
            if(line.length()!=n){
                System.out.println("잘못된 입력");
                return;
            }
            for(int j=0;j<n;j++){
                board[i][j]=line.charAt(j);
            }
        }

        int[] dirX ={1,0,-1,0};
        int[] dirY = {0,1,0,-1};
        int[][] visit = new int[n][n];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visit[i][j]==1) continue;
                Queue<Point> queue = new ArrayDeque<>();
                queue.add(new Point(j,i));
                visit[i][j]=1;
                while (!queue.isEmpty()){
                    Point p = queue.poll();
                    for(int dir=0 ; dir<4 ; dir++){
                        int x = p.x+dirX[dir];
                        int y = p.y+dirY[dir];
                        if(x<0 || x>=n || y<0 || y>=n) continue;
                        if(visit[y][x] == 1 || board[y][x]!=board[p.y][p.x]) continue; //이미 방문했거나 다른 색이면
                        queue.add(new Point(x,y));
                        visit[y][x]=1;
                    }
                }
                count++;

            }
        }
        int[][] visit2 = new int[n][n];
        int count2 = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visit2[i][j]==1) continue;
                Queue<Point> queue = new ArrayDeque<>();
                queue.add(new Point(j,i));
                visit2[i][j]=1;

                while (!queue.isEmpty()){
                    Point p = queue.poll();
                    for(int dir=0 ; dir<4 ; dir++){
                        int x = p.x+dirX[dir];
                        int y = p.y+dirY[dir];
                        if(x<0 || x>=n || y<0 || y>=n) continue;
                        if(visit2[y][x] ==1 || (board[y][x]!=board[p.y][p.x]&&(board[y][x]=='B'||board[p.y][p.x]=='B')) ){
                            continue; //이미 방문했거나 다른 색이면
                        }
                        queue.add(new Point(x,y));
                        visit2[y][x]=1;
                    }
                }
                count2++;
            }
        }
        System.out.println(count+" "+count2);
    }
}
