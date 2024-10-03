package programers;


public class Solution26 {
    public String solution(String s) {
        return s.chars()
                .boxed()
                .sorted((c1,c2)->c2-c1)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
