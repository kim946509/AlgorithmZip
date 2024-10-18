package programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution33 {

     public boolean solution(String[] phone_book) {
          Set<String> prefixes = new HashSet<>();
          //내림차순 정렬
          Arrays.sort(phone_book, (o1, o2) -> o2.length() - o1.length());
          for(String phone: phone_book) {
              if(prefixes.contains(phone))
                  return false;

              for (int end = 1; end < phone.length(); end++) {
                  prefixes.add(phone.substring(0, end));
              }
          }
          return true;
     }
     //    정확성: 83.3
    //    효율성: 16.7
    //    합계: 100.0 / 100.0
}

//// 3차시도
//public boolean solution(String[] phone_book) {
//    Arrays.sort(phone_book);
//    Set<String> prefixes = new HashSet<>();
//    for(int i=0;i<phone_book.length;i++){
//        for(int j=i+1;j<phone_book.length;j++){
//            if(phone_book[i].length()==phone_book[j].length()){
//                continue;
//            }
//            if(phone_book[j].startsWith(phone_book[i])){
//                return false;
//            }
//        }
//    }
//    return true;
//}
////     *     정확성: 83.3
//// * 효율성: 8.3
//// * 합계: 91.7 / 100.0
/** 2차 시도
 * public boolean solution(String[] phone_book) {
 *         Arrays.sort(phone_book);
 *         Set<String> prefixes = new HashSet<>();
 *         for(int i=0;i<phone_book.length;i++){
 *             for(int j=i+1;j<phone_book.length;j++){
 *                 if(phone_book[j].startsWith(phone_book[i])){
 *                     return false;
 *                 }
 *             }
 *         }
 *         return true;
 *     }

 */

/** 1차 시도
 *     public boolean solution(String[] phone_book) {
 *         Set<String> prefixes = new HashSet<>();
 *         for(String phone: phone_book){
 *             for(int end=1;end<phone.length();end++){
 *                 prefixes.add(phone.substring(0,end));
 *             }
 *         }
 *
 *         for(String phone: phone_book){
 *             if(prefixes.contains(phone))
 *                 return false;
 *         }
 *         return true;
 *     }
 *채점 결과
 * 정확성: 83.3
 * 효율성: 12.5
 * 합계: 95.8 / 100.0
 */

//// 좋은 풀이라고 생각하는 코드
//static public boolean solution(String[] phoneBook) {
//    Arrays.sort(phoneBook);
//    //HashMap mp = new HashMap();
//
//    for(int i=0; i<phoneBook.length-1;i++)
//    {
//        if(phoneBook[i+1].startsWith(phoneBook[i])) {return false;}
//    }
//    return true;
//}
//
//public static void main(String[] args) throws Exception {
//
//    String[] temp = {"119", "97674223", "1195524421"};
//    boolean result = solution(temp);
//    System.out.println(result);
//}