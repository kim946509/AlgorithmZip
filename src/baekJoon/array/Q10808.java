package baekJoon.array;

import java.util.Scanner;

public class Q10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] freq = new int[26];
        for(int i=0;i<word.length();i++){
            freq[word.charAt(i)-'a']++;
        }
        for(int i=0;i<freq.length;i++){
            System.out.print(freq[i]+" ");
        }
    }
}
