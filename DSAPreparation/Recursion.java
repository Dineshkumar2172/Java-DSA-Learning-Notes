package DSAPreparation; 

public class Recursion {

    int counter = 0;
    static int sumN = 0;

    public void print() {
        System.out.println("printing for : " + counter);

        counter++;
        if (counter < 5) { // implicit base case
            print();
        }
    }

    public void sumUptoN(int n) {
        // write a recursive function that given an input n sums all nonnegative integers up to n.
        // how would you solve it recusively?

        if (n > 0) {
            sumN += n;
            sumUptoN(n-1);
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.print();
        recursion.sumUptoN(5);
        System.out.println(sumN);
    }
}
