public class StackArray {
    private int top;
    private int[] arr;

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);

        
    }


    public StackArray(int capacity){
        this.top = -1;
        this.arr = new int[capacity];
    }

    
    public void push(int data){
        if (isFull()) {
            throw new RuntimeException("Stack is full !!!");
        }

        top++;
        arr[top] = data;
    }


    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }

        int poppedData = arr[top];
        arr[top] = 0;
        top--;
        return poppedData;
    }

    
    public int peek(){
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }
        return arr[top];
    }


    public boolean isFull(){
        if (top+1 == arr.length) {
            return true;
        }
        return false;
    }


    public boolean isEmpty(){
        if (top < 0) {
            return true;
        }

        return false;
    }
}
