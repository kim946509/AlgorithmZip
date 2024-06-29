package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class meetPointStar {
    private static class Point{
        long x;
        long y;

        Point(){}
        Point(long x,long y){
            this.x=x;
            this.y=y;
        }
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] process = process(line);
        for (int i = 0; i < process.length; i++) {
            System.out.println(process[i]);
        }
    }
    public static String[] process(int[][] line){
        ArrayList<Point> meetPoints = new ArrayList<>();
        for(int i=0;i<line.length-1;i++){
            for(int j=i+1;j<line.length;j++){
                int[] line1 = line[i];
                int[] line2 = line[j];
                Point meetPoint = getMeetPoint(line1,line2);
                if(meetPoint!=null)
                    meetPoints.add(meetPoint);
            }
        }

        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point meetPoint : meetPoints) {
            if(meetPoint.x < minX)
                minX=meetPoint.x;
            if(meetPoint.x > maxX)
                maxX=meetPoint.x;
            if(meetPoint.y < minY)
                minY=meetPoint.y;
            if(meetPoint.y > maxY)
                maxY=meetPoint.y;
        }

        int height = (int)(maxY-minY+1);
        int width = (int)(maxX-minX+1);

        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row,'.');
        }

        for (Point meetPoint : meetPoints) {
            int x=(int)(meetPoint.x-minX);
            int y=(int)(maxY-meetPoint.y);
            arr[y][x]='*';
        }

        String[] board = new String[arr.length];
        for(int i = 0; i<board.length;i++)
            board[i]=new String(arr[i]);


//        String[] board=new String[(int)height];
//        int cur = 0;
//        for(long i = maxY;i>=minY;i--){
//            StringBuilder stringBuilder = new StringBuilder();
//            for(long j = minX;j<=maxX;j++){
//                if(containsPoint(meetPoints, j,i))
//                    stringBuilder.append('*');
//                else
//                    stringBuilder.append('.');
//            }
//            board[cur] = stringBuilder.toString();
//            cur++;
//        }

        return board;
    }
    //해당 점이 containsPoint에 존재하는지 확인
    public static boolean containsPoint(List<Point> meetPoints, long x, long y){
        for (Point meetPoint : meetPoints) {
            if(meetPoint.x==x && meetPoint.y==y)
                return true;
        }
        return false;
    }

    public static Point getMeetPoint(int[] line1, int[] line2){
        long a=line1[0];
        long b=line1[1];
        long e=line1[2];

        long c=line2[0];
        long d=line2[1];
        long f=line2[2];

        try{
            double x = (double)(b*f-e*d)/(a*d-b*c);
            double y = (double)(e*c-a*f)/(a*d-b*c);
            //교차점이 정수일 경우
            if(x!=(long)x || y !=(long)y){
                return null;
            }
            return new Point((long)x,(long)y);
        } catch(ArithmeticException k){
            return null;
        }
    }
}




