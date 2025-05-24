package backTraking.stack;

public class Stack {
    private final int MX = 1000005;
    private int[] data = new int[MX];
    private int pos = 0;

    public void push(int x) {
        data[pos] = x;
        pos++;
    }

    public void pop() {
        pos--;
    }

    public int top() {
        System.out.println(data[pos - 1]);
        return data[pos - 1];
    }

}
