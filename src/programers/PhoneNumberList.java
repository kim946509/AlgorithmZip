package programers;

import java.util.Arrays;
import java.util.Comparator;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[] phone_book = {"110", "11955", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for (int i = 0; i < phone_book.length-1; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                String sub = phone_book[j].substring(0,phone_book[i].length());
                if(phone_book[i].equals(sub))
                    return false;
            }
        }

        return true;
    }
}
