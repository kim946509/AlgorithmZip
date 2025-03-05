import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {

    private static int n;
    private static int m;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void sequence(Deque<Integer> pocket) throws IOException {
        if (pocket.size() == m) {
            for (int num : pocket) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            pocket.add(i);
            sequence(pocket);
            pocket.removeLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence(new ArrayDeque<Integer>());
        bw.flush();
    }
}