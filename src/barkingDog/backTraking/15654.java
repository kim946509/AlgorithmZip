package barkingDog.backTraking;

import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int n;
    private static int m;

    public static void sequence(List<Integer> numbers, List<Integer> pockets) throws IOException {
        if (pockets.size() == m) {
            for (int number : pockets) {
                bw.write(number + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (pockets.contains(numbers.get(i))) {
                continue;
            }
            pockets.add(numbers.get(i));
            sequence(numbers, pockets);
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
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        numbers.sort(Comparator.naturalOrder());
        sequence(numbers, new ArrayList<Integer>());
        bw.flush();
    }
}