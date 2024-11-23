package baekJoon.array;

public class Array_test {
    public static void main(String[] args) {
        insert_test();
        erase_test();
    }

    private static int insert(int dix, int num, int[] arr, int length){
        for(int i = dix; i<length;i++){
            arr[i+1] = arr[i];
        }
        arr[dix] = num;
        return length+1;
    }

    private static int erase(int dix, int arr[], int length){
        for(int i = length-1; i>dix;i--){
            arr[i-1]=arr[i];
        }
        return length-1;
    }
    private static void printArr(int[] arr,int length){
        for(int i=0;i<length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private static void insert_test(){
        System.out.println("**** insert_test ****");
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;

        int length = 3;
        length = insert(3,40,arr,length);
        printArr(arr,length);
        length = insert(1,50,arr,length);
        printArr(arr,length);
        length = insert(0,15,arr,length);
        printArr(arr,length);
    }

    private static void erase_test() {
        System.out.println("**** erase_test ****");
        int[] arr = new int[10];
        arr[0] = 10;
        arr[1] = 50;
        arr[2] = 40;
        arr[3] = 30;
        arr[4] = 70;
        arr[5] = 20;
        int length = 6;
        printArr(arr,length);
        length = erase(1, arr,length); // 10 40 30 20
        printArr(arr,length);
        length = erase(3, arr,length); // 10 40 30
        printArr(arr,length);
    }
}
