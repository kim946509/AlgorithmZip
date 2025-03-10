package barkingDog.backTraking;

import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Integer> pocket = new ArrayList<>();
    private static Set<List<Integer>> pockets = new HashSet<>();
    private static int n;
    private static int m;
    private static boolean[] visited;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void sequence() throws IOException {
        if (pocket.size() == m) {
            if (!pockets.contains(pocket)) {
                for (int num : pocket) {
                    bw.write(num + " ");
                }
                bw.write("\n");
                pockets.add(pocket);
            }

            return;
        }

        for (int i = 0; i < n; i++) {

            if (visited[i] == true) {
                continue;
            }

            visited[i] = true;
            pocket.add(numbers.get(i));

            sequence();

            pocket.remove(pocket.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        s = br.readLine();
        st = new StringTokenizer(s);
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        numbers.sort(Comparator.naturalOrder());
        sequence();
        bw.flush();
    }
}