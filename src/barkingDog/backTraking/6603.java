package barkingDog.backTraking;

import java.io.IOException;
import java.io.*;
import java.util.*;

class Main {

    public static int[] numbers;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void sequence(List<Integer> pocket, int cur, int k) throws IOException {
        if (pocket.size() == 6) {
            for (int num : pocket) {
                bw.write(num + " ");
            }
            bw.write("\n");
        }

        for (int i = cur; i < k; i++) {
            pocket.add(numbers[i]);
            sequence(pocket, i + 1, k);
            pocket.remove(pocket.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            int k = Integer.parseInt(st.nextToken());
            numbers = new int[k];
            for (int i = 0; i < k; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            sequence(new ArrayList<Integer>(), 0, k);
            bw.flush();
            bw.write("\n");
        }
    }
}