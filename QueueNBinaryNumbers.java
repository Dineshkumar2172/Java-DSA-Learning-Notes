import java.util.LinkedList;
import java.util.Queue;

public class QueueNBinaryNumbers {
    public static void main(String[] args) {
        QueueNBinaryNumbers queueNBinaryNumbers = new QueueNBinaryNumbers();
        String[] result = queueNBinaryNumbers.generateBinaryNumbers(10);
        for (String string : result) {
            System.out.println(string);
        }
    }

    // generate binary numbers from 1 to n using a QUEUE.
    // example
    // `        input = 3, output = {"1", "10", "11"}
    //          input = 5, output = {"1". "10", "11", "100", "101"}
    public String[] generateBinaryNumbers(int n){
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            result[i] = queue.poll();
            String n1 = result[i] + "0";
            String n2 = result[i] + "1";
            queue.offer(n1);
            queue.offer(n2);
        }

        return result;
    }
}
