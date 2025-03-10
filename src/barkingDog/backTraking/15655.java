package barkingDog.backTraking;

import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {

    private static int n;
    private static int m;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void sequence(List<Integer> numbers, List<Integer> pockets, int cur) throws IOException {
        if (pockets.size() == m) {
            for (int number : pockets) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = cur; i < n; i++) {
            pockets.add(numbers.get(i));
            sequence(numbers, pockets, i + 1);
            pockets.remove(pockets.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        numbers.sort(Comparator.naturalOrder());
        sequence(numbers, new ArrayList<Integer>(), 0);
        bw.flush();
    }
}