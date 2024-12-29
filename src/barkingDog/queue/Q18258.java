package barkingDog.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Q18258 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int last = -1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] command = input.split(" ");

            if(command[0].equals("push")){
                queue.add(Integer.parseInt(command[1]));
                last=Integer.parseInt(command[1]);
            }
            else if(command[0].equals("size")){
                bw.write(String.valueOf(queue.size()));
                bw.newLine();
            }
            else if(command[0].equals("empty")){
                if(queue.isEmpty()){
                    bw.write("1");
                }
                else {
                    bw.write("0");
                }
                bw.newLine();
            }
            else if(queue.isEmpty()){
                bw.write("-1");
                bw.newLine();
            }
            else if(command[0].equals("pop")){
                bw.write(String.valueOf(queue.poll()));
                bw.newLine();
            }
            else if(command[0].equals("front")){
                bw.write(String.valueOf(queue.peek()));
                bw.newLine();
            }
            else if(command[0].equals("back")){
                bw.write(String.valueOf(last));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
