package barkingDog;

import barkingDog.stack.Stack;

public class test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(3);
        stack.pop();
        stack.top();
    }
}
