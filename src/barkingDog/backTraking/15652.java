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

    private static void sequence(List<Integer> numbers, int cur) throws IOException {
        if (numbers.size() == m) {
            for (int num : numbers) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = cur; i <= n; i++) {
            numbers.add(i);
            sequence(numbers, i);
            numbers.remove(numbers.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sequence(new ArrayList<Integer>(), 1);
        bw.flush();
    }
}