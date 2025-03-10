package barkingDog.backTraking;

import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {

    private static int n;
    private static int m;
    private static Set<List<Integer>> pockets = new HashSet<>();
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Integer> numbers = new ArrayList<>();

    private static void sequence(int cur, List<Integer> pocket) throws IOException {
        if (pocket.size() == m) {
            if (!pockets.contains(pocket)) {
                pockets.add(pocket);
                for (int num : pocket) {
                    bw.write(num + " ");
                }
                bw.write("\n");
            }
            return;
        }

        for (int i = cur; i < n; i++) {
            pocket.add(numbers.get(i));
            sequence(i + 1, pocket);
            pocket.remove(pocket.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        numbers = new ArrayList<>();
        s = br.readLine();
        st = new StringTokenizer(s);

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        numbers.sort(Comparator.naturalOrder());
        sequence(0, new ArrayList<Integer>());
        bw.flush();
    }
}