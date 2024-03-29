package programers;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution(prices);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for(int j = i+1;j<prices.length;j++){
                answer[i]++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        return answer;
    }
}
