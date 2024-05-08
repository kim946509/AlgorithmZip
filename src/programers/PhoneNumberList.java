package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class PhoneNumberList {
    public static void main(String[] args) {
        String[] phone_book = {"110", "11955", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        HashSet<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                String substring = phone_book[i].substring(0, j);
                if(phoneSet.contains(substring))
                    return false;
            }
        }
        return true;
    }


}
