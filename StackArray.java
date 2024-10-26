public class StackArray {
    private int top;
    private int[] arr;

    public static void main(String[] args) {
        StackArray stack = new StackArray(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        int peekRespnse = stack.peek();
        System.out.println("peek response : " + peekRespnse);
        int popResponse = stack.pop();
        System.out.println("pop response : " + popResponse);
        int peekRespnse1 = stack.peek();
        System.out.println("peek response : " + peekRespnse1);
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
