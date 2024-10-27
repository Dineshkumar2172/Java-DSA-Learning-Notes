import java.util.Stack;

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
        
        
        // reverse a string using stack in the middle
        String reversedStr = stack.reverseString("something");
        System.out.println(reversedStr);
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


    // reverse a string using stack
    public String reverseString(String str){
        Stack<Character> stack = new Stack<>();
        char[] stringChars = str.toCharArray();
        for (char c : stringChars) {
            stack.push(c);
        }

        for (int i = 0; i < stringChars.length; i++) {
            stringChars[i] = stack.pop();
        }

        return new String(stringChars);
    }


    // find next greater element using stack 
    public int[] nextGreaterElement(int[] arr){
        int[] result = new int[arr.length];
        
        return result;
    }
}
