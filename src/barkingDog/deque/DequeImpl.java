package barkingDog.deque;

public class DequeImpl {
    private final int MX = 1000005;
    private int[] dat = new int[2*MX+1];
    private int head = MX;
    private int tail = MX;

    public void push_front(int x){

        if(head-1<0){
            System.out.println("head가 0보다 작음");
            return;
        }
        head--;
        dat[head] = x;
        System.out.println("push front : " + dat[head]);
    }

    public void push_back(int x){
        if(tail>=2*MX+1){
            System.out.println("tail이 배열 크기보다 큼");
            return;
        }
        dat[tail] = x;
        System.out.println("push back : " + dat[tail]);
        tail++;
    }

    public void pop_front(){
        if(head==tail){
            System.out.println("비어있는 덱");
            return;
        }
        System.out.println("pop front : " + dat[head]);
        head++;
    }

    public void pop_back(){
        if(tail==head){
            System.out.println("비어있는 덱");
            return;
        }
        tail--;
        System.out.println("pop back :" +dat[tail]);
    }

    public int front(){
        if(tail==head){
            System.out.println("비어있는 덱");
            return -1;
        }
        System.out.println("front : "+dat[head]);
        return dat[head];
    }

    public int back(){
        if(tail==head){
            System.out.println("비어있는 덱");
            return -1;
        }
        System.out.println("back : "+ dat[tail-1]);
        return dat[tail];
    }

    public void test(){
        push_front(3);
        push_front(2);
        front();
        push_back(4);
        back();
        pop_front();
        pop_front();
        pop_front();
        pop_front();
        push_back(3);
        pop_back();
    }
}
